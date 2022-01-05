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
public class TeamRepositoryCustomImpl implements TeamRepositoryCustom{
    
    TeamRepository teamRepository;
    
    public long countAllTeams()
    {
        return teamRepository.countAllTeams();
    }
    
    public long countResearcherByTeam(String teamName)
    {
        return teamRepository.countResearcherByTeam(teamName);
    }
    
    public long countPhdStudentByTeam(String teamName)
    {
        return teamRepository.countPhdStudentByTeam(teamName);
    }
    
    public long countPostDocByTeam(String teamName)
    {
        return teamRepository.countPostDocByTeam(teamName);
    }
    
    public long countTeacherResearchertByTeam(String teamName)
    {
        return teamRepository.countTeacherResearchertByTeam(teamName);
    }
    
     public long countPublicationByTeam(String teamName)
    {
        return teamRepository.countPublicationByTeam(teamName);
    }
    
    
     public long avgImpactFactorPublicationByTeam(String teamName)
    {
        return teamRepository.avgImpactFactorPublicationByTeam(teamName);
    }
    
     public long countReviewJounalByTeam(String teamName)
    {
        return teamRepository.countReviewJounalByTeam(teamName);
    }
    
     public long avgImpactFactorReviewJounalByTeam(String teamName)
    {
        return teamRepository.avgImpactFactorReviewJounalByTeam(teamName);
    }
    
     public long countBookByTeam(String teamName)
    {
        return teamRepository.countBookByTeam(teamName);
    }
    
     public long countClinicalTrialByTeam(String teamName)
    {
        return teamRepository.countClinicalTrialByTeam(teamName);
    }
     
      public long countInvitedSeminarByTeam(String teamName)
    {
        return teamRepository.countInvitedSeminarByTeam(teamName);
    }
      
     public long countMeetingByTeam(String teamName)
    {
        return teamRepository.countMeetingByTeam(teamName);
    }
  
    
 
    
    
    
}
