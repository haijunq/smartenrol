/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model.view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import smartenrol.model.User;

/**
 *
 * @author Swordghost
 */
public class UserTable {
    private SimpleIntegerProperty userID;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty type;
    
    public UserTable(User user)
    {
        this.userID=new SimpleIntegerProperty(user.getIdUser());
        this.firstName=new SimpleStringProperty(user.getGivenName());
        this.lastName=new SimpleStringProperty(user.getSurname());
        this.type=new SimpleStringProperty(user.getUsertype().toString());
        
    }

    public int getUserID() {
        return userID.get();
    }

    public String getFirstName() {
        return firstName.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public String getType() {
        return type.get();
    }
    
    
}
