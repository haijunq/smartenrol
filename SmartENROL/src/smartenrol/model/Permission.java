/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

/**
 *
 * @author Jeremy
 */

public class Permission {

    private Integer idPermissions;
    private String functionname;
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
    public String toString() {
        return "smartenrol.model.Permissions[ idPermissions=" + idPermissions + " ]";
    }
    
}
