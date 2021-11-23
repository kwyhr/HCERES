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
@Table(name = "belongs_team")
@NamedQueries({
    @NamedQuery(name = "BelongsTeam.findAll", query = "SELECT b FROM BelongsTeam b"),
    @NamedQuery(name = "BelongsTeam.findByIdBelongsTeam", query = "SELECT b FROM BelongsTeam b WHERE b.idBelongsTeam = :idBelongsTeam"),
    @NamedQuery(name = "BelongsTeam.findByOnboardingDate", query = "SELECT b FROM BelongsTeam b WHERE b.onboardingDate = :onboardingDate"),
    @NamedQuery(name = "BelongsTeam.findByLeavingDate", query = "SELECT b FROM BelongsTeam b WHERE b.leavingDate = :leavingDate")})
public class BelongsTeam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_belongs_team")
    private Integer idBelongsTeam;
    @Column(name = "onboarding_date")
    @Temporal(TemporalType.DATE)
    private Date onboardingDate;
    @Column(name = "leaving_date")
    @Temporal(TemporalType.DATE)
    private Date leavingDate;
    @JoinColumn(name = "researcher_id", referencedColumnName = "researcher_id")
    @ManyToOne(optional = false)
    private Researcher researcherId;
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    @ManyToOne(optional = false)
    private Team teamId;

    /**
     *
     */
    public BelongsTeam() {
    }

    /**
     *
     * @param idBelongsTeam
     */
    public BelongsTeam(Integer idBelongsTeam) {
        this.idBelongsTeam = idBelongsTeam;
    }

    /**
     *
     * @return
     */
    public Integer getIdBelongsTeam() {
        return idBelongsTeam;
    }

    /**
     *
     * @param idBelongsTeam
     */
    public void setIdBelongsTeam(Integer idBelongsTeam) {
        this.idBelongsTeam = idBelongsTeam;
    }

    /**
     *
     * @return
     */
    public Date getOnboardingDate() {
        return onboardingDate;
    }

    /**
     *
     * @param onboardingDate
     */
    public void setOnboardingDate(Date onboardingDate) {
        this.onboardingDate = onboardingDate;
    }

    /**
     *
     * @return
     */
    public Date getLeavingDate() {
        return leavingDate;
    }

    /**
     *
     * @param leavingDate
     */
    public void setLeavingDate(Date leavingDate) {
        this.leavingDate = leavingDate;
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
        hash += (idBelongsTeam != null ? idBelongsTeam.hashCode() : 0);
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
        if (!(object instanceof BelongsTeam)) {
            return false;
        }
        BelongsTeam other = (BelongsTeam) object;
        if ((this.idBelongsTeam == null && other.idBelongsTeam != null) || (this.idBelongsTeam != null && !this.idBelongsTeam.equals(other.idBelongsTeam))) {
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
        return "org.centrale.hceres.items.BelongsTeam[ idBelongsTeam=" + idBelongsTeam + " ]";
    }
    
}
