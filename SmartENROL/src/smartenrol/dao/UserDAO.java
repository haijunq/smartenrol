package smartenrol.dao;

import smartenrol.model.User;
import java.sql.SQLException;
import java.util.ArrayList;
import org.joda.time.DateTime;
import static smartenrol.dao.SmartEnrolDAO.ps;
import static smartenrol.dao.SmartEnrolDAO.rs;

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
                user.setUsertype(rs.getString("userType"));
                user.setEmail(rs.getString("email"));
                user.setCountry(rs.getString("country"));
                user.setPostalCode(rs.getString("postalCode"));
                user.setProvince(rs.getString("province"));
                user.setCity(rs.getString("city"));
                user.setLastModified(new DateTime(rs.getTimestamp("lastModified")));
                user.setDateCreated(new DateTime(rs.getTimestamp("dateCreated")));
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
     * This method a list of Strings of all the Administrators.
     * @param surname surname of the user
     * @return an instance of User
     * Tested!
     */
    public ArrayList<Integer> getAllAdminID() {
        this.initConnection();
        ArrayList<Integer> adminlist = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT idUser FROM User WHERE usertype = 'Administrator'");
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                adminlist.add(rs.getInt("idUser"));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose(); 
        
        return adminlist;  
    }
    
    /*
     * update user profile
     */
    public boolean updateProfile(User user) {
        this.initConnection();
        ArrayList<User> userlist = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("UPDATE User set addr1 = ?, email = ?, phone = ? WHERE username = ?;");
            ps.setString(1, user.getAddr1());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getUsername());
           
            ps.executeUpdate();
             conn.commit();
            return true;
           }   
            catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return false;
        }

    }
    
/*
     * add user profile
     */
    public boolean addUser(User user) {
        this.initConnection();
        
        try {
           
                ps = conn.prepareStatement("INSERT INTO User SET addr1 = ?, "
                 + "email = ?, phone = ?, addr2 = ?, city = ?, province = ?, postalcode = ? , country = ?, lastModBy = ?, idUser = ?;");
            
                ps.setString(1, user.getAddr1());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getPhone());
                ps.setString(4, user.getPhone());
                ps.setString(5, user.getAddr2());
                ps.setString(6, user.getCity());
                ps.setString(7, user.getProvince());
                ps.setString(8, user.getCountry());
                ps.setInt(9, user.getLastModBy());
                ps.setInt(10, user.getIdUser());
           
             ps.executeQuery();
             conn.commit();
            return true;
           }   
            catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return false;
        }

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
            //sqlex.printStackTrace();
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
                    user.setUsertype(rs.getString("userType"));
                  user.setEmail(rs.getString("email"));
                user.setCountry(rs.getString("country"));
                user.setPostalCode(rs.getString("postalCode"));
                user.setCity(rs.getString("city"));
                user.setLastModified(new DateTime(rs.getTimestamp("lastModified")));
                user.setDateCreated(new DateTime(rs.getTimestamp("dateCreated")));
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
 * Search users by up to 3 keywords on searchable field idUser, givenName and surname
 * type can be instructor, student, administrator or any (all of them)
 * @author Terry Liu
 * @param keyword a string array of user input keywords, type is the usertype of the user
 * @return list of user
 * 
 */
    
    public ArrayList<User> searchUserbyKeyword(String[] keyword, String type) {
        this.initConnection();
        ArrayList<User> userlist = new ArrayList<>();
        String querystr="select idUser,givenName,surname,usertype from User where (idUser=? or givenName LIKE ? or surname LIKE ?) AND (idUser=? or givenName LIKE ? or surname LIKE ?) AND (idUser=? or givenName LIKE ? or surname LIKE ?)";
        boolean usetypeFilter=false;
        if (!(type.equalsIgnoreCase("") || type.equalsIgnoreCase("all")))
        {
               usetypeFilter=true;
        }
        
        
        
        if (usetypeFilter)
        {
            querystr=querystr+" AND usertype=?";
        }
        
        try {
            ps = conn.prepareStatement(querystr);
            ps.setString(1, keyword[0]);
            ps.setString(2, "%"+keyword[0]+"%");
            ps.setString(3, "%"+keyword[0]+"%");
            ps.setString(4, keyword[1]);
            ps.setString(5, "%"+keyword[1]+"%");
            ps.setString(6, "%"+keyword[1]+"%");
            ps.setString(7, keyword[2]);
            ps.setString(8, "%"+keyword[2]+"%");
            ps.setString(9, "%"+keyword[2]+"%");
            if (usetypeFilter)
            {
                ps.setString(10,type);
            }
            
            
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }
          
        try {
            while (rs.next()) {
            userlist.add(new User(
                    rs.getInt("idUser"),
                    rs.getString("givenName"),
                    rs.getString("surname"),
                    rs.getString("usertype")
                    ));
            
            
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }            
    
          
          
        this.psclose();
        return userlist;
    
    }
    // still need to implement
    // addUser()
    // removeUser() 
        
    
} //end UserDAO
