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
 * @author Haijun
 */
@Entity
@Table(name = "Building")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Building.findAll", query = "SELECT b FROM Building b"),
    @NamedQuery(name = "Building.findByIdLocation", query = "SELECT b FROM Building b WHERE b.idLocation = :idLocation"),
    @NamedQuery(name = "Building.findByAddr1", query = "SELECT b FROM Building b WHERE b.addr1 = :addr1"),
    @NamedQuery(name = "Building.findByAddr2", query = "SELECT b FROM Building b WHERE b.addr2 = :addr2"),
    @NamedQuery(name = "Building.findByCity", query = "SELECT b FROM Building b WHERE b.city = :city"),
    @NamedQuery(name = "Building.findByProvince", query = "SELECT b FROM Building b WHERE b.province = :province"),
    @NamedQuery(name = "Building.findByCountry", query = "SELECT b FROM Building b WHERE b.country = :country"),
    @NamedQuery(name = "Building.findByPostalCode", query = "SELECT b FROM Building b WHERE b.postalCode = :postalCode"),
    @NamedQuery(name = "Building.findByNotes", query = "SELECT b FROM Building b WHERE b.notes = :notes"),
    @NamedQuery(name = "Building.findByBuildingName", query = "SELECT b FROM Building b WHERE b.buildingName = :buildingName")})
public class Building implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idLocation")
    private String idLocation;
    @Column(name = "addr1")
    private String addr1;
    @Column(name = "addr2")
    private String addr2;
    @Column(name = "city")
    private String city;
    @Column(name = "province")
    private String province;
    @Column(name = "country")
    private String country;
    @Column(name = "postalCode")
    private String postalCode;
    @Column(name = "notes")
    private String notes;
    @Column(name = "buildingName")
    private String buildingName;
    @OneToMany(mappedBy = "headOfficeLocationID")
    private Collection<Faculty> facultyCollection;
    @OneToMany(mappedBy = "idLocation")
    private Collection<Department> departmentCollection;

    public Building() {
    }

    public Building(String idLocation) {
        this.idLocation = idLocation;
    }

    public String getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(String idLocation) {
        this.idLocation = idLocation;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    @XmlTransient
    public Collection<Faculty> getFacultyCollection() {
        return facultyCollection;
    }

    public void setFacultyCollection(Collection<Faculty> facultyCollection) {
        this.facultyCollection = facultyCollection;
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
        hash += (idLocation != null ? idLocation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Building)) {
            return false;
        }
        Building other = (Building) object;
        if ((this.idLocation == null && other.idLocation != null) || (this.idLocation != null && !this.idLocation.equals(other.idLocation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartenrol.model.Building[ idLocation=" + idLocation + " ]";
    }
    
}
