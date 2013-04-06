/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.joda.time.LocalTime;
import smartenrol.model.Course;
import smartenrol.model.Section;
import smartenrol.model.SectionNode;
import smartenrol.model.Term;

/**
 *
 * @author Haijun
 */
public class SectionNodeDAO {
    private static Connection conn; 
    private static PreparedStatement ps;
    private static ResultSet rs;
    private Term currentTerm;
    
    public SectionNodeDAO() {
        conn = null;
        ps = null;
        rs = null;
        currentTerm = new Term();
    }
    
    /**
     * Initialize a connection.
     */
    private void initConnection() {
        MySQLConnection mySQLConnection = MySQLConnection.getInstance();
        conn = mySQLConnection.getConnection();
    }           
        
    /**
     * This method closes the preparedstatement. 
     */
    private void psclose() {
        try {
            if (rs!=null)
                rs.close();
            ps.close();
        } catch(SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
        }
    }
    
    // todo:return a list of sectionNode for a student.
    
    /**
     * Return a list of sectionNodes for a course of current term.
     * @param idDepartment
     * @param idCourse
     * @return 
     */
    public ArrayList<SectionNode> getSectionNodeByCourse(String idDepartment, int idCourse) {
        this.initConnection();
        ArrayList<SectionNode> secNodeList = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM SectionNode WHERE idDepartment = ? AND idCourse = ? AND term = ? AND year = ? ");
            ps.setString(1, idDepartment);
            ps.setInt(2, idCourse);
            ps.setString(3, currentTerm.getCurrentTerm());
            ps.setInt(4, currentTerm.getCurrentYear());
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                secNodeList.add(new SectionNode(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getString("idSection"),
                        rs.getInt("year"),
                        rs.getString("term"),
                        rs.getInt("day"), 
                        new LocalTime(rs.getString("startTime")),
                        new LocalTime(rs.getString("endTime")),
                        rs.getString("idLocation"),
                        rs.getString("idRoom")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return secNodeList;
    }
    
    /**
     * Return a list of sectionNodes for a classroom.
     * @param idDepartment
     * @param idCourse
     * @return 
     */
    public ArrayList<SectionNode> getSectionNodeByClassRoom(String idLocation, String idRoom) {
        this.initConnection();
        ArrayList<SectionNode> secNodeList = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM SectionNode WHERE idLocation = ? AND idRoom = ? ");
            ps.setString(1, idLocation);
            ps.setString(2, idRoom);

            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                secNodeList.add(new SectionNode(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getString("idSection"),
                        rs.getInt("year"),
                        rs.getString("term"),
                        rs.getInt("day"), 
                        new LocalTime(rs.getString("startTime")),
                        new LocalTime(rs.getString("endTime")),
                        rs.getString("idLocation"),
                        rs.getString("idRoom")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return secNodeList;
    }

    /**
     * Return a list of SectionNode of a section. 
     * @param idDepartment
     * @param idCourse
     * @param idSection
     * @return 
     */
    public ArrayList<SectionNode> getSectionNodeListBySection(String idDepartment, int idCourse, String idSection) {
        this.initConnection();
        ArrayList<SectionNode> secNodeList = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM SectionNode WHERE idDepartment = ? AND idCourse = ? AND term = ? AND year = ? AND idSection = ?");
            ps.setString(1, idDepartment);
            ps.setInt(2, idCourse);
            ps.setString(3, currentTerm.getCurrentTerm());
            ps.setInt(4, currentTerm.getCurrentYear());
            ps.setString(5, idSection);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                secNodeList.add(new SectionNode(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getString("idSection"),
                        rs.getInt("year"),
                        rs.getString("term"),
                        rs.getInt("day"), 
                        new LocalTime(rs.getString("startTime")),
                        new LocalTime(rs.getString("endTime")),
                        rs.getString("idLocation"),
                        rs.getString("idRoom")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return secNodeList;
    }
}
