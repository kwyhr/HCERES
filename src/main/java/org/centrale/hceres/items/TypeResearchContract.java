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
@Table(name = "type_research_contract")
@NamedQueries({
    @NamedQuery(name = "TypeResearchContract.findAll", query = "SELECT t FROM TypeResearchContract t"),
    @NamedQuery(name = "TypeResearchContract.findByIdType", query = "SELECT t FROM TypeResearchContract t WHERE t.idType = :idType"),
    @NamedQuery(name = "TypeResearchContract.findByNameChoice", query = "SELECT t FROM TypeResearchContract t WHERE t.nameChoice = :nameChoice")})
public class TypeResearchContract implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_type")
    private Integer idType;
    @Size(max = 256)
    @Column(name = "name_choice")
    private String nameChoice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idType")
    private Collection<ResearchContractFundedPublicCharitableInst> researchContractFundedPublicCharitableInstCollection;

    /**
     *
     */
    public TypeResearchContract() {
    }

    /**
     *
     * @param idType
     */
    public TypeResearchContract(Integer idType) {
        this.idType = idType;
    }

    /**
     *
     * @return
     */
    public Integer getIdType() {
        return idType;
    }

    /**
     *
     * @param idType
     */
    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    /**
     *
     * @return
     */
    public String getNameChoice() {
        return nameChoice;
    }

    /**
     *
     * @param nameChoice
     */
    public void setNameChoice(String nameChoice) {
        this.nameChoice = nameChoice;
    }

    /**
     *
     * @return
     */
    public Collection<ResearchContractFundedPublicCharitableInst> getResearchContractFundedPublicCharitableInstCollection() {
        return researchContractFundedPublicCharitableInstCollection;
    }

    /**
     *
     * @param researchContractFundedPublicCharitableInstCollection
     */
    public void setResearchContractFundedPublicCharitableInstCollection(Collection<ResearchContractFundedPublicCharitableInst> researchContractFundedPublicCharitableInstCollection) {
        this.researchContractFundedPublicCharitableInstCollection = researchContractFundedPublicCharitableInstCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idType != null ? idType.hashCode() : 0);
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
        if (!(object instanceof TypeResearchContract)) {
            return false;
        }
        TypeResearchContract other = (TypeResearchContract) object;
        if ((this.idType == null && other.idType != null) || (this.idType != null && !this.idType.equals(other.idType))) {
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
        return "org.centrale.hceres.items.TypeResearchContract[ idType=" + idType + " ]";
    }
    
}
