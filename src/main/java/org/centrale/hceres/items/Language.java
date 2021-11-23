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
@Table(name = "language")
@NamedQueries({
    @NamedQuery(name = "Language.findAll", query = "SELECT l FROM Language l"),
    @NamedQuery(name = "Language.findByLanguageId", query = "SELECT l FROM Language l WHERE l.languageId = :languageId"),
    @NamedQuery(name = "Language.findByLanguageName", query = "SELECT l FROM Language l WHERE l.languageName = :languageName")})
public class Language implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "language_id")
    private Integer languageId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "language_name")
    private String languageName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languageId")
    private Collection<Book> bookCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languageId")
    private Collection<BookChapter> bookChapterCollection;

    /**
     *
     */
    public Language() {
    }

    /**
     *
     * @param languageId
     */
    public Language(Integer languageId) {
        this.languageId = languageId;
    }

    /**
     *
     * @param languageId
     * @param languageName
     */
    public Language(Integer languageId, String languageName) {
        this.languageId = languageId;
        this.languageName = languageName;
    }

    /**
     *
     * @return
     */
    public Integer getLanguageId() {
        return languageId;
    }

    /**
     *
     * @param languageId
     */
    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    /**
     *
     * @return
     */
    public String getLanguageName() {
        return languageName;
    }

    /**
     *
     * @param languageName
     */
    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    /**
     *
     * @return
     */
    public Collection<Book> getBookCollection() {
        return bookCollection;
    }

    /**
     *
     * @param bookCollection
     */
    public void setBookCollection(Collection<Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    /**
     *
     * @return
     */
    public Collection<BookChapter> getBookChapterCollection() {
        return bookChapterCollection;
    }

    /**
     *
     * @param bookChapterCollection
     */
    public void setBookChapterCollection(Collection<BookChapter> bookChapterCollection) {
        this.bookChapterCollection = bookChapterCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (languageId != null ? languageId.hashCode() : 0);
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
        if (!(object instanceof Language)) {
            return false;
        }
        Language other = (Language) object;
        if ((this.languageId == null && other.languageId != null) || (this.languageId != null && !this.languageId.equals(other.languageId))) {
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
        return "org.centrale.hceres.items.Language[ languageId=" + languageId + " ]";
    }
    
}
