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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "team_referent")
@NamedQueries({
    @NamedQuery(name = "TeamReferent.findAll", query = "SELECT t FROM TeamReferent t"),
    @NamedQuery(name = "TeamReferent.findByTeamReferentId", query = "SELECT t FROM TeamReferent t WHERE t.teamReferentId = :teamReferentId"),
    @NamedQuery(name = "TeamReferent.findByTeamReferentStart", query = "SELECT t FROM TeamReferent t WHERE t.teamReferentStart = :teamReferentStart"),
    @NamedQuery(name = "TeamReferent.findByTeamReferentEnd", query = "SELECT t FROM TeamReferent t WHERE t.teamReferentEnd = :teamReferentEnd")})
public class TeamReferent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "team_referent_id")
    private Integer teamReferentId;
    @Column(name = "team_referent_start")
    @Temporal(TemporalType.DATE)
    private Date teamReferentStart;
    @Column(name = "team_referent_end")
    @Temporal(TemporalType.DATE)
    private Date teamReferentEnd;
    @JoinColumn(name = "researcher_id", referencedColumnName = "researcher_id")
    @ManyToOne(optional = false)
    private Researcher researcherId;
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    @ManyToOne(optional = false)
    private Team teamId;

    /**
     *
     */
    public TeamReferent() {
    }

    /**
     *
     * @param teamReferentId
     */
    public TeamReferent(Integer teamReferentId) {
        this.teamReferentId = teamReferentId;
    }

    /**
     *
     * @return
     */
    public Integer getTeamReferentId() {
        return teamReferentId;
    }

    /**
     *
     * @param teamReferentId
     */
    public void setTeamReferentId(Integer teamReferentId) {
        this.teamReferentId = teamReferentId;
    }

    /**
     *
     * @return
     */
    public Date getTeamReferentStart() {
        return teamReferentStart;
    }

    /**
     *
     * @param teamReferentStart
     */
    public void setTeamReferentStart(Date teamReferentStart) {
        this.teamReferentStart = teamReferentStart;
    }

    /**
     *
     * @return
     */
    public Date getTeamReferentEnd() {
        return teamReferentEnd;
    }

    /**
     *
     * @param teamReferentEnd
     */
    public void setTeamReferentEnd(Date teamReferentEnd) {
        this.teamReferentEnd = teamReferentEnd;
    }

    /**
     *
     * @return
     */
    public Researcher getResearcherId() {
        return researcherId;
    }

    /**
     *
     * @param researcherId
     */
    public void setResearcherId(Researcher researcherId) {
        this.researcherId = researcherId;
    }

    /**
     *
     * @return
     */
    public Team getTeamId() {
        return teamId;
    }

    /**
     *
     * @param teamId
     */
    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamReferentId != null ? teamReferentId.hashCode() : 0);
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
        if (!(object instanceof TeamReferent)) {
            return false;
        }
        TeamReferent other = (TeamReferent) object;
        if ((this.teamReferentId == null && other.teamReferentId != null) || (this.teamReferentId != null && !this.teamReferentId.equals(other.teamReferentId))) {
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
        return "org.centrale.hceres.items.TeamReferent[ teamReferentId=" + teamReferentId + " ]";
    }
    
}
