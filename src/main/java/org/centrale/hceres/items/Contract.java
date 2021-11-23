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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "contract")
@NamedQueries({
    @NamedQuery(name = "Contract.findAll", query = "SELECT c FROM Contract c"),
    @NamedQuery(name = "Contract.findByIdContract", query = "SELECT c FROM Contract c WHERE c.idContract = :idContract"),
    @NamedQuery(name = "Contract.findByStartContract", query = "SELECT c FROM Contract c WHERE c.startContract = :startContract"),
    @NamedQuery(name = "Contract.findByEndContract", query = "SELECT c FROM Contract c WHERE c.endContract = :endContract"),
    @NamedQuery(name = "Contract.findByFunctionContract", query = "SELECT c FROM Contract c WHERE c.functionContract = :functionContract")})
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contract")
    private Integer idContract;
    @Column(name = "start_contract")
    @Temporal(TemporalType.DATE)
    private Date startContract;
    @Column(name = "end_contract")
    @Temporal(TemporalType.DATE)
    private Date endContract;
    @Size(max = 256)
    @Column(name = "function_contract")
    private String functionContract;
    @JoinColumn(name = "id_contract_type", referencedColumnName = "id_contract_type")
    @ManyToOne(optional = false)
    private ContractType idContractType;
    @JoinColumn(name = "id_employer", referencedColumnName = "id_employer")
    @ManyToOne(optional = false)
    private Employer idEmployer;
    @JoinColumn(name = "researcher_id", referencedColumnName = "researcher_id")
    @ManyToOne(optional = false)
    private Researcher researcherId;
    @JoinColumn(name = "id_status", referencedColumnName = "id_status")
    @ManyToOne(optional = false)
    private Status idStatus;

    /**
     *
     */
    public Contract() {
    }

    /**
     *
     * @param idContract
     */
    public Contract(Integer idContract) {
        this.idContract = idContract;
    }

    /**
     *
     * @return
     */
    public Integer getIdContract() {
        return idContract;
    }

    /**
     *
     * @param idContract
     */
    public void setIdContract(Integer idContract) {
        this.idContract = idContract;
    }

    /**
     *
     * @return
     */
    public Date getStartContract() {
        return startContract;
    }

    /**
     *
     * @param startContract
     */
    public void setStartContract(Date startContract) {
        this.startContract = startContract;
    }

    /**
     *
     * @return
     */
    public Date getEndContract() {
        return endContract;
    }

    /**
     *
     * @param endContract
     */
    public void setEndContract(Date endContract) {
        this.endContract = endContract;
    }

    /**
     *
     * @return
     */
    public String getFunctionContract() {
        return functionContract;
    }

    /**
     *
     * @param functionContract
     */
    public void setFunctionContract(String functionContract) {
        this.functionContract = functionContract;
    }

    /**
     *
     * @return
     */
    public ContractType getIdContractType() {
        return idContractType;
    }

    /**
     *
     * @param idContractType
     */
    public void setIdContractType(ContractType idContractType) {
        this.idContractType = idContractType;
    }

    /**
     *
     * @return
     */
    public Employer getIdEmployer() {
        return idEmployer;
    }

    /**
     *
     * @param idEmployer
     */
    public void setIdEmployer(Employer idEmployer) {
        this.idEmployer = idEmployer;
    }

    /**
     *
     * @return
     */
    public Researcher getResearcherId() {
        return researcherId;
    }

    /**
     *
     * @param researcherId
     */
    public void setResearcherId(Researcher researcherId) {
        this.researcherId = researcherId;
    }

    /**
     *
     * @return
     */
    public Status getIdStatus() {
        return idStatus;
    }

    /**
     *
     * @param idStatus
     */
    public void setIdStatus(Status idStatus) {
        this.idStatus = idStatus;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContract != null ? idContract.hashCode() : 0);
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
        if (!(object instanceof Contract)) {
            return false;
        }
        Contract other = (Contract) object;
        if ((this.idContract == null && other.idContract != null) || (this.idContract != null && !this.idContract.equals(other.idContract))) {
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
        return "org.centrale.hceres.items.Contract[ idContract=" + idContract + " ]";
    }
    
}
