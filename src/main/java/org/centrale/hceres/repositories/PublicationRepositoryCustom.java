/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.centrale.hceres.repositories;

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
    
}
