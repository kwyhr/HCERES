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
@Table(name = "scientific_expertise_type")
@NamedQueries({
    @NamedQuery(name = "ScientificExpertiseType.findAll", query = "SELECT s FROM ScientificExpertiseType s"),
    @NamedQuery(name = "ScientificExpertiseType.findByScientificExpertiseTypeId", query = "SELECT s FROM ScientificExpertiseType s WHERE s.scientificExpertiseTypeId = :scientificExpertiseTypeId"),
    @NamedQuery(name = "ScientificExpertiseType.findByNameChoice", query = "SELECT s FROM ScientificExpertiseType s WHERE s.nameChoice = :nameChoice")})
public class ScientificExpertiseType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "scientific_expertise_type_id")
    private Integer scientificExpertiseTypeId;
    @Size(max = 256)
    @Column(name = "name_choice")
    private String nameChoice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scientificExpertiseTypeId")
    private Collection<ScientificExpertise> scientificExpertiseCollection;

    /**
     *
     */
    public ScientificExpertiseType() {
    }

    /**
     *
     * @param scientificExpertiseTypeId
     */
    public ScientificExpertiseType(Integer scientificExpertiseTypeId) {
        this.scientificExpertiseTypeId = scientificExpertiseTypeId;
    }

    /**
     *
     * @return
     */
    public Integer getScientificExpertiseTypeId() {
        return scientificExpertiseTypeId;
    }

    /**
     *
     * @param scientificExpertiseTypeId
     */
    public void setScientificExpertiseTypeId(Integer scientificExpertiseTypeId) {
        this.scientificExpertiseTypeId = scientificExpertiseTypeId;
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
    public Collection<ScientificExpertise> getScientificExpertiseCollection() {
        return scientificExpertiseCollection;
    }

    /**
     *
     * @param scientificExpertiseCollection
     */
    public void setScientificExpertiseCollection(Collection<ScientificExpertise> scientificExpertiseCollection) {
        this.scientificExpertiseCollection = scientificExpertiseCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scientificExpertiseTypeId != null ? scientificExpertiseTypeId.hashCode() : 0);
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
        if (!(object instanceof ScientificExpertiseType)) {
            return false;
        }
        ScientificExpertiseType other = (ScientificExpertiseType) object;
        if ((this.scientificExpertiseTypeId == null && other.scientificExpertiseTypeId != null) || (this.scientificExpertiseTypeId != null && !this.scientificExpertiseTypeId.equals(other.scientificExpertiseTypeId))) {
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
        return "org.centrale.hceres.items.ScientificExpertiseType[ scientificExpertiseTypeId=" + scientificExpertiseTypeId + " ]";
    }
    
}
