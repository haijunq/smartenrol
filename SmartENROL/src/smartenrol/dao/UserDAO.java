package smartenrol.dao;

import smartenrol.model.User;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This is the DAO class for parsing the resultset and return instance of User.
 * @author Haijun
 */
public class UserDAO extends SmartEnrolDAO {
    
    public UserDAO() {
        super();
    }
            
    /**
     * This method do the query using the user's ID and return a User object of this user.
     * @param idUser ID of the user
     * @return an instance of User
     * Tested!
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
                user.setPostalCode(rs.getString("postalCode"));
                user.setCity(rs.getString("city"));
                user.setLastModified(rs.getTimestamp("lastModified"));
                user.setDateCreated(rs.getTimestamp("dateCreated"));
                user.setLastModBy(rs.getInt("lastModby"));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return user;
    }
    
    /**
     * This method do the query using the user's surname and return a User object of this user.
     * @param surname surname of the user
     * @return an instance of User
     * Tested!
     */
    public ArrayList<User> getUserBySurname(String surname) {
        this.initConnection();
        ArrayList<User> userlist = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        
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
                ids.add(rs.getInt("idUser"));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();

        for (int id : ids) {
            userlist.add(getUserByID(id));
        }      
        
        return userlist;  
    }
    
    /**
     * This method do the query using userName and password and return a User object of this user.
     * @param userName
     * @param password
     * @return 
     * Tested!
     */
    public User getUserInfo(String userName, String password) {
        this.initConnection();
        User user = new User();
        try {
            ps = conn.prepareStatement("SELECT * FROM User WHERE username = ? and password = ?");
            ps.setString(1, userName);
            ps.setString(2, password);
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
                user.setPostalCode(rs.getString("postalCode"));
                user.setCity(rs.getString("city"));
                user.setLastModified(rs.getTimestamp("lastModified"));
                user.setDateCreated(rs.getTimestamp("dateCreated"));
                user.setLastModBy(rs.getInt("lastModby"));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        this.psclose();
        
        return user;  
    }
               
    // still need to implement
    // updateUser()
    // addUser()
    // removeUser() 
        
    
} //end UserDAO
