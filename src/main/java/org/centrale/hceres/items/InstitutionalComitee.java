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
@Table(name = "institutional_comitee")
@NamedQueries({
    @NamedQuery(name = "InstitutionalComitee.findAll", query = "SELECT i FROM InstitutionalComitee i"),
    @NamedQuery(name = "InstitutionalComitee.findByIdActivity", query = "SELECT i FROM InstitutionalComitee i WHERE i.idActivity = :idActivity"),
    @NamedQuery(name = "InstitutionalComitee.findByInstitutionalComiteeName", query = "SELECT i FROM InstitutionalComitee i WHERE i.institutionalComiteeName = :institutionalComiteeName"),
    @NamedQuery(name = "InstitutionalComitee.findByYear", query = "SELECT i FROM InstitutionalComitee i WHERE i.year = :year")})
public class InstitutionalComitee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Size(max = 256)
    @Column(name = "institutional_comitee_name")
    private String institutionalComiteeName;
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
    public InstitutionalComitee() {
    }

    /**
     *
     * @param idActivity
     */
    public InstitutionalComitee(Integer idActivity) {
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
    public String getInstitutionalComiteeName() {
        return institutionalComiteeName;
    }

    /**
     *
     * @param institutionalComiteeName
     */
    public void setInstitutionalComiteeName(String institutionalComiteeName) {
        this.institutionalComiteeName = institutionalComiteeName;
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
        if (!(object instanceof InstitutionalComitee)) {
            return false;
        }
        InstitutionalComitee other = (InstitutionalComitee) object;
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
        return "org.centrale.hceres.items.InstitutionalComitee[ idActivity=" + idActivity + " ]";
    }
    
}
