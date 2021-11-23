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
@Table(name = "post_doc")
@NamedQueries({
    @NamedQuery(name = "PostDoc.findAll", query = "SELECT p FROM PostDoc p"),
    @NamedQuery(name = "PostDoc.findByIdActivity", query = "SELECT p FROM PostDoc p WHERE p.idActivity = :idActivity"),
    @NamedQuery(name = "PostDoc.findByNamePostDoc", query = "SELECT p FROM PostDoc p WHERE p.namePostDoc = :namePostDoc"),
    @NamedQuery(name = "PostDoc.findByNameSupervisor", query = "SELECT p FROM PostDoc p WHERE p.nameSupervisor = :nameSupervisor"),
    @NamedQuery(name = "PostDoc.findByArrivalDate", query = "SELECT p FROM PostDoc p WHERE p.arrivalDate = :arrivalDate"),
    @NamedQuery(name = "PostDoc.findByDepartureDate", query = "SELECT p FROM PostDoc p WHERE p.departureDate = :departureDate"),
    @NamedQuery(name = "PostDoc.findByDuration", query = "SELECT p FROM PostDoc p WHERE p.duration = :duration"),
    @NamedQuery(name = "PostDoc.findByNationality", query = "SELECT p FROM PostDoc p WHERE p.nationality = :nationality"),
    @NamedQuery(name = "PostDoc.findByOriginalLab", query = "SELECT p FROM PostDoc p WHERE p.originalLab = :originalLab"),
    @NamedQuery(name = "PostDoc.findByAssociatedFunding", query = "SELECT p FROM PostDoc p WHERE p.associatedFunding = :associatedFunding"),
    @NamedQuery(name = "PostDoc.findByAssociatedPubliRef", query = "SELECT p FROM PostDoc p WHERE p.associatedPubliRef = :associatedPubliRef")})
public class PostDoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Size(max = 256)
    @Column(name = "name_post_doc")
    private String namePostDoc;
    @Size(max = 256)
    @Column(name = "name_supervisor")
    private String nameSupervisor;
    @Column(name = "arrival_date")
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;
    @Column(name = "departure_date")
    @Temporal(TemporalType.DATE)
    private Date departureDate;
    @Column(name = "duration")
    private Integer duration;
    @Size(max = 256)
    @Column(name = "nationality")
    private String nationality;
    @Size(max = 256)
    @Column(name = "original_lab")
    private String originalLab;
    @Size(max = 256)
    @Column(name = "associated_funding")
    private String associatedFunding;
    @Size(max = 256)
    @Column(name = "associated_publi_ref")
    private String associatedPubliRef;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;

    /**
     *
     */
    public PostDoc() {
    }

    /**
     *
     * @param idActivity
     */
    public PostDoc(Integer idActivity) {
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
    public String getNamePostDoc() {
        return namePostDoc;
    }

    /**
     *
     * @param namePostDoc
     */
    public void setNamePostDoc(String namePostDoc) {
        this.namePostDoc = namePostDoc;
    }

    /**
     *
     * @return
     */
    public String getNameSupervisor() {
        return nameSupervisor;
    }

    /**
     *
     * @param nameSupervisor
     */
    public void setNameSupervisor(String nameSupervisor) {
        this.nameSupervisor = nameSupervisor;
    }

    /**
     *
     * @return
     */
    public Date getArrivalDate() {
        return arrivalDate;
    }

    /**
     *
     * @param arrivalDate
     */
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     *
     * @return
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     *
     * @param departureDate
     */
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    /**
     *
     * @return
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     *
     * @param duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     *
     * @return
     */
    public String getNationality() {
        return nationality;
    }

    /**
     *
     * @param nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     *
     * @return
     */
    public String getOriginalLab() {
        return originalLab;
    }

    /**
     *
     * @param originalLab
     */
    public void setOriginalLab(String originalLab) {
        this.originalLab = originalLab;
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
    public String getAssociatedPubliRef() {
        return associatedPubliRef;
    }

    /**
     *
     * @param associatedPubliRef
     */
    public void setAssociatedPubliRef(String associatedPubliRef) {
        this.associatedPubliRef = associatedPubliRef;
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
        if (!(object instanceof PostDoc)) {
            return false;
        }
        PostDoc other = (PostDoc) object;
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
        return "org.centrale.hceres.items.PostDoc[ idActivity=" + idActivity + " ]";
    }
    
}
