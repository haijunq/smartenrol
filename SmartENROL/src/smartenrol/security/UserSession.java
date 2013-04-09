/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.security;

import java.util.ArrayList;
import smartenrol.model.User;

/**
 *
 * @author Jeremy
 */
public class UserSession {
    
    private static UserSession user_session = null;
    private User currentUser;
    private boolean signedIn = false;
    private ArrayList<Object> permissions; 
    
    protected UserSession() {
        //currentUser = new User(12,"Jeremy","Wallace");
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
}