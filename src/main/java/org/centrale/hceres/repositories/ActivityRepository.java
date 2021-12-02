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

import java.util.List;
import org.centrale.hceres.items.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ECN
 */
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer>, ActivityRepositoryCustom {
    
    @Query(value = "SELECT DISTINCT Activity.*"
            + " FROM Activity"
            + " INNER JOIN Activity_Researcher USING (id_activity)"
            + " WHERE Activity_Researcher.Researcher_ID = ?1 AND Activity.ID_Type_Activity = ?2"
            , nativeQuery = true)
    public List<Activity> findResearcherActivities(int researcherId, int typeActivityId);
}
