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
import javax.validation.constraints.Size;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "laboratory_evaluation")
@NamedQueries({
    @NamedQuery(name = "LaboratoryEvaluation.findAll", query = "SELECT l FROM LaboratoryEvaluation l"),
    @NamedQuery(name = "LaboratoryEvaluation.findByIdActivity", query = "SELECT l FROM LaboratoryEvaluation l WHERE l.idActivity = :idActivity"),
    @NamedQuery(name = "LaboratoryEvaluation.findByLaboratoryEvaluationName", query = "SELECT l FROM LaboratoryEvaluation l WHERE l.laboratoryEvaluationName = :laboratoryEvaluationName"),
    @NamedQuery(name = "LaboratoryEvaluation.findByYear", query = "SELECT l FROM LaboratoryEvaluation l WHERE l.year = :year")})
public class LaboratoryEvaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Size(max = 256)
    @Column(name = "laboratory_evaluation_name")
    private String laboratoryEvaluationName;
    @Column(name = "year")
    private Integer year;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;
    @JoinColumn(name = "laboratory_evaluation_role_id", referencedColumnName = "laboratory_evaluation_role_id")
    @ManyToOne(optional = false)
    private LaboratoryEvaluationRole laboratoryEvaluationRoleId;

    /**
     *
     */
    public LaboratoryEvaluation() {
    }

    /**
     *
     * @param idActivity
     */
    public LaboratoryEvaluation(Integer idActivity) {
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
    public String getLaboratoryEvaluationName() {
        return laboratoryEvaluationName;
    }

    /**
     *
     * @param laboratoryEvaluationName
     */
    public void setLaboratoryEvaluationName(String laboratoryEvaluationName) {
        this.laboratoryEvaluationName = laboratoryEvaluationName;
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
    public LaboratoryEvaluationRole getLaboratoryEvaluationRoleId() {
        return laboratoryEvaluationRoleId;
    }

    /**
     *
     * @param laboratoryEvaluationRoleId
     */
    public void setLaboratoryEvaluationRoleId(LaboratoryEvaluationRole laboratoryEvaluationRoleId) {
        this.laboratoryEvaluationRoleId = laboratoryEvaluationRoleId;
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
        if (!(object instanceof LaboratoryEvaluation)) {
            return false;
        }
        LaboratoryEvaluation other = (LaboratoryEvaluation) object;
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
        return "org.centrale.hceres.items.LaboratoryEvaluation[ idActivity=" + idActivity + " ]";
    }
    
}
