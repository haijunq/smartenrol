/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jeremy
 */
@Entity
@Table(name = "MessageTemplate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MessageTemplate.findAll", query = "SELECT m FROM MessageTemplate m"),
    @NamedQuery(name = "MessageTemplate.findByType", query = "SELECT m FROM MessageTemplate m WHERE m.type = :type"),
    @NamedQuery(name = "MessageTemplate.findByStringPattern", query = "SELECT m FROM MessageTemplate m WHERE m.stringPattern = :stringPattern")})
public class MessageTemplate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Column(name = "stringPattern")
    private String stringPattern;
    @OneToMany(mappedBy = "type")
    private Collection<Message> messageCollection;

    public MessageTemplate() {
    }

    public MessageTemplate(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStringPattern() {
        return stringPattern;
    }

    public void setStringPattern(String stringPattern) {
        this.stringPattern = stringPattern;
    }

    @XmlTransient
    public Collection<Message> getMessageCollection() {
        return messageCollection;
    }

    public void setMessageCollection(Collection<Message> messageCollection) {
        this.messageCollection = messageCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (type != null ? type.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessageTemplate)) {
            return false;
        }
        MessageTemplate other = (MessageTemplate) object;
        if ((this.type == null && other.type != null) || (this.type != null && !this.type.equals(other.type))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartenrol.model.MessageTemplate[ type=" + type + " ]";
    }
    
}
