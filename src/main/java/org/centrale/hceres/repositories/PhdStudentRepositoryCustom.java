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

public interface PhdStudentRepositoryCustom {
    
    
    
    
    /**
     * Calculate the number of phd_students
     * 
     * @return 
     */
    @Query(value="SELECT COUNT(*) FROM phd_student",nativeQuery =true)
    public long countAllPhdStudents();
    
    /**
     * Calculate the number of international phd_students
     * 
     * @return 
     */
    @Query(value="SELECT COUNT(*)FROM phd_student"
            +   "INNER JOIN researcher USING(researcher_id)\n" +
                "INNER JOIN researcher_nationality USING(researcher_id)\n" +
                "INNER JOIN nationality USING(nationality_id)\n" +
                "WHERE nationality_name NOT LIKE 'Français'",nativeQuery =true)
    public long countAllInternationalPhdStudents();
    
    @Query(value="SELECT AVG(phd_duration) FROM phd_student",nativeQuery =true)
    public long avgPhdDuration();
    
    
}
