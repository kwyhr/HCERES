/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.hceres.repositories;

import org.springframework.stereotype.Repository;

/**
 *
 * @author twfid
 */

@Repository
public class SrAwardRepositoryCustomImpl implements SrAwardRepositoryCustom {
    
    SrAwardRepository  SrAwardRepository;
    
    public long countAllSrAward()
    {
        return SrAwardRepository.countAllSrAward();
    }
    
     public long countAllSrAward(String date1,String date2)
    {
        return SrAwardRepository.countAllSrAward( date1,date2);
    }
    
}
