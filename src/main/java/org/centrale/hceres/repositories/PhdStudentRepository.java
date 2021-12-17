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
import org.centrale.hceres.items.PhdStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ECN
 */
@Repository
public interface PhdStudentRepository extends JpaRepository<PhdStudent, Integer>,PhdStudentRepositoryCustom{

    @Query("SELECT p FROM PhdStudent p WHERE p.researcherId = :researcherId")
    public PhdStudent findByResearcherId(@Param("researcherId")Integer researcherId);
    
    @Query(value = "SELECT DISTINCT PhdStudent.*"
            + " FROM PhdStudent"
            + " INNER JOIN Researcher ISING (Researcher_ID)"
            + " WHERE Researcher.Researcher_Email ILIKE ?1"
            , nativeQuery = true)
    public Collection<PhdStudent> findByEmail(String email);
    
}
