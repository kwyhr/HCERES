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
public class PhdAssociatedCompanyPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "phd_student_id")
    private int phdStudentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "company_id")
    private int companyId;

    /**
     *
     */
    public PhdAssociatedCompanyPK() {
    }

    /**
     *
     * @param phdStudentId
     * @param companyId
     */
    public PhdAssociatedCompanyPK(int phdStudentId, int companyId) {
        this.phdStudentId = phdStudentId;
        this.companyId = companyId;
    }

    /**
     *
     * @return
     */
    public int getPhdStudentId() {
        return phdStudentId;
    }

    /**
     *
     * @param phdStudentId
     */
    public void setPhdStudentId(int phdStudentId) {
        this.phdStudentId = phdStudentId;
    }

    /**
     *
     * @return
     */
    public int getCompanyId() {
        return companyId;
    }

    /**
     *
     * @param companyId
     */
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) phdStudentId;
        hash += (int) companyId;
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
        if (!(object instanceof PhdAssociatedCompanyPK)) {
            return false;
        }
        PhdAssociatedCompanyPK other = (PhdAssociatedCompanyPK) object;
        if (this.phdStudentId != other.phdStudentId) {
            return false;
        }
        if (this.companyId != other.companyId) {
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
        return "org.centrale.hceres.items.PhdAssociatedCompanyPK[ phdStudentId=" + phdStudentId + ", companyId=" + companyId + " ]";
    }
    
}
