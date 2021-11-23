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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "journal")
@NamedQueries({
    @NamedQuery(name = "Journal.findAll", query = "SELECT j FROM Journal j"),
    @NamedQuery(name = "Journal.findByJournalId", query = "SELECT j FROM Journal j WHERE j.journalId = :journalId"),
    @NamedQuery(name = "Journal.findByJournalName", query = "SELECT j FROM Journal j WHERE j.journalName = :journalName")})
public class Journal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "journal_id")
    private Integer journalId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "journal_name")
    private String journalName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "journalId")
    private Collection<ReviewingJournalArticles> reviewingJournalArticlesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "journalId")
    private Collection<EditorialActivity> editorialActivityCollection;

    /**
     *
     */
    public Journal() {
    }

    /**
     *
     * @param journalId
     */
    public Journal(Integer journalId) {
        this.journalId = journalId;
    }

    /**
     *
     * @param journalId
     * @param journalName
     */
    public Journal(Integer journalId, String journalName) {
        this.journalId = journalId;
        this.journalName = journalName;
    }

    /**
     *
     * @return
     */
    public Integer getJournalId() {
        return journalId;
    }

    /**
     *
     * @param journalId
     */
    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }

    /**
     *
     * @return
     */
    public String getJournalName() {
        return journalName;
    }

    /**
     *
     * @param journalName
     */
    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    /**
     *
     * @return
     */
    public Collection<ReviewingJournalArticles> getReviewingJournalArticlesCollection() {
        return reviewingJournalArticlesCollection;
    }

    /**
     *
     * @param reviewingJournalArticlesCollection
     */
    public void setReviewingJournalArticlesCollection(Collection<ReviewingJournalArticles> reviewingJournalArticlesCollection) {
        this.reviewingJournalArticlesCollection = reviewingJournalArticlesCollection;
    }

    /**
     *
     * @return
     */
    public Collection<EditorialActivity> getEditorialActivityCollection() {
        return editorialActivityCollection;
    }

    /**
     *
     * @param editorialActivityCollection
     */
    public void setEditorialActivityCollection(Collection<EditorialActivity> editorialActivityCollection) {
        this.editorialActivityCollection = editorialActivityCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (journalId != null ? journalId.hashCode() : 0);
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
        if (!(object instanceof Journal)) {
            return false;
        }
        Journal other = (Journal) object;
        if ((this.journalId == null && other.journalId != null) || (this.journalId != null && !this.journalId.equals(other.journalId))) {
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
        return "org.centrale.hceres.items.Journal[ journalId=" + journalId + " ]";
    }
    
}
