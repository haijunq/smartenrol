/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import smartenrol.model.Corequisite;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import smartenrol.model.Course;

/**
 * This is the DAO class for Corequisite table.
 * @author Haijun
 */

public class CorequisiteDAO extends SmartEnrolDAO {
    
    public CorequisiteDAO() {
        super();
    }
    
    /**
     * This method returns a list of corequisite courses for the course "idDepartment, idCourse".
     * @param idDepartment
     * @param idCourse
     * @return list of corequisite courses
     * Passed test!
     */
    public ArrayList<Course> getCorequsiteCourseListByID(String idDepartment, int idCourse) {
        this.initConnection();
        CourseDAO coursedao = new CourseDAO();
        ArrayList<Course> coreqCourseList = new ArrayList<>();
        ArrayList<Corequisite> coreqs = this.getCorequsiteByID(idDepartment, idCourse);
        
        for (Iterator<Corequisite> it = coreqs.iterator(); it.hasNext();) {
            Corequisite creq = it.next();
            coreqCourseList.add(coursedao.getCourseByID(creq.getIdDepartmentCoReq(), creq.getIdCourseCoReq()));
        }
        
        return coreqCourseList;    
    }
    
    /**
     * This method returns the Corequisite object with search key "idDepartment, idCourse".
     * @param idDepartment
     * @param idCourse
     * @return Course object
     * JUnit test passed!
     */
    public ArrayList<Corequisite> getCorequsiteByID(String idDepartment, int idCourse) {
        this.initConnection();
        ArrayList<Corequisite> coreqs = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM Corequisite WHERE idDepartment = ? AND idCourse = ?");
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
                coreqs.add(new Corequisite(
                        rs.getString("idDepartment"), 
                        rs.getInt("idCourse"), 
                        rs.getString("idDepartmentCoReq"), 
                        rs.getInt("idCourseCoReq")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return coreqs;
    
    }
    
    
	/**
	 * Adds a corequisite
	 * @param coreq  composed of a key course and its corresponding corequisite course
	 * @return 	1 if successful
	 */

	public int addCorequisite(Corequisite coreq) {
		this.initConnection();
		int count = 0;

        try {
            ps = conn.prepareStatement("INSERT INTO Corequisite VALUES (?, ?, ?, ?)");
            ps.setString(1, coreq.getIdDepartment());
            ps.setInt(2, coreq.getIdCourse());
            ps.setString(3, coreq.getIdDepartmentCoReq());
            ps.setInt(4, coreq.getIdCourseCoReq());

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
