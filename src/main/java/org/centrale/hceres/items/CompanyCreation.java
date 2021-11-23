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
@Table(name = "company_creation")
@NamedQueries({
    @NamedQuery(name = "CompanyCreation.findAll", query = "SELECT c FROM CompanyCreation c"),
    @NamedQuery(name = "CompanyCreation.findByIdActivity", query = "SELECT c FROM CompanyCreation c WHERE c.idActivity = :idActivity"),
    @NamedQuery(name = "CompanyCreation.findByCompanyCreationName", query = "SELECT c FROM CompanyCreation c WHERE c.companyCreationName = :companyCreationName"),
    @NamedQuery(name = "CompanyCreation.findByCompanyCreationDate", query = "SELECT c FROM CompanyCreation c WHERE c.companyCreationDate = :companyCreationDate"),
    @NamedQuery(name = "CompanyCreation.findByCompanyCreationActive", query = "SELECT c FROM CompanyCreation c WHERE c.companyCreationActive = :companyCreationActive")})
public class CompanyCreation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Size(max = 256)
    @Column(name = "company_creation_name")
    private String companyCreationName;
    @Column(name = "company_creation_date")
    @Temporal(TemporalType.DATE)
    private Date companyCreationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "company_creation_active")
    private boolean companyCreationActive;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;

    /**
     *
     */
    public CompanyCreation() {
    }

    /**
     *
     * @param idActivity
     */
    public CompanyCreation(Integer idActivity) {
        this.idActivity = idActivity;
    }

    /**
     *
     * @param idActivity
     * @param companyCreationActive
     */
    public CompanyCreation(Integer idActivity, boolean companyCreationActive) {
        this.idActivity = idActivity;
        this.companyCreationActive = companyCreationActive;
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
    public String getCompanyCreationName() {
        return companyCreationName;
    }

    /**
     *
     * @param companyCreationName
     */
    public void setCompanyCreationName(String companyCreationName) {
        this.companyCreationName = companyCreationName;
    }

    /**
     *
     * @return
     */
    public Date getCompanyCreationDate() {
        return companyCreationDate;
    }

    /**
     *
     * @param companyCreationDate
     */
    public void setCompanyCreationDate(Date companyCreationDate) {
        this.companyCreationDate = companyCreationDate;
    }

    /**
     *
     * @return
     */
    public boolean getCompanyCreationActive() {
        return companyCreationActive;
    }

    /**
     *
     * @param companyCreationActive
     */
    public void setCompanyCreationActive(boolean companyCreationActive) {
        this.companyCreationActive = companyCreationActive;
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
        if (!(object instanceof CompanyCreation)) {
            return false;
        }
        CompanyCreation other = (CompanyCreation) object;
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
        return "org.centrale.hceres.items.CompanyCreation[ idActivity=" + idActivity + " ]";
    }
    
}
