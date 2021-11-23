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
@Table(name = "evaluation_thesis_role")
@NamedQueries({
    @NamedQuery(name = "EvaluationThesisRole.findAll", query = "SELECT e FROM EvaluationThesisRole e"),
    @NamedQuery(name = "EvaluationThesisRole.findByEvaluationThesisRoleId", query = "SELECT e FROM EvaluationThesisRole e WHERE e.evaluationThesisRoleId = :evaluationThesisRoleId"),
    @NamedQuery(name = "EvaluationThesisRole.findByEvaluationThesisRoleName", query = "SELECT e FROM EvaluationThesisRole e WHERE e.evaluationThesisRoleName = :evaluationThesisRoleName")})
public class EvaluationThesisRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "evaluation_thesis_role_id")
    private Integer evaluationThesisRoleId;
    @Size(max = 256)
    @Column(name = "evaluation_thesis_role_name")
    private String evaluationThesisRoleName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluationThesisRoleId")
    private Collection<EvaluationThesis> evaluationThesisCollection;

    /**
     *
     */
    public EvaluationThesisRole() {
    }

    /**
     *
     * @param evaluationThesisRoleId
     */
    public EvaluationThesisRole(Integer evaluationThesisRoleId) {
        this.evaluationThesisRoleId = evaluationThesisRoleId;
    }

    /**
     *
     * @return
     */
    public Integer getEvaluationThesisRoleId() {
        return evaluationThesisRoleId;
    }

    /**
     *
     * @param evaluationThesisRoleId
     */
    public void setEvaluationThesisRoleId(Integer evaluationThesisRoleId) {
        this.evaluationThesisRoleId = evaluationThesisRoleId;
    }

    /**
     *
     * @return
     */
    public String getEvaluationThesisRoleName() {
        return evaluationThesisRoleName;
    }

    /**
     *
     * @param evaluationThesisRoleName
     */
    public void setEvaluationThesisRoleName(String evaluationThesisRoleName) {
        this.evaluationThesisRoleName = evaluationThesisRoleName;
    }

    /**
     *
     * @return
     */
    public Collection<EvaluationThesis> getEvaluationThesisCollection() {
        return evaluationThesisCollection;
    }

    /**
     *
     * @param evaluationThesisCollection
     */
    public void setEvaluationThesisCollection(Collection<EvaluationThesis> evaluationThesisCollection) {
        this.evaluationThesisCollection = evaluationThesisCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluationThesisRoleId != null ? evaluationThesisRoleId.hashCode() : 0);
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
        if (!(object instanceof EvaluationThesisRole)) {
            return false;
        }
        EvaluationThesisRole other = (EvaluationThesisRole) object;
        if ((this.evaluationThesisRoleId == null && other.evaluationThesisRoleId != null) || (this.evaluationThesisRoleId != null && !this.evaluationThesisRoleId.equals(other.evaluationThesisRoleId))) {
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
        return "org.centrale.hceres.items.EvaluationThesisRole[ evaluationThesisRoleId=" + evaluationThesisRoleId + " ]";
    }
    
}
