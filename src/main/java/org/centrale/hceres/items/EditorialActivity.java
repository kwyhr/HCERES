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
import java.math.BigInteger;
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

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "editorial_activity")
@NamedQueries({
    @NamedQuery(name = "EditorialActivity.findAll", query = "SELECT e FROM EditorialActivity e"),
    @NamedQuery(name = "EditorialActivity.findByIdActivity", query = "SELECT e FROM EditorialActivity e WHERE e.idActivity = :idActivity"),
    @NamedQuery(name = "EditorialActivity.findByStartDate", query = "SELECT e FROM EditorialActivity e WHERE e.startDate = :startDate"),
    @NamedQuery(name = "EditorialActivity.findByEndDate", query = "SELECT e FROM EditorialActivity e WHERE e.endDate = :endDate"),
    @NamedQuery(name = "EditorialActivity.findByImpactFactor", query = "SELECT e FROM EditorialActivity e WHERE e.impactFactor = :impactFactor")})
public class EditorialActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "impact_factor")
    private BigInteger impactFactor;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;
    @JoinColumn(name = "function_editorial_activity_id", referencedColumnName = "function_editorial_activity_id")
    @ManyToOne(optional = false)
    private FunctionEditorialActivity functionEditorialActivityId;
    @JoinColumn(name = "journal_id", referencedColumnName = "journal_id")
    @ManyToOne(optional = false)
    private Journal journalId;

    /**
     *
     */
    public EditorialActivity() {
    }

    /**
     *
     * @param idActivity
     */
    public EditorialActivity(Integer idActivity) {
        this.idActivity = idActivity;
    }

    /**
     *
     * @param idActivity
     * @param impactFactor
     */
    public EditorialActivity(Integer idActivity, BigInteger impactFactor) {
        this.idActivity = idActivity;
        this.impactFactor = impactFactor;
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
    public BigInteger getImpactFactor() {
        return impactFactor;
    }

    /**
     *
     * @param impactFactor
     */
    public void setImpactFactor(BigInteger impactFactor) {
        this.impactFactor = impactFactor;
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
    public FunctionEditorialActivity getFunctionEditorialActivityId() {
        return functionEditorialActivityId;
    }

    /**
     *
     * @param functionEditorialActivityId
     */
    public void setFunctionEditorialActivityId(FunctionEditorialActivity functionEditorialActivityId) {
        this.functionEditorialActivityId = functionEditorialActivityId;
    }

    /**
     *
     * @return
     */
    public Journal getJournalId() {
        return journalId;
    }

    /**
     *
     * @param journalId
     */
    public void setJournalId(Journal journalId) {
        this.journalId = journalId;
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
        if (!(object instanceof EditorialActivity)) {
            return false;
        }
        EditorialActivity other = (EditorialActivity) object;
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
        return "org.centrale.hceres.items.EditorialActivity[ idActivity=" + idActivity + " ]";
    }
    
}
