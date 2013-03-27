/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Haijun
 */
@Entity
@Table(name = "Instructor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i"),
    @NamedQuery(name = "Instructor.findByIdUser", query = "SELECT i FROM Instructor i WHERE i.idUser = :idUser"),
    @NamedQuery(name = "Instructor.findByJobTitle", query = "SELECT i FROM Instructor i WHERE i.jobTitle = :jobTitle"),
    @NamedQuery(name = "Instructor.findByBackground", query = "SELECT i FROM Instructor i WHERE i.background = :background"),
    @NamedQuery(name = "Instructor.findByStatus", query = "SELECT i FROM Instructor i WHERE i.status = :status"),
    @NamedQuery(name = "Instructor.findByType", query = "SELECT i FROM Instructor i WHERE i.type = :type"),
    @NamedQuery(name = "Instructor.findByOffice", query = "SELECT i FROM Instructor i WHERE i.office = :office")})
public class Instructor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idUser")
    private Integer idUser;
    @Column(name = "jobTitle")
    private String jobTitle;
    @Column(name = "background")
    private String background;
    @Column(name = "status")
    private String status;
    @Column(name = "type")
    private String type;
    @Column(name = "office")
    private String office;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;
    @JoinColumn(name = "idFaculty", referencedColumnName = "idFaculty")
    @ManyToOne
    private Faculty idFaculty;

    public Instructor() {
    }

    public Instructor(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Faculty getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(Faculty idFaculty) {
        this.idFaculty = idFaculty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartenrol.model.Instructor[ idUser=" + idUser + " ]";
    }
    
}
