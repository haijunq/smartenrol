/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.security;

import java.util.ArrayList;
import smartenrol.dao.PermissionSetDAO;
import smartenrol.model.Permission;
import smartenrol.model.User;

/**
 *
 * @author Jeremy
 */
public class UserSession {
    
    private static UserSession user_session = null;
    private User currentUser = new User();
    private boolean signedIn = false;
    private ArrayList<Permission> permissions; 
    private PermissionSetDAO permissionsetdao = new PermissionSetDAO();
    
    protected UserSession() {
        
    }

    /**
     * Static method returns a single instance of UserSession
     * @return	a single instance of UserSession
     */
    public static UserSession getInstance()  {
        if (user_session == null) {
            user_session = new UserSession(); 
        }
        return user_session;
    }
    
    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
        setPermissions();
        signedIn = true;
    }    

    /**
     * @return the signedIn
     */
    public boolean isSignedIn() {
        return signedIn;
    }
    
    public void clearSession() {
        this.currentUser = null;
    }
    
    public boolean checkPermission(String permission) {
        for (Permission userPermission : permissions) {
            if (userPermission.getFunctionname().equals(permission)) {
                return true;
            }
        }
        return false;
    }
    
    private void setPermissions() {
        if (this.currentUser!=null) {
            permissions = permissionsetdao.getCurrentPermissionSet(currentUser);
        }
    }
    
}