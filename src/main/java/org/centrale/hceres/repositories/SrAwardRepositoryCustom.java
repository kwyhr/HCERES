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
public interface SrAwardRepositoryCustom {
     /**
     * Calculate the number of Prizes
     * 
     * @return 
     */
    @Query(value="SELECT COUNT(*) FROM sr_award",nativeQuery =true)
    public long countAllSrAward();
    
    
    /**
     * Calculate the number of Prizes between two Periods
     * 
     * @param date1
     * @param date2
     * @return 
     */
    @Query(value="SELECT COUNT(*) FROM sr_award WHERE\n" +
            "WHERE phd_student.defense_date BETWEEN =?1 AND =?2",nativeQuery =true)
    public long countAllSrAward(String date1,String date2);
    
}
