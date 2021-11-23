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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "connection")
@NamedQueries({
    @NamedQuery(name = "Connection.findAll", query = "SELECT c FROM Connection c"),
    @NamedQuery(name = "Connection.findByConnectionCode", query = "SELECT c FROM Connection c WHERE c.connectionCode = :connectionCode"),
    @NamedQuery(name = "Connection.findByConnectionLogin", query = "SELECT c FROM Connection c WHERE c.connectionLogin = :connectionLogin"),
    @NamedQuery(name = "Connection.findByConnectionExpire", query = "SELECT c FROM Connection c WHERE c.connectionExpire = :connectionExpire"),
    @NamedQuery(name = "Connection.findByConnectionStatus", query = "SELECT c FROM Connection c WHERE c.connectionStatus = :connectionStatus")})
public class Connection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "connection_code")
    private String connectionCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "connection_login")
    private String connectionLogin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "connection_expire")
    @Temporal(TemporalType.TIMESTAMP)
    private Date connectionExpire;
    @Column(name = "connection_status")
    private Integer connectionStatus;
    @JoinColumn(name = "researcher_id", referencedColumnName = "researcher_id")
    @ManyToOne
    private Researcher researcherId;

    /**
     *
     */
    public Connection() {
    }

    /**
     *
     * @param connectionCode
     */
    public Connection(String connectionCode) {
        this.connectionCode = connectionCode;
    }

    /**
     *
     * @param connectionCode
     * @param connectionLogin
     * @param connectionExpire
     */
    public Connection(String connectionCode, String connectionLogin, Date connectionExpire) {
        this.connectionCode = connectionCode;
        this.connectionLogin = connectionLogin;
        this.connectionExpire = connectionExpire;
    }

    /**
     *
     * @return
     */
    public String getConnectionCode() {
        return connectionCode;
    }

    /**
     *
     * @param connectionCode
     */
    public void setConnectionCode(String connectionCode) {
        this.connectionCode = connectionCode;
    }

    /**
     *
     * @return
     */
    public String getConnectionLogin() {
        return connectionLogin;
    }

    /**
     *
     * @param connectionLogin
     */
    public void setConnectionLogin(String connectionLogin) {
        this.connectionLogin = connectionLogin;
    }

    /**
     *
     * @return
     */
    public Date getConnectionExpire() {
        return connectionExpire;
    }

    /**
     *
     * @param connectionExpire
     */
    public void setConnectionExpire(Date connectionExpire) {
        this.connectionExpire = connectionExpire;
    }

    /**
     *
     * @return
     */
    public Integer getConnectionStatus() {
        return connectionStatus;
    }

    /**
     *
     * @param connectionStatus
     */
    public void setConnectionStatus(Integer connectionStatus) {
        this.connectionStatus = connectionStatus;
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
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (connectionCode != null ? connectionCode.hashCode() : 0);
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
        if (!(object instanceof Connection)) {
            return false;
        }
        Connection other = (Connection) object;
        if ((this.connectionCode == null && other.connectionCode != null) || (this.connectionCode != null && !this.connectionCode.equals(other.connectionCode))) {
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
        return "org.centrale.hceres.items.Connection[ connectionCode=" + connectionCode + " ]";
    }
    
}
