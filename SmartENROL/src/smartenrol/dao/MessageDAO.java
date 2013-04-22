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
 * @author Terry
 */
public class MessageDAO extends SmartEnrolDAO {
    
    public MessageDAO() {
        super();
    }
            
  
    public ArrayList<Message> getMessageByRecepient(int recepientID) {
        
        this.initConnection();
        ArrayList<Message> messagelist=new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM Message WHERE recepientID = ? order by id desc");
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

        public ArrayList<Message> getMessageBySender(int senderID) {
        
        this.initConnection();
        ArrayList<Message> messagelist=new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM Message WHERE senderID = ?");
            ps.setInt(1, senderID);
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
    
    public int sendSystemMessage(int senderID, String msg, String type)
    {
        this.initConnection();
        String insertstr="insert into Message (recepientID, senderID, type, message, date, status) Values (80010001,?,?,?,?,'New')";
        int count=0;    
        try {
            ps = conn.prepareStatement(insertstr);
            ps.setInt(1, senderID);
            ps.setString(2, type);
            ps.setString(3, msg);
            ps.setString(4, (new LocalDate().toString()));
            count = ps.executeUpdate();
        
            conn.commit();
            this.psclose();
            return count;
            
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            try {
                conn.rollback();
            } catch (SQLException sqlex2) {
                System.err.println("SQLException: " + sqlex2.getMessage());                
            }
            this.psclose();
            return 0;
	}
    
    
    
    }

        public int sendSelfMessage(int recepientID, String msg)
    {
        this.initConnection();
        String insertstr="insert into Message (recepientID, senderID, type, message, date, status) Values (?, 80010001,'info',?,?,'New')";
        int count=0;    
        try {
            ps = conn.prepareStatement(insertstr);
            ps.setInt(1, recepientID);
            ps.setString(2, msg);
            ps.setString(3, (new LocalDate().toString()));
            count = ps.executeUpdate();
        
            conn.commit();
            this.psclose();
            return count;
            
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            try {
                conn.rollback();
            } catch (SQLException sqlex2) {
                System.err.println("SQLException: " + sqlex2.getMessage());                
            }
            this.psclose();
            return 0;
	}       
    }
        
    /**
     * This method marks the message as read.
     * @param id
     * @return 
     */    
    public int markMessageAsRead(int id)
    {
        this.initConnection();
        String insertstr="update Message set type = 'Read' where id = ?";
        int count=0;    
        try {
            ps = conn.prepareStatement(insertstr);
            ps.setInt(1, id);

            count = ps.executeUpdate();
        
            conn.commit();
            this.psclose();
            return count;
            
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            try {
                conn.rollback();
            } catch (SQLException sqlex2) {
                System.err.println("SQLException: " + sqlex2.getMessage());                
            }
            this.psclose();
            return 0;
	}       
    }        
        
    /**
     * This method marks the message as read.
     * @param id
     * @return 
     */    
    public int markMessageAsProcessed(int id)
    {
        this.initConnection();
        String insertstr="update Message set type = 'Processed' where id = ?";
        int count=0;    
        try {
            ps = conn.prepareStatement(insertstr);
            ps.setInt(1, id);

            count = ps.executeUpdate();
        
            conn.commit();
            this.psclose();
            return count;
            
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            try {
                conn.rollback();
            } catch (SQLException sqlex2) {
                System.err.println("SQLException: " + sqlex2.getMessage());                
            }
            this.psclose();
            return 0;
	}       
    }            
}
