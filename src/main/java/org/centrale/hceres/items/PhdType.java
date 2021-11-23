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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "phd_type")
@NamedQueries({
    @NamedQuery(name = "PhdType.findAll", query = "SELECT p FROM PhdType p"),
    @NamedQuery(name = "PhdType.findByPhdTypeId", query = "SELECT p FROM PhdType p WHERE p.phdTypeId = :phdTypeId"),
    @NamedQuery(name = "PhdType.findByPhdTypeName", query = "SELECT p FROM PhdType p WHERE p.phdTypeName = :phdTypeName")})
public class PhdType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "phd_type_id")
    private Integer phdTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "phd_type_name")
    private String phdTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phdTypeId")
    private Collection<PhdStudent> phdStudentCollection;

    /**
     *
     */
    public PhdType() {
    }

    /**
     *
     * @param phdTypeId
     */
    public PhdType(Integer phdTypeId) {
        this.phdTypeId = phdTypeId;
    }

    /**
     *
     * @param phdTypeId
     * @param phdTypeName
     */
    public PhdType(Integer phdTypeId, String phdTypeName) {
        this.phdTypeId = phdTypeId;
        this.phdTypeName = phdTypeName;
    }

    /**
     *
     * @return
     */
    public Integer getPhdTypeId() {
        return phdTypeId;
    }

    /**
     *
     * @param phdTypeId
     */
    public void setPhdTypeId(Integer phdTypeId) {
        this.phdTypeId = phdTypeId;
    }

    /**
     *
     * @return
     */
    public String getPhdTypeName() {
        return phdTypeName;
    }

    /**
     *
     * @param phdTypeName
     */
    public void setPhdTypeName(String phdTypeName) {
        this.phdTypeName = phdTypeName;
    }

    /**
     *
     * @return
     */
    public Collection<PhdStudent> getPhdStudentCollection() {
        return phdStudentCollection;
    }

    /**
     *
     * @param phdStudentCollection
     */
    public void setPhdStudentCollection(Collection<PhdStudent> phdStudentCollection) {
        this.phdStudentCollection = phdStudentCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phdTypeId != null ? phdTypeId.hashCode() : 0);
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
        if (!(object instanceof PhdType)) {
            return false;
        }
        PhdType other = (PhdType) object;
        if ((this.phdTypeId == null && other.phdTypeId != null) || (this.phdTypeId != null && !this.phdTypeId.equals(other.phdTypeId))) {
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
        return "org.centrale.hceres.items.PhdType[ phdTypeId=" + phdTypeId + " ]";
    }
    
}
