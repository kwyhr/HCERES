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
@Table(name = "tool_product_role")
@NamedQueries({
    @NamedQuery(name = "ToolProductRole.findAll", query = "SELECT t FROM ToolProductRole t"),
    @NamedQuery(name = "ToolProductRole.findByToolProductRoleId", query = "SELECT t FROM ToolProductRole t WHERE t.toolProductRoleId = :toolProductRoleId"),
    @NamedQuery(name = "ToolProductRole.findByToolProductRoleName", query = "SELECT t FROM ToolProductRole t WHERE t.toolProductRoleName = :toolProductRoleName")})
public class ToolProductRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tool_product_role_id")
    private Integer toolProductRoleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "tool_product_role_name")
    private String toolProductRoleName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toolProductRole")
    private Collection<ToolProductInvolvment> toolProductInvolvmentCollection;

    /**
     *
     */
    public ToolProductRole() {
    }

    /**
     *
     * @param toolProductRoleId
     */
    public ToolProductRole(Integer toolProductRoleId) {
        this.toolProductRoleId = toolProductRoleId;
    }

    /**
     *
     * @param toolProductRoleId
     * @param toolProductRoleName
     */
    public ToolProductRole(Integer toolProductRoleId, String toolProductRoleName) {
        this.toolProductRoleId = toolProductRoleId;
        this.toolProductRoleName = toolProductRoleName;
    }

    /**
     *
     * @return
     */
    public Integer getToolProductRoleId() {
        return toolProductRoleId;
    }

    /**
     *
     * @param toolProductRoleId
     */
    public void setToolProductRoleId(Integer toolProductRoleId) {
        this.toolProductRoleId = toolProductRoleId;
    }

    /**
     *
     * @return
     */
    public String getToolProductRoleName() {
        return toolProductRoleName;
    }

    /**
     *
     * @param toolProductRoleName
     */
    public void setToolProductRoleName(String toolProductRoleName) {
        this.toolProductRoleName = toolProductRoleName;
    }

    /**
     *
     * @return
     */
    public Collection<ToolProductInvolvment> getToolProductInvolvmentCollection() {
        return toolProductInvolvmentCollection;
    }

    /**
     *
     * @param toolProductInvolvmentCollection
     */
    public void setToolProductInvolvmentCollection(Collection<ToolProductInvolvment> toolProductInvolvmentCollection) {
        this.toolProductInvolvmentCollection = toolProductInvolvmentCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (toolProductRoleId != null ? toolProductRoleId.hashCode() : 0);
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
        if (!(object instanceof ToolProductRole)) {
            return false;
        }
        ToolProductRole other = (ToolProductRole) object;
        if ((this.toolProductRoleId == null && other.toolProductRoleId != null) || (this.toolProductRoleId != null && !this.toolProductRoleId.equals(other.toolProductRoleId))) {
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
        return "org.centrale.hceres.items.ToolProductRole[ toolProductRoleId=" + toolProductRoleId + " ]";
    }
    
}
