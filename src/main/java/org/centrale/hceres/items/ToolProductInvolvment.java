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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "tool_product_involvment")
@NamedQueries({
    @NamedQuery(name = "ToolProductInvolvment.findAll", query = "SELECT t FROM ToolProductInvolvment t"),
    @NamedQuery(name = "ToolProductInvolvment.findByIdActivity", query = "SELECT t FROM ToolProductInvolvment t WHERE t.toolProductInvolvmentPK.idActivity = :idActivity"),
    @NamedQuery(name = "ToolProductInvolvment.findByToolProductRoleId", query = "SELECT t FROM ToolProductInvolvment t WHERE t.toolProductInvolvmentPK.toolProductRoleId = :toolProductRoleId"),
    @NamedQuery(name = "ToolProductInvolvment.findByToolProductInvolvmentResearchers", query = "SELECT t FROM ToolProductInvolvment t WHERE t.toolProductInvolvmentResearchers = :toolProductInvolvmentResearchers")})
public class ToolProductInvolvment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @EmbeddedId
    protected ToolProductInvolvmentPK toolProductInvolvmentPK;
    @Size(max = 2147483647)
    @Column(name = "tool_product_involvment_researchers")
    private String toolProductInvolvmentResearchers;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ToolProduct toolProduct;
    @JoinColumn(name = "tool_product_role_id", referencedColumnName = "tool_product_role_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ToolProductRole toolProductRole;

    /**
     *
     */
    public ToolProductInvolvment() {
    }

    /**
     *
     * @param toolProductInvolvmentPK
     */
    public ToolProductInvolvment(ToolProductInvolvmentPK toolProductInvolvmentPK) {
        this.toolProductInvolvmentPK = toolProductInvolvmentPK;
    }

    /**
     *
     * @param idActivity
     * @param toolProductRoleId
     */
    public ToolProductInvolvment(int idActivity, int toolProductRoleId) {
        this.toolProductInvolvmentPK = new ToolProductInvolvmentPK(idActivity, toolProductRoleId);
    }

    /**
     *
     * @return
     */
    public ToolProductInvolvmentPK getToolProductInvolvmentPK() {
        return toolProductInvolvmentPK;
    }

    /**
     *
     * @param toolProductInvolvmentPK
     */
    public void setToolProductInvolvmentPK(ToolProductInvolvmentPK toolProductInvolvmentPK) {
        this.toolProductInvolvmentPK = toolProductInvolvmentPK;
    }

    /**
     *
     * @return
     */
    public String getToolProductInvolvmentResearchers() {
        return toolProductInvolvmentResearchers;
    }

    /**
     *
     * @param toolProductInvolvmentResearchers
     */
    public void setToolProductInvolvmentResearchers(String toolProductInvolvmentResearchers) {
        this.toolProductInvolvmentResearchers = toolProductInvolvmentResearchers;
    }

    /**
     *
     * @return
     */
    public ToolProduct getToolProduct() {
        return toolProduct;
    }

    /**
     *
     * @param toolProduct
     */
    public void setToolProduct(ToolProduct toolProduct) {
        this.toolProduct = toolProduct;
    }

    /**
     *
     * @return
     */
    public ToolProductRole getToolProductRole() {
        return toolProductRole;
    }

    /**
     *
     * @param toolProductRole
     */
    public void setToolProductRole(ToolProductRole toolProductRole) {
        this.toolProductRole = toolProductRole;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (toolProductInvolvmentPK != null ? toolProductInvolvmentPK.hashCode() : 0);
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
        if (!(object instanceof ToolProductInvolvment)) {
            return false;
        }
        ToolProductInvolvment other = (ToolProductInvolvment) object;
        if ((this.toolProductInvolvmentPK == null && other.toolProductInvolvmentPK != null) || (this.toolProductInvolvmentPK != null && !this.toolProductInvolvmentPK.equals(other.toolProductInvolvmentPK))) {
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
        return "org.centrale.hceres.items.ToolProductInvolvment[ toolProductInvolvmentPK=" + toolProductInvolvmentPK + " ]";
    }
    
}
