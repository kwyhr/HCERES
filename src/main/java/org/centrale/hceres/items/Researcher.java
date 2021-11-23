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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.centrale.tools.Utilities;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "researcher")
@NamedQueries({
    @NamedQuery(name = "Researcher.findAll", query = "SELECT r FROM Researcher r"),
    @NamedQuery(name = "Researcher.findByResearcherId", query = "SELECT r FROM Researcher r WHERE r.researcherId = :researcherId"),
    @NamedQuery(name = "Researcher.findByResearcherSurname", query = "SELECT r FROM Researcher r WHERE r.researcherSurname = :researcherSurname"),
    @NamedQuery(name = "Researcher.findByResearcherName", query = "SELECT r FROM Researcher r WHERE r.researcherName = :researcherName"),
    @NamedQuery(name = "Researcher.findByResearcherEmail", query = "SELECT r FROM Researcher r WHERE r.researcherEmail = :researcherEmail"),
    @NamedQuery(name = "Researcher.findByResearcherOrcid", query = "SELECT r FROM Researcher r WHERE r.researcherOrcid = :researcherOrcid"),
    @NamedQuery(name = "Researcher.findByResearcherLogin", query = "SELECT r FROM Researcher r WHERE r.researcherLogin = :researcherLogin"),
    @NamedQuery(name = "Researcher.findByResearcherPassword", query = "SELECT r FROM Researcher r WHERE r.researcherPassword = :researcherPassword")})
public class Researcher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "researcher_id")
    private Integer researcherId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "researcher_surname")
    private String researcherSurname;
    @Size(max = 256)
    @Column(name = "researcher_name")
    private String researcherName;
    @Size(max = 256)
    @Column(name = "researcher_email")
    private String researcherEmail;
    @Size(max = 256)
    @Column(name = "researcher_orcid")
    private String researcherOrcid;
    @Size(max = 256)
    @Column(name = "researcher_login")
    private String researcherLogin;
    @Size(max = 1024)
    @Column(name = "researcher_password")
    private String researcherPassword;
    @ManyToMany(mappedBy = "researcherCollection")
    private Collection<Nationality> nationalityCollection;
    @ManyToMany(mappedBy = "researcherCollection")
    private Collection<Activity> activityCollection;
    @OneToMany(mappedBy = "researcherId")
    private Collection<Connection> connectionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "researcherId")
    private Collection<Contract> contractCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "researcherId")
    private Collection<TeamReferent> teamReferentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "researcherId")
    private Collection<Supervisor> supervisorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "researcherId")
    private Collection<PhdStudent> phdStudentCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "researcher")
    private Admin admin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "researcherId")
    private Collection<BelongsTeam> belongsTeamCollection;

    /**
     *
     */
    public Researcher() {
    }

    /**
     *
     * @param researcherId
     */
    public Researcher(Integer researcherId) {
        this.researcherId = researcherId;
    }

    /**
     *
     * @param researcherId
     * @param researcherSurname
     */
    public Researcher(Integer researcherId, String researcherSurname) {
        this.researcherId = researcherId;
        this.researcherSurname = researcherSurname;
    }

    /**
     *
     * @return
     */
    public Integer getResearcherId() {
        return researcherId;
    }

    /**
     *
     * @param researcherId
     */
    public void setResearcherId(Integer researcherId) {
        this.researcherId = researcherId;
    }

    /**
     *
     * @return
     */
    public String getResearcherSurname() {
        return researcherSurname;
    }

    /**
     *
     * @param researcherSurname
     */
    public void setResearcherSurname(String researcherSurname) {
        this.researcherSurname = researcherSurname;
    }

    /**
     *
     * @return
     */
    public String getResearcherName() {
        return researcherName;
    }

    /**
     *
     * @param researcherName
     */
    public void setResearcherName(String researcherName) {
        this.researcherName = researcherName;
    }

    /**
     *
     * @return
     */
    public String getResearcherEmail() {
        return researcherEmail;
    }

    /**
     *
     * @param researcherEmail
     */
    public void setResearcherEmail(String researcherEmail) {
        this.researcherEmail = researcherEmail;
    }

    /**
     *
     * @return
     */
    public String getResearcherOrcid() {
        return researcherOrcid;
    }

    /**
     *
     * @param researcherOrcid
     */
    public void setResearcherOrcid(String researcherOrcid) {
        this.researcherOrcid = researcherOrcid;
    }

    /**
     *
     * @return
     */
    public String getResearcherLogin() {
        return researcherLogin;
    }

    /**
     *
     * @param researcherLogin
     */
    public void setResearcherLogin(String researcherLogin) {
        this.researcherLogin = researcherLogin;
    }

    /**
     *
     * @return
     */
    public String getResearcherPassword() {
        return researcherPassword;
    }

    /**
     *
     * @param researcherPassword
     */
    public void setResearcherPassword(String researcherPassword) {
        this.researcherPassword = researcherPassword;
    }

    /**
     *
     * @return
     */
    public Collection<Nationality> getNationalityCollection() {
        return nationalityCollection;
    }

    /**
     *
     * @param nationalityCollection
     */
    public void setNationalityCollection(Collection<Nationality> nationalityCollection) {
        this.nationalityCollection = nationalityCollection;
    }

    /**
     *
     * @return
     */
    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    /**
     *
     * @param activityCollection
     */
    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
    }

    /**
     *
     * @return
     */
    public Collection<Connection> getConnectionCollection() {
        return connectionCollection;
    }

    /**
     *
     * @param connectionCollection
     */
    public void setConnectionCollection(Collection<Connection> connectionCollection) {
        this.connectionCollection = connectionCollection;
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
    public Collection<TeamReferent> getTeamReferentCollection() {
        return teamReferentCollection;
    }

    /**
     *
     * @param teamReferentCollection
     */
    public void setTeamReferentCollection(Collection<TeamReferent> teamReferentCollection) {
        this.teamReferentCollection = teamReferentCollection;
    }

    /**
     *
     * @return
     */
    public Collection<Supervisor> getSupervisorCollection() {
        return supervisorCollection;
    }

    /**
     *
     * @param supervisorCollection
     */
    public void setSupervisorCollection(Collection<Supervisor> supervisorCollection) {
        this.supervisorCollection = supervisorCollection;
    }

    /**
     *
     * @return
     */
    public Collection<PhdStudent> getPhdStudentCollection() {
        return phdStudentCollection;
    }

    /**
     *
     * @param phdStudentCollection
     */
    public void setPhdStudentCollection(Collection<PhdStudent> phdStudentCollection) {
        this.phdStudentCollection = phdStudentCollection;
    }

    /**
     *
     * @return
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     *
     * @param admin
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    /**
     *
     * @return
     */
    public Collection<BelongsTeam> getBelongsTeamCollection() {
        return belongsTeamCollection;
    }

    /**
     *
     * @param belongsTeamCollection
     */
    public void setBelongsTeamCollection(Collection<BelongsTeam> belongsTeamCollection) {
        this.belongsTeamCollection = belongsTeamCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (researcherId != null ? researcherId.hashCode() : 0);
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
        if (!(object instanceof Researcher)) {
            return false;
        }
        Researcher other = (Researcher) object;
        if ((this.researcherId == null && other.researcherId != null) || (this.researcherId != null && !this.researcherId.equals(other.researcherId))) {
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
        return "org.centrale.hceres.items.Researcher[ researcherId=" + researcherId + " ]";
    }

    /**
     * Extra elements
     */
    /**
     * Get current contract
     *
     * @return
     */
    public Contract getCurrentContract() {
        if (this.contractCollection == null) {
            return null;
        } else {
            Date now = Utilities.getCurrentDate();
            for (Contract temp : this.contractCollection) {
                Date start = temp.getStartContract();
                Date end = temp.getEndContract();
                if (((start == null) || (start.before(now))) && ((end == null) || (end.after(now)))) {
                    return temp;
                }
            }
            return null;
        }
    }

    /**
     * Get Current team
     *
     * @return
     */
    public BelongsTeam getCurrentBelongsTeam() {
        if (this.belongsTeamCollection == null) {
            return null;
        } else {
            Date now = Utilities.getCurrentDate();
            for (BelongsTeam temp : belongsTeamCollection) {
                Date start = temp.getOnboardingDate();
                Date end = temp.getLeavingDate();
                if (((start == null) || (start.before(now))) && ((end == null) || (end.after(now)))) {
                    return temp;
                }
            }
            return null;
        }
    }

    /**
     * Get Current laboratory
     *
     * @return
     */
    public Laboratory getCurrentLaboratory() {
        BelongsTeam current = getCurrentBelongsTeam();
        if ((current != null) && (current.getTeamId() != null)) {
            return current.getTeamId().getLaboratoryId();
        }
        return null;
    }
}
