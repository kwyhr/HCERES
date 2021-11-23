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
@Table(name = "incoming_mobility")
@NamedQueries({
    @NamedQuery(name = "IncomingMobility.findAll", query = "SELECT i FROM IncomingMobility i"),
    @NamedQuery(name = "IncomingMobility.findByIdActivity", query = "SELECT i FROM IncomingMobility i WHERE i.idActivity = :idActivity"),
    @NamedQuery(name = "IncomingMobility.findByNameSeniorScientist", query = "SELECT i FROM IncomingMobility i WHERE i.nameSeniorScientist = :nameSeniorScientist"),
    @NamedQuery(name = "IncomingMobility.findByArrivalDate", query = "SELECT i FROM IncomingMobility i WHERE i.arrivalDate = :arrivalDate"),
    @NamedQuery(name = "IncomingMobility.findByDepartureDate", query = "SELECT i FROM IncomingMobility i WHERE i.departureDate = :departureDate"),
    @NamedQuery(name = "IncomingMobility.findByDuration", query = "SELECT i FROM IncomingMobility i WHERE i.duration = :duration"),
    @NamedQuery(name = "IncomingMobility.findByNationality", query = "SELECT i FROM IncomingMobility i WHERE i.nationality = :nationality"),
    @NamedQuery(name = "IncomingMobility.findByOriginalLabName", query = "SELECT i FROM IncomingMobility i WHERE i.originalLabName = :originalLabName"),
    @NamedQuery(name = "IncomingMobility.findByOriginaLabLocation", query = "SELECT i FROM IncomingMobility i WHERE i.originaLabLocation = :originaLabLocation"),
    @NamedQuery(name = "IncomingMobility.findByPiPartner", query = "SELECT i FROM IncomingMobility i WHERE i.piPartner = :piPartner"),
    @NamedQuery(name = "IncomingMobility.findByProjectTitle", query = "SELECT i FROM IncomingMobility i WHERE i.projectTitle = :projectTitle"),
    @NamedQuery(name = "IncomingMobility.findByAssociatedFunding", query = "SELECT i FROM IncomingMobility i WHERE i.associatedFunding = :associatedFunding"),
    @NamedQuery(name = "IncomingMobility.findByPublicationReference", query = "SELECT i FROM IncomingMobility i WHERE i.publicationReference = :publicationReference"),
    @NamedQuery(name = "IncomingMobility.findByStrategicRecurringCollab", query = "SELECT i FROM IncomingMobility i WHERE i.strategicRecurringCollab = :strategicRecurringCollab"),
    @NamedQuery(name = "IncomingMobility.findByActiveProject", query = "SELECT i FROM IncomingMobility i WHERE i.activeProject = :activeProject"),
    @NamedQuery(name = "IncomingMobility.findByUmrCoordinated", query = "SELECT i FROM IncomingMobility i WHERE i.umrCoordinated = :umrCoordinated"),
    @NamedQuery(name = "IncomingMobility.findByAgreementSigned", query = "SELECT i FROM IncomingMobility i WHERE i.agreementSigned = :agreementSigned")})
public class IncomingMobility implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Size(max = 256)
    @Column(name = "name_senior_scientist")
    private String nameSeniorScientist;
    @Column(name = "arrival_date")
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;
    @Column(name = "departure_date")
    @Temporal(TemporalType.DATE)
    private Date departureDate;
    @Column(name = "duration")
    private Integer duration;
    @Size(max = 256)
    @Column(name = "nationality")
    private String nationality;
    @Size(max = 256)
    @Column(name = "original_lab_name")
    private String originalLabName;
    @Size(max = 256)
    @Column(name = "origina_lab_location")
    private String originaLabLocation;
    @Size(max = 256)
    @Column(name = "pi_partner")
    private String piPartner;
    @Size(max = 256)
    @Column(name = "project_title")
    private String projectTitle;
    @Size(max = 256)
    @Column(name = "associated_funding")
    private String associatedFunding;
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
    public IncomingMobility() {
    }

    /**
     *
     * @param idActivity
     */
    public IncomingMobility(Integer idActivity) {
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
    public String getNameSeniorScientist() {
        return nameSeniorScientist;
    }

    /**
     *
     * @param nameSeniorScientist
     */
    public void setNameSeniorScientist(String nameSeniorScientist) {
        this.nameSeniorScientist = nameSeniorScientist;
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
    public String getNationality() {
        return nationality;
    }

    /**
     *
     * @param nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     *
     * @return
     */
    public String getOriginalLabName() {
        return originalLabName;
    }

    /**
     *
     * @param originalLabName
     */
    public void setOriginalLabName(String originalLabName) {
        this.originalLabName = originalLabName;
    }

    /**
     *
     * @return
     */
    public String getOriginaLabLocation() {
        return originaLabLocation;
    }

    /**
     *
     * @param originaLabLocation
     */
    public void setOriginaLabLocation(String originaLabLocation) {
        this.originaLabLocation = originaLabLocation;
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
        if (!(object instanceof IncomingMobility)) {
            return false;
        }
        IncomingMobility other = (IncomingMobility) object;
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
        return "org.centrale.hceres.items.IncomingMobility[ idActivity=" + idActivity + " ]";
    }
    
}
