/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import smartenrol.model.Prerequisite;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import smartenrol.model.Course;

/**
 * This is the DAO class for Prerequisite table.
 * @author Haijun
 */
public class PrerequisiteDAO extends SmartEnrolDAO {
    
    public PrerequisiteDAO() {
        super();
    }
    
    /**
     * This method returns a list of prerequisite courses for the course "idDepartment, idCourse".
     * @param idDepartment
     * @param idCourse
     * @return list of prerequisite courses
     * Tested!
     */
    public ArrayList<Course> getPrerequsiteCourseListByID(String idDepartment, int idCourse) {
        this.initConnection();
        CourseDAO coursedao = new CourseDAO();
        ArrayList<Course> prereqCourseList = new ArrayList<>();
        ArrayList<Prerequisite> prereqs = this.getPrerequsiteByID(idDepartment, idCourse);
        
        for (Iterator<Prerequisite> it = prereqs.iterator(); it.hasNext();) {
            Prerequisite preq = it.next();
            prereqCourseList.add(coursedao.getCourseByID(preq.getIdDepartmentPreReq(), preq.getIdCoursePreReq()));
        }
        
        return prereqCourseList;    
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
	 * Adds Prerequisites 
	 * @param prereq  composed of a key course and its corresponding prerequisite course
	 * @return 	1 if successful
	 */

	public int addPrerequisite(Prerequisite prereq) {
		this.initConnection();
		int count = 0;

        try {
            ps = conn.prepareStatement("INSERT INTO Prerequisite VALUES (?, ?, ?, ?)");
            ps.setString(1, prereq.getIdDepartment());
            ps.setInt(2, prereq.getIdCourse());
            ps.setString(3, prereq.getIdDepartmentPreReq());
            ps.setInt(4, prereq.getIdCoursePreReq());

		    System.out.println(ps.toString()) ;
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