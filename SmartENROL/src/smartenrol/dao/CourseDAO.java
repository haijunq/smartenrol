
package smartenrol.dao;

import smartenrol.model.Course;
import smartenrol.model.Program;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * This is the DAO class for parsing the resultset and return instance of Course.
 * @author Haijun
 */
public class CourseDAO {
    
    private static Connection conn; 
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    public CourseDAO() {
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
     * This method return the course object with primary key "deparmentID, idCourse".
     * @param idDepartment
     * @param idCourse
     * @return Course object
     */
    public Course getCourseByID(String idDepartment, int idCourse) {
        this.initConnection();
        Course course = new Course();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM Course WHERE idDepartment = ? AND idCourse = ?");
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
                course.setIdDepartment(rs.getString("idDepartment"));
                course.setIdCourse(rs.getInt("idCourse"));
                course.setCourseName(rs.getString("courseName"));
                course.setCredits(rs.getFloat("credits"));
                course.setCourseDescription(rs.getString("courseDescription"));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return course;
    }
    
//    public ArrayList<Course> getCourseByProgram(Program program) {
//        to be implemented.
//    }
   
    /**
     * This method updates a course in the database with new info.
     * @param course an instance of Course class
     * @return 1 if success
     */
    public int updateCourse(Course course) {
        this.initConnection();
        int count = 0;
        
        try {
            ps = conn.prepareStatement("UPDATE Course SET credits = ?, idCourse = ?, courseDescription = ? WHERE deparmentID = ? AND idCourse = ?");
            ps.setString(4,course.getIdDepartment());
            ps.setInt(5, course.getIdCourse());
            ps.setFloat(1, course.getCredits());
            ps.setString(2, course.getCourseName());
            ps.setString(3, course.getCourseDescription());
            
            count = ps.executeUpdate();
            this.psclose();
            return count;
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            this.psclose();
            return count;
	}
    }
    
    /**
     * This methods adds a course to the database.
     * @param course an instance of Course class
     * @return 1 if success
     */
    public int addCourse(Course course) {
        this.initConnection();
        int count = 0;
        
        try {
            
            ps = conn.prepareStatement("INSERT INTO Course VALUES (?, ?, ?, ?, ?)");
            ps.setString(1,course.getIdDepartment());
            ps.setInt(2, course.getIdCourse());
            ps.setFloat(3, course.getCredits());
            ps.setString(4, course.getCourseName());
            ps.setString(5, course.getCourseDescription());
            
            count = ps.executeUpdate();
            this.psclose();
            return count;
            
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            this.psclose();
            return count;
	}
    }
    
    /**
     * This methods deletes a course from the database.
     * @param course
     * @return 
     */
    public int removeCourse(Course course) {
        this.initConnection();
        int count = 0;
        
        try {
            ps = conn.prepareStatement("DELETE FROM Course WHERE deparmentID = ? AND idCourse = ?");
            ps.setString(1,course.getIdDepartment());
            ps.setInt(2, course.getIdCourse());
            count = ps.executeUpdate();

            this.psclose();
            return count;
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            this.psclose();
            return count;
	}
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
    
} //end CourseDAO
