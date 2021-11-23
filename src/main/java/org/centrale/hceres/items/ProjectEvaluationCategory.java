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
@Table(name = "project_evaluation_category")
@NamedQueries({
    @NamedQuery(name = "ProjectEvaluationCategory.findAll", query = "SELECT p FROM ProjectEvaluationCategory p"),
    @NamedQuery(name = "ProjectEvaluationCategory.findByProjectEvaluationCategoryId", query = "SELECT p FROM ProjectEvaluationCategory p WHERE p.projectEvaluationCategoryId = :projectEvaluationCategoryId"),
    @NamedQuery(name = "ProjectEvaluationCategory.findByProjectEvaluationCategoryName", query = "SELECT p FROM ProjectEvaluationCategory p WHERE p.projectEvaluationCategoryName = :projectEvaluationCategoryName")})
public class ProjectEvaluationCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "project_evaluation_category_id")
    private Integer projectEvaluationCategoryId;
    @Size(max = 256)
    @Column(name = "project_evaluation_category_name")
    private String projectEvaluationCategoryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectEvaluationCategoryId")
    private Collection<ProjectEvaluation> projectEvaluationCollection;

    /**
     *
     */
    public ProjectEvaluationCategory() {
    }

    /**
     *
     * @param projectEvaluationCategoryId
     */
    public ProjectEvaluationCategory(Integer projectEvaluationCategoryId) {
        this.projectEvaluationCategoryId = projectEvaluationCategoryId;
    }

    /**
     *
     * @return
     */
    public Integer getProjectEvaluationCategoryId() {
        return projectEvaluationCategoryId;
    }

    /**
     *
     * @param projectEvaluationCategoryId
     */
    public void setProjectEvaluationCategoryId(Integer projectEvaluationCategoryId) {
        this.projectEvaluationCategoryId = projectEvaluationCategoryId;
    }

    /**
     *
     * @return
     */
    public String getProjectEvaluationCategoryName() {
        return projectEvaluationCategoryName;
    }

    /**
     *
     * @param projectEvaluationCategoryName
     */
    public void setProjectEvaluationCategoryName(String projectEvaluationCategoryName) {
        this.projectEvaluationCategoryName = projectEvaluationCategoryName;
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
        hash += (projectEvaluationCategoryId != null ? projectEvaluationCategoryId.hashCode() : 0);
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
        if (!(object instanceof ProjectEvaluationCategory)) {
            return false;
        }
        ProjectEvaluationCategory other = (ProjectEvaluationCategory) object;
        if ((this.projectEvaluationCategoryId == null && other.projectEvaluationCategoryId != null) || (this.projectEvaluationCategoryId != null && !this.projectEvaluationCategoryId.equals(other.projectEvaluationCategoryId))) {
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
        return "org.centrale.hceres.items.ProjectEvaluationCategory[ projectEvaluationCategoryId=" + projectEvaluationCategoryId + " ]";
    }
    
}
