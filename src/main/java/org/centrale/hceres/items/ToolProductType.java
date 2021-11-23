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
@Table(name = "tool_product_type")
@NamedQueries({
    @NamedQuery(name = "ToolProductType.findAll", query = "SELECT t FROM ToolProductType t"),
    @NamedQuery(name = "ToolProductType.findByToolProductTypeId", query = "SELECT t FROM ToolProductType t WHERE t.toolProductTypeId = :toolProductTypeId"),
    @NamedQuery(name = "ToolProductType.findByToolProductTypeName", query = "SELECT t FROM ToolProductType t WHERE t.toolProductTypeName = :toolProductTypeName")})
public class ToolProductType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tool_product_type_id")
    private Integer toolProductTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "tool_product_type_name")
    private String toolProductTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toolProductTypeId")
    private Collection<ToolProduct> toolProductCollection;

    /**
     *
     */
    public ToolProductType() {
    }

    /**
     *
     * @param toolProductTypeId
     */
    public ToolProductType(Integer toolProductTypeId) {
        this.toolProductTypeId = toolProductTypeId;
    }

    /**
     *
     * @param toolProductTypeId
     * @param toolProductTypeName
     */
    public ToolProductType(Integer toolProductTypeId, String toolProductTypeName) {
        this.toolProductTypeId = toolProductTypeId;
        this.toolProductTypeName = toolProductTypeName;
    }

    /**
     *
     * @return
     */
    public Integer getToolProductTypeId() {
        return toolProductTypeId;
    }

    /**
     *
     * @param toolProductTypeId
     */
    public void setToolProductTypeId(Integer toolProductTypeId) {
        this.toolProductTypeId = toolProductTypeId;
    }

    /**
     *
     * @return
     */
    public String getToolProductTypeName() {
        return toolProductTypeName;
    }

    /**
     *
     * @param toolProductTypeName
     */
    public void setToolProductTypeName(String toolProductTypeName) {
        this.toolProductTypeName = toolProductTypeName;
    }

    /**
     *
     * @return
     */
    public Collection<ToolProduct> getToolProductCollection() {
        return toolProductCollection;
    }

    /**
     *
     * @param toolProductCollection
     */
    public void setToolProductCollection(Collection<ToolProduct> toolProductCollection) {
        this.toolProductCollection = toolProductCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (toolProductTypeId != null ? toolProductTypeId.hashCode() : 0);
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
        if (!(object instanceof ToolProductType)) {
            return false;
        }
        ToolProductType other = (ToolProductType) object;
        if ((this.toolProductTypeId == null && other.toolProductTypeId != null) || (this.toolProductTypeId != null && !this.toolProductTypeId.equals(other.toolProductTypeId))) {
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
        return "org.centrale.hceres.items.ToolProductType[ toolProductTypeId=" + toolProductTypeId + " ]";
    }
    
}
