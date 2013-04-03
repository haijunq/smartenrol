
package smartenrol.dao;

import smartenrol.model.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This is the DAO class for the Course Table.
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
    
    public boolean isCourseInProgram(String idDepartment, int idCourse, String idProgram) {
        this.initConnection();
            
        try {
            ps = conn.prepareStatement("SELECT COUNT(*) FROM ProgramCourses WHERE idDepartment = ? AND idCourse = ? AND idProgram = ?");
            ps.setString(1, idDepartment);
            ps.setInt(2, idCourse);
            ps.setString(3, idProgram);
            rs = ps.executeQuery();
            while(rs.next()) {
            if (rs.getInt("COUNT(*)") == 0)
                return false; 
            else 
                return true;
            }
            
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
        }
        return false;
    }
    
    
    /**
     * This method return the course object with primary key "idDepartment, idCourse".
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
    
    /**
     * Return a list of courses whose courseName contains the String name.
     * @param name
     * @return Arraylist of courses
     */
    public ArrayList<Course> getCourseByName(String name) {
        this.initConnection();
        ArrayList<Course> courseList = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM Course WHERE courseName LIKE ? ");
            ps.setString(1, "%" + name + "%");
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
                        rs.getString("courseName"),
                        rs.getString("courseDescription")));
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
     * This method returns a list of courses whose level is between level and level + 100.
     * @param idDepartment
     * @param level
     * @return 
     */
    public ArrayList<Course> getCourseByLevel(String idDepartment, int level) {
        this.initConnection();
        ArrayList<Course> courseList = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM Course WHERE idDepartment = ? AND idCourse >= ? AND idCourse < (? +100) ");
            ps.setString(1, idDepartment);
            ps.setInt(2, level);
            ps.setInt(3, level);
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
                        rs.getString("courseName"),
                        rs.getString("courseDescription")));
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
     * This method updates a course in the database with new info.
     * @param course an instance of Course class
     * @return 1 if success
     */
    public int updateCourse(Course course) {
        this.initConnection();
        int count = 0;
        
        try {
            ps = conn.prepareStatement("UPDATE Course SET credits = ?, courseName = ?, courseDescription = ? WHERE idDepartment = ? AND idCourse = ?");
            ps.setString(4,course.getIdDepartment());
            ps.setInt(5, course.getIdCourse());
            ps.setFloat(1, course.getCredits());
            ps.setString(2, course.getCourseName());
            ps.setString(3, course.getCourseDescription());
            
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
            return count;
	}
    }
    
    /**
     * This methods adds a course to the database.
     * @param course an instance of Course class
     * @return 1 if success
     * Tested!
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
    
    /**
     * This methods deletes a course from the database.
     * @param course
     * @return 
     */
    public int removeCourse(Course course) {
        this.initConnection();
        int count = 0;
        
        try {
            ps = conn.prepareStatement("DELETE FROM Course WHERE idDepartment = ? AND idCourse = ?");
            ps.setString(1,course.getIdDepartment());
            ps.setInt(2, course.getIdCourse());
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
            return count;
	}
    }
    
        public ArrayList<Course> searchCourseByKeyword(String[] keyword) {
        this.initConnection();
        ArrayList<Course> courseList = new ArrayList<>();
             
        try {
            ps = conn.prepareStatement("select * from Course where (idDepartment=? or idCourse=? or courseName LIKE ?) AND (idDepartment=? or idCourse=? or courseName LIKE ?) AND (idDepartment=? or idCourse=? or courseName LIKE ?)");
            ps.setString(1, keyword[0]);
            ps.setString(2, keyword[0]);
            ps.setString(3, keyword[0]);
            ps.setString(4, keyword[1]);
            ps.setString(5, keyword[1]);
            ps.setString(6, keyword[1]);
            ps.setString(7, keyword[2]);
            ps.setString(8, keyword[2]);
            ps.setString(9, keyword[2]);
            
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
                        rs.getString("courseName"),
                        rs.getString("courseDescription")));
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
