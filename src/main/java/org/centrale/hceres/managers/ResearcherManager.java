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

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.centrale.hceres.items.PhdStudent;
import org.centrale.hceres.items.Researcher;
import org.centrale.hceres.repositories.PhdStudentRepository;
import org.centrale.hceres.repositories.ResearcherRepository;
import org.centrale.tools.Utilities;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ECN
 */
public class ResearcherManager {

    public static void saveData(HttpServletRequest request,
            ResearcherRepository researcherRepository, PhdStudentRepository phdStudentRepository) {
        ModelAndView returned;

        boolean isNew = false;
        // Get parameters
        int refChercheur = -1;
        Researcher researcher = null;
        if (request.getParameter("refChercheur") != null) {
            refChercheur = Utilities.getRequestInteger(request, "refChercheur");
            researcher = researcherRepository.find(refChercheur);
        }
        if ((request.getParameter("idChercheur") != null) && (researcher == null)) {
            refChercheur = Utilities.getRequestInteger(request, "idChercheur");
            researcher = researcherRepository.find(refChercheur);
        }

        String name = Utilities.getRequestString(request, "nameResearcher");
        String surname = Utilities.getRequestString(request, "surnameResearcher");
        String orcid = Utilities.getRequestString(request, "idOrcidResearcher");
        String email = Utilities.getRequestString(request, "emailAddress");

        // Save
        if (researcher == null) {
            // Create researcher
            researcher = new Researcher();
            isNew = true;
        }
        researcher.setResearcherName(name);
        researcher.setResearcherSurname(surname);
        researcher.setResearcherOrcid(orcid);
        researcher.setResearcherEmail(email);
        
        researcherRepository.save(researcher);
        refChercheur = researcher.getResearcherId();
        researcher = researcherRepository.getOne(refChercheur);
        
        if (isPhdStudent(request)) {
            PhdStudent aDoctor = phdStudentRepository.getOne(refChercheur);
            if (aDoctor == null) {
                aDoctor = new PhdStudent();
            }
            
            //TODO : Partie non fonctionnelle pour récupérer les dates
            aDoctor.setResearcherId(researcher);
            Date defDate = new Date(Integer.parseInt(request.getParameter("defenseDate"))); //non fonctionnel encore
            Date startThesis = new Date(Integer.parseInt(request.getParameter("dateStartThesis")));

            phdStudentRepository.save(aDoctor);
        }
    }

    private static boolean isPhdStudent(HttpServletRequest request) {
        return false;
    }
}
