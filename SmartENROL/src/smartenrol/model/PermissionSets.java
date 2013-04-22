/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jeremy
 */
@Entity
@Table(name = "PermissionSets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermissionSets.findAll", query = "SELECT p FROM PermissionSets p"),
    @NamedQuery(name = "PermissionSets.findByIdPermissionSet", query = "SELECT p FROM PermissionSets p WHERE p.permissionSetsPK.idPermissionSet = :idPermissionSet"),
    @NamedQuery(name = "PermissionSets.findByIdPermission", query = "SELECT p FROM PermissionSets p WHERE p.permissionSetsPK.idPermission = :idPermission")})
public class PermissionSets implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PermissionSetsPK permissionSetsPK;
    @JoinColumn(name = "idPermission", referencedColumnName = "idPermissions", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Permission permissions;

    public PermissionSets() {
    }

    public PermissionSets(PermissionSetsPK permissionSetsPK) {
        this.permissionSetsPK = permissionSetsPK;
    }

    public PermissionSets(String idPermissionSet, int idPermission) {
        this.permissionSetsPK = new PermissionSetsPK(idPermissionSet, idPermission);
    }

    public PermissionSetsPK getPermissionSetsPK() {
        return permissionSetsPK;
    }

    public void setPermissionSetsPK(PermissionSetsPK permissionSetsPK) {
        this.permissionSetsPK = permissionSetsPK;
    }

    public Permission getPermissions() {
        return permissions;
    }

    public void setPermissions(Permission permissions) {
        this.permissions = permissions;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permissionSetsPK != null ? permissionSetsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermissionSets)) {
            return false;
        }
        PermissionSets other = (PermissionSets) object;
        if ((this.permissionSetsPK == null && other.permissionSetsPK != null) || (this.permissionSetsPK != null && !this.permissionSetsPK.equals(other.permissionSetsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartenrol.model.PermissionSets[ permissionSetsPK=" + permissionSetsPK + " ]";
    }
    
}
