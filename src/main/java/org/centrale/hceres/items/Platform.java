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
@Table(name = "platform")
@NamedQueries({
    @NamedQuery(name = "Platform.findAll", query = "SELECT p FROM Platform p"),
    @NamedQuery(name = "Platform.findByIdActivity", query = "SELECT p FROM Platform p WHERE p.idActivity = :idActivity"),
    @NamedQuery(name = "Platform.findByCreationDate", query = "SELECT p FROM Platform p WHERE p.creationDate = :creationDate"),
    @NamedQuery(name = "Platform.findByDescription", query = "SELECT p FROM Platform p WHERE p.description = :description"),
    @NamedQuery(name = "Platform.findByManagers", query = "SELECT p FROM Platform p WHERE p.managers = :managers"),
    @NamedQuery(name = "Platform.findByAffiliation", query = "SELECT p FROM Platform p WHERE p.affiliation = :affiliation"),
    @NamedQuery(name = "Platform.findByLabellisation", query = "SELECT p FROM Platform p WHERE p.labellisation = :labellisation"),
    @NamedQuery(name = "Platform.findByOpenPrivateResearchers", query = "SELECT p FROM Platform p WHERE p.openPrivateResearchers = :openPrivateResearchers")})
public class Platform implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Size(max = 256)
    @Column(name = "description")
    private String description;
    @Size(max = 256)
    @Column(name = "managers")
    private String managers;
    @Size(max = 256)
    @Column(name = "affiliation")
    private String affiliation;
    @Size(max = 256)
    @Column(name = "labellisation")
    private String labellisation;
    @Column(name = "open_private_researchers")
    private Boolean openPrivateResearchers;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;

    /**
     *
     */
    public Platform() {
    }

    /**
     *
     * @param idActivity
     */
    public Platform(Integer idActivity) {
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
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     *
     * @param creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getManagers() {
        return managers;
    }

    /**
     *
     * @param managers
     */
    public void setManagers(String managers) {
        this.managers = managers;
    }

    /**
     *
     * @return
     */
    public String getAffiliation() {
        return affiliation;
    }

    /**
     *
     * @param affiliation
     */
    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    /**
     *
     * @return
     */
    public String getLabellisation() {
        return labellisation;
    }

    /**
     *
     * @param labellisation
     */
    public void setLabellisation(String labellisation) {
        this.labellisation = labellisation;
    }

    /**
     *
     * @return
     */
    public Boolean getOpenPrivateResearchers() {
        return openPrivateResearchers;
    }

    /**
     *
     * @param openPrivateResearchers
     */
    public void setOpenPrivateResearchers(Boolean openPrivateResearchers) {
        this.openPrivateResearchers = openPrivateResearchers;
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
        if (!(object instanceof Platform)) {
            return false;
        }
        Platform other = (Platform) object;
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
        return "org.centrale.hceres.items.Platform[ idActivity=" + idActivity + " ]";
    }
    
}
