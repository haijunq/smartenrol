/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import smartenrol.model.Course;
import smartenrol.model.StudentSection;
import smartenrol.model.Term;

/**
 * This class is for query and update the StudentSection table. 
 * used in sectionsidebar, timetable
 * @author Haijun
 */
public class StudentSectionDAO extends SmartEnrolDAO {
    private Term currentTerm; 
    
    public StudentSectionDAO() {
        super();
        currentTerm = new Term();
    }

    /**
     * Check whether the student has already enrolled in a section. 
     * @param idStudent
     * @param idDepartment
     * @param idCourse
     * @param idSection
     * @return 0 if not enrolled, 1 if in waitlist, 2 if enrolled, -1 if connection failed.
     */
    public int isStudentEnrolledInSection(int idStudent, String idDepartment, int idCourse, String idSection) {
        this.initConnection();
        ArrayList<StudentSection> stuSecList = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM StudentSection WHERE idStudent = ? AND idDepartment = ? AND idCourse = ? AND idSection = ? AND year = ? AND term = ? ");
            ps.setInt(1, idStudent);
            ps.setString(2, idDepartment);
            ps.setInt(3, idCourse);
            ps.setString(4, idSection);
            ps.setInt(5, currentTerm.getCurrentYear());
            ps.setString(6, currentTerm.getCurrentTerm());

            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return -1;
        }
        
        // parse the resultset
        try {
            while (rs.next()) {stuSecList.add(new StudentSection(
                        rs.getInt("idStudent"), 
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getString("idSection"),
                        rs.getInt("year"),
                        rs.getString("term"),
                        rs.getInt("grade"), 
                        rs.getBoolean("onWaitlist")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return -1;
        }        
        
        this.psclose();
        
        // if no record, then not enrolled.
        if (stuSecList.size() == 0)
            return 0;
        // if onwaitlist flag is on, then return 1.
        else if (stuSecList.get(0).isOnWaitlist())
            return 1;
        // otherwise, return 2, meaning enrolled.
        else 
            return 2;
    }
    

//    public boolean isStudentEnrolledInCourse(Student currentStudent, Course currentCourse) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
//    public ArrayList<Course> getStudentCourseHistoryList(Student stu) {
//        //get year < term.year
//    }
    
//    public ArrayList<Course> getStudentPassedCourseList(Student stu) {
//        ArrayList<Course> 
//    }
    
    public ArrayList<Course> getStudentCurrentTermCourseList(int idStudent) {
        this.initConnection();
        ArrayList<Course> stuCurrentCourseList = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT cs.idDepartment, cs.idCourse, cs.courseName, cs.credits FROM StudentSection ss, Course cs WHERE idStudent = ? AND year = ? AND term = ? AND onWaitlist = 0 AND ss.idDepartment = cs.idDepartment AND ss.idCourse = cs.idCourse");
            ps.setInt(1, idStudent);
            ps.setInt(2, currentTerm.getCurrentYear());
            ps.setString(3, currentTerm.getCurrentTerm());

            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }
        
        // parse the resultset
        try {
            while (rs.next()) {stuCurrentCourseList.add(new Course(
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
        return stuCurrentCourseList;
    }
    
//    public ArrayList<Section> getStudentCurrentTermSectionList(Student stu) {
//        
//    }
    
}
