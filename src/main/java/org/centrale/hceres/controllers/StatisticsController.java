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
import org.centrale.hceres.repositories.ConnectionRepository;
import org.centrale.hceres.managers.SecurityManager;
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
public class StatisticsController {

    @Autowired
    private ConnectionRepository connectionRepository;

    /**
     * Get researchers list in GET mode -> refused
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "statistics.do", method = RequestMethod.GET)
    public ModelAndView HandleGetStatistics(HttpServletRequest request) {
        // Back to default connection page
        Connection connectedUser = SecurityManager.getCurrentConnection(request, connectionRepository);
        if (connectedUser != null) {
            connectionRepository.remove(connectedUser);
        }

        return new ModelAndView("index");
    }

    /**
     * Get researchers list in POST mode
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "statistics.do", method = RequestMethod.POST)
    public ModelAndView HandlePostStatistics(HttpServletRequest request) {
        Connection connectedUser = SecurityManager.getCurrentConnection(request, connectionRepository);

        // Display statistics list
        ModelAndView returnedValue = new ModelAndView("statistics");
        returnedValue.addObject("connectedUser", connectedUser);

        return returnedValue;
    }
}
