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
    private SimpleStringProperty type;

    public MessageTable() {
    }

    
    
    public MessageTable(Message message) {
        this.date = new SimpleStringProperty(message.getDate().toString());
        this.senderID = new SimpleIntegerProperty(message.getSenderID());
        this.message = new SimpleStringProperty(message.getMessage());
        this.senderName=new SimpleStringProperty(new UserDAO().getUserByID(senderID.get()).getFullName());
        this.type=new SimpleStringProperty(message.getType());
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
      
    private String[] parseKeyword(String input) {
        String delims = "[ ]+";
        String[] tokens = input.split(delims);
        String[] keywords = new String[3];
        int i = 0;
        int maxtokens = tokens.length;
        if (maxtokens > 3) {
            maxtokens = 3;
        }

        for (i = 0; i < maxtokens; i++) {
            keywords[i] = tokens[i];
        }
        for (i = tokens.length; i < 3; i++) {
            keywords[i] = "";
        }

        return keywords;
    }

    public String[] parseEnrolRequest() {
        
        String[] result = new String[4];
        result[0] = type.get();
    
        String coursetext = message.get().substring(message.get().indexOf("[") + 1, message.get().indexOf("]"));
        String[] courseids = parseKeyword(coursetext);
        result[1] = courseids[0];
        result[2] = courseids[1];
        result[3] = courseids[2];
        return result;
    }
    
    public boolean isSpeicialApproval()
    {
        return (type.get().equalsIgnoreCase("restricted") || type.get().equalsIgnoreCase("prereq") || type.get().equalsIgnoreCase("deadline"));
    }
    
}
