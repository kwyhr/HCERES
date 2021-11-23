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
@Table(name = "invited_seminar")
@NamedQueries({
    @NamedQuery(name = "InvitedSeminar.findAll", query = "SELECT i FROM InvitedSeminar i"),
    @NamedQuery(name = "InvitedSeminar.findByIdActivity", query = "SELECT i FROM InvitedSeminar i WHERE i.idActivity = :idActivity"),
    @NamedQuery(name = "InvitedSeminar.findByTitleSeminar", query = "SELECT i FROM InvitedSeminar i WHERE i.titleSeminar = :titleSeminar"),
    @NamedQuery(name = "InvitedSeminar.findByDate", query = "SELECT i FROM InvitedSeminar i WHERE i.date = :date"),
    @NamedQuery(name = "InvitedSeminar.findByLocation", query = "SELECT i FROM InvitedSeminar i WHERE i.location = :location"),
    @NamedQuery(name = "InvitedSeminar.findByInvitedBy", query = "SELECT i FROM InvitedSeminar i WHERE i.invitedBy = :invitedBy")})
public class InvitedSeminar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Size(max = 256)
    @Column(name = "title_seminar")
    private String titleSeminar;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 256)
    @Column(name = "location")
    private String location;
    @Size(max = 256)
    @Column(name = "invited_by")
    private String invitedBy;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;

    /**
     *
     */
    public InvitedSeminar() {
    }

    /**
     *
     * @param idActivity
     */
    public InvitedSeminar(Integer idActivity) {
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
    public String getTitleSeminar() {
        return titleSeminar;
    }

    /**
     *
     * @param titleSeminar
     */
    public void setTitleSeminar(String titleSeminar) {
        this.titleSeminar = titleSeminar;
    }

    /**
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return
     */
    public String getInvitedBy() {
        return invitedBy;
    }

    /**
     *
     * @param invitedBy
     */
    public void setInvitedBy(String invitedBy) {
        this.invitedBy = invitedBy;
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
        if (!(object instanceof InvitedSeminar)) {
            return false;
        }
        InvitedSeminar other = (InvitedSeminar) object;
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
        return "org.centrale.hceres.items.InvitedSeminar[ idActivity=" + idActivity + " ]";
    }
    
}
