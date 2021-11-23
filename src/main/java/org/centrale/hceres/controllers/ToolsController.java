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
import org.centrale.hceres.items.Employer;
import org.centrale.hceres.items.Researcher;
import org.centrale.hceres.repositories.ConnectionRepository;
import org.centrale.hceres.repositories.ResearcherRepository;
import org.centrale.hceres.managers.SecurityManager;
import org.centrale.hceres.repositories.EmployerRepository;
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
public class ToolsController {

    @Autowired
    private ResearcherRepository researcherRepository;

    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private EmployerRepository employerRepository;

    /**
     * Manage parameters in GET mode -> refused
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "parametersForm.do", method = RequestMethod.GET)
    public ModelAndView HandleGetParameters(HttpServletRequest request) {
        // Back to default connection page
        Connection connectedUser = SecurityManager.getCurrentConnection(request, connectionRepository);
        if (connectedUser != null) {
            connectionRepository.remove(connectedUser);
        }

        return new ModelAndView("index");
    }

    /**
     * Manage parameters in POST mode
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "parametersForm.do", method = RequestMethod.POST)
    public ModelAndView HandlePostParameters(HttpServletRequest request) {
        Connection connectedUser = SecurityManager.getCurrentConnection(request, connectionRepository);
        ModelAndView returnedValue = new ModelAndView("parameters");
        returnedValue.addObject("connectedUser", connectedUser);

        return returnedValue;
    }

}
