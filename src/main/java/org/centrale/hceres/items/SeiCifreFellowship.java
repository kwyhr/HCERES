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
@Table(name = "sei_cifre_fellowship")
@NamedQueries({
    @NamedQuery(name = "SeiCifreFellowship.findAll", query = "SELECT s FROM SeiCifreFellowship s"),
    @NamedQuery(name = "SeiCifreFellowship.findByIdActivity", query = "SELECT s FROM SeiCifreFellowship s WHERE s.idActivity = :idActivity"),
    @NamedQuery(name = "SeiCifreFellowship.findByContractStartDate", query = "SELECT s FROM SeiCifreFellowship s WHERE s.contractStartDate = :contractStartDate"),
    @NamedQuery(name = "SeiCifreFellowship.findByNameFellow", query = "SELECT s FROM SeiCifreFellowship s WHERE s.nameFellow = :nameFellow"),
    @NamedQuery(name = "SeiCifreFellowship.findByNameCompanyInvolved", query = "SELECT s FROM SeiCifreFellowship s WHERE s.nameCompanyInvolved = :nameCompanyInvolved"),
    @NamedQuery(name = "SeiCifreFellowship.findByTitleThesis", query = "SELECT s FROM SeiCifreFellowship s WHERE s.titleThesis = :titleThesis"),
    @NamedQuery(name = "SeiCifreFellowship.findByContractEndDate", query = "SELECT s FROM SeiCifreFellowship s WHERE s.contractEndDate = :contractEndDate"),
    @NamedQuery(name = "SeiCifreFellowship.findByContractAmount", query = "SELECT s FROM SeiCifreFellowship s WHERE s.contractAmount = :contractAmount"),
    @NamedQuery(name = "SeiCifreFellowship.findByAssociatedPubliRef", query = "SELECT s FROM SeiCifreFellowship s WHERE s.associatedPubliRef = :associatedPubliRef")})
public class SeiCifreFellowship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Column(name = "contract_start_date")
    @Temporal(TemporalType.DATE)
    private Date contractStartDate;
    @Size(max = 256)
    @Column(name = "name_fellow")
    private String nameFellow;
    @Size(max = 256)
    @Column(name = "name_company_involved")
    private String nameCompanyInvolved;
    @Size(max = 256)
    @Column(name = "title_thesis")
    private String titleThesis;
    @Column(name = "contract_end_date")
    @Temporal(TemporalType.DATE)
    private Date contractEndDate;
    @Column(name = "contract_amount")
    private Integer contractAmount;
    @Size(max = 256)
    @Column(name = "associated_publi_ref")
    private String associatedPubliRef;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;

    /**
     *
     */
    public SeiCifreFellowship() {
    }

    /**
     *
     * @param idActivity
     */
    public SeiCifreFellowship(Integer idActivity) {
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
    public String getNameFellow() {
        return nameFellow;
    }

    /**
     *
     * @param nameFellow
     */
    public void setNameFellow(String nameFellow) {
        this.nameFellow = nameFellow;
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
    public String getTitleThesis() {
        return titleThesis;
    }

    /**
     *
     * @param titleThesis
     */
    public void setTitleThesis(String titleThesis) {
        this.titleThesis = titleThesis;
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
    public Integer getContractAmount() {
        return contractAmount;
    }

    /**
     *
     * @param contractAmount
     */
    public void setContractAmount(Integer contractAmount) {
        this.contractAmount = contractAmount;
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
        if (!(object instanceof SeiCifreFellowship)) {
            return false;
        }
        SeiCifreFellowship other = (SeiCifreFellowship) object;
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
        return "org.centrale.hceres.items.SeiCifreFellowship[ idActivity=" + idActivity + " ]";
    }
    
}
