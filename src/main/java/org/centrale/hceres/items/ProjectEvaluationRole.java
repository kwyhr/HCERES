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
@Table(name = "project_evaluation_role")
@NamedQueries({
    @NamedQuery(name = "ProjectEvaluationRole.findAll", query = "SELECT p FROM ProjectEvaluationRole p"),
    @NamedQuery(name = "ProjectEvaluationRole.findByProjectEvaluationRoleId", query = "SELECT p FROM ProjectEvaluationRole p WHERE p.projectEvaluationRoleId = :projectEvaluationRoleId"),
    @NamedQuery(name = "ProjectEvaluationRole.findByProjectEvaluationRoleName", query = "SELECT p FROM ProjectEvaluationRole p WHERE p.projectEvaluationRoleName = :projectEvaluationRoleName")})
public class ProjectEvaluationRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "project_evaluation_role_id")
    private Integer projectEvaluationRoleId;
    @Size(max = 256)
    @Column(name = "project_evaluation_role_name")
    private String projectEvaluationRoleName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectEvaluationRoleId")
    private Collection<ProjectEvaluation> projectEvaluationCollection;

    /**
     *
     */
    public ProjectEvaluationRole() {
    }

    /**
     *
     * @param projectEvaluationRoleId
     */
    public ProjectEvaluationRole(Integer projectEvaluationRoleId) {
        this.projectEvaluationRoleId = projectEvaluationRoleId;
    }

    /**
     *
     * @return
     */
    public Integer getProjectEvaluationRoleId() {
        return projectEvaluationRoleId;
    }

    /**
     *
     * @param projectEvaluationRoleId
     */
    public void setProjectEvaluationRoleId(Integer projectEvaluationRoleId) {
        this.projectEvaluationRoleId = projectEvaluationRoleId;
    }

    /**
     *
     * @return
     */
    public String getProjectEvaluationRoleName() {
        return projectEvaluationRoleName;
    }

    /**
     *
     * @param projectEvaluationRoleName
     */
    public void setProjectEvaluationRoleName(String projectEvaluationRoleName) {
        this.projectEvaluationRoleName = projectEvaluationRoleName;
    }

    /**
     *
     * @return
     */
    public Collection<ProjectEvaluation> getProjectEvaluationCollection() {
        return projectEvaluationCollection;
    }

    /**
     *
     * @param projectEvaluationCollection
     */
    public void setProjectEvaluationCollection(Collection<ProjectEvaluation> projectEvaluationCollection) {
        this.projectEvaluationCollection = projectEvaluationCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectEvaluationRoleId != null ? projectEvaluationRoleId.hashCode() : 0);
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
        if (!(object instanceof ProjectEvaluationRole)) {
            return false;
        }
        ProjectEvaluationRole other = (ProjectEvaluationRole) object;
        if ((this.projectEvaluationRoleId == null && other.projectEvaluationRoleId != null) || (this.projectEvaluationRoleId != null && !this.projectEvaluationRoleId.equals(other.projectEvaluationRoleId))) {
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
        return "org.centrale.hceres.items.ProjectEvaluationRole[ projectEvaluationRoleId=" + projectEvaluationRoleId + " ]";
    }
    
}
