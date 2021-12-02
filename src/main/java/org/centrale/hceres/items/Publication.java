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
import java.util.HashMap;
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
@Table(name = "publication")
@NamedQueries({
    @NamedQuery(name = "Publication.findAll", query = "SELECT p FROM Publication p"),
    @NamedQuery(name = "Publication.findByIdActivity", query = "SELECT p FROM Publication p WHERE p.idActivity = :idActivity"),
    @NamedQuery(name = "Publication.findByTitle", query = "SELECT p FROM Publication p WHERE p.title = :title"),
    @NamedQuery(name = "Publication.findByAuthors", query = "SELECT p FROM Publication p WHERE p.authors = :authors"),
    @NamedQuery(name = "Publication.findBySource", query = "SELECT p FROM Publication p WHERE p.source = :source"),
    @NamedQuery(name = "Publication.findByPublicationDate", query = "SELECT p FROM Publication p WHERE p.publicationDate = :publicationDate"),
    @NamedQuery(name = "Publication.findByPmid", query = "SELECT p FROM Publication p WHERE p.pmid = :pmid"),
    @NamedQuery(name = "Publication.findByImpactFactor", query = "SELECT p FROM Publication p WHERE p.impactFactor = :impactFactor")})
public class Publication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Size(max = 512)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "authors")
    private String authors;
    @Size(max = 256)
    @Column(name = "source")
    private String source;
    @Column(name = "publication_date")
    @Temporal(TemporalType.DATE)
    private Date publicationDate;
    @Size(max = 16)
    @Column(name = "pmid")
    private String pmid;
    @Column(name = "impact_factor")
    private BigInteger impactFactor;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;
    @JoinColumn(name = "publication_type_id", referencedColumnName = "publication_type_id")
    @ManyToOne(optional = false)
    private PublicationType publicationTypeId;

    /**
     *
     */
    public Publication() {
    }

    /**
     *
     * @param idActivity
     */
    public Publication(Integer idActivity) {
        this.idActivity = idActivity;
    }

    /**
     *
     * @param idActivity
     * @param authors
     */
    public Publication(Integer idActivity, String authors) {
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
    public String getSource() {
        return source;
    }

    /**
     *
     * @param source
     */
    public void setSource(String source) {
        this.source = source;
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
    public String getPmid() {
        return pmid;
    }

    /**
     *
     * @param pmid
     */
    public void setPmid(String pmid) {
        this.pmid = pmid;
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
    public PublicationType getPublicationTypeId() {
        return publicationTypeId;
    }

    /**
     *
     * @param publicationTypeId
     */
    public void setPublicationTypeId(PublicationType publicationTypeId) {
        this.publicationTypeId = publicationTypeId;
    }

    /**
     * 
     * @return 
     */
    public HashMap<String, String> getInfos() {
        HashMap<String, String> returnedValue = new HashMap<String, String>();
        returnedValue.put("title", this.getTitle());
        returnedValue.put("authors", this.getAuthors());
        returnedValue.put("source", this.getSource());
        
        return returnedValue;
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
        if (!(object instanceof Publication)) {
            return false;
        }
        Publication other = (Publication) object;
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
        return "org.centrale.hceres.items.Publication[ idActivity=" + idActivity + " ]";
    }
    
}
