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

import javax.servlet.http.HttpServletRequest;
import org.centrale.hceres.items.Connection;
import org.centrale.hceres.managers.ActivityManager;
import org.centrale.hceres.repositories.ResearcherRepository;
import org.centrale.hceres.managers.SecurityManager;
import org.centrale.hceres.repositories.ActivityRepository;
import org.centrale.hceres.repositories.ConnectionRepository;
import org.centrale.hceres.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ECN
 */
@Controller
public class ParametersController {

    @Autowired
    private ResearcherRepository researcherRepository;

    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private  ActivityRepository activityRepository;
    
    @Autowired
    private PublicationRepository publicationRepository;
    /**
     * Get researchers list in GET mode -> refused
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "chechpublications.do")
    public ModelAndView HandleGetCheckPublications(HttpServletRequest request) {
        Connection connectedUser = org.centrale.hceres.managers.SecurityManager.getCurrentConnection(request, connectionRepository);

        ActivityManager.processPublication( researcherRepository, activityRepository, publicationRepository);

        ModelAndView returned = new ModelAndView("welcome");
        returned.addObject("connectedUser", connectedUser);
        
        return returned;
    }
}
