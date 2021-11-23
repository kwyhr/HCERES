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
@Table(name = "oral_communication")
@NamedQueries({
    @NamedQuery(name = "OralCommunication.findAll", query = "SELECT o FROM OralCommunication o"),
    @NamedQuery(name = "OralCommunication.findByIdActivity", query = "SELECT o FROM OralCommunication o WHERE o.idActivity = :idActivity"),
    @NamedQuery(name = "OralCommunication.findByOralCommunicationTitle", query = "SELECT o FROM OralCommunication o WHERE o.oralCommunicationTitle = :oralCommunicationTitle"),
    @NamedQuery(name = "OralCommunication.findByOralCommunicationDat", query = "SELECT o FROM OralCommunication o WHERE o.oralCommunicationDat = :oralCommunicationDat"),
    @NamedQuery(name = "OralCommunication.findByAuthors", query = "SELECT o FROM OralCommunication o WHERE o.authors = :authors")})
public class OralCommunication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Size(max = 512)
    @Column(name = "oral_communication_title")
    private String oralCommunicationTitle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "oral_communication_dat")
    @Temporal(TemporalType.DATE)
    private Date oralCommunicationDat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "authors")
    private String authors;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;
    @JoinColumn(name = "meeting_id", referencedColumnName = "meeting_id")
    @ManyToOne(optional = false)
    private Meeting meetingId;
    @JoinColumn(name = "type_oral_communication_id", referencedColumnName = "type_oral_communication_id")
    @ManyToOne(optional = false)
    private TypeOralCommunication typeOralCommunicationId;

    /**
     *
     */
    public OralCommunication() {
    }

    /**
     *
     * @param idActivity
     */
    public OralCommunication(Integer idActivity) {
        this.idActivity = idActivity;
    }

    /**
     *
     * @param idActivity
     * @param oralCommunicationDat
     * @param authors
     */
    public OralCommunication(Integer idActivity, Date oralCommunicationDat, String authors) {
        this.idActivity = idActivity;
        this.oralCommunicationDat = oralCommunicationDat;
        this.authors = authors;
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
    public String getOralCommunicationTitle() {
        return oralCommunicationTitle;
    }

    /**
     *
     * @param oralCommunicationTitle
     */
    public void setOralCommunicationTitle(String oralCommunicationTitle) {
        this.oralCommunicationTitle = oralCommunicationTitle;
    }

    /**
     *
     * @return
     */
    public Date getOralCommunicationDat() {
        return oralCommunicationDat;
    }

    /**
     *
     * @param oralCommunicationDat
     */
    public void setOralCommunicationDat(Date oralCommunicationDat) {
        this.oralCommunicationDat = oralCommunicationDat;
    }

    /**
     *
     * @return
     */
    public String getAuthors() {
        return authors;
    }

    /**
     *
     * @param authors
     */
    public void setAuthors(String authors) {
        this.authors = authors;
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
    public Meeting getMeetingId() {
        return meetingId;
    }

    /**
     *
     * @param meetingId
     */
    public void setMeetingId(Meeting meetingId) {
        this.meetingId = meetingId;
    }

    /**
     *
     * @return
     */
    public TypeOralCommunication getTypeOralCommunicationId() {
        return typeOralCommunicationId;
    }

    /**
     *
     * @param typeOralCommunicationId
     */
    public void setTypeOralCommunicationId(TypeOralCommunication typeOralCommunicationId) {
        this.typeOralCommunicationId = typeOralCommunicationId;
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
        if (!(object instanceof OralCommunication)) {
            return false;
        }
        OralCommunication other = (OralCommunication) object;
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
        return "org.centrale.hceres.items.OralCommunication[ idActivity=" + idActivity + " ]";
    }
    
}
