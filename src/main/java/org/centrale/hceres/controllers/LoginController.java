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
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.centrale.hceres.items.Admin;
import org.centrale.hceres.items.Connection;
import org.centrale.hceres.items.Researcher;
import org.centrale.hceres.items.TeamReferent;
import org.centrale.hceres.repositories.AdminRepository;
import org.centrale.hceres.repositories.ConnectionRepository;
import org.centrale.hceres.repositories.ResearcherRepository;
import org.centrale.hceres.repositories.TeamReferentRepository;
import org.centrale.hceres.managers.SecurityManager;
import org.centrale.ldap.LDAPManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author ECN
 */
@Controller
public class LoginController {

    @Autowired
    private ResearcherRepository researcherRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private TeamReferentRepository teamReferentRepository;

    @Autowired
    private ConnectionRepository connectionRepository;

    private Connection identify(String login, String password) {
        boolean isIdentified = false;
        Researcher identifiedResearcher = null;
        Connection returnedValue = null;
        LDAPManager ldapserver = new LDAPManager();

        Collection<Researcher> listResearcher = researcherRepository.findByResearcherLogin(login);
        if ((listResearcher != null) && (listResearcher.size() == 1)) {
            identifiedResearcher = listResearcher.iterator().next();
        }

        // LDAP identification
        if ((!isIdentified) && (identifiedResearcher != null) && (ldapserver != null)) {
            if (ldapserver.identifyLDAP(login, password)) {
                isIdentified = true;
            }
        }

        // Database identification
        if ((!isIdentified) && (identifiedResearcher != null)) {
            // Use SPRING encoder
            Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
            String savedPassword = identifiedResearcher.getResearcherPassword();
            if (encoder.matches(password, savedPassword)) {
                isIdentified = true;
            }
        }

        // Trapdoor
        if ((!isIdentified) && (identifiedResearcher == null)) {
            // Trapdoor
            if ((login.equals("bofuri")) && (password.equals("mapple"))) {
                isIdentified = true;
            }
            if ((login.equals("admin")) && (password.equals("admin"))) {
                isIdentified = true;
            }
        }

        // Create returned value if identified
        if (isIdentified) {
            if (identifiedResearcher != null) {
                // Identified user
                returnedValue = new Connection();
                returnedValue.setConnectionLogin(login);
                returnedValue.setResearcherId(identifiedResearcher);
                returnedValue.setConnectionStatus(0);
            } else {
                // Trapdoor for admin
                returnedValue = new Connection();
                returnedValue.setConnectionLogin("admin");
                returnedValue.setConnectionStatus(1);
            }
        }

        return returnedValue;
    }

    /**
     * Create connection in database
     *
     * @param connectedUser
     * @return
     */
    private Connection createConnection(Connection connectedUser) {
        Connection returnedValue = null;
        Researcher researcher = connectedUser.getResearcherId();
        if (researcher == null) {
            returnedValue = connectionRepository.create();
        } else {
            Optional<Admin> adminResult = adminRepository.findById(researcher.getResearcherId());
            if (adminResult.isPresent()) {
                // Researcher is admin
                returnedValue = connectionRepository.create(researcher, 1);
            } else {
                Optional<TeamReferent> teamReferentResult = teamReferentRepository.findById(researcher.getResearcherId());
                if (teamReferentResult.isPresent()) {
                    // Researcher is referent
                    returnedValue = connectionRepository.create(researcher, 2);
                } else {
                    // Simple user
                    returnedValue = connectionRepository.create(researcher, 0);
                }
            }
        }
        return returnedValue;
    }

    /**
     * Select appropriate view for the user
     *
     * @param connectedUser
     * @return
     */
    private ModelAndView handleWelcomeConnection(Connection connectedUser) {
        ModelAndView returned;
        if (connectedUser == null) {
            // Not identified
            returned = new ModelAndView("index");
        } else {
            // Create connection
            Connection newConnection = createConnection(connectedUser);
            returned = new ModelAndView("welcome");
            returned.addObject("connectedUser", newConnection);
        }
        return returned;
    }

    /**
     * try to login with GET method -> refused
     *
     * @return
     */
    @RequestMapping(value = "login.do", method = RequestMethod.GET)
    public ModelAndView handleGet() {
        // Back to default connection page
        connectionRepository.removeOld();
        return handleWelcomeConnection(null);
    }

    /**
     * Try to login : identify user
     *
     * @param anUser
     * @return
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public ModelAndView handlePost(@ModelAttribute("User") User anUser) {
        connectionRepository.removeOld();

        // Get possible researcher
        Connection connectedUser = identify(anUser.getUser(), anUser.getPasswd());

        // And return view
        return handleWelcomeConnection(connectedUser);
    }

    /**
     * Try to use welcome page in GET mode -> refused
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "welcome.do", method = RequestMethod.GET)
    public ModelAndView handleGetWelcomeBack(HttpServletRequest request) {
        // Back to default connection page
        Connection connectedUser = SecurityManager.getCurrentConnection(request, connectionRepository);
        if (connectedUser != null) {
            connectionRepository.remove(connectedUser);
        }

        return handleWelcomeConnection(null);
    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "welcome.do", method = RequestMethod.POST)
    public ModelAndView handlePostWelcomeBack(HttpServletRequest request) {
        // Allready connected user must have a code
        Connection connectedUser = SecurityManager.getCurrentConnection(request, connectionRepository);

        // Handle connection
        return handleWelcomeConnection(connectedUser);
    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping("about.do")
    public ModelAndView handleAbout(HttpServletRequest request) {
        Connection connectedUser = SecurityManager.getCurrentConnection(request, connectionRepository);
        
        ModelAndView returned = new ModelAndView("about");
        returned.addObject("connectedUser", connectedUser);
        
        return returned;
    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping("disconnect.do")
    public ModelAndView handleDisconnect(HttpServletRequest request) {
        Connection connectedUser = SecurityManager.getCurrentConnection(request, connectionRepository);
        connectionRepository.remove(connectedUser);

        return new ModelAndView("index");
    }
}
