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
    
    
}
