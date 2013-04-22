/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jeremy
 */
@Entity
@Table(name = "Permissions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permissions.findAll", query = "SELECT p FROM Permissions p"),
    @NamedQuery(name = "Permissions.findByIdPermissions", query = "SELECT p FROM Permissions p WHERE p.idPermissions = :idPermissions"),
    @NamedQuery(name = "Permissions.findByFunctionname", query = "SELECT p FROM Permissions p WHERE p.functionname = :functionname"),
    @NamedQuery(name = "Permissions.findByDescription", query = "SELECT p FROM Permissions p WHERE p.description = :description")})
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPermissions")
    private Integer idPermissions;
    @Column(name = "functionname")
    private String functionname;
    @Column(name = "description")
    private String description;

    public Permission() {
    }

    public Permission(Integer idPermissions) {
        this.idPermissions = idPermissions;
    }

    public Integer getIdPermissions() {
        return idPermissions;
    }

    public void setIdPermissions(Integer idPermissions) {
        this.idPermissions = idPermissions;
    }

    public String getFunctionname() {
        return functionname;
    }

    public void setFunctionname(String functionname) {
        this.functionname = functionname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermissions != null ? idPermissions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        if ((this.idPermissions == null && other.idPermissions != null) || (this.idPermissions != null && !this.idPermissions.equals(other.idPermissions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartenrol.model.Permissions[ idPermissions=" + idPermissions + " ]";
    }
    
}
