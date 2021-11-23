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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "network")
@NamedQueries({
    @NamedQuery(name = "Network.findAll", query = "SELECT n FROM Network n"),
    @NamedQuery(name = "Network.findByIdActivity", query = "SELECT n FROM Network n WHERE n.idActivity = :idActivity"),
    @NamedQuery(name = "Network.findByStartDate", query = "SELECT n FROM Network n WHERE n.startDate = :startDate"),
    @NamedQuery(name = "Network.findByNameNetwork", query = "SELECT n FROM Network n WHERE n.nameNetwork = :nameNetwork"),
    @NamedQuery(name = "Network.findByActiveNetwork", query = "SELECT n FROM Network n WHERE n.activeNetwork = :activeNetwork"),
    @NamedQuery(name = "Network.findByAssociatedFunding", query = "SELECT n FROM Network n WHERE n.associatedFunding = :associatedFunding"),
    @NamedQuery(name = "Network.findByNbResultingPublications", query = "SELECT n FROM Network n WHERE n.nbResultingPublications = :nbResultingPublications"),
    @NamedQuery(name = "Network.findByRefResultingPublications", query = "SELECT n FROM Network n WHERE n.refResultingPublications = :refResultingPublications"),
    @NamedQuery(name = "Network.findByUmrCoordinated", query = "SELECT n FROM Network n WHERE n.umrCoordinated = :umrCoordinated"),
    @NamedQuery(name = "Network.findByAgreementSigned", query = "SELECT n FROM Network n WHERE n.agreementSigned = :agreementSigned")})
public class Network implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Size(max = 256)
    @Column(name = "name_network")
    private String nameNetwork;
    @Column(name = "active_network")
    private Boolean activeNetwork;
    @Size(max = 256)
    @Column(name = "associated_funding")
    private String associatedFunding;
    @Column(name = "nb_resulting_publications")
    private Integer nbResultingPublications;
    @Size(max = 256)
    @Column(name = "ref_resulting_publications")
    private String refResultingPublications;
    @Column(name = "umr_coordinated")
    private Boolean umrCoordinated;
    @Column(name = "agreement_signed")
    private Boolean agreementSigned;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;

    /**
     *
     */
    public Network() {
    }

    /**
     *
     * @param idActivity
     */
    public Network(Integer idActivity) {
        this.idActivity = idActivity;
    }

    /**
     *
     * @return
     */
    public Integer getIdActivity() {
        return idActivity;
    }

    /**
     *
     * @param idActivity
     */
    public void setIdActivity(Integer idActivity) {
        this.idActivity = idActivity;
    }

    /**
     *
     * @return
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @return
     */
    public String getNameNetwork() {
        return nameNetwork;
    }

    /**
     *
     * @param nameNetwork
     */
    public void setNameNetwork(String nameNetwork) {
        this.nameNetwork = nameNetwork;
    }

    /**
     *
     * @return
     */
    public Boolean getActiveNetwork() {
        return activeNetwork;
    }

    /**
     *
     * @param activeNetwork
     */
    public void setActiveNetwork(Boolean activeNetwork) {
        this.activeNetwork = activeNetwork;
    }

    /**
     *
     * @return
     */
    public String getAssociatedFunding() {
        return associatedFunding;
    }

    /**
     *
     * @param associatedFunding
     */
    public void setAssociatedFunding(String associatedFunding) {
        this.associatedFunding = associatedFunding;
    }

    /**
     *
     * @return
     */
    public Integer getNbResultingPublications() {
        return nbResultingPublications;
    }

    /**
     *
     * @param nbResultingPublications
     */
    public void setNbResultingPublications(Integer nbResultingPublications) {
        this.nbResultingPublications = nbResultingPublications;
    }

    /**
     *
     * @return
     */
    public String getRefResultingPublications() {
        return refResultingPublications;
    }

    /**
     *
     * @param refResultingPublications
     */
    public void setRefResultingPublications(String refResultingPublications) {
        this.refResultingPublications = refResultingPublications;
    }

    /**
     *
     * @return
     */
    public Boolean getUmrCoordinated() {
        return umrCoordinated;
    }

    /**
     *
     * @param umrCoordinated
     */
    public void setUmrCoordinated(Boolean umrCoordinated) {
        this.umrCoordinated = umrCoordinated;
    }

    /**
     *
     * @return
     */
    public Boolean getAgreementSigned() {
        return agreementSigned;
    }

    /**
     *
     * @param agreementSigned
     */
    public void setAgreementSigned(Boolean agreementSigned) {
        this.agreementSigned = agreementSigned;
    }

    /**
     *
     * @return
     */
    public Activity getActivity() {
        return activity;
    }

    /**
     *
     * @param activity
     */
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActivity != null ? idActivity.hashCode() : 0);
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
        if (!(object instanceof Network)) {
            return false;
        }
        Network other = (Network) object;
        if ((this.idActivity == null && other.idActivity != null) || (this.idActivity != null && !this.idActivity.equals(other.idActivity))) {
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
        return "org.centrale.hceres.items.Network[ idActivity=" + idActivity + " ]";
    }
    
}
