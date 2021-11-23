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

import org.centrale.hceres.items.Researcher;

/**
 *
 * @author kwyhr
 */
public interface ResearcherRepositoryCustom {
    /**
     * Create new researcher
     * @param name
     * @param surname
     * @param email
     * @return 
     */
    public Researcher create(String name, String surname, String email);
    
    /**
     * Get researcher according to the ID
     * @param researcherId
     * @return 
     */
    public Researcher find(int researcherId);
    
    /**
     * >Remove researcher
     * @param researcherId 
     */
    public void delete(int researcherId);
}

