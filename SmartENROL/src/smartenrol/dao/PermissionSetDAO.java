/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import smartenrol.model.PermissionSets;
import smartenrol.model.Permission;
import smartenrol.model.User;

/**
 *
 * @author Haijun
 */
public class PermissionSetDAO extends SmartEnrolDAO {
    private PermissionSets currentPermissionSet;
    
    public PermissionSetDAO() {
        super();
        currentPermissionSet = new PermissionSets();
    }

    /**
     * Get the permission set for the permission sets.
     * @return 
     */
    public ArrayList<Permission> getCurrentPermissionSet(User thisUser) {
        this.initConnection();
        ArrayList<Permission> permissions = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT Permissions.functionname FROM Permissions,PermissionSets,UserPermissions WHERE idUser = ? "
                    + "AND Permissions.idPermissions = PermissionSets.idPermissions"
                    + "AND PermissionSets.idPermissionSets = UserPermission.idPermissionSet");
            ps.setInt(1, thisUser.getIdUser());
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                Permission thisPermission = new Permission();
                thisPermission.setFunctionname(rs.getString("functionname"));
                permissions.add(thisPermission);
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return permissions;
    }
}
