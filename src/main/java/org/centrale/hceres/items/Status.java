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
@Table(name = "status")
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s"),
    @NamedQuery(name = "Status.findByIdStatus", query = "SELECT s FROM Status s WHERE s.idStatus = :idStatus"),
    @NamedQuery(name = "Status.findByNameStatus", query = "SELECT s FROM Status s WHERE s.nameStatus = :nameStatus")})
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_status")
    private Integer idStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "name_status")
    private String nameStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStatus")
    private Collection<Contract> contractCollection;

    /**
     *
     */
    public Status() {
    }

    /**
     *
     * @param idStatus
     */
    public Status(Integer idStatus) {
        this.idStatus = idStatus;
    }

    /**
     *
     * @param idStatus
     * @param nameStatus
     */
    public Status(Integer idStatus, String nameStatus) {
        this.idStatus = idStatus;
        this.nameStatus = nameStatus;
    }

    /**
     *
     * @return
     */
    public Integer getIdStatus() {
        return idStatus;
    }

    /**
     *
     * @param idStatus
     */
    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    /**
     *
     * @return
     */
    public String getNameStatus() {
        return nameStatus;
    }

    /**
     *
     * @param nameStatus
     */
    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
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
        hash += (idStatus != null ? idStatus.hashCode() : 0);
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
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.idStatus == null && other.idStatus != null) || (this.idStatus != null && !this.idStatus.equals(other.idStatus))) {
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
        return "org.centrale.hceres.items.Status[ idStatus=" + idStatus + " ]";
    }
    
}
