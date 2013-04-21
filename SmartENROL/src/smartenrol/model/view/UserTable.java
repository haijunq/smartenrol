/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model.view;

import smartenrol.model.User;

/**
 *
 * @author Swordghost
 */
public class UserTable {
    private int UserID;
    private String FirstName;
    private String LastName;
    private User.Type type;
    
    public UserTable(User user)
    {
        this.UserID=user.getIdUser();
        this.FirstName=user.getGivenName();
        this.LastName=user.getSurname();
        this.type=user.getUsertype();
        
    }

    public int getUserID() {
        return UserID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public User.Type getType() {
        return type;
    }
    
    
}
