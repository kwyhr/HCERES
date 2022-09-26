/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.centrale.hceres.repositories;

import java.util.Collection;
import org.centrale.hceres.items.Publication;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author twfid
 */
public interface PublicationRepositoryCustom {
    
    /**
     * Calculate the number of publications
     * 
     * @return 
     */
    @Query(value="SELECT COUNT(*) FROM publication",nativeQuery =true)
    public long countAllPublications();
    
    /**
     * Average of of publication's impact factor
     * @return 
     */
    
    @Query(value="SELECT AVG(publication.impact_factor) FROM publication ",nativeQuery =true)
    public long avgPublicationImpactFactor();
    
    /**
     *  count Publications that have impact_factor great than average
     * @return 
     */
    @Query(value="SELECT COUNT(*) FROM publication WHERE publication.impact_factor >= (SELECT AVG(publication.impact_factor) FROM publication)",nativeQuery =true)
    public long countTopPublications();
    
    /**
     * Count Publication by type
     * @return 
     */
    @Query(value="SELECT publication_type.publication_type_name AS typePublication,COUNT(*) AS totalPulication  FROM publication\n" +
                "INNER JOIN publication_type USING(publication_type_id)\n" +
                "GROUP BY publication_type.publication_type_name",nativeQuery =true)
    public Collection <Publication> countPublicationByType();
    
}
