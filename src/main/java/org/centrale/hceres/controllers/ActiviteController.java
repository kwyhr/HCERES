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
    
    
    // Ajout d'activite :
    /**
     *
     * @return
     */
    @RequestMapping(value="NouvActivite.do",method=RequestMethod.GET)
    public ModelAndView handleGetAjoutActivite(){  
        return new ModelAndView("AjouterActivite");
    }
    
    @RequestMapping(value="EducationActivite.do",method=RequestMethod.GET)
    public ModelAndView handleGetEducation(){  
        return new ModelAndView("Education");
    }
    
    @RequestMapping(value="PostDoctorat.do",method=RequestMethod.GET)
    public ModelAndView handleGetPostDoctorat(){  
        return new ModelAndView("PostDoctorat");
    }
    
    @RequestMapping(value="Prix.do",method=RequestMethod.GET)
    public ModelAndView handleGetPrix(){  
        return new ModelAndView("Prix");
    }
    
    @RequestMapping(value="Brevet.do",method=RequestMethod.GET)
    public ModelAndView handleGetBrevet(){  
        return new ModelAndView("Brevet");
    }
    
    @RequestMapping(value="Production.do",method=RequestMethod.GET)
    public ModelAndView handleGetProduction(){  
        return new ModelAndView("Production");
    }
    
    @RequestMapping(value="Platform1.do",method=RequestMethod.GET)
    public ModelAndView handleGetPlatform1(){  
        return new ModelAndView("Platform1");
    }
    
    @RequestMapping(value="Edition.do",method=RequestMethod.GET)
    public ModelAndView handleGetEdition(){  
        return new ModelAndView("Edition");
    }
    
    @RequestMapping(value="Revue.do",method=RequestMethod.GET)
    public ModelAndView handleGetRevue(){  
        return new ModelAndView("Revue");
    }
    
    @RequestMapping(value="Publication1.do",method=RequestMethod.GET)
    public ModelAndView handleGetPublication1(){  
        return new ModelAndView("Publication1");
    }
    
    @RequestMapping(value="Livre.do",method=RequestMethod.GET)
    public ModelAndView handleGetLivre(){  
        return new ModelAndView("Livre");
    }
    
    @RequestMapping(value="Séminaire.do",method=RequestMethod.GET)
    public ModelAndView handleGetSéminaire(){  
        return new ModelAndView("Séminaire");
    }
         
    @RequestMapping(value="Communication.do",method=RequestMethod.GET)
    public ModelAndView handleGetCommunication(){  
        return new ModelAndView("Communication");
    }
    
    @RequestMapping(value="contratIndus.do",method=RequestMethod.GET)
    public ModelAndView handleGetcontratIndus(){  
        return new ModelAndView("contratIndus");
    }
    
    
    @RequestMapping(value="collabInter.do",method=RequestMethod.GET)
    public ModelAndView handleGetcollabInter(){  
        return new ModelAndView("collabInter");
    }
    
    @RequestMapping(value="expertise1.do",method=RequestMethod.GET)
    public ModelAndView handleGetexpertise1(){  
        return new ModelAndView("expertise1");
    }
    
    @RequestMapping(value="essaiClinique.do",method=RequestMethod.GET)
    public ModelAndView handleGetessaiClinique(){  
        return new ModelAndView("essaiClinique");
    }
    
    @RequestMapping(value="mobiliteEntrante.do",method=RequestMethod.GET)
    public ModelAndView handleGetmobiliteEntrante(){  
        return new ModelAndView("mobiliteEntrante");
    }
    
    @RequestMapping(value="MobiliteSortante.do",method=RequestMethod.GET)
    public ModelAndView handleGetMobiliteSortante(){  
        return new ModelAndView("MobiliteSortante");
    }
    
    @RequestMapping(value="creationEntreprise.do",method=RequestMethod.GET)
    public ModelAndView handleGetcreationEntreprise(){  
        return new ModelAndView("creationEntreprise");
    } 
}
