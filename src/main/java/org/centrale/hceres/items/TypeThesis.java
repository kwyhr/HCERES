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
@Table(name = "type_thesis")
@NamedQueries({
    @NamedQuery(name = "TypeThesis.findAll", query = "SELECT t FROM TypeThesis t"),
    @NamedQuery(name = "TypeThesis.findByTypeThesisId", query = "SELECT t FROM TypeThesis t WHERE t.typeThesisId = :typeThesisId"),
    @NamedQuery(name = "TypeThesis.findByTypeThesisName", query = "SELECT t FROM TypeThesis t WHERE t.typeThesisName = :typeThesisName")})
public class TypeThesis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "type_thesis_id")
    private Integer typeThesisId;
    @Size(max = 256)
    @Column(name = "type_thesis_name")
    private String typeThesisName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeThesisId")
    private Collection<EvaluationThesis> evaluationThesisCollection;

    /**
     *
     */
    public TypeThesis() {
    }

    /**
     *
     * @param typeThesisId
     */
    public TypeThesis(Integer typeThesisId) {
        this.typeThesisId = typeThesisId;
    }

    /**
     *
     * @return
     */
    public Integer getTypeThesisId() {
        return typeThesisId;
    }

    /**
     *
     * @param typeThesisId
     */
    public void setTypeThesisId(Integer typeThesisId) {
        this.typeThesisId = typeThesisId;
    }

    /**
     *
     * @return
     */
    public String getTypeThesisName() {
        return typeThesisName;
    }

    /**
     *
     * @param typeThesisName
     */
    public void setTypeThesisName(String typeThesisName) {
        this.typeThesisName = typeThesisName;
    }

    /**
     *
     * @return
     */
    public Collection<EvaluationThesis> getEvaluationThesisCollection() {
        return evaluationThesisCollection;
    }

    /**
     *
     * @param evaluationThesisCollection
     */
    public void setEvaluationThesisCollection(Collection<EvaluationThesis> evaluationThesisCollection) {
        this.evaluationThesisCollection = evaluationThesisCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeThesisId != null ? typeThesisId.hashCode() : 0);
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
        if (!(object instanceof TypeThesis)) {
            return false;
        }
        TypeThesis other = (TypeThesis) object;
        if ((this.typeThesisId == null && other.typeThesisId != null) || (this.typeThesisId != null && !this.typeThesisId.equals(other.typeThesisId))) {
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
        return "org.centrale.hceres.items.TypeThesis[ typeThesisId=" + typeThesisId + " ]";
    }
    
}
