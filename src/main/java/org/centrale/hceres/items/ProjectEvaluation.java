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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "project_evaluation")
@NamedQueries({
    @NamedQuery(name = "ProjectEvaluation.findAll", query = "SELECT p FROM ProjectEvaluation p"),
    @NamedQuery(name = "ProjectEvaluation.findByIdActivity", query = "SELECT p FROM ProjectEvaluation p WHERE p.idActivity = :idActivity"),
    @NamedQuery(name = "ProjectEvaluation.findByYear", query = "SELECT p FROM ProjectEvaluation p WHERE p.year = :year")})
public class ProjectEvaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Column(name = "year")
    private Integer year;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;
    @JoinColumn(name = "funder_id", referencedColumnName = "funder_id")
    @ManyToOne(optional = false)
    private Funder funderId;
    @JoinColumn(name = "project_evaluation_category_id", referencedColumnName = "project_evaluation_category_id")
    @ManyToOne(optional = false)
    private ProjectEvaluationCategory projectEvaluationCategoryId;
    @JoinColumn(name = "project_evaluation_role_id", referencedColumnName = "project_evaluation_role_id")
    @ManyToOne(optional = false)
    private ProjectEvaluationRole projectEvaluationRoleId;

    /**
     *
     */
    public ProjectEvaluation() {
    }

    /**
     *
     * @param idActivity
     */
    public ProjectEvaluation(Integer idActivity) {
        this.idActivity = idActivity;
    }

    /**
     *
     * @return
     */
    public Integer getIdActivity() {
        return idActivity;
    }

    /**
     *
     * @param idActivity
     */
    public void setIdActivity(Integer idActivity) {
        this.idActivity = idActivity;
    }

    /**
     *
     * @return
     */
    public Integer getYear() {
        return year;
    }

    /**
     *
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     *
     * @return
     */
    public Activity getActivity() {
        return activity;
    }

    /**
     *
     * @param activity
     */
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    /**
     *
     * @return
     */
    public Funder getFunderId() {
        return funderId;
    }

    /**
     *
     * @param funderId
     */
    public void setFunderId(Funder funderId) {
        this.funderId = funderId;
    }

    /**
     *
     * @return
     */
    public ProjectEvaluationCategory getProjectEvaluationCategoryId() {
        return projectEvaluationCategoryId;
    }

    /**
     *
     * @param projectEvaluationCategoryId
     */
    public void setProjectEvaluationCategoryId(ProjectEvaluationCategory projectEvaluationCategoryId) {
        this.projectEvaluationCategoryId = projectEvaluationCategoryId;
    }

    /**
     *
     * @return
     */
    public ProjectEvaluationRole getProjectEvaluationRoleId() {
        return projectEvaluationRoleId;
    }

    /**
     *
     * @param projectEvaluationRoleId
     */
    public void setProjectEvaluationRoleId(ProjectEvaluationRole projectEvaluationRoleId) {
        this.projectEvaluationRoleId = projectEvaluationRoleId;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActivity != null ? idActivity.hashCode() : 0);
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
        if (!(object instanceof ProjectEvaluation)) {
            return false;
        }
        ProjectEvaluation other = (ProjectEvaluation) object;
        if ((this.idActivity == null && other.idActivity != null) || (this.idActivity != null && !this.idActivity.equals(other.idActivity))) {
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
        return "org.centrale.hceres.items.ProjectEvaluation[ idActivity=" + idActivity + " ]";
    }
    
}
