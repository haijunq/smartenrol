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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Haijun
 */
@Entity
@Table(name = "Faculty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faculty.findAll", query = "SELECT f FROM Faculty f"),
    @NamedQuery(name = "Faculty.findByIdFaculty", query = "SELECT f FROM Faculty f WHERE f.idFaculty = :idFaculty"),
    @NamedQuery(name = "Faculty.findByName", query = "SELECT f FROM Faculty f WHERE f.name = :name"),
    @NamedQuery(name = "Faculty.findByDescription", query = "SELECT f FROM Faculty f WHERE f.description = :description"),
    @NamedQuery(name = "Faculty.findByMainPhone", query = "SELECT f FROM Faculty f WHERE f.mainPhone = :mainPhone"),
    @NamedQuery(name = "Faculty.findByDeanID", query = "SELECT f FROM Faculty f WHERE f.deanID = :deanID"),
    @NamedQuery(name = "Faculty.findByMainContactID", query = "SELECT f FROM Faculty f WHERE f.mainContactID = :mainContactID")})
public class Faculty implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idFaculty")
    private String idFaculty;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "mainPhone")
    private String mainPhone;
    @Column(name = "deanID")
    private String deanID;
    @Column(name = "mainContactID")
    private String mainContactID;
    @JoinColumn(name = "headOfficeLocationID", referencedColumnName = "idLocation")
    @ManyToOne
    private Building headOfficeLocationID;
    @OneToMany(mappedBy = "idFaculty")
    private Collection<Administrator> administratorCollection;
    @OneToMany(mappedBy = "idFaculty")
    private Collection<Instructor> instructorCollection;
    @OneToMany(mappedBy = "idFaculty")
    private Collection<Department> departmentCollection;

    public Faculty() {
    }

    public Faculty(String idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(String idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainPhone() {
        return mainPhone;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public String getDeanID() {
        return deanID;
    }

    public void setDeanID(String deanID) {
        this.deanID = deanID;
    }

    public String getMainContactID() {
        return mainContactID;
    }

    public void setMainContactID(String mainContactID) {
        this.mainContactID = mainContactID;
    }

    public Building getHeadOfficeLocationID() {
        return headOfficeLocationID;
    }

    public void setHeadOfficeLocationID(Building headOfficeLocationID) {
        this.headOfficeLocationID = headOfficeLocationID;
    }

    @XmlTransient
    public Collection<Administrator> getAdministratorCollection() {
        return administratorCollection;
    }

    public void setAdministratorCollection(Collection<Administrator> administratorCollection) {
        this.administratorCollection = administratorCollection;
    }

    @XmlTransient
    public Collection<Instructor> getInstructorCollection() {
        return instructorCollection;
    }

    public void setInstructorCollection(Collection<Instructor> instructorCollection) {
        this.instructorCollection = instructorCollection;
    }

    @XmlTransient
    public Collection<Department> getDepartmentCollection() {
        return departmentCollection;
    }

    public void setDepartmentCollection(Collection<Department> departmentCollection) {
        this.departmentCollection = departmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFaculty != null ? idFaculty.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faculty)) {
            return false;
        }
        Faculty other = (Faculty) object;
        if ((this.idFaculty == null && other.idFaculty != null) || (this.idFaculty != null && !this.idFaculty.equals(other.idFaculty))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartenrol.model.Faculty[ idFaculty=" + idFaculty + " ]";
    }
    
}
