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
import java.util.List;
import org.centrale.hceres.items.Researcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ECN
 */
@Repository
public interface ResearcherRepository extends JpaRepository<Researcher, Integer>, ResearcherRepositoryCustom {

    @Query(name="Researcher.findByResearcherId")
    public Researcher findByResearcherId(@Param("researcherId")Integer researcherId);

    @Query(name="Researcher.findByResearcherLogin")
    public Collection<Researcher> findByResearcherLogin(@Param("researcherLogin")String researcherLogin);

    @Query(value = "SELECT DISTINCT Researcher.*"
            + " FROM Researcher"
            + " WHERE Researcher.Researcher_Name ILIKE ?1 AND Researcher.Researcher_Surname ILIKE ?2"
            , nativeQuery = true)
    public Collection<Researcher> findByResearcherFullName(String lastname, String firstname);

}
