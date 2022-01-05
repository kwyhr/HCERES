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
    /**
     * average of phd duration
     * @return 
     */
    
    @Query(value="SELECT AVG(phd_duration) FROM phd_student",nativeQuery =true)
    public long avgPhdDuration();
    
  /**
   * The number of defended thesis between two dates
   * @param date1
   * @param date2
   * @return 
   */
    @Query(value="SELECT COUNT(*) FROM phd_student\n" +
           "WHERE phd_student.defense_date BETWEEN =?1 AND =?1",nativeQuery =true)
    public long CountAllDefendedThesis(String date1,String date2);
    
}
