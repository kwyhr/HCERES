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
@Table(name = "labcom_creation")
@NamedQueries({
    @NamedQuery(name = "LabcomCreation.findAll", query = "SELECT l FROM LabcomCreation l"),
    @NamedQuery(name = "LabcomCreation.findByIdActivity", query = "SELECT l FROM LabcomCreation l WHERE l.idActivity = :idActivity"),
    @NamedQuery(name = "LabcomCreation.findByLabcomCreationName", query = "SELECT l FROM LabcomCreation l WHERE l.labcomCreationName = :labcomCreationName"),
    @NamedQuery(name = "LabcomCreation.findByContractStartDate", query = "SELECT l FROM LabcomCreation l WHERE l.contractStartDate = :contractStartDate"),
    @NamedQuery(name = "LabcomCreation.findByNameCompanyInvolved", query = "SELECT l FROM LabcomCreation l WHERE l.nameCompanyInvolved = :nameCompanyInvolved"),
    @NamedQuery(name = "LabcomCreation.findByTitleProject", query = "SELECT l FROM LabcomCreation l WHERE l.titleProject = :titleProject"),
    @NamedQuery(name = "LabcomCreation.findByContractEndDate", query = "SELECT l FROM LabcomCreation l WHERE l.contractEndDate = :contractEndDate"),
    @NamedQuery(name = "LabcomCreation.findByAssociatedPubliRef", query = "SELECT l FROM LabcomCreation l WHERE l.associatedPubliRef = :associatedPubliRef")})
public class LabcomCreation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Size(max = 256)
    @Column(name = "labcom_creation_name")
    private String labcomCreationName;
    @Column(name = "contract_start_date")
    @Temporal(TemporalType.DATE)
    private Date contractStartDate;
    @Size(max = 256)
    @Column(name = "name_company_involved")
    private String nameCompanyInvolved;
    @Size(max = 256)
    @Column(name = "title_project")
    private String titleProject;
    @Column(name = "contract_end_date")
    @Temporal(TemporalType.DATE)
    private Date contractEndDate;
    @Size(max = 256)
    @Column(name = "associated_publi_ref")
    private String associatedPubliRef;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;

    /**
     *
     */
    public LabcomCreation() {
    }

    /**
     *
     * @param idActivity
     */
    public LabcomCreation(Integer idActivity) {
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
    public String getLabcomCreationName() {
        return labcomCreationName;
    }

    /**
     *
     * @param labcomCreationName
     */
    public void setLabcomCreationName(String labcomCreationName) {
        this.labcomCreationName = labcomCreationName;
    }

    /**
     *
     * @return
     */
    public Date getContractStartDate() {
        return contractStartDate;
    }

    /**
     *
     * @param contractStartDate
     */
    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    /**
     *
     * @return
     */
    public String getNameCompanyInvolved() {
        return nameCompanyInvolved;
    }

    /**
     *
     * @param nameCompanyInvolved
     */
    public void setNameCompanyInvolved(String nameCompanyInvolved) {
        this.nameCompanyInvolved = nameCompanyInvolved;
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
    public Date getContractEndDate() {
        return contractEndDate;
    }

    /**
     *
     * @param contractEndDate
     */
    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
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
        if (!(object instanceof LabcomCreation)) {
            return false;
        }
        LabcomCreation other = (LabcomCreation) object;
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
        return "org.centrale.hceres.items.LabcomCreation[ idActivity=" + idActivity + " ]";
    }
    
}
