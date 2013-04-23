/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import java.io.Serializable;

/**
 *
 * @author Haijun
 */
public class Department {

    private String idDepartment;
    private String name;
    private String description;
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

    public String toPhoneEmailString() {
        return "Contact us \nPhone : " + this.phone + "\nEmail : " + this.email;
    }
    
}
