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
@Table(name = "type_collab")
@NamedQueries({
    @NamedQuery(name = "TypeCollab.findAll", query = "SELECT t FROM TypeCollab t"),
    @NamedQuery(name = "TypeCollab.findByTypeCollabId", query = "SELECT t FROM TypeCollab t WHERE t.typeCollabId = :typeCollabId"),
    @NamedQuery(name = "TypeCollab.findByNameChoice", query = "SELECT t FROM TypeCollab t WHERE t.nameChoice = :nameChoice")})
public class TypeCollab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "type_collab_id")
    private Integer typeCollabId;
    @Size(max = 256)
    @Column(name = "name_choice")
    private String nameChoice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeCollabId")
    private Collection<NationalInternationalCollaboration> nationalInternationalCollaborationCollection;

    /**
     *
     */
    public TypeCollab() {
    }

    /**
     *
     * @param typeCollabId
     */
    public TypeCollab(Integer typeCollabId) {
        this.typeCollabId = typeCollabId;
    }

    /**
     *
     * @return
     */
    public Integer getTypeCollabId() {
        return typeCollabId;
    }

    /**
     *
     * @param typeCollabId
     */
    public void setTypeCollabId(Integer typeCollabId) {
        this.typeCollabId = typeCollabId;
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
    public Collection<NationalInternationalCollaboration> getNationalInternationalCollaborationCollection() {
        return nationalInternationalCollaborationCollection;
    }

    /**
     *
     * @param nationalInternationalCollaborationCollection
     */
    public void setNationalInternationalCollaborationCollection(Collection<NationalInternationalCollaboration> nationalInternationalCollaborationCollection) {
        this.nationalInternationalCollaborationCollection = nationalInternationalCollaborationCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeCollabId != null ? typeCollabId.hashCode() : 0);
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
        if (!(object instanceof TypeCollab)) {
            return false;
        }
        TypeCollab other = (TypeCollab) object;
        if ((this.typeCollabId == null && other.typeCollabId != null) || (this.typeCollabId != null && !this.typeCollabId.equals(other.typeCollabId))) {
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
        return "org.centrale.hceres.items.TypeCollab[ typeCollabId=" + typeCollabId + " ]";
    }
    
}
