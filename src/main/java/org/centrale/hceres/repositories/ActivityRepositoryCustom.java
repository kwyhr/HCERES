/* --------------------------------------------------------------------------------
 * Projet HCERES
 * 
 * Gestion de données pour l'HCERES
 * 
 * Ecole Centrale Nantes - laboratoire CRTI
 * Avril 2021
 * L LETERTRE, S LIMOUX, JY MARTIN
 * -------------------------------------------------------------------------------- */
package org.centrale.hceres.repositories;

import java.util.HashMap;
import java.util.List;
import org.centrale.hceres.items.Activity;
import org.centrale.hceres.items.Researcher;
import org.centrale.hceres.items.TypeActivity;

/**
 *
 * @author kwyhr
 */
public interface ActivityRepositoryCustom {

    /**
     * Add an activity to a researcher
     *
     * @param activity
     * @param researcher
     */
    public void addResearcher(Activity activity, Researcher researcher);

    /**
     * find researcher activities
     * @param researcher
     * @return 
     */
    public HashMap<Integer, List<Activity>> findResearcherActivities(Researcher researcher);

    /**
     * find researcher activities
     * @param researcher
     * @param typeActivity
     * @return 
     */
    public List<Activity> findResearcherActivities(Researcher researcher, TypeActivity typeActivity);
}
