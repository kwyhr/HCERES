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
import javax.validation.constraints.NotNull;

/**
 *
 * @author kwyhr
 */
@Entity
@Table(name = "mail_activity")
@NamedQueries({
    @NamedQuery(name = "MailActivity.findAll", query = "SELECT m FROM MailActivity m"),
    @NamedQuery(name = "MailActivity.findByMailActivityId", query = "SELECT m FROM MailActivity m WHERE m.mailActivityId = :mailActivityId"),
    @NamedQuery(name = "MailActivity.findByMailActivityDate", query = "SELECT m FROM MailActivity m WHERE m.mailActivityDate = :mailActivityDate")})
public class MailActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mail_activity_id")
    private Integer mailActivityId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mail_activity_date")
    @Temporal(TemporalType.DATE)
    private Date mailActivityDate;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity")
    @ManyToOne(optional = false)
    private Activity idActivity;
    @JoinColumn(name = "mail_template_id", referencedColumnName = "mail_template_id")
    @ManyToOne(optional = false)
    private MailTemplate mailTemplateId;

    /**
     *
     */
    public MailActivity() {
    }

    /**
     *
     * @param mailActivityId
     */
    public MailActivity(Integer mailActivityId) {
        this.mailActivityId = mailActivityId;
    }

    /**
     *
     * @param mailActivityId
     * @param mailActivityDate
     */
    public MailActivity(Integer mailActivityId, Date mailActivityDate) {
        this.mailActivityId = mailActivityId;
        this.mailActivityDate = mailActivityDate;
    }

    /**
     *
     * @return
     */
    public Integer getMailActivityId() {
        return mailActivityId;
    }

    /**
     *
     * @param mailActivityId
     */
    public void setMailActivityId(Integer mailActivityId) {
        this.mailActivityId = mailActivityId;
    }

    /**
     *
     * @return
     */
    public Date getMailActivityDate() {
        return mailActivityDate;
    }

    /**
     *
     * @param mailActivityDate
     */
    public void setMailActivityDate(Date mailActivityDate) {
        this.mailActivityDate = mailActivityDate;
    }

    /**
     *
     * @return
     */
    public Activity getIdActivity() {
        return idActivity;
    }

    /**
     *
     * @param idActivity
     */
    public void setIdActivity(Activity idActivity) {
        this.idActivity = idActivity;
    }

    /**
     *
     * @return
     */
    public MailTemplate getMailTemplateId() {
        return mailTemplateId;
    }

    /**
     *
     * @param mailTemplateId
     */
    public void setMailTemplateId(MailTemplate mailTemplateId) {
        this.mailTemplateId = mailTemplateId;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mailActivityId != null ? mailActivityId.hashCode() : 0);
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
        if (!(object instanceof MailActivity)) {
            return false;
        }
        MailActivity other = (MailActivity) object;
        if ((this.mailActivityId == null && other.mailActivityId != null) || (this.mailActivityId != null && !this.mailActivityId.equals(other.mailActivityId))) {
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
        return "org.centrale.hceres.items.MailActivity[ mailActivityId=" + mailActivityId + " ]";
    }
    
}
