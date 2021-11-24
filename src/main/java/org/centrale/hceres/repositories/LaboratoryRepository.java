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

import org.centrale.hceres.items.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ECN
 */
@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Integer>{

    @Query(name="Laboratory.findByIdLaboratory")
    public Laboratory findByLaboratoryId(@Param("IdLaboratory")Integer laboratoryId);

}
