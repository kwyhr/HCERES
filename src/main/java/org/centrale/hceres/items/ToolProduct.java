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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "tool_product")
@NamedQueries({
    @NamedQuery(name = "ToolProduct.findAll", query = "SELECT t FROM ToolProduct t"),
    @NamedQuery(name = "ToolProduct.findByIdActivity", query = "SELECT t FROM ToolProduct t WHERE t.idActivity = :idActivity"),
    @NamedQuery(name = "ToolProduct.findByToolProductNam", query = "SELECT t FROM ToolProduct t WHERE t.toolProductNam = :toolProductNam"),
    @NamedQuery(name = "ToolProduct.findByToolProductCreation", query = "SELECT t FROM ToolProduct t WHERE t.toolProductCreation = :toolProductCreation"),
    @NamedQuery(name = "ToolProduct.findByToolProductAuthors", query = "SELECT t FROM ToolProduct t WHERE t.toolProductAuthors = :toolProductAuthors"),
    @NamedQuery(name = "ToolProduct.findByToolProductDescription", query = "SELECT t FROM ToolProduct t WHERE t.toolProductDescription = :toolProductDescription")})
public class ToolProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_activity")
    private Integer idActivity;
    @Size(max = 256)
    @Column(name = "tool_product_nam")
    private String toolProductNam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tool_product_creation")
    @Temporal(TemporalType.DATE)
    private Date toolProductCreation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tool_product_authors")
    private String toolProductAuthors;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tool_product_description")
    private String toolProductDescription;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Activity activity;
    @JoinColumn(name = "tool_product_type_id", referencedColumnName = "tool_product_type_id")
    @ManyToOne(optional = false)
    private ToolProductType toolProductTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toolProduct")
    private Collection<ToolProductInvolvment> toolProductInvolvmentCollection;

    /**
     *
     */
    public ToolProduct() {
    }

    /**
     *
     * @param idActivity
     */
    public ToolProduct(Integer idActivity) {
        this.idActivity = idActivity;
    }

    /**
     *
     * @param idActivity
     * @param toolProductCreation
     * @param toolProductAuthors
     * @param toolProductDescription
     */
    public ToolProduct(Integer idActivity, Date toolProductCreation, String toolProductAuthors, String toolProductDescription) {
        this.idActivity = idActivity;
        this.toolProductCreation = toolProductCreation;
        this.toolProductAuthors = toolProductAuthors;
        this.toolProductDescription = toolProductDescription;
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
    public String getToolProductNam() {
        return toolProductNam;
    }

    /**
     *
     * @param toolProductNam
     */
    public void setToolProductNam(String toolProductNam) {
        this.toolProductNam = toolProductNam;
    }

    /**
     *
     * @return
     */
    public Date getToolProductCreation() {
        return toolProductCreation;
    }

    /**
     *
     * @param toolProductCreation
     */
    public void setToolProductCreation(Date toolProductCreation) {
        this.toolProductCreation = toolProductCreation;
    }

    /**
     *
     * @return
     */
    public String getToolProductAuthors() {
        return toolProductAuthors;
    }

    /**
     *
     * @param toolProductAuthors
     */
    public void setToolProductAuthors(String toolProductAuthors) {
        this.toolProductAuthors = toolProductAuthors;
    }

    /**
     *
     * @return
     */
    public String getToolProductDescription() {
        return toolProductDescription;
    }

    /**
     *
     * @param toolProductDescription
     */
    public void setToolProductDescription(String toolProductDescription) {
        this.toolProductDescription = toolProductDescription;
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
    public ToolProductType getToolProductTypeId() {
        return toolProductTypeId;
    }

    /**
     *
     * @param toolProductTypeId
     */
    public void setToolProductTypeId(ToolProductType toolProductTypeId) {
        this.toolProductTypeId = toolProductTypeId;
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
        if (!(object instanceof ToolProduct)) {
            return false;
        }
        ToolProduct other = (ToolProduct) object;
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
        return "org.centrale.hceres.items.ToolProduct[ idActivity=" + idActivity + " ]";
    }
    
}
