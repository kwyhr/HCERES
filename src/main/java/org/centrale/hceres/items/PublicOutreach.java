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
@Table(name = "public_outreach")
@NamedQueries({
    @NamedQuery(name = "PublicOutreach.findAll", query = "SELECT p FROM PublicOutreach p"),
    @NamedQuery(name = "PublicOutreach.findByIdActivity", query = "SELECT p FROM PublicOutreach p WHERE p.idActivity = :idActivity"),
    @NamedQuery(name = "PublicOutreach.findByCompletionDate", query = "SELECT p FROM PublicOutreach p WHERE p.completionDate = :completionDate"),
    @NamedQuery(name = "PublicOutreach.findByDescription", query = "SELECT p FROM PublicOutreach p WHERE p.description = :description")})
public class PublicOutreach implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Column(name = "completion_date")
    @Temporal(TemporalType.DATE)
    private Date completionDate;
    @Size(max = 256)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;
    @JoinColumn(name = "public_outreach_type_id", referencedColumnName = "public_outreach_type_id")
    @ManyToOne(optional = false)
    private PublicOutreachType publicOutreachTypeId;

    /**
     *
     */
    public PublicOutreach() {
    }

    /**
     *
     * @param idActivity
     */
    public PublicOutreach(Integer idActivity) {
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
    public Date getCompletionDate() {
        return completionDate;
    }

    /**
     *
     * @param completionDate
     */
    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
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
    public PublicOutreachType getPublicOutreachTypeId() {
        return publicOutreachTypeId;
    }

    /**
     *
     * @param publicOutreachTypeId
     */
    public void setPublicOutreachTypeId(PublicOutreachType publicOutreachTypeId) {
        this.publicOutreachTypeId = publicOutreachTypeId;
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
        if (!(object instanceof PublicOutreach)) {
            return false;
        }
        PublicOutreach other = (PublicOutreach) object;
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
        return "org.centrale.hceres.items.PublicOutreach[ idActivity=" + idActivity + " ]";
    }
    
}
