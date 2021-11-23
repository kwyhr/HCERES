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
@Table(name = "institution")
@NamedQueries({
    @NamedQuery(name = "Institution.findAll", query = "SELECT i FROM Institution i"),
    @NamedQuery(name = "Institution.findByInstitutionId", query = "SELECT i FROM Institution i WHERE i.institutionId = :institutionId"),
    @NamedQuery(name = "Institution.findByInstitutionName", query = "SELECT i FROM Institution i WHERE i.institutionName = :institutionName")})
public class Institution implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "institution_id")
    private Integer institutionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "institution_name")
    private String institutionName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "institutionId")
    private Collection<Laboratory> laboratoryCollection;

    /**
     *
     */
    public Institution() {
    }

    /**
     *
     * @param institutionId
     */
    public Institution(Integer institutionId) {
        this.institutionId = institutionId;
    }

    /**
     *
     * @param institutionId
     * @param institutionName
     */
    public Institution(Integer institutionId, String institutionName) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
    }

    /**
     *
     * @return
     */
    public Integer getInstitutionId() {
        return institutionId;
    }

    /**
     *
     * @param institutionId
     */
    public void setInstitutionId(Integer institutionId) {
        this.institutionId = institutionId;
    }

    /**
     *
     * @return
     */
    public String getInstitutionName() {
        return institutionName;
    }

    /**
     *
     * @param institutionName
     */
    public void setNameInstitution(String institutionName) {
        this.institutionName = institutionName;
    }

    /**
     *
     * @return
     */
    public Collection<Laboratory> getLaboratoryCollection() {
        return laboratoryCollection;
    }

    /**
     *
     * @param laboratoryCollection
     */
    public void setLaboratoryCollection(Collection<Laboratory> laboratoryCollection) {
        this.laboratoryCollection = laboratoryCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (institutionId != null ? institutionId.hashCode() : 0);
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
        if (!(object instanceof Institution)) {
            return false;
        }
        Institution other = (Institution) object;
        if ((this.institutionId == null && other.institutionId != null) || (this.institutionId != null && !this.institutionId.equals(other.institutionId))) {
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
        return "org.centrale.hceres.items.Institution[ institutionId=" + institutionId + " ]";
    }
    
}
