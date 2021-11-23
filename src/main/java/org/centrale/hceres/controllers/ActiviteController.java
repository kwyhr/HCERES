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

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.centrale.hceres.items.Connection;
import org.centrale.hceres.items.PhdType;
import org.centrale.hceres.items.TypeActivity;
import org.centrale.hceres.repositories.ConnectionRepository;
import org.centrale.hceres.repositories.TypeActivityRepository;
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
public class ActiviteController {

    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private TypeActivityRepository typeActivityRepository;

    /**
     * Get activities list in GET mode -> refused
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "activities.do", method = RequestMethod.GET)
    public ModelAndView HandleGetActivities(HttpServletRequest request) {
        // Back to default connection page
        Connection connectedUser = org.centrale.hceres.managers.SecurityManager.getCurrentConnection(request, connectionRepository);
        if (connectedUser != null) {
            connectionRepository.remove(connectedUser);
        }

        return new ModelAndView("index");
    }

    /**
     * Get activity list in POST mode
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "activities.do", method = RequestMethod.POST)
    public ModelAndView HandlePostActivities(HttpServletRequest request) {
        Connection connectedUser = org.centrale.hceres.managers.SecurityManager.getCurrentConnection(request, connectionRepository);

        // Display researchers list
        return listActivities(connectedUser);
    }

    /**
     * Create list of activities view
     *
     * @param connectedUser
     * @return
     */
    private ModelAndView listActivities(Connection connectedUser) {
        String[] propertiesLTA = {"idTypeActivity"};
        List<TypeActivity> listTypeActivity = typeActivityRepository.findAll(Sort.by(Sort.Direction.ASC, propertiesLTA));

        ModelAndView returnedValue = new ModelAndView("activities");
        returnedValue.addObject("connectedUser", connectedUser);
        returnedValue.addObject("listActivities", listTypeActivity);

        return returnedValue;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "newActivity.do", method = RequestMethod.GET)
    public ModelAndView handleGet() {
        return new ModelAndView("Formulaire_d_activite");
    }
}
