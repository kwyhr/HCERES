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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "phd_associated_company")
@NamedQueries({
    @NamedQuery(name = "PhdAssociatedCompany.findAll", query = "SELECT p FROM PhdAssociatedCompany p"),
    @NamedQuery(name = "PhdAssociatedCompany.findByPhdStudentId", query = "SELECT p FROM PhdAssociatedCompany p WHERE p.phdAssociatedCompanyPK.phdStudentId = :phdStudentId"),
    @NamedQuery(name = "PhdAssociatedCompany.findByCompanyId", query = "SELECT p FROM PhdAssociatedCompany p WHERE p.phdAssociatedCompanyPK.companyId = :companyId"),
    @NamedQuery(name = "PhdAssociatedCompany.findByPhdAssociatedCompanyStart", query = "SELECT p FROM PhdAssociatedCompany p WHERE p.phdAssociatedCompanyStart = :phdAssociatedCompanyStart"),
    @NamedQuery(name = "PhdAssociatedCompany.findByPhdAssociatedCompanyEnd", query = "SELECT p FROM PhdAssociatedCompany p WHERE p.phdAssociatedCompanyEnd = :phdAssociatedCompanyEnd")})
public class PhdAssociatedCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @EmbeddedId
    protected PhdAssociatedCompanyPK phdAssociatedCompanyPK;
    @Column(name = "phd_associated_company_start")
    @Temporal(TemporalType.DATE)
    private Date phdAssociatedCompanyStart;
    @Column(name = "phd_associated_company_end")
    @Temporal(TemporalType.DATE)
    private Date phdAssociatedCompanyEnd;
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Company company;
    @JoinColumn(name = "phd_student_id", referencedColumnName = "phd_student_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PhdStudent phdStudent;

    /**
     *
     */
    public PhdAssociatedCompany() {
    }

    /**
     *
     * @param phdAssociatedCompanyPK
     */
    public PhdAssociatedCompany(PhdAssociatedCompanyPK phdAssociatedCompanyPK) {
        this.phdAssociatedCompanyPK = phdAssociatedCompanyPK;
    }

    /**
     *
     * @param phdStudentId
     * @param companyId
     */
    public PhdAssociatedCompany(int phdStudentId, int companyId) {
        this.phdAssociatedCompanyPK = new PhdAssociatedCompanyPK(phdStudentId, companyId);
    }

    /**
     *
     * @return
     */
    public PhdAssociatedCompanyPK getPhdAssociatedCompanyPK() {
        return phdAssociatedCompanyPK;
    }

    /**
     *
     * @param phdAssociatedCompanyPK
     */
    public void setPhdAssociatedCompanyPK(PhdAssociatedCompanyPK phdAssociatedCompanyPK) {
        this.phdAssociatedCompanyPK = phdAssociatedCompanyPK;
    }

    /**
     *
     * @return
     */
    public Date getPhdAssociatedCompanyStart() {
        return phdAssociatedCompanyStart;
    }

    /**
     *
     * @param phdAssociatedCompanyStart
     */
    public void setPhdAssociatedCompanyStart(Date phdAssociatedCompanyStart) {
        this.phdAssociatedCompanyStart = phdAssociatedCompanyStart;
    }

    /**
     *
     * @return
     */
    public Date getPhdAssociatedCompanyEnd() {
        return phdAssociatedCompanyEnd;
    }

    /**
     *
     * @param phdAssociatedCompanyEnd
     */
    public void setPhdAssociatedCompanyEnd(Date phdAssociatedCompanyEnd) {
        this.phdAssociatedCompanyEnd = phdAssociatedCompanyEnd;
    }

    /**
     *
     * @return
     */
    public Company getCompany() {
        return company;
    }

    /**
     *
     * @param company
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     *
     * @return
     */
    public PhdStudent getPhdStudent() {
        return phdStudent;
    }

    /**
     *
     * @param phdStudent
     */
    public void setPhdStudent(PhdStudent phdStudent) {
        this.phdStudent = phdStudent;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phdAssociatedCompanyPK != null ? phdAssociatedCompanyPK.hashCode() : 0);
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
        if (!(object instanceof PhdAssociatedCompany)) {
            return false;
        }
        PhdAssociatedCompany other = (PhdAssociatedCompany) object;
        if ((this.phdAssociatedCompanyPK == null && other.phdAssociatedCompanyPK != null) || (this.phdAssociatedCompanyPK != null && !this.phdAssociatedCompanyPK.equals(other.phdAssociatedCompanyPK))) {
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
        return "org.centrale.hceres.items.PhdAssociatedCompany[ phdAssociatedCompanyPK=" + phdAssociatedCompanyPK + " ]";
    }
    
}
