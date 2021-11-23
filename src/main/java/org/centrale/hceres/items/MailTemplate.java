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
@Table(name = "mail_template")
@NamedQueries({
    @NamedQuery(name = "MailTemplate.findAll", query = "SELECT m FROM MailTemplate m"),
    @NamedQuery(name = "MailTemplate.findByMailTemplateId", query = "SELECT m FROM MailTemplate m WHERE m.mailTemplateId = :mailTemplateId"),
    @NamedQuery(name = "MailTemplate.findByMailTemplateTitle", query = "SELECT m FROM MailTemplate m WHERE m.mailTemplateTitle = :mailTemplateTitle"),
    @NamedQuery(name = "MailTemplate.findByMailTemplateContent", query = "SELECT m FROM MailTemplate m WHERE m.mailTemplateContent = :mailTemplateContent")})
public class MailTemplate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mail_template_id")
    private Integer mailTemplateId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "mail_template_title")
    private String mailTemplateTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "mail_template_content")
    private String mailTemplateContent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mailTemplateId")
    private Collection<MailActivity> mailActivityCollection;

    /**
     *
     */
    public MailTemplate() {
    }

    /**
     *
     * @param mailTemplateId
     */
    public MailTemplate(Integer mailTemplateId) {
        this.mailTemplateId = mailTemplateId;
    }

    /**
     *
     * @param mailTemplateId
     * @param mailTemplateTitle
     * @param mailTemplateContent
     */
    public MailTemplate(Integer mailTemplateId, String mailTemplateTitle, String mailTemplateContent) {
        this.mailTemplateId = mailTemplateId;
        this.mailTemplateTitle = mailTemplateTitle;
        this.mailTemplateContent = mailTemplateContent;
    }

    /**
     *
     * @return
     */
    public Integer getMailTemplateId() {
        return mailTemplateId;
    }

    /**
     *
     * @param mailTemplateId
     */
    public void setMailTemplateId(Integer mailTemplateId) {
        this.mailTemplateId = mailTemplateId;
    }

    /**
     *
     * @return
     */
    public String getMailTemplateTitle() {
        return mailTemplateTitle;
    }

    /**
     *
     * @param mailTemplateTitle
     */
    public void setMailTemplateTitle(String mailTemplateTitle) {
        this.mailTemplateTitle = mailTemplateTitle;
    }

    /**
     *
     * @return
     */
    public String getMailTemplateContent() {
        return mailTemplateContent;
    }

    /**
     *
     * @param mailTemplateContent
     */
    public void setMailTemplateContent(String mailTemplateContent) {
        this.mailTemplateContent = mailTemplateContent;
    }

    /**
     *
     * @return
     */
    public Collection<MailActivity> getMailActivityCollection() {
        return mailActivityCollection;
    }

    /**
     *
     * @param mailActivityCollection
     */
    public void setMailActivityCollection(Collection<MailActivity> mailActivityCollection) {
        this.mailActivityCollection = mailActivityCollection;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mailTemplateId != null ? mailTemplateId.hashCode() : 0);
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
        if (!(object instanceof MailTemplate)) {
            return false;
        }
        MailTemplate other = (MailTemplate) object;
        if ((this.mailTemplateId == null && other.mailTemplateId != null) || (this.mailTemplateId != null && !this.mailTemplateId.equals(other.mailTemplateId))) {
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
        return "org.centrale.hceres.items.MailTemplate[ mailTemplateId=" + mailTemplateId + " ]";
    }
    
}
