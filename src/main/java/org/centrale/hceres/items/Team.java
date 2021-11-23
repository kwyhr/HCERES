/* --------------------------------------------------------------------------------
 * Projet HCERES
 * 
 * Gestion de données pour l'HCERES
 * 
 * Ecole Centrale Nantes - laboratoire CRTI
 * Avril 2021
 * L LETERTRE, S LIMOUX, JY MARTIN
 * -------------------------------------------------------------------------------- */
package org.centrale.hceres.items;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "team")
@NamedQueries({
    @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t"),
    @NamedQuery(name = "Team.findByTeamId", query = "SELECT t FROM Team t WHERE t.teamId = :teamId"),
    @NamedQuery(name = "Team.findByTeamName", query = "SELECT t FROM Team t WHERE t.teamName = :teamName"),
    @NamedQuery(name = "Team.findByTeamCreation", query = "SELECT t FROM Team t WHERE t.teamCreation = :teamCreation"),
    @NamedQuery(name = "Team.findByTeamEnd", query = "SELECT t FROM Team t WHERE t.teamEnd = :teamEnd"),
    @NamedQuery(name = "Team.findByTeamLastReport", query = "SELECT t FROM Team t WHERE t.teamLastReport = :teamLastReport")})
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "team_id")
    private Integer teamId;
    @Size(max = 256)
    @Column(name = "team_name")
    private String teamName;
    @Column(name = "team_creation")
    @Temporal(TemporalType.DATE)
    private Date teamCreation;
    @Column(name = "team_end")
    @Temporal(TemporalType.DATE)
    private Date teamEnd;
    @Column(name = "team_last_report")
    @Temporal(TemporalType.DATE)
    private Date teamLastReport;
    @ManyToMany(mappedBy = "teamCollection")
    private Collection<Activity> activityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamId")
    private Collection<TeamReferent> teamReferentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private Collection<PublicationStatistics> publicationStatisticsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamId")
    private Collection<BelongsTeam> belongsTeamCollection;
    @JoinColumn(name = "laboratory_id", referencedColumnName = "laboratory_id")
    @ManyToOne(optional = false)
    private Laboratory laboratoryId;

    /**
     *
     */
    public Team() {
    }

    /**
     *
     * @param teamId
     */
    public Team(Integer teamId) {
        this.teamId = teamId;
    }

    /**
     *
     * @return
     */
    public Integer getTeamId() {
        return teamId;
    }

    /**
     *
     * @param teamId
     */
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    /**
     *
     * @return
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     *
     * @param teamName
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     *
     * @return
     */
    public Date getTeamCreation() {
        return teamCreation;
    }

    /**
     *
     * @param teamCreation
     */
    public void setTeamCreation(Date teamCreation) {
        this.teamCreation = teamCreation;
    }

    /**
     *
     * @return
     */
    public Date getTeamEnd() {
        return teamEnd;
    }

    /**
     *
     * @param teamEnd
     */
    public void setTeamEnd(Date teamEnd) {
        this.teamEnd = teamEnd;
    }

    /**
     *
     * @return
     */
    public Date getTeamLastReport() {
        return teamLastReport;
    }

    /**
     *
     * @param teamLastReport
     */
    public void setTeamLastReport(Date teamLastReport) {
        this.teamLastReport = teamLastReport;
    }

    /**
     *
     * @return
     */
    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    /**
     *
     * @param activityCollection
     */
    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
    }

    /**
     *
     * @return
     */
    public Collection<TeamReferent> getTeamReferentCollection() {
        return teamReferentCollection;
    }

    /**
     *
     * @param teamReferentCollection
     */
    public void setTeamReferentCollection(Collection<TeamReferent> teamReferentCollection) {
        this.teamReferentCollection = teamReferentCollection;
    }

    /**
     *
     * @return
     */
    public Collection<PublicationStatistics> getPublicationStatisticsCollection() {
        return publicationStatisticsCollection;
    }

    /**
     *
     * @param publicationStatisticsCollection
     */
    public void setPublicationStatisticsCollection(Collection<PublicationStatistics> publicationStatisticsCollection) {
        this.publicationStatisticsCollection = publicationStatisticsCollection;
    }

    /**
     *
     * @return
     */
    public Collection<BelongsTeam> getBelongsTeamCollection() {
        return belongsTeamCollection;
    }

    /**
     *
     * @param belongsTeamCollection
     */
    public void setBelongsTeamCollection(Collection<BelongsTeam> belongsTeamCollection) {
        this.belongsTeamCollection = belongsTeamCollection;
    }

    /**
     *
     * @return
     */
    public Laboratory getLaboratoryId() {
        return laboratoryId;
    }

    /**
     *
     * @param laboratoryId
     */
    public void setLaboratoryId(Laboratory laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamId != null ? teamId.hashCode() : 0);
        return hash;
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.teamId == null && other.teamId != null) || (this.teamId != null && !this.teamId.equals(other.teamId))) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "org.centrale.hceres.items.Team[ teamId=" + teamId + " ]";
    }
    
}
