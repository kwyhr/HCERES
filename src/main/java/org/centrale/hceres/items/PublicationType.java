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
@Table(name = "publication_type")
@NamedQueries({
    @NamedQuery(name = "PublicationType.findAll", query = "SELECT p FROM PublicationType p"),
    @NamedQuery(name = "PublicationType.findByPublicationTypeId", query = "SELECT p FROM PublicationType p WHERE p.publicationTypeId = :publicationTypeId"),
    @NamedQuery(name = "PublicationType.findByPublicationTypeName", query = "SELECT p FROM PublicationType p WHERE p.publicationTypeName = :publicationTypeName")})
public class PublicationType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "publication_type_id")
    private Integer publicationTypeId;
    @Size(max = 256)
    @Column(name = "publication_type_name")
    private String publicationTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publicationTypeId")
    private Collection<Publication> publicationCollection;

    /**
     *
     */
    public PublicationType() {
    }

    /**
     *
     * @param publicationTypeId
     */
    public PublicationType(Integer publicationTypeId) {
        this.publicationTypeId = publicationTypeId;
    }

    /**
     *
     * @return
     */
    public Integer getPublicationTypeId() {
        return publicationTypeId;
    }

    /**
     *
     * @param publicationTypeId
     */
    public void setPublicationTypeId(Integer publicationTypeId) {
        this.publicationTypeId = publicationTypeId;
    }

    /**
     *
     * @return
     */
    public String getPublicationTypeName() {
        return publicationTypeName;
    }

    /**
     *
     * @param publicationTypeName
     */
    public void setPublicationTypeName(String publicationTypeName) {
        this.publicationTypeName = publicationTypeName;
    }

    /**
     *
     * @return
     */
    public Collection<Publication> getPublicationCollection() {
        return publicationCollection;
    }

    /**
     *
     * @param publicationCollection
     */
    public void setPublicationCollection(Collection<Publication> publicationCollection) {
        this.publicationCollection = publicationCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (publicationTypeId != null ? publicationTypeId.hashCode() : 0);
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
        if (!(object instanceof PublicationType)) {
            return false;
        }
        PublicationType other = (PublicationType) object;
        if ((this.publicationTypeId == null && other.publicationTypeId != null) || (this.publicationTypeId != null && !this.publicationTypeId.equals(other.publicationTypeId))) {
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
        return "org.centrale.hceres.items.PublicationType[ publicationTypeId=" + publicationTypeId + " ]";
    }
    
}
