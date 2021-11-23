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
@Table(name = "learned_scientific_society")
@NamedQueries({
    @NamedQuery(name = "LearnedScientificSociety.findAll", query = "SELECT l FROM LearnedScientificSociety l"),
    @NamedQuery(name = "LearnedScientificSociety.findByIdActivity", query = "SELECT l FROM LearnedScientificSociety l WHERE l.idActivity = :idActivity"),
    @NamedQuery(name = "LearnedScientificSociety.findByLearnedScientificSocietyName", query = "SELECT l FROM LearnedScientificSociety l WHERE l.learnedScientificSocietyName = :learnedScientificSocietyName"),
    @NamedQuery(name = "LearnedScientificSociety.findByStartDate", query = "SELECT l FROM LearnedScientificSociety l WHERE l.startDate = :startDate"),
    @NamedQuery(name = "LearnedScientificSociety.findByEndDate", query = "SELECT l FROM LearnedScientificSociety l WHERE l.endDate = :endDate")})
public class LearnedScientificSociety implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Size(max = 256)
    @Column(name = "learned_scientific_society_name")
    private String learnedScientificSocietyName;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;
    @JoinColumn(name = "learned_scientific_society_role_id", referencedColumnName = "learned_scientific_society_role_id")
    @ManyToOne(optional = false)
    private LearnedScientificSocietyRole learnedScientificSocietyRoleId;

    /**
     *
     */
    public LearnedScientificSociety() {
    }

    /**
     *
     * @param idActivity
     */
    public LearnedScientificSociety(Integer idActivity) {
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
    public String getLearnedScientificSocietyName() {
        return learnedScientificSocietyName;
    }

    /**
     *
     * @param learnedScientificSocietyName
     */
    public void setLearnedScientificSocietyName(String learnedScientificSocietyName) {
        this.learnedScientificSocietyName = learnedScientificSocietyName;
    }

    /**
     *
     * @return
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @return
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     *
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
    public LearnedScientificSocietyRole getLearnedScientificSocietyRoleId() {
        return learnedScientificSocietyRoleId;
    }

    /**
     *
     * @param learnedScientificSocietyRoleId
     */
    public void setLearnedScientificSocietyRoleId(LearnedScientificSocietyRole learnedScientificSocietyRoleId) {
        this.learnedScientificSocietyRoleId = learnedScientificSocietyRoleId;
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
        if (!(object instanceof LearnedScientificSociety)) {
            return false;
        }
        LearnedScientificSociety other = (LearnedScientificSociety) object;
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
        return "org.centrale.hceres.items.LearnedScientificSociety[ idActivity=" + idActivity + " ]";
    }
    
}
