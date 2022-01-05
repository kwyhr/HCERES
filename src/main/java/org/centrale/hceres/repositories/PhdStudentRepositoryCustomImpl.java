/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.hceres.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 *
 * @author twfid
 */
@Repository
public class PhdStudentRepositoryCustomImpl implements PhdStudentRepositoryCustom {
    
    @Autowired
    @Lazy
    PhdStudentRepository phdStudentRepository;
    
    
    public long countAllPhdStudents()
    {
        return  phdStudentRepository.countAllPhdStudents();
        
    }
    
    public long countAllInternationalPhdStudents()
    {
        return phdStudentRepository.countAllInternationalPhdStudents();
    }
    
    public long avgPhdDuration()
    {
        return phdStudentRepository.avgPhdDuration();
        
    }
    
    public long CountAllDefendedThesis(String date1,String date2)
    {
        return phdStudentRepository.CountAllDefendedThesis(date1, date2);
    }
    
}
