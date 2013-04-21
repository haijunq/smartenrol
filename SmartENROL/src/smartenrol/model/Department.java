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
import javax.persistence.Lob;
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
@Table(name = "Department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByIdDepartment", query = "SELECT d FROM Department d WHERE d.idDepartment = :idDepartment"),
    @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name"),
    @NamedQuery(name = "Department.findByDepartmentHeadID", query = "SELECT d FROM Department d WHERE d.departmentHeadID = :departmentHeadID"),
    @NamedQuery(name = "Department.findByMainContactID", query = "SELECT d FROM Department d WHERE d.mainContactID = :mainContactID")})
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idDepartment")
    private String idDepartment;
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "departmentHeadID")
    private String departmentHeadID;
    @Column(name = "mainContactID")
    private String mainContactID;
    @OneToMany(mappedBy = "idDepartment")
    private Collection<Administrator> administratorCollection;
    @JoinColumn(name = "idLocation", referencedColumnName = "idLocation")
    
    private String idLocation;
   
    private String idFaculty;
    
    private String phone;
    private String email;
    private String deptHeadName;
    private int idAdmin;
 
    
    
    
    public Department() {
    }

    public Department(String idDepartment) {
        this.idDepartment = idDepartment;
    }

    public Department(String idDepartment, String name, String idLocation, String phone, String email) {
        this.idDepartment = idDepartment;
        this.name = name;
        this.idLocation = idLocation;
        this.phone = phone;
        this.email = email;
    }

    public String getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(String idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    
    

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDeptHeadName() {
        return deptHeadName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDeptHeadName(String deptHeadName) {
        this.deptHeadName = deptHeadName;
    }
    
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartmentHeadID() {
        return departmentHeadID;
    }

    public void setDepartmentHeadID(String departmentHeadID) {
        this.departmentHeadID = departmentHeadID;
    }

    public String getMainContactID() {
        return mainContactID;
    }

    public void setMainContactID(String mainContactID) {
        this.mainContactID = mainContactID;
    }

    @XmlTransient
    public Collection<Administrator> getAdministratorCollection() {
        return administratorCollection;
    }

    public void setAdministratorCollection(Collection<Administrator> administratorCollection) {
        this.administratorCollection = administratorCollection;
    }

    public String getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(String idLocation) {
        this.idLocation = idLocation;
    }

    public String getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(String idFaculty) {
        this.idFaculty = idFaculty;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepartment != null ? idDepartment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.idDepartment == null && other.idDepartment != null) || (this.idDepartment != null && !this.idDepartment.equals(other.idDepartment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartenrol.model.Department[ idDepartment=" + idDepartment + " ]";
    }
    
}
