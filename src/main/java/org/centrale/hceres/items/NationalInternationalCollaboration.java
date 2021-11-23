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
@Table(name = "national_international_collaboration")
@NamedQueries({
    @NamedQuery(name = "NationalInternationalCollaboration.findAll", query = "SELECT n FROM NationalInternationalCollaboration n"),
    @NamedQuery(name = "NationalInternationalCollaboration.findByIdActivity", query = "SELECT n FROM NationalInternationalCollaboration n WHERE n.idActivity = :idActivity"),
    @NamedQuery(name = "NationalInternationalCollaboration.findByDateProjectStart", query = "SELECT n FROM NationalInternationalCollaboration n WHERE n.dateProjectStart = :dateProjectStart"),
    @NamedQuery(name = "NationalInternationalCollaboration.findByPartnerEntity", query = "SELECT n FROM NationalInternationalCollaboration n WHERE n.partnerEntity = :partnerEntity"),
    @NamedQuery(name = "NationalInternationalCollaboration.findByCountryStateCity", query = "SELECT n FROM NationalInternationalCollaboration n WHERE n.countryStateCity = :countryStateCity"),
    @NamedQuery(name = "NationalInternationalCollaboration.findByPiPartners", query = "SELECT n FROM NationalInternationalCollaboration n WHERE n.piPartners = :piPartners"),
    @NamedQuery(name = "NationalInternationalCollaboration.findByMailPartners", query = "SELECT n FROM NationalInternationalCollaboration n WHERE n.mailPartners = :mailPartners"),
    @NamedQuery(name = "NationalInternationalCollaboration.findByProjetcTitle", query = "SELECT n FROM NationalInternationalCollaboration n WHERE n.projetcTitle = :projetcTitle"),
    @NamedQuery(name = "NationalInternationalCollaboration.findByStrategicRecurringCollab", query = "SELECT n FROM NationalInternationalCollaboration n WHERE n.strategicRecurringCollab = :strategicRecurringCollab"),
    @NamedQuery(name = "NationalInternationalCollaboration.findByActiveProject", query = "SELECT n FROM NationalInternationalCollaboration n WHERE n.activeProject = :activeProject"),
    @NamedQuery(name = "NationalInternationalCollaboration.findByAssociatedFunding", query = "SELECT n FROM NationalInternationalCollaboration n WHERE n.associatedFunding = :associatedFunding"),
    @NamedQuery(name = "NationalInternationalCollaboration.findByNumberResultingPublications", query = "SELECT n FROM NationalInternationalCollaboration n WHERE n.numberResultingPublications = :numberResultingPublications"),
    @NamedQuery(name = "NationalInternationalCollaboration.findByRefJointPublication", query = "SELECT n FROM NationalInternationalCollaboration n WHERE n.refJointPublication = :refJointPublication"),
    @NamedQuery(name = "NationalInternationalCollaboration.findByUmrCoordinated", query = "SELECT n FROM NationalInternationalCollaboration n WHERE n.umrCoordinated = :umrCoordinated"),
    @NamedQuery(name = "NationalInternationalCollaboration.findByAgreementSigned", query = "SELECT n FROM NationalInternationalCollaboration n WHERE n.agreementSigned = :agreementSigned")})
public class NationalInternationalCollaboration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Column(name = "date_project_start")
    @Temporal(TemporalType.DATE)
    private Date dateProjectStart;
    @Size(max = 256)
    @Column(name = "partner_entity")
    private String partnerEntity;
    @Size(max = 256)
    @Column(name = "country_state_city")
    private String countryStateCity;
    @Size(max = 256)
    @Column(name = "pi_partners")
    private String piPartners;
    @Size(max = 256)
    @Column(name = "mail_partners")
    private String mailPartners;
    @Size(max = 256)
    @Column(name = "projetc_title")
    private String projetcTitle;
    @Column(name = "strategic_recurring_collab")
    private Boolean strategicRecurringCollab;
    @Column(name = "active_project")
    private Boolean activeProject;
    @Size(max = 256)
    @Column(name = "associated_funding")
    private String associatedFunding;
    @Column(name = "number_resulting_publications")
    private Integer numberResultingPublications;
    @Size(max = 256)
    @Column(name = "ref_joint_publication")
    private String refJointPublication;
    @Column(name = "umr_coordinated")
    private Boolean umrCoordinated;
    @Column(name = "agreement_signed")
    private Boolean agreementSigned;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;
    @JoinColumn(name = "type_collab_id", referencedColumnName = "type_collab_id")
    @ManyToOne(optional = false)
    private TypeCollab typeCollabId;

    /**
     *
     */
    public NationalInternationalCollaboration() {
    }

    /**
     *
     * @param idActivity
     */
    public NationalInternationalCollaboration(Integer idActivity) {
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
    public Date getDateProjectStart() {
        return dateProjectStart;
    }

    /**
     *
     * @param dateProjectStart
     */
    public void setDateProjectStart(Date dateProjectStart) {
        this.dateProjectStart = dateProjectStart;
    }

    /**
     *
     * @return
     */
    public String getPartnerEntity() {
        return partnerEntity;
    }

    /**
     *
     * @param partnerEntity
     */
    public void setPartnerEntity(String partnerEntity) {
        this.partnerEntity = partnerEntity;
    }

    /**
     *
     * @return
     */
    public String getCountryStateCity() {
        return countryStateCity;
    }

    /**
     *
     * @param countryStateCity
     */
    public void setCountryStateCity(String countryStateCity) {
        this.countryStateCity = countryStateCity;
    }

    /**
     *
     * @return
     */
    public String getPiPartners() {
        return piPartners;
    }

    /**
     *
     * @param piPartners
     */
    public void setPiPartners(String piPartners) {
        this.piPartners = piPartners;
    }

    /**
     *
     * @return
     */
    public String getMailPartners() {
        return mailPartners;
    }

    /**
     *
     * @param mailPartners
     */
    public void setMailPartners(String mailPartners) {
        this.mailPartners = mailPartners;
    }

    /**
     *
     * @return
     */
    public String getProjetcTitle() {
        return projetcTitle;
    }

    /**
     *
     * @param projetcTitle
     */
    public void setProjetcTitle(String projetcTitle) {
        this.projetcTitle = projetcTitle;
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
    public Integer getNumberResultingPublications() {
        return numberResultingPublications;
    }

    /**
     *
     * @param numberResultingPublications
     */
    public void setNumberResultingPublications(Integer numberResultingPublications) {
        this.numberResultingPublications = numberResultingPublications;
    }

    /**
     *
     * @return
     */
    public String getRefJointPublication() {
        return refJointPublication;
    }

    /**
     *
     * @param refJointPublication
     */
    public void setRefJointPublication(String refJointPublication) {
        this.refJointPublication = refJointPublication;
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
    public TypeCollab getTypeCollabId() {
        return typeCollabId;
    }

    /**
     *
     * @param typeCollabId
     */
    public void setTypeCollabId(TypeCollab typeCollabId) {
        this.typeCollabId = typeCollabId;
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
        if (!(object instanceof NationalInternationalCollaboration)) {
            return false;
        }
        NationalInternationalCollaboration other = (NationalInternationalCollaboration) object;
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
        return "org.centrale.hceres.items.NationalInternationalCollaboration[ idActivity=" + idActivity + " ]";
    }
    
}
