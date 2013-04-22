/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.SQLException;
import smartenrol.model.Faculty;
import smartenrol.model.Instructor;

/**
 *
 * @author Haijun
 */
public class InstructorDAO extends UserDAO {
    
    /**
     * Return a Student instance by specifying student's ID (same as idUser).
     * @param idStudent
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
                instructor.setPostalCode(rs.getString("postalCode"));          
                instructor.setCity(rs.getString("city"));
                instructor.setLastModified(rs.getTimestamp("lastModified"));
                instructor.setDateCreated(rs.getTimestamp("dateCreated"));
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
    
}
