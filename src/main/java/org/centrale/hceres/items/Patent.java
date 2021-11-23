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
@Table(name = "patent")
@NamedQueries({
    @NamedQuery(name = "Patent.findAll", query = "SELECT p FROM Patent p"),
    @NamedQuery(name = "Patent.findByIdActivity", query = "SELECT p FROM Patent p WHERE p.idActivity = :idActivity"),
    @NamedQuery(name = "Patent.findByTitle", query = "SELECT p FROM Patent p WHERE p.title = :title"),
    @NamedQuery(name = "Patent.findByRegistrationDate", query = "SELECT p FROM Patent p WHERE p.registrationDate = :registrationDate"),
    @NamedQuery(name = "Patent.findByFilingDate", query = "SELECT p FROM Patent p WHERE p.filingDate = :filingDate"),
    @NamedQuery(name = "Patent.findByAcceptationDate", query = "SELECT p FROM Patent p WHERE p.acceptationDate = :acceptationDate"),
    @NamedQuery(name = "Patent.findByLicensingDate", query = "SELECT p FROM Patent p WHERE p.licensingDate = :licensingDate"),
    @NamedQuery(name = "Patent.findByInventors", query = "SELECT p FROM Patent p WHERE p.inventors = :inventors"),
    @NamedQuery(name = "Patent.findByCoOwners", query = "SELECT p FROM Patent p WHERE p.coOwners = :coOwners"),
    @NamedQuery(name = "Patent.findByPriorityNumber", query = "SELECT p FROM Patent p WHERE p.priorityNumber = :priorityNumber"),
    @NamedQuery(name = "Patent.findByPriorityDate", query = "SELECT p FROM Patent p WHERE p.priorityDate = :priorityDate"),
    @NamedQuery(name = "Patent.findByPublicationNumber", query = "SELECT p FROM Patent p WHERE p.publicationNumber = :publicationNumber"),
    @NamedQuery(name = "Patent.findByPublicationDate", query = "SELECT p FROM Patent p WHERE p.publicationDate = :publicationDate"),
    @NamedQuery(name = "Patent.findByInpiLink", query = "SELECT p FROM Patent p WHERE p.inpiLink = :inpiLink"),
    @NamedQuery(name = "Patent.findByStatus", query = "SELECT p FROM Patent p WHERE p.status = :status"),
    @NamedQuery(name = "Patent.findByPctExtensionObtained", query = "SELECT p FROM Patent p WHERE p.pctExtensionObtained = :pctExtensionObtained"),
    @NamedQuery(name = "Patent.findByPublicationNumberPctExtension", query = "SELECT p FROM Patent p WHERE p.publicationNumberPctExtension = :publicationNumberPctExtension"),
    @NamedQuery(name = "Patent.findByPublicationDatePctExtension", query = "SELECT p FROM Patent p WHERE p.publicationDatePctExtension = :publicationDatePctExtension"),
    @NamedQuery(name = "Patent.findByInternationalExtension", query = "SELECT p FROM Patent p WHERE p.internationalExtension = :internationalExtension"),
    @NamedQuery(name = "Patent.findByPublicationNumberInternationalExtension", query = "SELECT p FROM Patent p WHERE p.publicationNumberInternationalExtension = :publicationNumberInternationalExtension"),
    @NamedQuery(name = "Patent.findByPublicationDateInternationalExtension", query = "SELECT p FROM Patent p WHERE p.publicationDateInternationalExtension = :publicationDateInternationalExtension"),
    @NamedQuery(name = "Patent.findByRefTransferContract", query = "SELECT p FROM Patent p WHERE p.refTransferContract = :refTransferContract"),
    @NamedQuery(name = "Patent.findByNameCompanyInvolved", query = "SELECT p FROM Patent p WHERE p.nameCompanyInvolved = :nameCompanyInvolved")})
public class Patent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Size(max = 256)
    @Column(name = "title")
    private String title;
    @Column(name = "registration_date")
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
    @Column(name = "filing_date")
    @Temporal(TemporalType.DATE)
    private Date filingDate;
    @Column(name = "acceptation_date")
    @Temporal(TemporalType.DATE)
    private Date acceptationDate;
    @Column(name = "licensing_date")
    @Temporal(TemporalType.DATE)
    private Date licensingDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "inventors")
    private String inventors;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "co_owners")
    private String coOwners;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "priority_number")
    private Float priorityNumber;
    @Column(name = "priority_date")
    @Temporal(TemporalType.DATE)
    private Date priorityDate;
    @Size(max = 256)
    @Column(name = "publication_number")
    private String publicationNumber;
    @Column(name = "publication_date")
    @Temporal(TemporalType.DATE)
    private Date publicationDate;
    @Size(max = 256)
    @Column(name = "inpi_link")
    private String inpiLink;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pct_extension_obtained")
    private boolean pctExtensionObtained;
    @Size(max = 256)
    @Column(name = "publication_number_pct_extension")
    private String publicationNumberPctExtension;
    @Column(name = "publication_date_pct_extension")
    @Temporal(TemporalType.DATE)
    private Date publicationDatePctExtension;
    @Basic(optional = false)
    @NotNull
    @Column(name = "international_extension")
    private boolean internationalExtension;
    @Size(max = 256)
    @Column(name = "publication_number_international_extension")
    private String publicationNumberInternationalExtension;
    @Column(name = "publication_date_international_extension")
    @Temporal(TemporalType.DATE)
    private Date publicationDateInternationalExtension;
    @Size(max = 256)
    @Column(name = "ref_transfer_contract")
    private String refTransferContract;
    @Size(max = 256)
    @Column(name = "name_company_involved")
    private String nameCompanyInvolved;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;
    @JoinColumn(name = "type_patent_id", referencedColumnName = "type_patent_id")
    @ManyToOne(optional = false)
    private TypePatent typePatentId;

    /**
     *
     */
    public Patent() {
    }

    /**
     *
     * @param idActivity
     */
    public Patent(Integer idActivity) {
        this.idActivity = idActivity;
    }

    /**
     *
     * @param idActivity
     * @param inventors
     * @param coOwners
     * @param status
     * @param pctExtensionObtained
     * @param internationalExtension
     */
    public Patent(Integer idActivity, String inventors, String coOwners, boolean status, boolean pctExtensionObtained, boolean internationalExtension) {
        this.idActivity = idActivity;
        this.inventors = inventors;
        this.coOwners = coOwners;
        this.status = status;
        this.pctExtensionObtained = pctExtensionObtained;
        this.internationalExtension = internationalExtension;
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
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     *
     * @param registrationDate
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     *
     * @return
     */
    public Date getFilingDate() {
        return filingDate;
    }

    /**
     *
     * @param filingDate
     */
    public void setFilingDate(Date filingDate) {
        this.filingDate = filingDate;
    }

    /**
     *
     * @return
     */
    public Date getAcceptationDate() {
        return acceptationDate;
    }

    /**
     *
     * @param acceptationDate
     */
    public void setAcceptationDate(Date acceptationDate) {
        this.acceptationDate = acceptationDate;
    }

    /**
     *
     * @return
     */
    public Date getLicensingDate() {
        return licensingDate;
    }

    /**
     *
     * @param licensingDate
     */
    public void setLicensingDate(Date licensingDate) {
        this.licensingDate = licensingDate;
    }

    /**
     *
     * @return
     */
    public String getInventors() {
        return inventors;
    }

    /**
     *
     * @param inventors
     */
    public void setInventors(String inventors) {
        this.inventors = inventors;
    }

    /**
     *
     * @return
     */
    public String getCoOwners() {
        return coOwners;
    }

    /**
     *
     * @param coOwners
     */
    public void setCoOwners(String coOwners) {
        this.coOwners = coOwners;
    }

    /**
     *
     * @return
     */
    public Float getPriorityNumber() {
        return priorityNumber;
    }

    /**
     *
     * @param priorityNumber
     */
    public void setPriorityNumber(Float priorityNumber) {
        this.priorityNumber = priorityNumber;
    }

    /**
     *
     * @return
     */
    public Date getPriorityDate() {
        return priorityDate;
    }

    /**
     *
     * @param priorityDate
     */
    public void setPriorityDate(Date priorityDate) {
        this.priorityDate = priorityDate;
    }

    /**
     *
     * @return
     */
    public String getPublicationNumber() {
        return publicationNumber;
    }

    /**
     *
     * @param publicationNumber
     */
    public void setPublicationNumber(String publicationNumber) {
        this.publicationNumber = publicationNumber;
    }

    /**
     *
     * @return
     */
    public Date getPublicationDate() {
        return publicationDate;
    }

    /**
     *
     * @param publicationDate
     */
    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     *
     * @return
     */
    public String getInpiLink() {
        return inpiLink;
    }

    /**
     *
     * @param inpiLink
     */
    public void setInpiLink(String inpiLink) {
        this.inpiLink = inpiLink;
    }

    /**
     *
     * @return
     */
    public boolean getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public boolean getPctExtensionObtained() {
        return pctExtensionObtained;
    }

    /**
     *
     * @param pctExtensionObtained
     */
    public void setPctExtensionObtained(boolean pctExtensionObtained) {
        this.pctExtensionObtained = pctExtensionObtained;
    }

    /**
     *
     * @return
     */
    public String getPublicationNumberPctExtension() {
        return publicationNumberPctExtension;
    }

    /**
     *
     * @param publicationNumberPctExtension
     */
    public void setPublicationNumberPctExtension(String publicationNumberPctExtension) {
        this.publicationNumberPctExtension = publicationNumberPctExtension;
    }

    /**
     *
     * @return
     */
    public Date getPublicationDatePctExtension() {
        return publicationDatePctExtension;
    }

    /**
     *
     * @param publicationDatePctExtension
     */
    public void setPublicationDatePctExtension(Date publicationDatePctExtension) {
        this.publicationDatePctExtension = publicationDatePctExtension;
    }

    /**
     *
     * @return
     */
    public boolean getInternationalExtension() {
        return internationalExtension;
    }

    /**
     *
     * @param internationalExtension
     */
    public void setInternationalExtension(boolean internationalExtension) {
        this.internationalExtension = internationalExtension;
    }

    /**
     *
     * @return
     */
    public String getPublicationNumberInternationalExtension() {
        return publicationNumberInternationalExtension;
    }

    /**
     *
     * @param publicationNumberInternationalExtension
     */
    public void setPublicationNumberInternationalExtension(String publicationNumberInternationalExtension) {
        this.publicationNumberInternationalExtension = publicationNumberInternationalExtension;
    }

    /**
     *
     * @return
     */
    public Date getPublicationDateInternationalExtension() {
        return publicationDateInternationalExtension;
    }

    /**
     *
     * @param publicationDateInternationalExtension
     */
    public void setPublicationDateInternationalExtension(Date publicationDateInternationalExtension) {
        this.publicationDateInternationalExtension = publicationDateInternationalExtension;
    }

    /**
     *
     * @return
     */
    public String getRefTransferContract() {
        return refTransferContract;
    }

    /**
     *
     * @param refTransferContract
     */
    public void setRefTransferContract(String refTransferContract) {
        this.refTransferContract = refTransferContract;
    }

    /**
     *
     * @return
     */
    public String getNameCompanyInvolved() {
        return nameCompanyInvolved;
    }

    /**
     *
     * @param nameCompanyInvolved
     */
    public void setNameCompanyInvolved(String nameCompanyInvolved) {
        this.nameCompanyInvolved = nameCompanyInvolved;
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
    public TypePatent getTypePatentId() {
        return typePatentId;
    }

    /**
     *
     * @param typePatentId
     */
    public void setTypePatentId(TypePatent typePatentId) {
        this.typePatentId = typePatentId;
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
        if (!(object instanceof Patent)) {
            return false;
        }
        Patent other = (Patent) object;
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
        return "org.centrale.hceres.items.Patent[ idActivity=" + idActivity + " ]";
    }
    
}
