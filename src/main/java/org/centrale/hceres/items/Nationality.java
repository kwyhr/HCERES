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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "nationality")
@NamedQueries({
    @NamedQuery(name = "Nationality.findAll", query = "SELECT n FROM Nationality n"),
    @NamedQuery(name = "Nationality.findByNationalityId", query = "SELECT n FROM Nationality n WHERE n.nationalityId = :nationalityId"),
    @NamedQuery(name = "Nationality.findByNationalityName", query = "SELECT n FROM Nationality n WHERE n.nationalityName = :nationalityName")})
public class Nationality implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nationality_id")
    private Integer nationalityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "nationality_name")
    private String nationalityName;
    @JoinTable(name = "researcher_nationality", joinColumns = {
        @JoinColumn(name = "nationality_id", referencedColumnName = "nationality_id")}, inverseJoinColumns = {
        @JoinColumn(name = "researcher_id", referencedColumnName = "researcher_id")})
    @ManyToMany
    private Collection<Researcher> researcherCollection;

    /**
     *
     */
    public Nationality() {
    }

    /**
     *
     * @param nationalityId
     */
    public Nationality(Integer nationalityId) {
        this.nationalityId = nationalityId;
    }

    /**
     *
     * @param nationalityId
     * @param nationalityName
     */
    public Nationality(Integer nationalityId, String nationalityName) {
        this.nationalityId = nationalityId;
        this.nationalityName = nationalityName;
    }

    /**
     *
     * @return
     */
    public Integer getNationalityId() {
        return nationalityId;
    }

    /**
     *
     * @param nationalityId
     */
    public void setNationalityId(Integer nationalityId) {
        this.nationalityId = nationalityId;
    }

    /**
     *
     * @return
     */
    public String getNationalityName() {
        return nationalityName;
    }

    /**
     *
     * @param nationalityName
     */
    public void setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName;
    }

    /**
     *
     * @return
     */
    public Collection<Researcher> getResearcherCollection() {
        return researcherCollection;
    }

    /**
     *
     * @param researcherCollection
     */
    public void setResearcherCollection(Collection<Researcher> researcherCollection) {
        this.researcherCollection = researcherCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nationalityId != null ? nationalityId.hashCode() : 0);
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
        if (!(object instanceof Nationality)) {
            return false;
        }
        Nationality other = (Nationality) object;
        if ((this.nationalityId == null && other.nationalityId != null) || (this.nationalityId != null && !this.nationalityId.equals(other.nationalityId))) {
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
        return "org.centrale.hceres.items.Nationality[ nationalityId=" + nationalityId + " ]";
    }
    
}
