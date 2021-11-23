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
@Table(name = "contract_type")
@NamedQueries({
    @NamedQuery(name = "ContractType.findAll", query = "SELECT c FROM ContractType c"),
    @NamedQuery(name = "ContractType.findByIdContractType", query = "SELECT c FROM ContractType c WHERE c.idContractType = :idContractType"),
    @NamedQuery(name = "ContractType.findByNameContractType", query = "SELECT c FROM ContractType c WHERE c.nameContractType = :nameContractType")})
public class ContractType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contract_type")
    private Integer idContractType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "name_contract_type")
    private String nameContractType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContractType")
    private Collection<Contract> contractCollection;

    /**
     *
     */
    public ContractType() {
    }

    /**
     *
     * @param idContractType
     */
    public ContractType(Integer idContractType) {
        this.idContractType = idContractType;
    }

    /**
     *
     * @param idContractType
     * @param nameContractType
     */
    public ContractType(Integer idContractType, String nameContractType) {
        this.idContractType = idContractType;
        this.nameContractType = nameContractType;
    }

    /**
     *
     * @return
     */
    public Integer getIdContractType() {
        return idContractType;
    }

    /**
     *
     * @param idContractType
     */
    public void setIdContractType(Integer idContractType) {
        this.idContractType = idContractType;
    }

    /**
     *
     * @return
     */
    public String getNameContractType() {
        return nameContractType;
    }

    /**
     *
     * @param nameContractType
     */
    public void setNameContractType(String nameContractType) {
        this.nameContractType = nameContractType;
    }

    /**
     *
     * @return
     */
    public Collection<Contract> getContractCollection() {
        return contractCollection;
    }

    /**
     *
     * @param contractCollection
     */
    public void setContractCollection(Collection<Contract> contractCollection) {
        this.contractCollection = contractCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContractType != null ? idContractType.hashCode() : 0);
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
        if (!(object instanceof ContractType)) {
            return false;
        }
        ContractType other = (ContractType) object;
        if ((this.idContractType == null && other.idContractType != null) || (this.idContractType != null && !this.idContractType.equals(other.idContractType))) {
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
        return "org.centrale.hceres.items.ContractType[ idContractType=" + idContractType + " ]";
    }
    
}
