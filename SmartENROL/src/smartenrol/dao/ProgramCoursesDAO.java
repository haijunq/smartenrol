/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import smartenrol.model.Course;

/**
 *
 * @author Haijun
 */
public class ProgramCoursesDAO extends SmartEnrolDAO {

    public ProgramCoursesDAO() {
        super();
    }
    
    /**
     * Return a list of courses that a program is required.
     * @param idProgram
     * @return 
     * tested!
     */
    public ArrayList<Course> getCourseListByProgram(String idProgram) {
        this.initConnection();
        ArrayList<Course> courseList = new ArrayList<>(); 
        
         try {
            ps = conn.prepareStatement("SELECT c.idDepartment, c.idCourse, c.courseName, c.credits \n" +
                                    "FROM ProgramCourses pc, Course c\n" +
                                    "WHERE idProgram = ? AND required = 1 AND pc.idDepartment = c.idDepartment AND pc.idCourse = c.idCourse ");
            ps.setString(1, idProgram);

            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                courseList.add(new Course(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getFloat("credits"),
                        rs.getString("courseName")));

            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return courseList;
    }
    
     /**
     * Return a list of courses that a program is required.
     * @param idProgram
     * @return 
     * tested!
     */
    public ArrayList<Course> getRequiredCourseListByStudent(int idStudent) {
        this.initConnection();
        ArrayList<Course> courseList = new ArrayList<>(); 
        
         try {
            ps = conn.prepareStatement("SELECT c.idDepartment, c.idCourse, c.courseName, c.credits \n" +
                                    "FROM ProgramCourses pc, Course c, Student s \n" +
                                    "WHERE s.idUser = ? AND pc.required = 1 AND pc.idDepartment = c.idDepartment AND pc.idCourse = c.idCourse AND s.idProgram = pc.idProgram");
            ps.setInt(1, idStudent);

            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                courseList.add(new Course(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getFloat("credits"),
                        rs.getString("courseName")));

            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return courseList;
    }
    
    
    	/**
	 *  Adds the Prgroam Course record into the database.
	 * @param program 
	 * @return 1 if successful, 0 otherwise
	 */
	public int addProgramCourses(String idProgram, String idDepartment, int idCourse, int required) {

		this.initConnection();
		int count = 0;

        try {
            
            ps = conn.prepareStatement("INSERT INTO ProgramCourses (idProgram, idDepartment, idCourse, required) " +
										"VALUES (?, ?, ?, ?)");
            ps.setString(1, idProgram);
            ps.setString(2, idDepartment);
            ps.setInt(3, idCourse);
            ps.setInt(4, required);

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
