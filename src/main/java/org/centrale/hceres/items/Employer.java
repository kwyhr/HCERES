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
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "employer")
@NamedQueries({
    @NamedQuery(name = "Employer.findAll", query = "SELECT e FROM Employer e"),
    @NamedQuery(name = "Employer.findByIdEmployer", query = "SELECT e FROM Employer e WHERE e.idEmployer = :idEmployer"),
    @NamedQuery(name = "Employer.findByNameEmployer", query = "SELECT e FROM Employer e WHERE e.nameEmployer = :nameEmployer")})
public class Employer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_employer")
    private Integer idEmployer;
    @Size(max = 256)
    @Column(name = "name_employer")
    private String nameEmployer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmployer")
    private Collection<Contract> contractCollection;

    /**
     *
     */
    public Employer() {
    }

    /**
     *
     * @param idEmployer
     */
    public Employer(Integer idEmployer) {
        this.idEmployer = idEmployer;
    }

    /**
     *
     * @return
     */
    public Integer getIdEmployer() {
        return idEmployer;
    }

    /**
     *
     * @param idEmployer
     */
    public void setIdEmployer(Integer idEmployer) {
        this.idEmployer = idEmployer;
    }

    /**
     *
     * @return
     */
    public String getNameEmployer() {
        return nameEmployer;
    }

    /**
     *
     * @param nameEmployer
     */
    public void setNameEmployer(String nameEmployer) {
        this.nameEmployer = nameEmployer;
    }

    /**
     *
     * @return
     */
    public Collection<Contract> getContractCollection() {
        return contractCollection;
    }

    /**
     *
     * @param contractCollection
     */
    public void setContractCollection(Collection<Contract> contractCollection) {
        this.contractCollection = contractCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmployer != null ? idEmployer.hashCode() : 0);
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
        if (!(object instanceof Employer)) {
            return false;
        }
        Employer other = (Employer) object;
        if ((this.idEmployer == null && other.idEmployer != null) || (this.idEmployer != null && !this.idEmployer.equals(other.idEmployer))) {
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
        return "org.centrale.hceres.items.Employer[ idEmployer=" + idEmployer + " ]";
    }
    
}
