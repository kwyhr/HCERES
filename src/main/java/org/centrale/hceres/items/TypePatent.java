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
@Table(name = "type_patent")
@NamedQueries({
    @NamedQuery(name = "TypePatent.findAll", query = "SELECT t FROM TypePatent t"),
    @NamedQuery(name = "TypePatent.findByTypePatentId", query = "SELECT t FROM TypePatent t WHERE t.typePatentId = :typePatentId"),
    @NamedQuery(name = "TypePatent.findByNameChoice", query = "SELECT t FROM TypePatent t WHERE t.nameChoice = :nameChoice")})
public class TypePatent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "type_patent_id")
    private Integer typePatentId;
    @Size(max = 256)
    @Column(name = "name_choice")
    private String nameChoice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typePatentId")
    private Collection<Patent> patentCollection;

    /**
     *
     */
    public TypePatent() {
    }

    /**
     *
     * @param typePatentId
     */
    public TypePatent(Integer typePatentId) {
        this.typePatentId = typePatentId;
    }

    /**
     *
     * @return
     */
    public Integer getTypePatentId() {
        return typePatentId;
    }

    /**
     *
     * @param typePatentId
     */
    public void setTypePatentId(Integer typePatentId) {
        this.typePatentId = typePatentId;
    }

    /**
     *
     * @return
     */
    public String getNameChoice() {
        return nameChoice;
    }

    /**
     *
     * @param nameChoice
     */
    public void setNameChoice(String nameChoice) {
        this.nameChoice = nameChoice;
    }

    /**
     *
     * @return
     */
    public Collection<Patent> getPatentCollection() {
        return patentCollection;
    }

    /**
     *
     * @param patentCollection
     */
    public void setPatentCollection(Collection<Patent> patentCollection) {
        this.patentCollection = patentCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typePatentId != null ? typePatentId.hashCode() : 0);
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
        if (!(object instanceof TypePatent)) {
            return false;
        }
        TypePatent other = (TypePatent) object;
        if ((this.typePatentId == null && other.typePatentId != null) || (this.typePatentId != null && !this.typePatentId.equals(other.typePatentId))) {
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
        return "org.centrale.hceres.items.TypePatent[ typePatentId=" + typePatentId + " ]";
    }
    
}
