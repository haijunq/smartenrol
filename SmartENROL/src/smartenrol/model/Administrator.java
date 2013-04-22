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
@Table(name = "Administrator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a"),
    @NamedQuery(name = "Administrator.findByIdUser", query = "SELECT a FROM Administrator a WHERE a.idUser = :idUser"),
    @NamedQuery(name = "Administrator.findByJobTitle", query = "SELECT a FROM Administrator a WHERE a.jobTitle = :jobTitle"),
    @NamedQuery(name = "Administrator.findByOffice", query = "SELECT a FROM Administrator a WHERE a.office = :office"),
    @NamedQuery(name = "Administrator.findByStatus", query = "SELECT a FROM Administrator a WHERE a.status = :status"),
    @NamedQuery(name = "Administrator.findByIdSupervisor", query = "SELECT a FROM Administrator a WHERE a.idSupervisor = :idSupervisor"),
    @NamedQuery(name = "Administrator.findByType", query = "SELECT a FROM Administrator a WHERE a.type = :type")})
public class Administrator extends User {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idUser")
    private Integer idUser;
    @Column(name = "jobTitle")
    private String jobTitle;
    @Column(name = "office")
    private String office;
    @Column(name = "status")
    private String status;
    @Column(name = "idSupervisor")
    private String idSupervisor;
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "idDepartment", referencedColumnName = "idDepartment")
    @ManyToOne
    private Department idDepartment;
    @JoinColumn(name = "idFaculty", referencedColumnName = "idFaculty")
    @ManyToOne
    private Faculty idFaculty;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public Administrator() {
    }

    public Administrator(Integer idUser) {
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

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(String idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Department getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Department idDepartment) {
        this.idDepartment = idDepartment;
    }

    public Faculty getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(Faculty idFaculty) {
        this.idFaculty = idFaculty;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (!(object instanceof Administrator)) {
            return false;
        }
        Administrator other = (Administrator) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartenrol.model.Administrator[ idUser=" + idUser + " ]";
    }
    
}
