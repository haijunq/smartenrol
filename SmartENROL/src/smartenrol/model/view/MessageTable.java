/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model.view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import smartenrol.dao.UserDAO;
import smartenrol.model.Message;
import smartenrol.model.User;

/**
 *
 * @author Terry
 */
public class MessageTable {
    
    private SimpleStringProperty date;
    private SimpleIntegerProperty senderID;
    private SimpleStringProperty senderName;
    private SimpleStringProperty message;

    public MessageTable() {
    }

    
    
    public MessageTable(Message message) {
        this.date = new SimpleStringProperty(message.getDate().toString());
        this.senderID = new SimpleIntegerProperty(message.getSenderID());
        this.message = new SimpleStringProperty(message.getMessage());
        this.senderName=new SimpleStringProperty(new UserDAO().getUserByID(senderID.get()).getFullName());
    }
    

    public String getDate() {
        return date.get();
    }

    public int getSenderID() {
        return senderID.get();
    }

    public String getSenderName() {
        return senderName.get();
    }

    public String getMessage() {
        return message.get();
    }
   
    
}
