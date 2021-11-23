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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kwyhr
 */
@Embeddable
public class ToolProductInvolvmentPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private int idActivity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tool_product_role_id")
    private int toolProductRoleId;

    /**
     *
     */
    public ToolProductInvolvmentPK() {
    }

    /**
     *
     * @param idActivity
     * @param toolProductRoleId
     */
    public ToolProductInvolvmentPK(int idActivity, int toolProductRoleId) {
        this.idActivity = idActivity;
        this.toolProductRoleId = toolProductRoleId;
    }

    /**
     *
     * @return
     */
    public int getIdActivity() {
        return idActivity;
    }

    /**
     *
     * @param idActivity
     */
    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
    }

    /**
     *
     * @return
     */
    public int getToolProductRoleId() {
        return toolProductRoleId;
    }

    /**
     *
     * @param toolProductRoleId
     */
    public void setToolProductRoleId(int toolProductRoleId) {
        this.toolProductRoleId = toolProductRoleId;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idActivity;
        hash += (int) toolProductRoleId;
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
        if (!(object instanceof ToolProductInvolvmentPK)) {
            return false;
        }
        ToolProductInvolvmentPK other = (ToolProductInvolvmentPK) object;
        if (this.idActivity != other.idActivity) {
            return false;
        }
        if (this.toolProductRoleId != other.toolProductRoleId) {
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
        return "org.centrale.hceres.items.ToolProductInvolvmentPK[ idActivity=" + idActivity + ", toolProductRoleId=" + toolProductRoleId + " ]";
    }
    
}
