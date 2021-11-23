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
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "meeting")
@NamedQueries({
    @NamedQuery(name = "Meeting.findAll", query = "SELECT m FROM Meeting m"),
    @NamedQuery(name = "Meeting.findByMeetingId", query = "SELECT m FROM Meeting m WHERE m.meetingId = :meetingId"),
    @NamedQuery(name = "Meeting.findByNeetingName", query = "SELECT m FROM Meeting m WHERE m.neetingName = :neetingName"),
    @NamedQuery(name = "Meeting.findByMeetingYear", query = "SELECT m FROM Meeting m WHERE m.meetingYear = :meetingYear"),
    @NamedQuery(name = "Meeting.findByMeetingLocation", query = "SELECT m FROM Meeting m WHERE m.meetingLocation = :meetingLocation"),
    @NamedQuery(name = "Meeting.findByMeetingStart", query = "SELECT m FROM Meeting m WHERE m.meetingStart = :meetingStart"),
    @NamedQuery(name = "Meeting.findByMeetingEnd", query = "SELECT m FROM Meeting m WHERE m.meetingEnd = :meetingEnd")})
public class Meeting implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "meeting_id")
    private Integer meetingId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "neeting_name")
    private String neetingName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "meeting_year")
    private int meetingYear;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "meeting_location")
    private String meetingLocation;
    @Column(name = "meeting_start")
    @Temporal(TemporalType.DATE)
    private Date meetingStart;
    @Column(name = "meeting_end")
    @Temporal(TemporalType.DATE)
    private Date meetingEnd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meetingId")
    private Collection<MeetingCongressOrg> meetingCongressOrgCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meetingId")
    private Collection<OralCommunication> oralCommunicationCollection;

    /**
     *
     */
    public Meeting() {
    }

    /**
     *
     * @param meetingId
     */
    public Meeting(Integer meetingId) {
        this.meetingId = meetingId;
    }

    /**
     *
     * @param meetingId
     * @param neetingName
     * @param meetingYear
     * @param meetingLocation
     */
    public Meeting(Integer meetingId, String neetingName, int meetingYear, String meetingLocation) {
        this.meetingId = meetingId;
        this.neetingName = neetingName;
        this.meetingYear = meetingYear;
        this.meetingLocation = meetingLocation;
    }

    /**
     *
     * @return
     */
    public Integer getMeetingId() {
        return meetingId;
    }

    /**
     *
     * @param meetingId
     */
    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    /**
     *
     * @return
     */
    public String getNeetingName() {
        return neetingName;
    }

    /**
     *
     * @param neetingName
     */
    public void setNeetingName(String neetingName) {
        this.neetingName = neetingName;
    }

    /**
     *
     * @return
     */
    public int getMeetingYear() {
        return meetingYear;
    }

    /**
     *
     * @param meetingYear
     */
    public void setMeetingYear(int meetingYear) {
        this.meetingYear = meetingYear;
    }

    /**
     *
     * @return
     */
    public String getMeetingLocation() {
        return meetingLocation;
    }

    /**
     *
     * @param meetingLocation
     */
    public void setMeetingLocation(String meetingLocation) {
        this.meetingLocation = meetingLocation;
    }

    /**
     *
     * @return
     */
    public Date getMeetingStart() {
        return meetingStart;
    }

    /**
     *
     * @param meetingStart
     */
    public void setMeetingStart(Date meetingStart) {
        this.meetingStart = meetingStart;
    }

    /**
     *
     * @return
     */
    public Date getMeetingEnd() {
        return meetingEnd;
    }

    /**
     *
     * @param meetingEnd
     */
    public void setMeetingEnd(Date meetingEnd) {
        this.meetingEnd = meetingEnd;
    }

    /**
     *
     * @return
     */
    public Collection<MeetingCongressOrg> getMeetingCongressOrgCollection() {
        return meetingCongressOrgCollection;
    }

    /**
     *
     * @param meetingCongressOrgCollection
     */
    public void setMeetingCongressOrgCollection(Collection<MeetingCongressOrg> meetingCongressOrgCollection) {
        this.meetingCongressOrgCollection = meetingCongressOrgCollection;
    }

    /**
     *
     * @return
     */
    public Collection<OralCommunication> getOralCommunicationCollection() {
        return oralCommunicationCollection;
    }

    /**
     *
     * @param oralCommunicationCollection
     */
    public void setOralCommunicationCollection(Collection<OralCommunication> oralCommunicationCollection) {
        this.oralCommunicationCollection = oralCommunicationCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (meetingId != null ? meetingId.hashCode() : 0);
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
        if (!(object instanceof Meeting)) {
            return false;
        }
        Meeting other = (Meeting) object;
        if ((this.meetingId == null && other.meetingId != null) || (this.meetingId != null && !this.meetingId.equals(other.meetingId))) {
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
        return "org.centrale.hceres.items.Meeting[ meetingId=" + meetingId + " ]";
    }
    
}
