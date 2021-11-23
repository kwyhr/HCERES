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
@Table(name = "book_chapter")
@NamedQueries({
    @NamedQuery(name = "BookChapter.findAll", query = "SELECT b FROM BookChapter b"),
    @NamedQuery(name = "BookChapter.findByIdActivity", query = "SELECT b FROM BookChapter b WHERE b.idActivity = :idActivity"),
    @NamedQuery(name = "BookChapter.findByPublicationDate", query = "SELECT b FROM BookChapter b WHERE b.publicationDate = :publicationDate"),
    @NamedQuery(name = "BookChapter.findByBookTitle", query = "SELECT b FROM BookChapter b WHERE b.bookTitle = :bookTitle"),
    @NamedQuery(name = "BookChapter.findByChapterTitle", query = "SELECT b FROM BookChapter b WHERE b.chapterTitle = :chapterTitle"),
    @NamedQuery(name = "BookChapter.findByEditor", query = "SELECT b FROM BookChapter b WHERE b.editor = :editor"),
    @NamedQuery(name = "BookChapter.findByNbPage", query = "SELECT b FROM BookChapter b WHERE b.nbPage = :nbPage"),
    @NamedQuery(name = "BookChapter.findByAuthors", query = "SELECT b FROM BookChapter b WHERE b.authors = :authors"),
    @NamedQuery(name = "BookChapter.findByAdditionalInfo", query = "SELECT b FROM BookChapter b WHERE b.additionalInfo = :additionalInfo")})
public class BookChapter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Column(name = "publication_date")
    @Temporal(TemporalType.DATE)
    private Date publicationDate;
    @Size(max = 256)
    @Column(name = "book_title")
    private String bookTitle;
    @Size(max = 256)
    @Column(name = "chapter_title")
    private String chapterTitle;
    @Size(max = 256)
    @Column(name = "editor")
    private String editor;
    @Column(name = "nb_page")
    private Integer nbPage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "authors")
    private String authors;
    @Size(max = 2147483647)
    @Column(name = "additional_info")
    private String additionalInfo;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;
    @JoinColumn(name = "language_id", referencedColumnName = "language_id")
    @ManyToOne(optional = false)
    private Language languageId;

    /**
     *
     */
    public BookChapter() {
    }

    /**
     *
     * @param idActivity
     */
    public BookChapter(Integer idActivity) {
        this.idActivity = idActivity;
    }

    /**
     *
     * @param idActivity
     * @param authors
     */
    public BookChapter(Integer idActivity, String authors) {
        this.idActivity = idActivity;
        this.authors = authors;
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
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     *
     * @param bookTitle
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     *
     * @return
     */
    public String getChapterTitle() {
        return chapterTitle;
    }

    /**
     *
     * @param chapterTitle
     */
    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    /**
     *
     * @return
     */
    public String getEditor() {
        return editor;
    }

    /**
     *
     * @param editor
     */
    public void setEditor(String editor) {
        this.editor = editor;
    }

    /**
     *
     * @return
     */
    public Integer getNbPage() {
        return nbPage;
    }

    /**
     *
     * @param nbPage
     */
    public void setNbPage(Integer nbPage) {
        this.nbPage = nbPage;
    }

    /**
     *
     * @return
     */
    public String getAuthors() {
        return authors;
    }

    /**
     *
     * @param authors
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }

    /**
     *
     * @return
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     *
     * @param additionalInfo
     */
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
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
    public Language getLanguageId() {
        return languageId;
    }

    /**
     *
     * @param languageId
     */
    public void setLanguageId(Language languageId) {
        this.languageId = languageId;
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
        if (!(object instanceof BookChapter)) {
            return false;
        }
        BookChapter other = (BookChapter) object;
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
        return "org.centrale.hceres.items.BookChapter[ idActivity=" + idActivity + " ]";
    }
    
}
