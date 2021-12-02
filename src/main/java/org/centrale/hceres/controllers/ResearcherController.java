/* --------------------------------------------------------------------------------
 * Projet HCERES
 * 
 * Gestion de données pour l'HCERES
 * 
 * Ecole Centrale Nantes - laboratoire CRTI
 * Avril 2021
 * L LETERTRE, S LIMOUX, JY MARTIN
 * -------------------------------------------------------------------------------- */
package org.centrale.hceres.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.centrale.hceres.items.*;
import org.centrale.hceres.managers.*;
import org.centrale.hceres.repositories.*;
import org.centrale.tools.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ECN
 */
@Controller
public class ResearcherController {

    @Autowired
    private ResearcherRepository researcherRepository;

    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    BelongsTeamRepository belongsTeamRepository;
    
    @Autowired
    private PhdStudentRepository phdStudentRepository;

    @Autowired
    private PhdTypeRepository phdTypeRepository;

    @Autowired
    private NationalityRepository nationalityRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    TypeActivityRepository typeActivityRepository;

    /**
     * Get researchers list in GET mode -> refused
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "researchers.do", method = RequestMethod.GET)
    public ModelAndView HandleGetResearchers(HttpServletRequest request) {
        // Back to default connection page
        Connection connectedUser = org.centrale.hceres.managers.SecurityManager.getCurrentConnection(request, connectionRepository);
        if (connectedUser != null) {
            connectionRepository.remove(connectedUser);
        }

        return new ModelAndView("index");
    }

    /**
     * Create list researchers view
     *
     * @param connectedUser
     * @return
     */
    private ModelAndView listResearchers(Connection connectedUser) {
        String[] properties = {"researcherSurname", "researcherName"};
        List<Researcher> researchersList = researcherRepository.findAll(Sort.by(Sort.Direction.ASC, properties));
        ModelAndView returnedValue = new ModelAndView("researchers");
        returnedValue.addObject("connectedUser", connectedUser);
        returnedValue.addObject("researchersList", researchersList);

        return returnedValue;
    }

    /**
     * Create researcher view
     *
     * @param connectedUser
     * @return
     */
    private ModelAndView editResearcher(Connection connectedUser, int researcherId) {
        Researcher researcher = researcherRepository.find(researcherId);
        if (researcher == null) {
            return listResearchers(connectedUser);
        } else {
            String[] propertiesLE = {"nameEmployer"};
            List<Employer> listEmployer = employerRepository.findAll(Sort.by(Sort.Direction.ASC, propertiesLE));

            String[] propertiesLS = {"idStatus"};
            List<Status> listStatus = statusRepository.findAll(Sort.by(Sort.Direction.ASC, propertiesLS));

            String[] propertiesLLab = {"laboratoryAcronym"};
            List<Laboratory> listLaboratories = laboratoryRepository.findAll(Sort.by(Sort.Direction.ASC, propertiesLLab));

            String[] propertiesLT = {"teamName"};
            List<Team> listTeams = teamRepository.findAll(Sort.by(Sort.Direction.ASC, propertiesLT));

            String[] propertiesLTPhd = {"phdTypeName"};
            List<PhdType> listPhdType = phdTypeRepository.findAll(Sort.by(Sort.Direction.ASC, propertiesLTPhd));
            
            String[] propertiesLN = {"nationalityId"};
            List<Nationality> listNationalities = nationalityRepository.findAll(Sort.by(Sort.Direction.ASC, propertiesLN));

            List<TypeActivity> listeType = typeActivityRepository.findAll();
            HashMap<Integer, List<Activity>> listActivities = activityRepository.findResearcherActivities(researcher);
            
            ModelAndView returnedValue = new ModelAndView("researcher");
            returnedValue.addObject("connectedUser", connectedUser);
            returnedValue.addObject("researcher", researcher);
            returnedValue.addObject("listEmployer", listEmployer);
            returnedValue.addObject("listStatus", listStatus);
            returnedValue.addObject("listLaboratories", listLaboratories);
            returnedValue.addObject("listTeams", listTeams);
            returnedValue.addObject("listPhdType", listPhdType);
            returnedValue.addObject("listNationalities", listNationalities);
            returnedValue.addObject("listTypeActivities", listeType);
            returnedValue.addObject("listActivities", listActivities);

            return returnedValue;
        }
    }

    /**
     * Get researchers list in POST mode
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "researchers.do", method = RequestMethod.POST)
    public ModelAndView HandlePostResearchers(HttpServletRequest request) {
        Connection connectedUser = org.centrale.hceres.managers.SecurityManager.getCurrentConnection(request, connectionRepository);

        // Display researchers list
        return listResearchers(connectedUser);
    }

    /**
     * Handle researcher in GET mode -> refused
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "handleResearcher.do", method = RequestMethod.GET)
    public ModelAndView HandleGetResearcher(HttpServletRequest request) {
        // Back to default connection page
        Connection connectedUser = org.centrale.hceres.managers.SecurityManager.getCurrentConnection(request, connectionRepository);
        if (connectedUser != null) {
            connectionRepository.remove(connectedUser);
        }

        return new ModelAndView("index");
    }

    /**
     * Handle researcher in POST mode
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "handleResearcher.do", method = RequestMethod.POST)
    public ModelAndView HandlePostResearcher(HttpServletRequest request) {
        Connection connectedUser = org.centrale.hceres.managers.SecurityManager.getCurrentConnection(request, connectionRepository);
        int returnedScreen = 0;
        ModelAndView returnedValue;
        Integer researcherId = Utilities.getRequestInteger(request, "selectedID");
        String actionStr = Utilities.getRequestString(request, "action");

        if ((researcherId != null) && (actionStr != null)) {
            switch (actionStr) {
                case "edit":
                    returnedScreen = 1;
                    break;
                case "delete":
                    returnedScreen = 0;
                    researcherRepository.delete(0);
                    break;
            }

            switch (returnedScreen) {
                case 0:
                    return listResearchers(connectedUser);

                case 1:
                    return editResearcher(connectedUser, researcherId);

                default:
                    return HandlePostResearchers(request);
            }
        } else {
            return listResearchers(connectedUser);
        }
    }

    /**
     * Manage new researcher or researcher modification
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "newChercheur.do", method = RequestMethod.POST)
    public ModelAndView handlePost(HttpServletRequest request) {
        Connection connectedUser = org.centrale.hceres.managers.SecurityManager.getCurrentConnection(request, connectionRepository);

        ResearcherManager.saveData( request, researcherRepository,  phdStudentRepository,
            nationalityRepository, teamRepository, belongsTeamRepository);
        
        return listResearchers(connectedUser);
    }
}
