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
import org.centrale.hceres.items.Nationality;
import org.centrale.hceres.items.Researcher;
import org.springframework.data.jpa.repository.Query;

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
    
    /**
     * Set researcher nationality
     * @param researcher
     * @param nationality 
     */
    public void setNationality(Researcher researcher, Nationality nationality);
    
    /**
     * Set multiple nationalities
     * 
     * @param researcher
     * @param nationalities 
     */
    public void setNationalities(Researcher researcher, List<Nationality> nationalities);
    
    /**
     * Calculate the number of researchers 
     * 
     * @return 
     */
    @Query(value="SELECT COUNT(*) FROM researcher",nativeQuery =true)
    public long countAllResearchers();
    
    /**
     * Calculate the number of international researchers
     * 
     * @return 
     */
    @Query(value="SELECT COUNT(*)FROM researcher\n" +
                "INNER JOIN researcher_nationality USING(researcher_id)\n" +
                "INNER JOIN nationality USING(nationality_id)\n" +
                "WHERE nationality_name NOT LIKE 'Français'",nativeQuery =true)
    public long countAllInternationalResearchers();
    
    
    
    
}

