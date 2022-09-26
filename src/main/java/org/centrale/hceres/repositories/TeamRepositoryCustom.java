/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.centrale.hceres.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author twfid
 */
public interface TeamRepositoryCustom {
    
    /**
     * Calculate the number of teams
     * 
     * @return 
     */
    @Query(value="SELECT COUNT(*) FROM team",nativeQuery =true)
    public long countAllTeams();
    
   
    /**
     * Number of researchers by Team
     * @return 
     */
    @Query(value= "SELECT COUNT(*) FROM researcher\n" +
                "INNER JOIN belongs_team USING(researcher_id)\n" +
                "INNER JOIN team USING(id_ belongs_team)\n" +
                "WHERE  team_name LIKE =?1",nativeQuery =true)
    public long countResearcherByTeam(String teamName);
    
    /**
     * Number of Post doc by Team
     * @param TeamName
     * @return 
     */
    
   @Query(value="SELECT COUNT(*) FROM post_doc\n" +
                "INNER JOIN activity USING(id_activity)\n" +
                "INNER JOIN activity_team USING(id_activity)\n" +
                "INNER JOIN team USING(id_team)\n" +
                "AND team_name LIKE =?1",nativeQuery =true)
   public long countPostDocByTeam(String teamName);
   
   /**
     * Number of Phd Student by Team
     * @param TeamName
     * @return 
     */
    
   @Query(value="SELECT COUNT(*) FROM phd_student\n" +
                "INNER JOIN researcher USING (researcher_id)\n" +
                "INNER JOIN belongs_team USING(researcher_id)\n" +
                "INNER JOIN team USING(id_ belongs_team)\n" +
                "WHERE  team_name LIKE =?1",nativeQuery =true)
   public long countPhdStudentByTeam(String teamName);
   
   /**
    * The number of teacher/researcher by Team
    * @param teamName
    * @return 
    */
   @Query(value="SELECT COUNT(*) FROM education\n" +
                "INNER JOIN researcher USING (researcher_id)\n" +
                "INNER JOIN belongs_team USING(researcher_id)\n" +
                "INNER JOIN team USING(id_ belongs_team)\n" +
                "WHERE  team_name LIKE =?1",nativeQuery =true)
   public long countTeacherResearchertByTeam(String teamName);
   /**
    * Number of publications by Team
    * @param teamName
    * @return 
    */
   
   @Query(value="SELECT COUNT(*) FROM publication\n" +
                "INNER JOIN activity USING(id_activity)\n" +
                "INNER JOIN activity_team USING(id_activity)\n" +
                "INNER JOIN team USING(id_team)\n" +
                "WHERE  team_name LIKE =?1",nativeQuery =true)
   public long countPublicationByTeam(String teamName);
   
   /**
    * average  value of team publication impact factors
    * @param teamName
    * @return 
    */
   
   @Query(value="SELECT AVG(publication.impact_factor) FROM publication \n" +
                "INNER JOIN activity USING(id_activity)\n" +
                "INNER JOIN activity_team USING(id_activity)\n" +
                "INNER JOIN team USING(id_team)\n" +
                "WHERE  team_name LIKE =?1",nativeQuery =true)
   public long avgImpactFactorPublicationByTeam(String teamName);
   
   /**
    *  number of Journal Review articles by teams
    * @param teamName
    * @return 
    */
   
   @Query(value="SELECT COUNT(*) FROM reviewing_journal_articles\n" +
                "INNER JOIN activity USING(id_activity)\n" +
                "INNER JOIN activity_team USING(id_activity)\n" +
                "INNER JOIN team USING(id_team)\n" +
                "WHERE  team_name LIKE =?1",nativeQuery =true)
   public long countReviewJounalByTeam(String teamName);
   
   @Query(value="SELECT AVG(publication.impact_factor) FROM reviewing_journal_articles \n" +
                "INNER JOIN activity USING(id_activity)\n" +
                "INNER JOIN activity_team USING(id_activity)\n" +
                "INNER JOIN team USING(id_team)\n" +
                "WHERE  team_name LIKE =?1",nativeQuery =true)
   public long avgImpactFactorReviewJounalByTeam(String teamName);
   
   
   /**
    * Number of book by Team
    * @param teamName
    * @return 
    */
   @Query(value="SELECT COUNT(*) FROM Book\n" +
                "INNER JOIN activity USING(id_activity)\n" +
                "INNER JOIN activity_team USING(id_activity)\n" +
                "INNER JOIN team USING(id_team)\n" +
                "WHERE  team_name LIKE =?1",nativeQuery =true)
   public long countBookByTeam(String teamName);
   
   
   /**
    * Number of clinical_trial
    * @param teamName
    * @return 
    */
   @Query(value="SELECT COUNT(*) FROM sei_clinical_trial\n" +
                "INNER JOIN activity USING(id_activity)\n" +
                "INNER JOIN activity_team USING(id_activity)\n" +
                "INNER JOIN team USING(id_team)\n" +
                "WHERE  team_name LIKE =?1",nativeQuery =true)
   public long countClinicalTrialByTeam(String teamName);
   
   /**
    * The number of semar where the team where invited
    * @param teamName
    * @return 
    */
   
   @Query(value="SELECT COUNT(*) FROM invited_seminar\n" +
                "INNER JOIN activity USING(id_activity)\n" +
                "INNER JOIN activity_team USING(id_activity)\n" +
                "INNER JOIN team USING(id_team)\n" +
                "WHERE  team_name LIKE =?1",nativeQuery =true)
   public long countInvitedSeminarByTeam(String teamName);
   
   /**
    * The number of meetings
    * @param teamName
    * @return 
    */
   
   @Query(value="SELECT COUNT(*) FROM meeting\n" +
                "INNER JOIN activity USING(id_activity)\n" +
                "INNER JOIN activity_team USING(id_activity)\n" +
                "INNER JOIN team USING(id_team)\n" +
                "WHERE  team_name LIKE =?1",nativeQuery =true)
   public long countMeetingByTeam(String teamName);
   
   
   
     
   
   
}
