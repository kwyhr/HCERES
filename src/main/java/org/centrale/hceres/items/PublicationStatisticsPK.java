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
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kwyhr
 */
@Embeddable
public class PublicationStatisticsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "team_id")
    private int teamId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "publication_statistics_year")
    private int publicationStatisticsYear;

    /**
     *
     */
    public PublicationStatisticsPK() {
    }

    /**
     *
     * @param teamId
     * @param publicationStatisticsYear
     */
    public PublicationStatisticsPK(int teamId, int publicationStatisticsYear) {
        this.teamId = teamId;
        this.publicationStatisticsYear = publicationStatisticsYear;
    }

    /**
     *
     * @return
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     *
     * @param teamId
     */
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    /**
     *
     * @return
     */
    public int getPublicationStatisticsYear() {
        return publicationStatisticsYear;
    }

    /**
     *
     * @param publicationStatisticsYear
     */
    public void setPublicationStatisticsYear(int publicationStatisticsYear) {
        this.publicationStatisticsYear = publicationStatisticsYear;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) teamId;
        hash += (int) publicationStatisticsYear;
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
        if (!(object instanceof PublicationStatisticsPK)) {
            return false;
        }
        PublicationStatisticsPK other = (PublicationStatisticsPK) object;
        if (this.teamId != other.teamId) {
            return false;
        }
        if (this.publicationStatisticsYear != other.publicationStatisticsYear) {
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
        return "org.centrale.hceres.items.PublicationStatisticsPK[ teamId=" + teamId + ", publicationStatisticsYear=" + publicationStatisticsYear + " ]";
    }
    
}
