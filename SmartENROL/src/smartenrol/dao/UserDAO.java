package smartenrol.dao;

import smartenrol.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This is the DAO class for parsing the resultset and return instance of User.
 * @author Haijun
 */
public class UserDAO {
    private static Connection conn; 
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    public UserDAO() {
        conn = null;
        ps = null;
        rs = null;
    }
    
    /**
     * Initialize a connection.
     */
    private void initConnection() {
        MySQLConnection mySQLConnection = MySQLConnection.getInstance();
        conn = mySQLConnection.getConnection();
    }
            
    /**
     * This method do the query using the user's ID and return a User object of this user.
     * @param idUser ID of the user
     * @return an instance of User
     */
    public User getUserByID(int idUser) {
        this.initConnection();
        User user = new User(idUser);
        
        try {
            ps = conn.prepareStatement("SELECT * FROM User WHERE idUser = ?");
            ps.setInt(1, idUser);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                user.setIdUser(rs.getInt("idUser"));
                user.setGivenName(rs.getString("givenName"));
                user.setSurname(rs.getString("surname"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddr1(rs.getString("addr1"));
                user.setAddr2(rs.getString("addr2"));
                user.setPostalCode(rs.getString("postCode"));
                user.setCity(rs.getString("city"));
                user.setLastModified(rs.getTimestamp("lastModified"));
                user.setDateCreated(rs.getTimestamp("dataCreated"));
                user.setLastModBy(rs.getInt("lastModby"));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }        
        
        return user;
    }
    
    /**
     * This method do the query using the user's surname and return a User object of this user.
     * @param surname surname of the user
     * @return an instance of User
     */
    public User getUserBySurname(String surname) {
        this.initConnection();
        User user = new User();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM User WHERE surname = ?");
            ps.setString(1, surname);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                user.setIdUser(rs.getInt("idUser"));
                user.setGivenName(rs.getString("givenName"));
                user.setSurname(rs.getString("surname"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddr1(rs.getString("addr1"));
                user.setAddr2(rs.getString("addr2"));
                user.setPostalCode(rs.getString("postCode"));
                user.setCity(rs.getString("city"));
                user.setLastModified(rs.getTimestamp("lastModified"));
                user.setDateCreated(rs.getTimestamp("dataCreated"));
                user.setLastModBy(rs.getInt("lastModby"));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }        
        
        return user;  
    }
    
    
    // still need to implement
    // updateUser()
    // addUser()
    // removeUser() 
    
    
    
} //end UserDAO
