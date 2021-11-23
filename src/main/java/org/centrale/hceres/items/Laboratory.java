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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "laboratory")
@NamedQueries({
    @NamedQuery(name = "Laboratory.findAll", query = "SELECT l FROM Laboratory l"),
    @NamedQuery(name = "Laboratory.findByLaboratoryId", query = "SELECT l FROM Laboratory l WHERE l.laboratoryId = :laboratoryId"),
    @NamedQuery(name = "Laboratory.findByLaboratoryName", query = "SELECT l FROM Laboratory l WHERE l.laboratoryName = :laboratoryName"),
    @NamedQuery(name = "Laboratory.findByLaboratoryAcronym", query = "SELECT l FROM Laboratory l WHERE l.laboratoryAcronym = :laboratoryAcronym")})
public class Laboratory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "laboratory_id")
    private Integer laboratoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "laboratory_name")
    private String laboratoryName;
    @Size(max = 32)
    @Column(name = "laboratory_acronym")
    private String laboratoryAcronym;
    @JoinColumn(name = "institution_id", referencedColumnName = "institution_id")
    @ManyToOne(optional = false)
    private Institution institutionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "laboratoryId")
    private Collection<Team> teamCollection;

    /**
     *
     */
    public Laboratory() {
    }

    /**
     *
     * @param laboratoryId
     */
    public Laboratory(Integer laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    /**
     *
     * @param laboratoryId
     * @param laboratoryName
     */
    public Laboratory(Integer laboratoryId, String laboratoryName) {
        this.laboratoryId = laboratoryId;
        this.laboratoryName = laboratoryName;
    }

    /**
     *
     * @return
     */
    public Integer getLaboratoryId() {
        return laboratoryId;
    }

    /**
     *
     * @param laboratoryId
     */
    public void setLaboratoryId(Integer laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    /**
     *
     * @return
     */
    public String getLaboratoryName() {
        return laboratoryName;
    }

    /**
     *
     * @param laboratoryName
     */
    public void setLaboratoryName(String laboratoryName) {
        this.laboratoryName = laboratoryName;
    }

    /**
     *
     * @return
     */
    public String getLaboratoryAcronym() {
        return laboratoryAcronym;
    }

    /**
     *
     * @param laboratoryAcronym
     */
    public void setLaboratoryAcronym(String laboratoryAcronym) {
        this.laboratoryAcronym = laboratoryAcronym;
    }

    /**
     *
     * @return
     */
    public Institution getInstitutionId() {
        return institutionId;
    }

    /**
     *
     * @param institutionId
     */
    public void setInstitutionId(Institution institutionId) {
        this.institutionId = institutionId;
    }

    /**
     *
     * @return
     */
    public Collection<Team> getTeamCollection() {
        return teamCollection;
    }

    /**
     *
     * @param teamCollection
     */
    public void setTeamCollection(Collection<Team> teamCollection) {
        this.teamCollection = teamCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (laboratoryId != null ? laboratoryId.hashCode() : 0);
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
        if (!(object instanceof Laboratory)) {
            return false;
        }
        Laboratory other = (Laboratory) object;
        if ((this.laboratoryId == null && other.laboratoryId != null) || (this.laboratoryId != null && !this.laboratoryId.equals(other.laboratoryId))) {
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
        return "org.centrale.hceres.items.Laboratory[ laboratoryId=" + laboratoryId + " ]";
    }
    
}
