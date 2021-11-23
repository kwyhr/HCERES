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
@Table(name = "function_editorial_activity")
@NamedQueries({
    @NamedQuery(name = "FunctionEditorialActivity.findAll", query = "SELECT f FROM FunctionEditorialActivity f"),
    @NamedQuery(name = "FunctionEditorialActivity.findByFunctionEditorialActivityId", query = "SELECT f FROM FunctionEditorialActivity f WHERE f.functionEditorialActivityId = :functionEditorialActivityId"),
    @NamedQuery(name = "FunctionEditorialActivity.findByFunctionEditorialActivityName", query = "SELECT f FROM FunctionEditorialActivity f WHERE f.functionEditorialActivityName = :functionEditorialActivityName")})
public class FunctionEditorialActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "function_editorial_activity_id")
    private Integer functionEditorialActivityId;
    @Size(max = 256)
    @Column(name = "function_editorial_activity_name")
    private String functionEditorialActivityName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "functionEditorialActivityId")
    private Collection<EditorialActivity> editorialActivityCollection;

    /**
     *
     */
    public FunctionEditorialActivity() {
    }

    /**
     *
     * @param functionEditorialActivityId
     */
    public FunctionEditorialActivity(Integer functionEditorialActivityId) {
        this.functionEditorialActivityId = functionEditorialActivityId;
    }

    /**
     *
     * @return
     */
    public Integer getFunctionEditorialActivityId() {
        return functionEditorialActivityId;
    }

    /**
     *
     * @param functionEditorialActivityId
     */
    public void setFunctionEditorialActivityId(Integer functionEditorialActivityId) {
        this.functionEditorialActivityId = functionEditorialActivityId;
    }

    /**
     *
     * @return
     */
    public String getFunctionEditorialActivityName() {
        return functionEditorialActivityName;
    }

    /**
     *
     * @param functionEditorialActivityName
     */
    public void setFunctionEditorialActivityName(String functionEditorialActivityName) {
        this.functionEditorialActivityName = functionEditorialActivityName;
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
        hash += (functionEditorialActivityId != null ? functionEditorialActivityId.hashCode() : 0);
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
        if (!(object instanceof FunctionEditorialActivity)) {
            return false;
        }
        FunctionEditorialActivity other = (FunctionEditorialActivity) object;
        if ((this.functionEditorialActivityId == null && other.functionEditorialActivityId != null) || (this.functionEditorialActivityId != null && !this.functionEditorialActivityId.equals(other.functionEditorialActivityId))) {
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
        return "org.centrale.hceres.items.FunctionEditorialActivity[ functionEditorialActivityId=" + functionEditorialActivityId + " ]";
    }
    
}
