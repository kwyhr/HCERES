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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "admin")
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findByResearcherId", query = "SELECT a FROM Admin a WHERE a.researcherId = :researcherId")})
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "researcher_id")
    private Integer researcherId;
    @JoinColumn(name = "researcher_id", referencedColumnName = "researcher_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Researcher researcher;

    /**
     *
     */
    public Admin() {
    }

    /**
     *
     * @param researcherId
     */
    public Admin(Integer researcherId) {
        this.researcherId = researcherId;
    }

    /**
     *
     * @return
     */
    public Integer getResearcherId() {
        return researcherId;
    }

    /**
     *
     * @param researcherId
     */
    public void setResearcherId(Integer researcherId) {
        this.researcherId = researcherId;
    }

    /**
     *
     * @return
     */
    public Researcher getResearcher() {
        return researcher;
    }

    /**
     *
     * @param researcher
     */
    public void setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (researcherId != null ? researcherId.hashCode() : 0);
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
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.researcherId == null && other.researcherId != null) || (this.researcherId != null && !this.researcherId.equals(other.researcherId))) {
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
        return "org.centrale.hceres.items.Admin[ researcherId=" + researcherId + " ]";
    }
    
}
