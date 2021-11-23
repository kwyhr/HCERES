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
@Table(name = "research_contract_funded_public_charitable_inst")
@NamedQueries({
    @NamedQuery(name = "ResearchContractFundedPublicCharitableInst.findAll", query = "SELECT r FROM ResearchContractFundedPublicCharitableInst r"),
    @NamedQuery(name = "ResearchContractFundedPublicCharitableInst.findByIdActivity", query = "SELECT r FROM ResearchContractFundedPublicCharitableInst r WHERE r.idActivity = :idActivity"),
    @NamedQuery(name = "ResearchContractFundedPublicCharitableInst.findByDateContractAward", query = "SELECT r FROM ResearchContractFundedPublicCharitableInst r WHERE r.dateContractAward = :dateContractAward"),
    @NamedQuery(name = "ResearchContractFundedPublicCharitableInst.findByFundingIntitution", query = "SELECT r FROM ResearchContractFundedPublicCharitableInst r WHERE r.fundingIntitution = :fundingIntitution"),
    @NamedQuery(name = "ResearchContractFundedPublicCharitableInst.findByProjectTitle", query = "SELECT r FROM ResearchContractFundedPublicCharitableInst r WHERE r.projectTitle = :projectTitle"),
    @NamedQuery(name = "ResearchContractFundedPublicCharitableInst.findByStartYear", query = "SELECT r FROM ResearchContractFundedPublicCharitableInst r WHERE r.startYear = :startYear"),
    @NamedQuery(name = "ResearchContractFundedPublicCharitableInst.findByEndYear", query = "SELECT r FROM ResearchContractFundedPublicCharitableInst r WHERE r.endYear = :endYear"),
    @NamedQuery(name = "ResearchContractFundedPublicCharitableInst.findByGrantAmount", query = "SELECT r FROM ResearchContractFundedPublicCharitableInst r WHERE r.grantAmount = :grantAmount")})
public class ResearchContractFundedPublicCharitableInst implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Column(name = "date_contract_award")
    @Temporal(TemporalType.DATE)
    private Date dateContractAward;
    @Size(max = 256)
    @Column(name = "funding_intitution")
    private String fundingIntitution;
    @Size(max = 256)
    @Column(name = "project_title")
    private String projectTitle;
    @Column(name = "start_year")
    private Integer startYear;
    @Column(name = "end_year")
    private Integer endYear;
    @Column(name = "grant_amount")
    private Integer grantAmount;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;
    @JoinColumn(name = "id_type", referencedColumnName = "id_type")
    @ManyToOne(optional = false)
    private TypeResearchContract idType;

    /**
     *
     */
    public ResearchContractFundedPublicCharitableInst() {
    }

    /**
     *
     * @param idActivity
     */
    public ResearchContractFundedPublicCharitableInst(Integer idActivity) {
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
    public Date getDateContractAward() {
        return dateContractAward;
    }

    /**
     *
     * @param dateContractAward
     */
    public void setDateContractAward(Date dateContractAward) {
        this.dateContractAward = dateContractAward;
    }

    /**
     *
     * @return
     */
    public String getFundingIntitution() {
        return fundingIntitution;
    }

    /**
     *
     * @param fundingIntitution
     */
    public void setFundingIntitution(String fundingIntitution) {
        this.fundingIntitution = fundingIntitution;
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
    public Integer getStartYear() {
        return startYear;
    }

    /**
     *
     * @param startYear
     */
    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    /**
     *
     * @return
     */
    public Integer getEndYear() {
        return endYear;
    }

    /**
     *
     * @param endYear
     */
    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    /**
     *
     * @return
     */
    public Integer getGrantAmount() {
        return grantAmount;
    }

    /**
     *
     * @param grantAmount
     */
    public void setGrantAmount(Integer grantAmount) {
        this.grantAmount = grantAmount;
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
    public TypeResearchContract getIdType() {
        return idType;
    }

    /**
     *
     * @param idType
     */
    public void setIdType(TypeResearchContract idType) {
        this.idType = idType;
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
        if (!(object instanceof ResearchContractFundedPublicCharitableInst)) {
            return false;
        }
        ResearchContractFundedPublicCharitableInst other = (ResearchContractFundedPublicCharitableInst) object;
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
        return "org.centrale.hceres.items.ResearchContractFundedPublicCharitableInst[ idActivity=" + idActivity + " ]";
    }
    
}
