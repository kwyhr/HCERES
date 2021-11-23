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
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "supervisor")
@NamedQueries({
    @NamedQuery(name = "Supervisor.findAll", query = "SELECT s FROM Supervisor s"),
    @NamedQuery(name = "Supervisor.findBySupervisorId", query = "SELECT s FROM Supervisor s WHERE s.supervisorId = :supervisorId"),
    @NamedQuery(name = "Supervisor.findBySupervisorPercentage", query = "SELECT s FROM Supervisor s WHERE s.supervisorPercentage = :supervisorPercentage")})
public class Supervisor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "supervisor_id")
    private Integer supervisorId;
    @Column(name = "supervisor_percentage")
    private BigInteger supervisorPercentage;
    @JoinColumn(name = "phd_student_id", referencedColumnName = "phd_student_id")
    @ManyToOne(optional = false)
    private PhdStudent phdStudentId;
    @JoinColumn(name = "researcher_id", referencedColumnName = "researcher_id")
    @ManyToOne(optional = false)
    private Researcher researcherId;

    /**
     *
     */
    public Supervisor() {
    }

    /**
     *
     * @param supervisorId
     */
    public Supervisor(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }

    /**
     *
     * @return
     */
    public Integer getSupervisorId() {
        return supervisorId;
    }

    /**
     *
     * @param supervisorId
     */
    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }

    /**
     *
     * @return
     */
    public BigInteger getSupervisorPercentage() {
        return supervisorPercentage;
    }

    /**
     *
     * @param supervisorPercentage
     */
    public void setSupervisorPercentage(BigInteger supervisorPercentage) {
        this.supervisorPercentage = supervisorPercentage;
    }

    /**
     *
     * @return
     */
    public PhdStudent getPhdStudentId() {
        return phdStudentId;
    }

    /**
     *
     * @param phdStudentId
     */
    public void setPhdStudentId(PhdStudent phdStudentId) {
        this.phdStudentId = phdStudentId;
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
        hash += (supervisorId != null ? supervisorId.hashCode() : 0);
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
        if (!(object instanceof Supervisor)) {
            return false;
        }
        Supervisor other = (Supervisor) object;
        if ((this.supervisorId == null && other.supervisorId != null) || (this.supervisorId != null && !this.supervisorId.equals(other.supervisorId))) {
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
        return "org.centrale.hceres.items.Supervisor[ supervisorId=" + supervisorId + " ]";
    }
    
}
