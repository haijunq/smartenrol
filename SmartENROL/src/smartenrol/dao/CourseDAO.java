
package smartenrol.dao;

import smartenrol.model.Course;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This is the DAO class for the Course Table.
 * @author Haijun
 */
public class CourseDAO extends SmartEnrolDAO {

    public CourseDAO() {
        super();
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
                course.setIsRestricted(rs.getBoolean("isRestricted"));
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
                        rs.getString("courseDescription"),
                        rs.getBoolean("isRestricted")));
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
                        rs.getString("courseDescription"), 
                        rs.getBoolean("isRestricted")));

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
            ps = conn.prepareStatement("UPDATE Course SET credits = ?, courseName = ?, courseDescription = ?, isRestricted = ? WHERE idDepartment = ? AND idCourse = ?");
            ps.setString(5,course.getIdDepartment());
            ps.setInt(6, course.getIdCourse());
            ps.setFloat(1, course.getCredits());
            ps.setString(2, course.getCourseName());
            ps.setString(3, course.getCourseDescription());
            ps.setBoolean(4, course.isRestricted());
            
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
            
            ps = conn.prepareStatement("INSERT INTO Course VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1,course.getIdDepartment());
            ps.setInt(2, course.getIdCourse());
            ps.setFloat(3, course.getCredits());
            ps.setString(4, course.getCourseName());
            ps.setString(5, course.getCourseDescription());
            ps.setBoolean(6, course.isRestricted());
            
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

    /**
     * Returns a list of courses by searching keywords. 
     * @param keyword
     * @return 
     */
    public ArrayList<Course> searchCourseByKeyword(String[] keyword) {
        this.initConnection();
        ArrayList<Course> courseList = new ArrayList<>();
             
        try {
            ps = conn.prepareStatement("select * from Course where (idDepartment=? or idCourse=? or courseName LIKE ?) AND (idDepartment=? or idCourse=? or courseName LIKE ?) AND (idDepartment=? or idCourse=? or courseName LIKE ?)");
            ps.setString(1, keyword[0]);
            ps.setString(2, keyword[0]);
            ps.setString(3, "%"+keyword[0]+"%");
            ps.setString(4, keyword[1]);
            ps.setString(5, keyword[1]);
            ps.setString(6, "%"+keyword[1]+"%");
            ps.setString(7, keyword[2]);
            ps.setString(8, keyword[2]);
            ps.setString(9, "%"+keyword[2]+"%");
            
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
                        rs.getString("courseDescription"), 
                        rs.getBoolean("isRestricted")));
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
     * Check whether a course is restricted to a certain program.
     * @param idDepartment
     * @param idCourse
     * @return 
     */
    public boolean isCourseRestricted(String idDepartment, int idCourse) {
        this.initConnection();
        boolean isRestricted = false;
        
        try {
            ps = conn.prepareStatement("SELECT isRestricted FROM Course WHERE idDepartment = ? AND idCourse = ?");
            ps.setString(1, idDepartment);
            ps.setInt(2, idCourse);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
        }

        // parse the resultset
        try {
            if (rs.next()) 
                isRestricted = rs.getBoolean("isRestricted");
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
        }        
        
        this.psclose();
        return isRestricted;
    }    
    
} //end CourseDAO
