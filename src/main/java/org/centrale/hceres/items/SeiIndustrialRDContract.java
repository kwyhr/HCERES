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
@Table(name = "sei_industrial_r_d_contract")
@NamedQueries({
    @NamedQuery(name = "SeiIndustrialRDContract.findAll", query = "SELECT s FROM SeiIndustrialRDContract s"),
    @NamedQuery(name = "SeiIndustrialRDContract.findByIdActivity", query = "SELECT s FROM SeiIndustrialRDContract s WHERE s.idActivity = :idActivity"),
    @NamedQuery(name = "SeiIndustrialRDContract.findByStartDate", query = "SELECT s FROM SeiIndustrialRDContract s WHERE s.startDate = :startDate"),
    @NamedQuery(name = "SeiIndustrialRDContract.findByNameCompanyInvolved", query = "SELECT s FROM SeiIndustrialRDContract s WHERE s.nameCompanyInvolved = :nameCompanyInvolved"),
    @NamedQuery(name = "SeiIndustrialRDContract.findByProjectTitle", query = "SELECT s FROM SeiIndustrialRDContract s WHERE s.projectTitle = :projectTitle"),
    @NamedQuery(name = "SeiIndustrialRDContract.findByAgreementAmount", query = "SELECT s FROM SeiIndustrialRDContract s WHERE s.agreementAmount = :agreementAmount"),
    @NamedQuery(name = "SeiIndustrialRDContract.findByEndDate", query = "SELECT s FROM SeiIndustrialRDContract s WHERE s.endDate = :endDate"),
    @NamedQuery(name = "SeiIndustrialRDContract.findByAssociatedPubliRef", query = "SELECT s FROM SeiIndustrialRDContract s WHERE s.associatedPubliRef = :associatedPubliRef")})
public class SeiIndustrialRDContract implements Serializable {

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
    @Column(name = "name_company_involved")
    private String nameCompanyInvolved;
    @Size(max = 256)
    @Column(name = "project_title")
    private String projectTitle;
    @Column(name = "agreement_amount")
    private Integer agreementAmount;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Size(max = 256)
    @Column(name = "associated_publi_ref")
    private String associatedPubliRef;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;

    /**
     *
     */
    public SeiIndustrialRDContract() {
    }

    /**
     *
     * @param idActivity
     */
    public SeiIndustrialRDContract(Integer idActivity) {
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
    public String getProjectTitle() {
        return projectTitle;
    }

    /**
     *
     * @param projectTitle
     */
    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    /**
     *
     * @return
     */
    public Integer getAgreementAmount() {
        return agreementAmount;
    }

    /**
     *
     * @param agreementAmount
     */
    public void setAgreementAmount(Integer agreementAmount) {
        this.agreementAmount = agreementAmount;
    }

    /**
     *
     * @return
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     *
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        if (!(object instanceof SeiIndustrialRDContract)) {
            return false;
        }
        SeiIndustrialRDContract other = (SeiIndustrialRDContract) object;
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
        return "org.centrale.hceres.items.SeiIndustrialRDContract[ idActivity=" + idActivity + " ]";
    }
    
}
