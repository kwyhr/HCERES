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
@Table(name = "type_consortium")
@NamedQueries({
    @NamedQuery(name = "TypeConsortium.findAll", query = "SELECT t FROM TypeConsortium t"),
    @NamedQuery(name = "TypeConsortium.findByTypeConsortiumId", query = "SELECT t FROM TypeConsortium t WHERE t.typeConsortiumId = :typeConsortiumId"),
    @NamedQuery(name = "TypeConsortium.findByTypeConsortiumName", query = "SELECT t FROM TypeConsortium t WHERE t.typeConsortiumName = :typeConsortiumName")})
public class TypeConsortium implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "type_consortium_id")
    private Integer typeConsortiumId;
    @Size(max = 256)
    @Column(name = "type_consortium_name")
    private String typeConsortiumName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeConsortiumId")
    private Collection<SeiLeadConsortiumIndustry> seiLeadConsortiumIndustryCollection;

    /**
     *
     */
    public TypeConsortium() {
    }

    /**
     *
     * @param typeConsortiumId
     */
    public TypeConsortium(Integer typeConsortiumId) {
        this.typeConsortiumId = typeConsortiumId;
    }

    /**
     *
     * @return
     */
    public Integer getTypeConsortiumId() {
        return typeConsortiumId;
    }

    /**
     *
     * @param typeConsortiumId
     */
    public void setTypeConsortiumId(Integer typeConsortiumId) {
        this.typeConsortiumId = typeConsortiumId;
    }

    /**
     *
     * @return
     */
    public String getTypeConsortiumName() {
        return typeConsortiumName;
    }

    /**
     *
     * @param typeConsortiumName
     */
    public void setTypeConsortiumName(String typeConsortiumName) {
        this.typeConsortiumName = typeConsortiumName;
    }

    /**
     *
     * @return
     */
    public Collection<SeiLeadConsortiumIndustry> getSeiLeadConsortiumIndustryCollection() {
        return seiLeadConsortiumIndustryCollection;
    }

    /**
     *
     * @param seiLeadConsortiumIndustryCollection
     */
    public void setSeiLeadConsortiumIndustryCollection(Collection<SeiLeadConsortiumIndustry> seiLeadConsortiumIndustryCollection) {
        this.seiLeadConsortiumIndustryCollection = seiLeadConsortiumIndustryCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeConsortiumId != null ? typeConsortiumId.hashCode() : 0);
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
        if (!(object instanceof TypeConsortium)) {
            return false;
        }
        TypeConsortium other = (TypeConsortium) object;
        if ((this.typeConsortiumId == null && other.typeConsortiumId != null) || (this.typeConsortiumId != null && !this.typeConsortiumId.equals(other.typeConsortiumId))) {
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
        return "org.centrale.hceres.items.TypeConsortium[ typeConsortiumId=" + typeConsortiumId + " ]";
    }
    
}
