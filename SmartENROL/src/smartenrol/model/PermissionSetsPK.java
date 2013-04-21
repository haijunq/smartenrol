/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jeremy
 */
@Embeddable
public class PermissionSetsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idPermissionSet")
    private String idPermissionSet;
    @Basic(optional = false)
    @Column(name = "idPermission")
    private int idPermission;

    public PermissionSetsPK() {
    }

    public PermissionSetsPK(String idPermissionSet, int idPermission) {
        this.idPermissionSet = idPermissionSet;
        this.idPermission = idPermission;
    }

    public String getIdPermissionSet() {
        return idPermissionSet;
    }

    public void setIdPermissionSet(String idPermissionSet) {
        this.idPermissionSet = idPermissionSet;
    }

    public int getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(int idPermission) {
        this.idPermission = idPermission;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermissionSet != null ? idPermissionSet.hashCode() : 0);
        hash += (int) idPermission;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermissionSetsPK)) {
            return false;
        }
        PermissionSetsPK other = (PermissionSetsPK) object;
        if ((this.idPermissionSet == null && other.idPermissionSet != null) || (this.idPermissionSet != null && !this.idPermissionSet.equals(other.idPermissionSet))) {
            return false;
        }
        if (this.idPermission != other.idPermission) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartenrol.model.PermissionSetsPK[ idPermissionSet=" + idPermissionSet + ", idPermission=" + idPermission + " ]";
    }
    
}
