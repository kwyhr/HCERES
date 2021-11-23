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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "publication_statistics")
@NamedQueries({
    @NamedQuery(name = "PublicationStatistics.findAll", query = "SELECT p FROM PublicationStatistics p"),
    @NamedQuery(name = "PublicationStatistics.findByTeamId", query = "SELECT p FROM PublicationStatistics p WHERE p.publicationStatisticsPK.teamId = :teamId"),
    @NamedQuery(name = "PublicationStatistics.findByPublicationStatisticsYear", query = "SELECT p FROM PublicationStatistics p WHERE p.publicationStatisticsPK.publicationStatisticsYear = :publicationStatisticsYear"),
    @NamedQuery(name = "PublicationStatistics.findByPublicationStatisticsPdc", query = "SELECT p FROM PublicationStatistics p WHERE p.publicationStatisticsPdc = :publicationStatisticsPdc"),
    @NamedQuery(name = "PublicationStatistics.findByPublicationStatisticsCollabInt", query = "SELECT p FROM PublicationStatistics p WHERE p.publicationStatisticsCollabInt = :publicationStatisticsCollabInt"),
    @NamedQuery(name = "PublicationStatistics.findByPublicationStatisticsCollabLabo", query = "SELECT p FROM PublicationStatistics p WHERE p.publicationStatisticsCollabLabo = :publicationStatisticsCollabLabo")})
public class PublicationStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @EmbeddedId
    protected PublicationStatisticsPK publicationStatisticsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "publication_statistics_pdc")
    private int publicationStatisticsPdc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "publication_statistics_collab_int")
    private int publicationStatisticsCollabInt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "publication_statistics_collab_labo")
    private int publicationStatisticsCollabLabo;
    @JoinColumn(name = "team_id", referencedColumnName = "team_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Team team;

    /**
     *
     */
    public PublicationStatistics() {
    }

    /**
     *
     * @param publicationStatisticsPK
     */
    public PublicationStatistics(PublicationStatisticsPK publicationStatisticsPK) {
        this.publicationStatisticsPK = publicationStatisticsPK;
    }

    /**
     *
     * @param publicationStatisticsPK
     * @param publicationStatisticsPdc
     * @param publicationStatisticsCollabInt
     * @param publicationStatisticsCollabLabo
     */
    public PublicationStatistics(PublicationStatisticsPK publicationStatisticsPK, int publicationStatisticsPdc, int publicationStatisticsCollabInt, int publicationStatisticsCollabLabo) {
        this.publicationStatisticsPK = publicationStatisticsPK;
        this.publicationStatisticsPdc = publicationStatisticsPdc;
        this.publicationStatisticsCollabInt = publicationStatisticsCollabInt;
        this.publicationStatisticsCollabLabo = publicationStatisticsCollabLabo;
    }

    /**
     *
     * @param teamId
     * @param publicationStatisticsYear
     */
    public PublicationStatistics(int teamId, int publicationStatisticsYear) {
        this.publicationStatisticsPK = new PublicationStatisticsPK(teamId, publicationStatisticsYear);
    }

    /**
     *
     * @return
     */
    public PublicationStatisticsPK getPublicationStatisticsPK() {
        return publicationStatisticsPK;
    }

    /**
     *
     * @param publicationStatisticsPK
     */
    public void setPublicationStatisticsPK(PublicationStatisticsPK publicationStatisticsPK) {
        this.publicationStatisticsPK = publicationStatisticsPK;
    }

    /**
     *
     * @return
     */
    public int getPublicationStatisticsPdc() {
        return publicationStatisticsPdc;
    }

    /**
     *
     * @param publicationStatisticsPdc
     */
    public void setPublicationStatisticsPdc(int publicationStatisticsPdc) {
        this.publicationStatisticsPdc = publicationStatisticsPdc;
    }

    /**
     *
     * @return
     */
    public int getPublicationStatisticsCollabInt() {
        return publicationStatisticsCollabInt;
    }

    /**
     *
     * @param publicationStatisticsCollabInt
     */
    public void setPublicationStatisticsCollabInt(int publicationStatisticsCollabInt) {
        this.publicationStatisticsCollabInt = publicationStatisticsCollabInt;
    }

    /**
     *
     * @return
     */
    public int getPublicationStatisticsCollabLabo() {
        return publicationStatisticsCollabLabo;
    }

    /**
     *
     * @param publicationStatisticsCollabLabo
     */
    public void setPublicationStatisticsCollabLabo(int publicationStatisticsCollabLabo) {
        this.publicationStatisticsCollabLabo = publicationStatisticsCollabLabo;
    }

    /**
     *
     * @return
     */
    public Team getTeam() {
        return team;
    }

    /**
     *
     * @param team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (publicationStatisticsPK != null ? publicationStatisticsPK.hashCode() : 0);
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
        if (!(object instanceof PublicationStatistics)) {
            return false;
        }
        PublicationStatistics other = (PublicationStatistics) object;
        if ((this.publicationStatisticsPK == null && other.publicationStatisticsPK != null) || (this.publicationStatisticsPK != null && !this.publicationStatisticsPK.equals(other.publicationStatisticsPK))) {
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
        return "org.centrale.hceres.items.PublicationStatistics[ publicationStatisticsPK=" + publicationStatisticsPK + " ]";
    }
    
}
