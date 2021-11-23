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
@Table(name = "evaluation_thesis")
@NamedQueries({
    @NamedQuery(name = "EvaluationThesis.findAll", query = "SELECT e FROM EvaluationThesis e"),
    @NamedQuery(name = "EvaluationThesis.findByIdActivity", query = "SELECT e FROM EvaluationThesis e WHERE e.idActivity = :idActivity"),
    @NamedQuery(name = "EvaluationThesis.findByYear", query = "SELECT e FROM EvaluationThesis e WHERE e.year = :year"),
    @NamedQuery(name = "EvaluationThesis.findByNameUniversity", query = "SELECT e FROM EvaluationThesis e WHERE e.nameUniversity = :nameUniversity")})
public class EvaluationThesis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Column(name = "year")
    private Integer year;
    @Size(max = 256)
    @Column(name = "name_university")
    private String nameUniversity;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;
    @JoinColumn(name = "evaluation_thesis_role_id", referencedColumnName = "evaluation_thesis_role_id")
    @ManyToOne(optional = false)
    private EvaluationThesisRole evaluationThesisRoleId;
    @JoinColumn(name = "type_thesis_id", referencedColumnName = "type_thesis_id")
    @ManyToOne(optional = false)
    private TypeThesis typeThesisId;

    /**
     *
     */
    public EvaluationThesis() {
    }

    /**
     *
     * @param idActivity
     */
    public EvaluationThesis(Integer idActivity) {
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
    public String getNameUniversity() {
        return nameUniversity;
    }

    /**
     *
     * @param nameUniversity
     */
    public void setNameUniversity(String nameUniversity) {
        this.nameUniversity = nameUniversity;
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
    public EvaluationThesisRole getEvaluationThesisRoleId() {
        return evaluationThesisRoleId;
    }

    /**
     *
     * @param evaluationThesisRoleId
     */
    public void setEvaluationThesisRoleId(EvaluationThesisRole evaluationThesisRoleId) {
        this.evaluationThesisRoleId = evaluationThesisRoleId;
    }

    /**
     *
     * @return
     */
    public TypeThesis getTypeThesisId() {
        return typeThesisId;
    }

    /**
     *
     * @param typeThesisId
     */
    public void setTypeThesisId(TypeThesis typeThesisId) {
        this.typeThesisId = typeThesisId;
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
        if (!(object instanceof EvaluationThesis)) {
            return false;
        }
        EvaluationThesis other = (EvaluationThesis) object;
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
        return "org.centrale.hceres.items.EvaluationThesis[ idActivity=" + idActivity + " ]";
    }
    
}
