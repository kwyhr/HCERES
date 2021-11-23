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
@Table(name = "sr_award")
@NamedQueries({
    @NamedQuery(name = "SrAward.findAll", query = "SELECT s FROM SrAward s"),
    @NamedQuery(name = "SrAward.findByIdActivity", query = "SELECT s FROM SrAward s WHERE s.idActivity = :idActivity"),
    @NamedQuery(name = "SrAward.findByAwardeeName", query = "SELECT s FROM SrAward s WHERE s.awardeeName = :awardeeName"),
    @NamedQuery(name = "SrAward.findByAwardDate", query = "SELECT s FROM SrAward s WHERE s.awardDate = :awardDate"),
    @NamedQuery(name = "SrAward.findByDescription", query = "SELECT s FROM SrAward s WHERE s.description = :description")})
public class SrAward implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Size(max = 256)
    @Column(name = "awardee_name")
    private String awardeeName;
    @Column(name = "award_date")
    @Temporal(TemporalType.DATE)
    private Date awardDate;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;

    /**
     *
     */
    public SrAward() {
    }

    /**
     *
     * @param idActivity
     */
    public SrAward(Integer idActivity) {
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
    public String getAwardeeName() {
        return awardeeName;
    }

    /**
     *
     * @param awardeeName
     */
    public void setAwardeeName(String awardeeName) {
        this.awardeeName = awardeeName;
    }

    /**
     *
     * @return
     */
    public Date getAwardDate() {
        return awardDate;
    }

    /**
     *
     * @param awardDate
     */
    public void setAwardDate(Date awardDate) {
        this.awardDate = awardDate;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof SrAward)) {
            return false;
        }
        SrAward other = (SrAward) object;
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
        return "org.centrale.hceres.items.SrAward[ idActivity=" + idActivity + " ]";
    }
    
}
