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

import java.util.Collection;
import java.util.Date;
import org.centrale.hceres.items.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ECN
 */
@Repository
public interface ConnectionRepository extends JpaRepository<Connection, String>, ConnectionRepositoryCustom{
    /**
     * Get all expired connections
     * @param expireDate
     * @return
     */
    @Query("SELECT c FROM Connection c WHERE c.connectionExpire < :expireDate")
    public Collection<Connection> findAllExpireBefore(@Param("expireDate")Date expireDate);
}
