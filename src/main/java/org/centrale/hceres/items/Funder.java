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
@Table(name = "funder")
@NamedQueries({
    @NamedQuery(name = "Funder.findAll", query = "SELECT f FROM Funder f"),
    @NamedQuery(name = "Funder.findByFunderId", query = "SELECT f FROM Funder f WHERE f.funderId = :funderId"),
    @NamedQuery(name = "Funder.findByFunderName", query = "SELECT f FROM Funder f WHERE f.funderName = :funderName")})
public class Funder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 2147483647)
    @Column(name = "funder_id")
    private String funderId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "funder_name")
    private String funderName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funderId")
    private Collection<ProjectEvaluation> projectEvaluationCollection;

    /**
     *
     */
    public Funder() {
    }

    /**
     *
     * @param funderId
     */
    public Funder(String funderId) {
        this.funderId = funderId;
    }

    /**
     *
     * @param funderId
     * @param funderName
     */
    public Funder(String funderId, String funderName) {
        this.funderId = funderId;
        this.funderName = funderName;
    }

    /**
     *
     * @return
     */
    public String getFunderId() {
        return funderId;
    }

    /**
     *
     * @param funderId
     */
    public void setFunderId(String funderId) {
        this.funderId = funderId;
    }

    /**
     *
     * @return
     */
    public String getFunderName() {
        return funderName;
    }

    /**
     *
     * @param funderName
     */
    public void setFunderName(String funderName) {
        this.funderName = funderName;
    }

    /**
     *
     * @return
     */
    public Collection<ProjectEvaluation> getProjectEvaluationCollection() {
        return projectEvaluationCollection;
    }

    /**
     *
     * @param projectEvaluationCollection
     */
    public void setProjectEvaluationCollection(Collection<ProjectEvaluation> projectEvaluationCollection) {
        this.projectEvaluationCollection = projectEvaluationCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funderId != null ? funderId.hashCode() : 0);
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
        if (!(object instanceof Funder)) {
            return false;
        }
        Funder other = (Funder) object;
        if ((this.funderId == null && other.funderId != null) || (this.funderId != null && !this.funderId.equals(other.funderId))) {
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
        return "org.centrale.hceres.items.Funder[ funderId=" + funderId + " ]";
    }
    
}
