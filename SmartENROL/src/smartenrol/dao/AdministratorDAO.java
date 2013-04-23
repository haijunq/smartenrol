/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.SQLException;
import org.joda.time.DateTime;
import smartenrol.model.Faculty;
import smartenrol.model.Administrator;
import smartenrol.model.Department;

/**
 *
 * @author Haijun
 */
public class AdministratorDAO extends UserDAO {
    
    /**
     * Return a Student instance by specifying student's ID (same as idUser).
     * @param idStudent
     * @return 
     * Tested!
     */
    public Administrator getAdministratorByID(int idAdministrator) {
        this.initConnection();
        Administrator administrator = new Administrator();
        
        try {
            ps = conn.prepareStatement("SELECT a.*, u.* \n" +
                                    "FROM User u, Administrator a, Department d \n" +
                                    "WHERE u.idUser = ? AND a.idUser = ? AND a.idUser = a.idUser AND a.idDepartment = d.idDepartment");
            ps.setInt(1, idAdministrator);
            ps.setInt(2, idAdministrator);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                administrator.setIdUser(rs.getInt("idUser"));
                administrator.setOffice(rs.getString("office"));
                administrator.setIdDepartment(new Department(rs.getString("idDepartment")));
                administrator.setJobTitle(rs.getString("jobtitle"));
                administrator.setIdFaculty(new Faculty(rs.getString("idFaculty")));
                administrator.setStatus(rs.getString("status"));
                administrator.setGivenName(rs.getString("givenName"));
                administrator.setSurname(rs.getString("surname"));
                administrator.setUsername(rs.getString("username"));
                administrator.setPassword(rs.getString("password"));
                administrator.setPhone(rs.getString("phone"));
                administrator.setAddr1(rs.getString("addr1"));
                administrator.setAddr2(rs.getString("addr2"));
                administrator.setPostalCode(rs.getString("postalCode"));          
                administrator.setCity(rs.getString("city"));
                administrator.setLastModified(new DateTime(rs.getTimestamp("lastModified")));
                administrator.setDateCreated(new DateTime(rs.getTimestamp("dateCreated")));
                administrator.setLastModBy(rs.getInt("lastModby"));
                administrator.setUsertype(rs.getString("userType"));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return administrator;
    }

    /*
     * update user profile
     */
    public boolean updateProfile(Administrator administrator) {
        this.initConnection();
        
        try {
            super.updateProfile(administrator);
            
            ps = conn.prepareStatement("UPDATE Administrator set office = ?, "
                    + "idDepartment = ?, jobtitle = ? "
                    + "WHERE idUser = ?;");
            
            ps.setString(1, administrator.getOffice());
            ps.setString(2, administrator.getIdDepartment().getIdDepartment());
            ps.setString(3, administrator.getJobTitle());
            ps.setInt(4, administrator.getIdUser());
           
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
    
    public boolean addAdministrator(Administrator administrator) {
        this.initConnection();
        int userID = addUser(administrator);
        try {
            
            ps = conn.prepareStatement("INSERT INTO Administrator (office,idDepartment,jobtitle,idUser) VALUES (?,?,?,?)");
            
            ps.setString(1, administrator.getOffice());
            ps.setString(2, administrator.getIdDepartment().getIdDepartment());
            ps.setString(3, administrator.getJobTitle());
            ps.setInt(4, userID);
           
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
}
