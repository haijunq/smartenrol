/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import smartenrol.model.Course;
import smartenrol.model.Section;
import smartenrol.model.Student;

/**
 * This class is for query and update the StudentSection table. 
 * used in sectionsidebar, timetable
 * @author Haijun
 */
public class StudentSectionDAO {
        
    private static Connection conn; 
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    public StudentSectionDAO() {
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

    public boolean isStudentEnrolledInSection(Student currentStudent, Section currentSelectedSection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isStudentEnrolledInCourse(Student currentStudent, Course currentCourse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    public ArrayList<Course> getStudentCourseHistoryList(Student stu) {
//        //get year < term.year
//    }
//    
//    public ArrayList<Course> getStudentPassedCourseList(Student stu) {
//        ArrayList<Course> 
//    }
//    
//    public ArrayList<Course> getStudentCurrentTermCourseList(Student stu) {
//        
//    }
//    
//    public ArrayList<Section> getStudentCurrentTermSectionList(Student stu) {
//        
//    }
    
}
