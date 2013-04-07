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
    private ArrayList<Object> permissions; 
    
    protected UserSession() {
        this.currentUser = new User(89,"Jeremy","Wallace");
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
    
    public String getUserName() {
        System.out.println(currentUser.getGivenName()+" "+currentUser.getSurname());
        return currentUser.getGivenName()+" "+currentUser.getSurname();
    }
    
}