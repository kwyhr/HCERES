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
@Table(name = "sei_clinical_trial")
@NamedQueries({
    @NamedQuery(name = "SeiClinicalTrial.findAll", query = "SELECT s FROM SeiClinicalTrial s"),
    @NamedQuery(name = "SeiClinicalTrial.findByIdActivity", query = "SELECT s FROM SeiClinicalTrial s WHERE s.idActivity = :idActivity"),
    @NamedQuery(name = "SeiClinicalTrial.findByStartDate", query = "SELECT s FROM SeiClinicalTrial s WHERE s.startDate = :startDate"),
    @NamedQuery(name = "SeiClinicalTrial.findByCoordinatorPartner", query = "SELECT s FROM SeiClinicalTrial s WHERE s.coordinatorPartner = :coordinatorPartner"),
    @NamedQuery(name = "SeiClinicalTrial.findByTitleClinicalTrial", query = "SELECT s FROM SeiClinicalTrial s WHERE s.titleClinicalTrial = :titleClinicalTrial"),
    @NamedQuery(name = "SeiClinicalTrial.findByEndDate", query = "SELECT s FROM SeiClinicalTrial s WHERE s.endDate = :endDate"),
    @NamedQuery(name = "SeiClinicalTrial.findByRegistrationNb", query = "SELECT s FROM SeiClinicalTrial s WHERE s.registrationNb = :registrationNb"),
    @NamedQuery(name = "SeiClinicalTrial.findBySponsorName", query = "SELECT s FROM SeiClinicalTrial s WHERE s.sponsorName = :sponsorName"),
    @NamedQuery(name = "SeiClinicalTrial.findByIncludedPatientsNb", query = "SELECT s FROM SeiClinicalTrial s WHERE s.includedPatientsNb = :includedPatientsNb"),
    @NamedQuery(name = "SeiClinicalTrial.findByFunding", query = "SELECT s FROM SeiClinicalTrial s WHERE s.funding = :funding"),
    @NamedQuery(name = "SeiClinicalTrial.findByFundingAmount", query = "SELECT s FROM SeiClinicalTrial s WHERE s.fundingAmount = :fundingAmount")})
public class SeiClinicalTrial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "coordinator_partner")
    private Boolean coordinatorPartner;
    @Size(max = 256)
    @Column(name = "title_clinical_trial")
    private String titleClinicalTrial;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Size(max = 256)
    @Column(name = "registration_nb")
    private String registrationNb;
    @Size(max = 256)
    @Column(name = "sponsor_name")
    private String sponsorName;
    @Column(name = "included_patients_nb")
    private Integer includedPatientsNb;
    @Size(max = 256)
    @Column(name = "funding")
    private String funding;
    @Column(name = "funding_amount")
    private Integer fundingAmount;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;

    /**
     *
     */
    public SeiClinicalTrial() {
    }

    /**
     *
     * @param idActivity
     */
    public SeiClinicalTrial(Integer idActivity) {
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
    public Boolean getCoordinatorPartner() {
        return coordinatorPartner;
    }

    /**
     *
     * @param coordinatorPartner
     */
    public void setCoordinatorPartner(Boolean coordinatorPartner) {
        this.coordinatorPartner = coordinatorPartner;
    }

    /**
     *
     * @return
     */
    public String getTitleClinicalTrial() {
        return titleClinicalTrial;
    }

    /**
     *
     * @param titleClinicalTrial
     */
    public void setTitleClinicalTrial(String titleClinicalTrial) {
        this.titleClinicalTrial = titleClinicalTrial;
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
    public String getRegistrationNb() {
        return registrationNb;
    }

    /**
     *
     * @param registrationNb
     */
    public void setRegistrationNb(String registrationNb) {
        this.registrationNb = registrationNb;
    }

    /**
     *
     * @return
     */
    public String getSponsorName() {
        return sponsorName;
    }

    /**
     *
     * @param sponsorName
     */
    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    /**
     *
     * @return
     */
    public Integer getIncludedPatientsNb() {
        return includedPatientsNb;
    }

    /**
     *
     * @param includedPatientsNb
     */
    public void setIncludedPatientsNb(Integer includedPatientsNb) {
        this.includedPatientsNb = includedPatientsNb;
    }

    /**
     *
     * @return
     */
    public String getFunding() {
        return funding;
    }

    /**
     *
     * @param funding
     */
    public void setFunding(String funding) {
        this.funding = funding;
    }

    /**
     *
     * @return
     */
    public Integer getFundingAmount() {
        return fundingAmount;
    }

    /**
     *
     * @param fundingAmount
     */
    public void setFundingAmount(Integer fundingAmount) {
        this.fundingAmount = fundingAmount;
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
        if (!(object instanceof SeiClinicalTrial)) {
            return false;
        }
        SeiClinicalTrial other = (SeiClinicalTrial) object;
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
        return "org.centrale.hceres.items.SeiClinicalTrial[ idActivity=" + idActivity + " ]";
    }
    
}
