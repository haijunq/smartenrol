/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import org.joda.time.DateTime;
import smartenrol.model.Faculty;
import smartenrol.model.Instructor;

/**
 *
 * @author Haijun
 */
public class InstructorDAO extends UserDAO {
    
    /**
     * Return a Instructor instance by specifying an instructor's ID (same as idUser).
     * @param idInstructor
     * @return 
     * Tested!
     */
    public Instructor getInstructorByID(int idInstructor) {
        this.initConnection();
        Instructor instructor = new Instructor();
        
        try {
            ps = conn.prepareStatement("SELECT i.*, u.*, f.* \n" +
                                    "FROM User u, Instructor i, Faculty f \n" +
                                    "WHERE u.idUser = ? AND i.idUser = ? AND i.idUser = u.idUser AND i.idFaculty = f.idFaculty");
            ps.setInt(1, idInstructor);
            ps.setInt(2, idInstructor);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                instructor.setIdUser(rs.getInt("idUser"));
                instructor.setOffice(rs.getString("office"));
                instructor.setBackground(rs.getString("background"));
                instructor.setJobTitle(rs.getString("jobtitle"));
                instructor.setIdFaculty(new Faculty(rs.getString("idFaculty")));
                instructor.getIdFaculty().setName(rs.getString("f.name"));
                instructor.setStatus(rs.getString("status"));
                instructor.setGivenName(rs.getString("givenName"));
                instructor.setSurname(rs.getString("surname"));
                instructor.setUsername(rs.getString("username"));
                instructor.setPassword(rs.getString("password"));
                instructor.setPhone(rs.getString("phone"));
                instructor.setEmail(rs.getString("email"));
                instructor.setAddr1(rs.getString("addr1"));
                instructor.setAddr2(rs.getString("addr2"));
                instructor.setUsertype(rs.getString("userType"));
                instructor.setPostalCode(rs.getString("postalCode"));          
                instructor.setCity(rs.getString("city"));
                instructor.setLastModified(new DateTime(rs.getTimestamp("lastModified")));
                instructor.setDateCreated(new DateTime(rs.getTimestamp("dateCreated")));
                instructor.setLastModBy(rs.getInt("lastModby"));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return instructor;
    }
    
    /*
     * update user profile
     */
    public boolean updateProfile(Instructor instructor) {
        this.initConnection();
        
        try {
            super.updateProfile(instructor);
            
            ps = conn.prepareStatement("UPDATE Instructor set office = ?, "
                    + "idFaculty = ?, jobtitle = ? "
                    + "WHERE idUser = ?;");
            
            ps.setString(1, instructor.getOffice());
            ps.setString(2, instructor.getIdFaculty().getIdFaculty());
            ps.setString(3, instructor.getJobTitle());
            ps.setInt(4, instructor.getIdUser());
           
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
    
    /**
     * This method adds a new instructor to the database
     * @param instructor New instructor to be added.
     * @return true if successful.
     */
    public boolean addInstructor(Instructor instructor) {
        this.initConnection();
        int userID = addUser(instructor);
        try {
            
            ps = conn.prepareStatement("INSERT INTO Instructor (office,idFaculty,jobtitle,idUser) VALUES (?,?,?,?)");
            
            ps.setString(1, instructor.getOffice());
            ps.setString(2, instructor.getIdFaculty().getIdFaculty());
            ps.setString(3, instructor.getJobTitle());
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

    /**
     * Return a list of instructors filtered by idDepartment
     * @param idInstructor
     * @return ArrayList<Instructor>
     * Tested!
     */
    public ArrayList<Instructor> getInstructorByDept(String idDepartment) {

        this.initConnection();
        ArrayList<Instructor> instructorList = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT i.idUser\n" +
                                    "FROM Instructor i, Department d \n" +
                                    "WHERE d.idDepartment = ? AND d.idFaculty = i.idFaculty");
            ps.setString(1, idDepartment);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {

            while (rs.next()) 
				instructorList.add(new Instructor(rs.getInt("idUser")));
            
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return instructorList;
    }
}
