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
import javax.validation.constraints.NotNull;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "reviewing_journal_articles")
@NamedQueries({
    @NamedQuery(name = "ReviewingJournalArticles.findAll", query = "SELECT r FROM ReviewingJournalArticles r"),
    @NamedQuery(name = "ReviewingJournalArticles.findByIdActivity", query = "SELECT r FROM ReviewingJournalArticles r WHERE r.idActivity = :idActivity"),
    @NamedQuery(name = "ReviewingJournalArticles.findByYear", query = "SELECT r FROM ReviewingJournalArticles r WHERE r.year = :year"),
    @NamedQuery(name = "ReviewingJournalArticles.findByNbReviewedArticles", query = "SELECT r FROM ReviewingJournalArticles r WHERE r.nbReviewedArticles = :nbReviewedArticles"),
    @NamedQuery(name = "ReviewingJournalArticles.findByImpactFactor", query = "SELECT r FROM ReviewingJournalArticles r WHERE r.impactFactor = :impactFactor")})
public class ReviewingJournalArticles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Column(name = "year")
    private Integer year;
    @Column(name = "nb_reviewed_articles")
    private Integer nbReviewedArticles;
    @Column(name = "impact_factor")
    private BigInteger impactFactor;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;
    @JoinColumn(name = "journal_id", referencedColumnName = "journal_id")
    @ManyToOne(optional = false)
    private Journal journalId;

    /**
     *
     */
    public ReviewingJournalArticles() {
    }

    /**
     *
     * @param idActivity
     */
    public ReviewingJournalArticles(Integer idActivity) {
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
    public Integer getYear() {
        return year;
    }

    /**
     *
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     *
     * @return
     */
    public Integer getNbReviewedArticles() {
        return nbReviewedArticles;
    }

    /**
     *
     * @param nbReviewedArticles
     */
    public void setNbReviewedArticles(Integer nbReviewedArticles) {
        this.nbReviewedArticles = nbReviewedArticles;
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
        if (!(object instanceof ReviewingJournalArticles)) {
            return false;
        }
        ReviewingJournalArticles other = (ReviewingJournalArticles) object;
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
        return "org.centrale.hceres.items.ReviewingJournalArticles[ idActivity=" + idActivity + " ]";
    }
    
}
