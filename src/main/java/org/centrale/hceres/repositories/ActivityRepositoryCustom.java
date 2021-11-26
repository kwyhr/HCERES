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

import org.centrale.hceres.items.Activity;
import org.centrale.hceres.items.Researcher;

/**
 *
 * @author kwyhr
 */
public interface ActivityRepositoryCustom {
    /**
     * Add an activity to a researcher
     * @param activity
     * @param researcher 
     */
	public void addResearcher(Activity activity,Researcher researcher);
}

