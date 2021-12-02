/* --------------------------------------------------------------------------------
 * Projet HCERES
 * 
 * Gestion de données pour l'HCERES
 * 
 * Ecole Centrale Nantes - laboratoire CRTI
 * Avril 2021
 * L LETERTRE, S LIMOUX, JY MARTIN
 * -------------------------------------------------------------------------------- */
package org.centrale.hceres.managers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.centrale.hceres.items.BelongsTeam;
import org.centrale.hceres.items.Team;
import org.centrale.hceres.items.Nationality;
import org.centrale.hceres.items.PhdStudent;
import org.centrale.hceres.items.Researcher;
import org.centrale.hceres.repositories.*;
import org.centrale.tools.Utilities;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ECN
 */
public class ResearcherManager {

    public static void saveData(HttpServletRequest request,
            ResearcherRepository researcherRepository, PhdStudentRepository phdStudentRepository,
            NationalityRepository nationalityRepository, TeamRepository teamRepository,
            BelongsTeamRepository belongsTeamRepository) {
        ModelAndView returned;

        boolean isNew = false;
        Date now = Utilities.getCurrentDate();

        // Get parameters
        int refChercheur = -1;
        Researcher researcher = null;
        if (request.getParameter("refChercheur") != null) {
            refChercheur = Utilities.getRequestInteger(request, "refChercheur");
            researcher = researcherRepository.find(refChercheur);
        }
        if ((request.getParameter("idResearcher") != null) && (researcher == null)) {
            refChercheur = Utilities.getRequestInteger(request, "idResearcher");
            researcher = researcherRepository.find(refChercheur);
        }

        String name = Utilities.getRequestString(request, "nameResearcher");
        String surname = Utilities.getRequestString(request, "surnameResearcher");
        String email = Utilities.getRequestString(request, "emailAddress");
        String orcid = Utilities.getRequestString(request, "idOrcidResearcher");
        ArrayList<Integer> nationalitiesInt = Utilities.getRequestArrayList(request, "nationality");
        Integer laboratoryId = Utilities.getRequestInteger(request, "laboratory");
        Integer teamId = Utilities.getRequestInteger(request, "team");

        String login = Utilities.getRequestString(request, "loginResearcher");
        String password = Utilities.getRequestString(request, "passwordResearcher");

        ArrayList<Nationality> nationalities = new ArrayList<Nationality>();
        for (int nationalityId : nationalitiesInt) {
            Nationality nationality = nationalityRepository.findByNationalityId(nationalityId);
            nationalities.add(nationality);
        }
        
        // Set data
        if (researcher == null) {
            // Create researcher
            researcher = new Researcher();
            isNew = true;
        }
        researcher.setResearcherName(name);
        researcher.setResearcherSurname(surname);
        researcher.setResearcherOrcid(orcid);
        researcher.setResearcherEmail(email);
        if ((login != null) && (!login.isEmpty())) {
            researcher.setResearcherLogin(login);
            if ((password != null) && (!password.isEmpty())) {
                Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
                String encodedPassword = encoder.encode(password);
                researcher.setResearcherPassword(encodedPassword);
            }
        }

        researcherRepository.setNationalities(researcher, nationalities);
        if (teamId != null) {
            Team team = teamRepository.findByTeamId(teamId);
            if (team != null) {
                BelongsTeam currentTeam = researcher.getCurrentBelongsTeam();
                if (currentTeam == null) {
                    // No current team
                    currentTeam = new BelongsTeam();
                    currentTeam.setOnboardingDate(null);
                    currentTeam.setTeamId(team);
                    currentTeam.setResearcherId(researcher);
                    belongsTeamRepository.save(currentTeam);
                } else if (currentTeam.getTeamId().getTeamId().intValue() != team.getTeamId().intValue()) {
                    // Current team is not the selected one -> close current belongsteam
                    Date yesterday = Utilities.getCurrentDate();
                    yesterday.setTime(yesterday.getTime() - (long) 1000 * 60 * 60 * 24);
                    currentTeam.setLeavingDate(yesterday);
                    belongsTeamRepository.save(currentTeam);

                    // Create new one
                    currentTeam = new BelongsTeam();
                    currentTeam.setOnboardingDate(now);
                    currentTeam.setTeamId(team);
                    belongsTeamRepository.save(currentTeam);
                }
            }
        }

        // Save data
        researcherRepository.save(researcher);
        refChercheur = researcher.getResearcherId();
        researcher = researcherRepository.getOne(refChercheur);

        // Phd Student info
        if (isPhdStudent(request)) {
            // Get parameters
            Date startThesis = Utilities.getRequestDate(request, "phdStart");
            Date defDate = Utilities.getRequestDate(request, "phdDefense");

            //Set data
            PhdStudent aDoctor = phdStudentRepository.getOne(refChercheur);
            if (aDoctor == null) {
                aDoctor = new PhdStudent();
            }
            aDoctor.setResearcherId(researcher);
            aDoctor.setPhdStart(startThesis);
            aDoctor.setPhdDefenseDate(defDate);

            // Save
            phdStudentRepository.save(aDoctor);
        }
    }

    private static boolean isPhdStudent(HttpServletRequest request) {
        return false;
    }
}
