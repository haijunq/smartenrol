/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import smartenrol.model.Course;
import smartenrol.model.Section;
import smartenrol.model.Term;

/**
 *
 * @author Haijun
 */
public class SectionDAO extends SmartEnrolDAO {
    private Term currentTerm;
    
    public SectionDAO() {
        super();
        currentTerm = new Term();
    }
    
    /**
     * Return a list of sections for a course.
     * @param course
     * @return 
     */
    public ArrayList<Section> getSectionListByCourse(Course course) {
        this.initConnection();
        ArrayList<Section> seclist = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM Section WHERE idDepartment = ? AND idCourse = ? AND term = ? AND year = ? ");
            ps.setString(1, course.getIdDepartment());
            ps.setInt(2, course.getIdCourse());
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
                seclist.add(new Section(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getString("idSection"),
                        rs.getInt("year"),
                        rs.getString("term"),
                        rs.getString("notes"), 
                        rs.getString("type"),
                        rs.getInt("maxClassSize"),
                        rs.getInt("idInstructor")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return seclist;
    }
    
     /**
     * Return a list of sections for a course.
     * @param course
     * @return 
     */
    public ArrayList<Section> getSectionListByCourse(String idDepartment, int idCourse) {
        this.initConnection();
        ArrayList<Section> seclist = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM Section WHERE idDepartment = ? AND idCourse = ? AND term = ? AND year = ? ");
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
                seclist.add(new Section(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getString("idSection"),
                        rs.getInt("year"),
                        rs.getString("term"),
                        rs.getString("notes"), 
                        rs.getString("type"),
                        rs.getInt("maxClassSize"),
                        rs.getInt("idInstructor")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return seclist;
    }
    
    /**
     * Return a section instance by course id with section id.
     * @param idDepartment
     * @param idCourse
     * @param idSection
     * @return 
     */
    public Section getSectionByID(String idDepartment, int idCourse, String idSection) {
        this.initConnection();
        Section sec = null;
        
        try {
            ps = conn.prepareStatement("SELECT * FROM Section WHERE idDepartment = ? AND idCourse = ? AND idSection = ? AND term = ? AND year = ? ");
            ps.setString(1, idDepartment);
            ps.setInt(2, idCourse);
            ps.setString(3, idSection);
            ps.setString(4, currentTerm.getCurrentTerm());
            ps.setInt(5, currentTerm.getCurrentYear());
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                sec = new Section(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getString("idSection"),
                        rs.getInt("year"),
                        rs.getString("term"),
                        rs.getString("notes"), 
                        rs.getString("type"),
                        rs.getInt("maxClassSize"),
                        rs.getInt("idInstructor"));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return sec;
    }
}
