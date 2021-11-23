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
@Table(name = "laboratory_evaluation_role")
@NamedQueries({
    @NamedQuery(name = "LaboratoryEvaluationRole.findAll", query = "SELECT l FROM LaboratoryEvaluationRole l"),
    @NamedQuery(name = "LaboratoryEvaluationRole.findByLaboratoryEvaluationRoleId", query = "SELECT l FROM LaboratoryEvaluationRole l WHERE l.laboratoryEvaluationRoleId = :laboratoryEvaluationRoleId"),
    @NamedQuery(name = "LaboratoryEvaluationRole.findByNameChoice", query = "SELECT l FROM LaboratoryEvaluationRole l WHERE l.nameChoice = :nameChoice")})
public class LaboratoryEvaluationRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "laboratory_evaluation_role_id")
    private Integer laboratoryEvaluationRoleId;
    @Size(max = 256)
    @Column(name = "name_choice")
    private String nameChoice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "laboratoryEvaluationRoleId")
    private Collection<InstitutionalComitee> institutionalComiteeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "laboratoryEvaluationRoleId")
    private Collection<LaboratoryEvaluation> laboratoryEvaluationCollection;

    /**
     *
     */
    public LaboratoryEvaluationRole() {
    }

    /**
     *
     * @param laboratoryEvaluationRoleId
     */
    public LaboratoryEvaluationRole(Integer laboratoryEvaluationRoleId) {
        this.laboratoryEvaluationRoleId = laboratoryEvaluationRoleId;
    }

    /**
     *
     * @return
     */
    public Integer getLaboratoryEvaluationRoleId() {
        return laboratoryEvaluationRoleId;
    }

    /**
     *
     * @param laboratoryEvaluationRoleId
     */
    public void setLaboratoryEvaluationRoleId(Integer laboratoryEvaluationRoleId) {
        this.laboratoryEvaluationRoleId = laboratoryEvaluationRoleId;
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
    public Collection<InstitutionalComitee> getInstitutionalComiteeCollection() {
        return institutionalComiteeCollection;
    }

    /**
     *
     * @param institutionalComiteeCollection
     */
    public void setInstitutionalComiteeCollection(Collection<InstitutionalComitee> institutionalComiteeCollection) {
        this.institutionalComiteeCollection = institutionalComiteeCollection;
    }

    /**
     *
     * @return
     */
    public Collection<LaboratoryEvaluation> getLaboratoryEvaluationCollection() {
        return laboratoryEvaluationCollection;
    }

    /**
     *
     * @param laboratoryEvaluationCollection
     */
    public void setLaboratoryEvaluationCollection(Collection<LaboratoryEvaluation> laboratoryEvaluationCollection) {
        this.laboratoryEvaluationCollection = laboratoryEvaluationCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (laboratoryEvaluationRoleId != null ? laboratoryEvaluationRoleId.hashCode() : 0);
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
        if (!(object instanceof LaboratoryEvaluationRole)) {
            return false;
        }
        LaboratoryEvaluationRole other = (LaboratoryEvaluationRole) object;
        if ((this.laboratoryEvaluationRoleId == null && other.laboratoryEvaluationRoleId != null) || (this.laboratoryEvaluationRoleId != null && !this.laboratoryEvaluationRoleId.equals(other.laboratoryEvaluationRoleId))) {
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
        return "org.centrale.hceres.items.LaboratoryEvaluationRole[ laboratoryEvaluationRoleId=" + laboratoryEvaluationRoleId + " ]";
    }
    
}
