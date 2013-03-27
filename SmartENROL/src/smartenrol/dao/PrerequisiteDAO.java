/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import smartenrol.model.Prerequisite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This is the DAO class for parsing the resultset and return instance of Course.
 * @author Haijun
 */
public class PrerequisiteDAO {
    
    private static Connection conn; 
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    public PrerequisiteDAO() {
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
     * This method returns the Prerequisite object with search key "idDepartment, idCourse".
     * @param idDepartment
     * @param idCourse
     * @return Course object
     */
    public ArrayList<Prerequisite> getPrerequsiteByID(String idDepartment, int idCourse) {
        this.initConnection();
        ArrayList<Prerequisite> prereqs = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM Prerequisite WHERE idDepartment = ? AND idCourse = ?");
            ps.setString(1, idDepartment);
            ps.setInt(2, idCourse);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }
       
        // parse the resultset
        try {
            while (rs.next()) {
                prereqs.add(new Prerequisite(
                        rs.getString("idDepartment"), 
                        rs.getInt("idCourse"), 
                        rs.getString("idDepartmentPreReq"), 
                        rs.getInt("idCoursePreReq")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return prereqs;
    
    }
    
        
    /**
     * This method closes the preparedstatement. 
     */
    private void psclose() {
        try {
            ps.close();
        } catch(SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
        }
    }
}