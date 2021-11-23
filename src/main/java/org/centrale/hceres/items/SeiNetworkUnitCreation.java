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
@Table(name = "sei_network_unit_creation")
@NamedQueries({
    @NamedQuery(name = "SeiNetworkUnitCreation.findAll", query = "SELECT s FROM SeiNetworkUnitCreation s"),
    @NamedQuery(name = "SeiNetworkUnitCreation.findByIdActivity", query = "SELECT s FROM SeiNetworkUnitCreation s WHERE s.idActivity = :idActivity"),
    @NamedQuery(name = "SeiNetworkUnitCreation.findByNetworkStartDate", query = "SELECT s FROM SeiNetworkUnitCreation s WHERE s.networkStartDate = :networkStartDate"),
    @NamedQuery(name = "SeiNetworkUnitCreation.findByNameNetwork", query = "SELECT s FROM SeiNetworkUnitCreation s WHERE s.nameNetwork = :nameNetwork"),
    @NamedQuery(name = "SeiNetworkUnitCreation.findByNamePartner", query = "SELECT s FROM SeiNetworkUnitCreation s WHERE s.namePartner = :namePartner"),
    @NamedQuery(name = "SeiNetworkUnitCreation.findByTitleProject", query = "SELECT s FROM SeiNetworkUnitCreation s WHERE s.titleProject = :titleProject"),
    @NamedQuery(name = "SeiNetworkUnitCreation.findByNetworkEndDate", query = "SELECT s FROM SeiNetworkUnitCreation s WHERE s.networkEndDate = :networkEndDate"),
    @NamedQuery(name = "SeiNetworkUnitCreation.findByAssociatedPubliRef", query = "SELECT s FROM SeiNetworkUnitCreation s WHERE s.associatedPubliRef = :associatedPubliRef")})
public class SeiNetworkUnitCreation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Column(name = "network_start_date")
    @Temporal(TemporalType.DATE)
    private Date networkStartDate;
    @Size(max = 256)
    @Column(name = "name_network")
    private String nameNetwork;
    @Size(max = 256)
    @Column(name = "name_partner")
    private String namePartner;
    @Size(max = 256)
    @Column(name = "title_project")
    private String titleProject;
    @Column(name = "network_end_date")
    @Temporal(TemporalType.DATE)
    private Date networkEndDate;
    @Size(max = 256)
    @Column(name = "associated_publi_ref")
    private String associatedPubliRef;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;

    /**
     *
     */
    public SeiNetworkUnitCreation() {
    }

    /**
     *
     * @param idActivity
     */
    public SeiNetworkUnitCreation(Integer idActivity) {
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
    public Date getNetworkStartDate() {
        return networkStartDate;
    }

    /**
     *
     * @param networkStartDate
     */
    public void setNetworkStartDate(Date networkStartDate) {
        this.networkStartDate = networkStartDate;
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
    public String getNamePartner() {
        return namePartner;
    }

    /**
     *
     * @param namePartner
     */
    public void setNamePartner(String namePartner) {
        this.namePartner = namePartner;
    }

    /**
     *
     * @return
     */
    public String getTitleProject() {
        return titleProject;
    }

    /**
     *
     * @param titleProject
     */
    public void setTitleProject(String titleProject) {
        this.titleProject = titleProject;
    }

    /**
     *
     * @return
     */
    public Date getNetworkEndDate() {
        return networkEndDate;
    }

    /**
     *
     * @param networkEndDate
     */
    public void setNetworkEndDate(Date networkEndDate) {
        this.networkEndDate = networkEndDate;
    }

    /**
     *
     * @return
     */
    public String getAssociatedPubliRef() {
        return associatedPubliRef;
    }

    /**
     *
     * @param associatedPubliRef
     */
    public void setAssociatedPubliRef(String associatedPubliRef) {
        this.associatedPubliRef = associatedPubliRef;
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
        if (!(object instanceof SeiNetworkUnitCreation)) {
            return false;
        }
        SeiNetworkUnitCreation other = (SeiNetworkUnitCreation) object;
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
        return "org.centrale.hceres.items.SeiNetworkUnitCreation[ idActivity=" + idActivity + " ]";
    }
    
}
