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

import javax.servlet.http.HttpServletRequest;
import org.centrale.hceres.items.Connection;
import org.centrale.hceres.items.Researcher;

/**
 *
 * @author kwyhr
 */
public interface ConnectionRepositoryCustom {
    /**
     * Create new connexion for a researcher
     * @param researcher
     * @param status
     * @return 
     */
    public Connection create(Researcher researcher, int status);
    
    /**
     * Create new connexion for an admin passthrough
     * @return 
     */
    public Connection create();

    /**
     * Remove old data
     */
    public void removeOld();
    
    /**
     * Expand expire time
     * @param connection 
     */
    public void expand(Connection connection);
    
    /**
     * Expand expire time
     * @param connection 
     * @param time 
     */
    public void expand(Connection connection, long time);
 
    
    /**
     * remove connection
     * @param connection 
     */
    public void remove(Connection connection);
}

