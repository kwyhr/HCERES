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
@Table(name = "scientific_expertise")
@NamedQueries({
    @NamedQuery(name = "ScientificExpertise.findAll", query = "SELECT s FROM ScientificExpertise s"),
    @NamedQuery(name = "ScientificExpertise.findByIdActivity", query = "SELECT s FROM ScientificExpertise s WHERE s.idActivity = :idActivity"),
    @NamedQuery(name = "ScientificExpertise.findByStartDate", query = "SELECT s FROM ScientificExpertise s WHERE s.startDate = :startDate"),
    @NamedQuery(name = "ScientificExpertise.findByEndDate", query = "SELECT s FROM ScientificExpertise s WHERE s.endDate = :endDate"),
    @NamedQuery(name = "ScientificExpertise.findByDescription", query = "SELECT s FROM ScientificExpertise s WHERE s.description = :description")})
public class ScientificExpertise implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;
    @JoinColumn(name = "scientific_expertise_type_id", referencedColumnName = "scientific_expertise_type_id")
    @ManyToOne(optional = false)
    private ScientificExpertiseType scientificExpertiseTypeId;

    /**
     *
     */
    public ScientificExpertise() {
    }

    /**
     *
     * @param idActivity
     */
    public ScientificExpertise(Integer idActivity) {
        this.idActivity = idActivity;
    }

    /**
     *
     * @param idActivity
     * @param description
     */
    public ScientificExpertise(Integer idActivity, String description) {
        this.idActivity = idActivity;
        this.description = description;
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
    public ScientificExpertiseType getScientificExpertiseTypeId() {
        return scientificExpertiseTypeId;
    }

    /**
     *
     * @param scientificExpertiseTypeId
     */
    public void setScientificExpertiseTypeId(ScientificExpertiseType scientificExpertiseTypeId) {
        this.scientificExpertiseTypeId = scientificExpertiseTypeId;
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
        if (!(object instanceof ScientificExpertise)) {
            return false;
        }
        ScientificExpertise other = (ScientificExpertise) object;
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
        return "org.centrale.hceres.items.ScientificExpertise[ idActivity=" + idActivity + " ]";
    }
    
}
