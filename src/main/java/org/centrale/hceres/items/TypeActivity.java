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
import javax.validation.constraints.Size;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "type_activity")
@NamedQueries({
    @NamedQuery(name = "TypeActivity.findAll", query = "SELECT t FROM TypeActivity t"),
    @NamedQuery(name = "TypeActivity.findByIdTypeActivity", query = "SELECT t FROM TypeActivity t WHERE t.idTypeActivity = :idTypeActivity"),
    @NamedQuery(name = "TypeActivity.findByNameType", query = "SELECT t FROM TypeActivity t WHERE t.nameType = :nameType")})
public class TypeActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_type_activity")
    private Integer idTypeActivity;
    @Size(max = 256)
    @Column(name = "name_type")
    private String nameType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypeActivity")
    private Collection<Activity> activityCollection;

    /**
     *
     */
    public TypeActivity() {
    }

    /**
     *
     * @param idTypeActivity
     */
    public TypeActivity(Integer idTypeActivity) {
        this.idTypeActivity = idTypeActivity;
    }

    /**
     *
     * @return
     */
    public Integer getIdTypeActivity() {
        return idTypeActivity;
    }

    /**
     *
     * @param idTypeActivity
     */
    public void setIdTypeActivity(Integer idTypeActivity) {
        this.idTypeActivity = idTypeActivity;
    }

    /**
     *
     * @return
     */
    public String getNameType() {
        return nameType;
    }

    /**
     *
     * @param nameType
     */
    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    /**
     *
     * @return
     */
    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    /**
     *
     * @param activityCollection
     */
    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeActivity != null ? idTypeActivity.hashCode() : 0);
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
        if (!(object instanceof TypeActivity)) {
            return false;
        }
        TypeActivity other = (TypeActivity) object;
        if ((this.idTypeActivity == null && other.idTypeActivity != null) || (this.idTypeActivity != null && !this.idTypeActivity.equals(other.idTypeActivity))) {
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
        return "org.centrale.hceres.items.TypeActivity[ idTypeActivity=" + idTypeActivity + " ]";
    }
    
}
