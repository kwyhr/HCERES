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
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "phd_student")
@NamedQueries({
    @NamedQuery(name = "PhdStudent.findAll", query = "SELECT p FROM PhdStudent p"),
    @NamedQuery(name = "PhdStudent.findByPhdStudentId", query = "SELECT p FROM PhdStudent p WHERE p.phdStudentId = :phdStudentId"),
    @NamedQuery(name = "PhdStudent.findByPhdStart", query = "SELECT p FROM PhdStudent p WHERE p.phdStart = :phdStart"),
    @NamedQuery(name = "PhdStudent.findByPhdMainFunding", query = "SELECT p FROM PhdStudent p WHERE p.phdMainFunding = :phdMainFunding"),
    @NamedQuery(name = "PhdStudent.findByPhdDefenseDate", query = "SELECT p FROM PhdStudent p WHERE p.phdDefenseDate = :phdDefenseDate"),
    @NamedQuery(name = "PhdStudent.findByPhdDuration", query = "SELECT p FROM PhdStudent p WHERE p.phdDuration = :phdDuration"),
    @NamedQuery(name = "PhdStudent.findByPhdFutur", query = "SELECT p FROM PhdStudent p WHERE p.phdFutur = :phdFutur")})
public class PhdStudent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "phd_student_id")
    private Integer phdStudentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "phd_start")
    @Temporal(TemporalType.DATE)
    private Date phdStart;
    @Size(max = 256)
    @Column(name = "phd_main_funding")
    private String phdMainFunding;
    @Column(name = "phd_defense_date")
    @Temporal(TemporalType.DATE)
    private Date phdDefenseDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "phd_duration")
    private int phdDuration;
    @Size(max = 2147483647)
    @Column(name = "phd_futur")
    private String phdFutur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phdStudentId")
    private Collection<Supervisor> supervisorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phdStudent")
    private Collection<PhdAssociatedCompany> phdAssociatedCompanyCollection;
    @JoinColumn(name = "phd_type_id", referencedColumnName = "phd_type_id")
    @ManyToOne(optional = false)
    private PhdType phdTypeId;
    @JoinColumn(name = "researcher_id", referencedColumnName = "researcher_id")
    @ManyToOne(optional = false)
    private Researcher researcherId;

    /**
     *
     */
    public PhdStudent() {
    }

    /**
     *
     * @param phdStudentId
     */
    public PhdStudent(Integer phdStudentId) {
        this.phdStudentId = phdStudentId;
    }

    /**
     *
     * @param phdStudentId
     * @param phdStart
     * @param phdDuration
     */
    public PhdStudent(Integer phdStudentId, Date phdStart, int phdDuration) {
        this.phdStudentId = phdStudentId;
        this.phdStart = phdStart;
        this.phdDuration = phdDuration;
    }

    /**
     *
     * @return
     */
    public Integer getPhdStudentId() {
        return phdStudentId;
    }

    /**
     *
     * @param phdStudentId
     */
    public void setPhdStudentId(Integer phdStudentId) {
        this.phdStudentId = phdStudentId;
    }

    /**
     *
     * @return
     */
    public Date getPhdStart() {
        return phdStart;
    }

    /**
     *
     * @param phdStart
     */
    public void setPhdStart(Date phdStart) {
        this.phdStart = phdStart;
    }

    /**
     *
     * @return
     */
    public String getPhdMainFunding() {
        return phdMainFunding;
    }

    /**
     *
     * @param phdMainFunding
     */
    public void setPhdMainFunding(String phdMainFunding) {
        this.phdMainFunding = phdMainFunding;
    }

    /**
     *
     * @return
     */
    public Date getPhdDefenseDate() {
        return phdDefenseDate;
    }

    /**
     *
     * @param phdDefenseDate
     */
    public void setPhdDefenseDate(Date phdDefenseDate) {
        this.phdDefenseDate = phdDefenseDate;
    }

    /**
     *
     * @return
     */
    public int getPhdDuration() {
        return phdDuration;
    }

    /**
     *
     * @param phdDuration
     */
    public void setPhdDuration(int phdDuration) {
        this.phdDuration = phdDuration;
    }

    /**
     *
     * @return
     */
    public String getPhdFutur() {
        return phdFutur;
    }

    /**
     *
     * @param phdFutur
     */
    public void setPhdFutur(String phdFutur) {
        this.phdFutur = phdFutur;
    }

    /**
     *
     * @return
     */
    public Collection<Supervisor> getSupervisorCollection() {
        return supervisorCollection;
    }

    /**
     *
     * @param supervisorCollection
     */
    public void setSupervisorCollection(Collection<Supervisor> supervisorCollection) {
        this.supervisorCollection = supervisorCollection;
    }

    /**
     *
     * @return
     */
    public Collection<PhdAssociatedCompany> getPhdAssociatedCompanyCollection() {
        return phdAssociatedCompanyCollection;
    }

    /**
     *
     * @param phdAssociatedCompanyCollection
     */
    public void setPhdAssociatedCompanyCollection(Collection<PhdAssociatedCompany> phdAssociatedCompanyCollection) {
        this.phdAssociatedCompanyCollection = phdAssociatedCompanyCollection;
    }

    /**
     *
     * @return
     */
    public PhdType getPhdTypeId() {
        return phdTypeId;
    }

    /**
     *
     * @param phdTypeId
     */
    public void setPhdTypeId(PhdType phdTypeId) {
        this.phdTypeId = phdTypeId;
    }

    /**
     *
     * @return
     */
    public Researcher getResearcherId() {
        return researcherId;
    }

    /**
     *
     * @param researcherId
     */
    public void setResearcherId(Researcher researcherId) {
        this.researcherId = researcherId;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phdStudentId != null ? phdStudentId.hashCode() : 0);
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
        if (!(object instanceof PhdStudent)) {
            return false;
        }
        PhdStudent other = (PhdStudent) object;
        if ((this.phdStudentId == null && other.phdStudentId != null) || (this.phdStudentId != null && !this.phdStudentId.equals(other.phdStudentId))) {
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
        return "org.centrale.hceres.items.PhdStudent[ phdStudentId=" + phdStudentId + " ]";
    }
    
}
