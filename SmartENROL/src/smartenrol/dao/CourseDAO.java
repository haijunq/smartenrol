
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
    private static Connection con; 
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    public CourseDAO() {
        con = null;
        ps = null;
        rs = null;
    }
    
    /**
     * Initialize a connection.
     */
    private void initConnection() {
        MySQLConnection mySQLConnection = MySQLConnection.getInstance();
        con = mySQLConnection.getConnection();
    }           
    
    /**
     * This method return the course object with primary key "deparmentID, courseNumber".
     * @param departmentID
     * @param courseNumber
     * @return Course object
     */
    public Course getCourseByID(String departmentID, int courseNumber) {
        this.initConnection();
        Course course = new Course();
        
        try {
            ps = con.prepareStatement("select * from Course where departmentID = ? AND courseNumber = ?");
            ps.setString(1, departmentID);
            ps.setInt(2, courseNumber);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                course.setDepartmentID(rs.getString("departmentID"));
                course.setCourseNumber(rs.getInt("courseNumber"));
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
            ps = con.prepareStatement("update Course set credits = ?, courseNumber = ?, courseDescription = ? where deparmentID = ? and courseNumber = ?");
            ps.setString(4,course.getDepartmentID());
            ps.setInt(5, course.getCourseNumber());
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
            ps = con.prepareStatement("insert into Course values (?, ?, ?, ?, ?)");
            ps.setString(1,course.getDepartmentID());
            ps.setInt(2, course.getCourseNumber());
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
            ps = con.prepareStatement("delete from Course where deparmentID = ? and courseNumber = ?");
            ps.setString(1,course.getDepartmentID());
            ps.setInt(2, course.getCourseNumber());
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
