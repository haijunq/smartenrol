/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import org.joda.time.LocalDate;
import smartenrol.model.Message;

/**
 *
 * @author Swordghost
 */
public class MessageDAO extends SmartEnrolDAO {
    
    public MessageDAO() {
        super();
    }
            
  
    public ArrayList<Message> getMessageByRecepient(int recepientID) {
        
        this.initConnection();
        ArrayList<Message> messagelist=new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM Message WHERE recepientID = ?");
            ps.setInt(1, recepientID);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                messagelist.add(new Message(rs.getInt("id"),
                        rs.getInt("recepientID"),
                        rs.getInt("senderID"),
                        rs.getString("type"),
                        rs.getString("message"),
                        new LocalDate(rs.getString("date")),
                        rs.getString("status")));
                        
               
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return messagelist;
    }

    
    
}
