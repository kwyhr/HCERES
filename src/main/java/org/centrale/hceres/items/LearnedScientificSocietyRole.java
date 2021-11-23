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
@Table(name = "learned_scientific_society_role")
@NamedQueries({
    @NamedQuery(name = "LearnedScientificSocietyRole.findAll", query = "SELECT l FROM LearnedScientificSocietyRole l"),
    @NamedQuery(name = "LearnedScientificSocietyRole.findByLearnedScientificSocietyRoleId", query = "SELECT l FROM LearnedScientificSocietyRole l WHERE l.learnedScientificSocietyRoleId = :learnedScientificSocietyRoleId"),
    @NamedQuery(name = "LearnedScientificSocietyRole.findByNameChoice", query = "SELECT l FROM LearnedScientificSocietyRole l WHERE l.nameChoice = :nameChoice")})
public class LearnedScientificSocietyRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "learned_scientific_society_role_id")
    private Integer learnedScientificSocietyRoleId;
    @Size(max = 256)
    @Column(name = "name_choice")
    private String nameChoice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "learnedScientificSocietyRoleId")
    private Collection<LearnedScientificSociety> learnedScientificSocietyCollection;

    /**
     *
     */
    public LearnedScientificSocietyRole() {
    }

    /**
     *
     * @param learnedScientificSocietyRoleId
     */
    public LearnedScientificSocietyRole(Integer learnedScientificSocietyRoleId) {
        this.learnedScientificSocietyRoleId = learnedScientificSocietyRoleId;
    }

    /**
     *
     * @return
     */
    public Integer getLearnedScientificSocietyRoleId() {
        return learnedScientificSocietyRoleId;
    }

    /**
     *
     * @param learnedScientificSocietyRoleId
     */
    public void setLearnedScientificSocietyRoleId(Integer learnedScientificSocietyRoleId) {
        this.learnedScientificSocietyRoleId = learnedScientificSocietyRoleId;
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
    public Collection<LearnedScientificSociety> getLearnedScientificSocietyCollection() {
        return learnedScientificSocietyCollection;
    }

    /**
     *
     * @param learnedScientificSocietyCollection
     */
    public void setLearnedScientificSocietyCollection(Collection<LearnedScientificSociety> learnedScientificSocietyCollection) {
        this.learnedScientificSocietyCollection = learnedScientificSocietyCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (learnedScientificSocietyRoleId != null ? learnedScientificSocietyRoleId.hashCode() : 0);
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
        if (!(object instanceof LearnedScientificSocietyRole)) {
            return false;
        }
        LearnedScientificSocietyRole other = (LearnedScientificSocietyRole) object;
        if ((this.learnedScientificSocietyRoleId == null && other.learnedScientificSocietyRoleId != null) || (this.learnedScientificSocietyRoleId != null && !this.learnedScientificSocietyRoleId.equals(other.learnedScientificSocietyRoleId))) {
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
        return "org.centrale.hceres.items.LearnedScientificSocietyRole[ learnedScientificSocietyRoleId=" + learnedScientificSocietyRoleId + " ]";
    }
    
}
