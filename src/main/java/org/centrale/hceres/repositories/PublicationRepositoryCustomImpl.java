/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.hceres.repositories;

import java.util.Collection;
import org.centrale.hceres.items.Publication;
import org.springframework.stereotype.Repository;

/**
 *
 * @author twfid
 */

@Repository
public class PublicationRepositoryCustomImpl implements PublicationRepositoryCustom{
    
    PublicationRepository publicationRepository;
    
    public long countAllPublications()
    {
        return publicationRepository.countAllPublications();
    }
    
    public long avgPublicationImpactFactor()
    {
        return publicationRepository.avgPublicationImpactFactor();
        
    }
    
    public long countTopPublications()
    {
        return publicationRepository.countTopPublications();
        
    }
    
    public Collection <Publication> countPublicationByType()
    {
        return publicationRepository.countPublicationByType();
    }
}
