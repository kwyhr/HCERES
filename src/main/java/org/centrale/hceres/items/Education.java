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
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "education")
@NamedQueries({
    @NamedQuery(name = "Education.findAll", query = "SELECT e FROM Education e"),
    @NamedQuery(name = "Education.findByIdActivity", query = "SELECT e FROM Education e WHERE e.idActivity = :idActivity"),
    @NamedQuery(name = "Education.findByEducationCourseName", query = "SELECT e FROM Education e WHERE e.educationCourseName = :educationCourseName"),
    @NamedQuery(name = "Education.findByEducationCompletion", query = "SELECT e FROM Education e WHERE e.educationCompletion = :educationCompletion"),
    @NamedQuery(name = "Education.findByEducationDescription", query = "SELECT e FROM Education e WHERE e.educationDescription = :educationDescription"),
    @NamedQuery(name = "Education.findByEducationFormation", query = "SELECT e FROM Education e WHERE e.educationFormation = :educationFormation")})
public class Education implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Size(max = 256)
    @Column(name = "education_course_name")
    private String educationCourseName;
    @Column(name = "education_completion")
    @Temporal(TemporalType.DATE)
    private Date educationCompletion;
    @Size(max = 2147483647)
    @Column(name = "education_description")
    private String educationDescription;
    @Size(max = 256)
    @Column(name = "education_formation")
    private String educationFormation;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;
    @JoinColumn(name = "education_involvment_id", referencedColumnName = "education_involvment_id")
    @ManyToOne(optional = false)
    private EducationInvolvment educationInvolvmentId;
    @JoinColumn(name = "education_level_id", referencedColumnName = "education_level_id")
    @ManyToOne(optional = false)
    private EducationLevel educationLevelId;

    /**
     *
     */
    public Education() {
    }

    /**
     *
     * @param idActivity
     */
    public Education(Integer idActivity) {
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
    public String getEducationCourseName() {
        return educationCourseName;
    }

    /**
     *
     * @param educationCourseName
     */
    public void setEducationCourseName(String educationCourseName) {
        this.educationCourseName = educationCourseName;
    }

    /**
     *
     * @return
     */
    public Date getEducationCompletion() {
        return educationCompletion;
    }

    /**
     *
     * @param educationCompletion
     */
    public void setEducationCompletion(Date educationCompletion) {
        this.educationCompletion = educationCompletion;
    }

    /**
     *
     * @return
     */
    public String getEducationDescription() {
        return educationDescription;
    }

    /**
     *
     * @param educationDescription
     */
    public void setEducationDescription(String educationDescription) {
        this.educationDescription = educationDescription;
    }

    /**
     *
     * @return
     */
    public String getEducationFormation() {
        return educationFormation;
    }

    /**
     *
     * @param educationFormation
     */
    public void setEducationFormation(String educationFormation) {
        this.educationFormation = educationFormation;
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
    public EducationInvolvment getEducationInvolvmentId() {
        return educationInvolvmentId;
    }

    /**
     *
     * @param educationInvolvmentId
     */
    public void setEducationInvolvmentId(EducationInvolvment educationInvolvmentId) {
        this.educationInvolvmentId = educationInvolvmentId;
    }

    /**
     *
     * @return
     */
    public EducationLevel getEducationLevelId() {
        return educationLevelId;
    }

    /**
     *
     * @param educationLevelId
     */
    public void setEducationLevelId(EducationLevel educationLevelId) {
        this.educationLevelId = educationLevelId;
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
        if (!(object instanceof Education)) {
            return false;
        }
        Education other = (Education) object;
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
        return "org.centrale.hceres.items.Education[ idActivity=" + idActivity + " ]";
    }
    
}
