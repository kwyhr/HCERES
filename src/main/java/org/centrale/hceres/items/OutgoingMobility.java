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
@Table(name = "outgoing_mobility")
@NamedQueries({
    @NamedQuery(name = "OutgoingMobility.findAll", query = "SELECT o FROM OutgoingMobility o"),
    @NamedQuery(name = "OutgoingMobility.findByIdActivity", query = "SELECT o FROM OutgoingMobility o WHERE o.idActivity = :idActivity"),
    @NamedQuery(name = "OutgoingMobility.findByNamePersonConcerned", query = "SELECT o FROM OutgoingMobility o WHERE o.namePersonConcerned = :namePersonConcerned"),
    @NamedQuery(name = "OutgoingMobility.findByArrivalDate", query = "SELECT o FROM OutgoingMobility o WHERE o.arrivalDate = :arrivalDate"),
    @NamedQuery(name = "OutgoingMobility.findByDepartureDate", query = "SELECT o FROM OutgoingMobility o WHERE o.departureDate = :departureDate"),
    @NamedQuery(name = "OutgoingMobility.findByDuration", query = "SELECT o FROM OutgoingMobility o WHERE o.duration = :duration"),
    @NamedQuery(name = "OutgoingMobility.findByHostLabName", query = "SELECT o FROM OutgoingMobility o WHERE o.hostLabName = :hostLabName"),
    @NamedQuery(name = "OutgoingMobility.findByHostLabLocation", query = "SELECT o FROM OutgoingMobility o WHERE o.hostLabLocation = :hostLabLocation"),
    @NamedQuery(name = "OutgoingMobility.findByPiPartner", query = "SELECT o FROM OutgoingMobility o WHERE o.piPartner = :piPartner"),
    @NamedQuery(name = "OutgoingMobility.findByProjectTitle", query = "SELECT o FROM OutgoingMobility o WHERE o.projectTitle = :projectTitle"),
    @NamedQuery(name = "OutgoingMobility.findByAssociatedFunding", query = "SELECT o FROM OutgoingMobility o WHERE o.associatedFunding = :associatedFunding"),
    @NamedQuery(name = "OutgoingMobility.findByNbPublications", query = "SELECT o FROM OutgoingMobility o WHERE o.nbPublications = :nbPublications"),
    @NamedQuery(name = "OutgoingMobility.findByPublicationReference", query = "SELECT o FROM OutgoingMobility o WHERE o.publicationReference = :publicationReference"),
    @NamedQuery(name = "OutgoingMobility.findByStrategicRecurringCollab", query = "SELECT o FROM OutgoingMobility o WHERE o.strategicRecurringCollab = :strategicRecurringCollab"),
    @NamedQuery(name = "OutgoingMobility.findByActiveProject", query = "SELECT o FROM OutgoingMobility o WHERE o.activeProject = :activeProject"),
    @NamedQuery(name = "OutgoingMobility.findByUmrCoordinated", query = "SELECT o FROM OutgoingMobility o WHERE o.umrCoordinated = :umrCoordinated"),
    @NamedQuery(name = "OutgoingMobility.findByAgreementSigned", query = "SELECT o FROM OutgoingMobility o WHERE o.agreementSigned = :agreementSigned")})
public class OutgoingMobility implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Size(max = 256)
    @Column(name = "name_person_concerned")
    private String namePersonConcerned;
    @Column(name = "arrival_date")
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;
    @Column(name = "departure_date")
    @Temporal(TemporalType.DATE)
    private Date departureDate;
    @Column(name = "duration")
    private Integer duration;
    @Size(max = 256)
    @Column(name = "host_lab_name")
    private String hostLabName;
    @Size(max = 256)
    @Column(name = "host_lab_location")
    private String hostLabLocation;
    @Size(max = 256)
    @Column(name = "pi_partner")
    private String piPartner;
    @Size(max = 256)
    @Column(name = "project_title")
    private String projectTitle;
    @Size(max = 256)
    @Column(name = "associated_funding")
    private String associatedFunding;
    @Column(name = "nb_publications")
    private Integer nbPublications;
    @Size(max = 256)
    @Column(name = "publication_reference")
    private String publicationReference;
    @Column(name = "strategic_recurring_collab")
    private Boolean strategicRecurringCollab;
    @Column(name = "active_project")
    private Boolean activeProject;
    @Column(name = "umr_coordinated")
    private Boolean umrCoordinated;
    @Column(name = "agreement_signed")
    private Boolean agreementSigned;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;

    /**
     *
     */
    public OutgoingMobility() {
    }

    /**
     *
     * @param idActivity
     */
    public OutgoingMobility(Integer idActivity) {
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
    public String getNamePersonConcerned() {
        return namePersonConcerned;
    }

    /**
     *
     * @param namePersonConcerned
     */
    public void setNamePersonConcerned(String namePersonConcerned) {
        this.namePersonConcerned = namePersonConcerned;
    }

    /**
     *
     * @return
     */
    public Date getArrivalDate() {
        return arrivalDate;
    }

    /**
     *
     * @param arrivalDate
     */
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     *
     * @return
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     *
     * @param departureDate
     */
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    /**
     *
     * @return
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     *
     * @param duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     *
     * @return
     */
    public String getHostLabName() {
        return hostLabName;
    }

    /**
     *
     * @param hostLabName
     */
    public void setHostLabName(String hostLabName) {
        this.hostLabName = hostLabName;
    }

    /**
     *
     * @return
     */
    public String getHostLabLocation() {
        return hostLabLocation;
    }

    /**
     *
     * @param hostLabLocation
     */
    public void setHostLabLocation(String hostLabLocation) {
        this.hostLabLocation = hostLabLocation;
    }

    /**
     *
     * @return
     */
    public String getPiPartner() {
        return piPartner;
    }

    /**
     *
     * @param piPartner
     */
    public void setPiPartner(String piPartner) {
        this.piPartner = piPartner;
    }

    /**
     *
     * @return
     */
    public String getProjectTitle() {
        return projectTitle;
    }

    /**
     *
     * @param projectTitle
     */
    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    /**
     *
     * @return
     */
    public String getAssociatedFunding() {
        return associatedFunding;
    }

    /**
     *
     * @param associatedFunding
     */
    public void setAssociatedFunding(String associatedFunding) {
        this.associatedFunding = associatedFunding;
    }

    /**
     *
     * @return
     */
    public Integer getNbPublications() {
        return nbPublications;
    }

    /**
     *
     * @param nbPublications
     */
    public void setNbPublications(Integer nbPublications) {
        this.nbPublications = nbPublications;
    }

    /**
     *
     * @return
     */
    public String getPublicationReference() {
        return publicationReference;
    }

    /**
     *
     * @param publicationReference
     */
    public void setPublicationReference(String publicationReference) {
        this.publicationReference = publicationReference;
    }

    /**
     *
     * @return
     */
    public Boolean getStrategicRecurringCollab() {
        return strategicRecurringCollab;
    }

    /**
     *
     * @param strategicRecurringCollab
     */
    public void setStrategicRecurringCollab(Boolean strategicRecurringCollab) {
        this.strategicRecurringCollab = strategicRecurringCollab;
    }

    /**
     *
     * @return
     */
    public Boolean getActiveProject() {
        return activeProject;
    }

    /**
     *
     * @param activeProject
     */
    public void setActiveProject(Boolean activeProject) {
        this.activeProject = activeProject;
    }

    /**
     *
     * @return
     */
    public Boolean getUmrCoordinated() {
        return umrCoordinated;
    }

    /**
     *
     * @param umrCoordinated
     */
    public void setUmrCoordinated(Boolean umrCoordinated) {
        this.umrCoordinated = umrCoordinated;
    }

    /**
     *
     * @return
     */
    public Boolean getAgreementSigned() {
        return agreementSigned;
    }

    /**
     *
     * @param agreementSigned
     */
    public void setAgreementSigned(Boolean agreementSigned) {
        this.agreementSigned = agreementSigned;
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
        if (!(object instanceof OutgoingMobility)) {
            return false;
        }
        OutgoingMobility other = (OutgoingMobility) object;
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
        return "org.centrale.hceres.items.OutgoingMobility[ idActivity=" + idActivity + " ]";
    }
    
}
