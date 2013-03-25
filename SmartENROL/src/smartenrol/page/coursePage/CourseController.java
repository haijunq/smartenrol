/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.coursePage;

import java.util.ArrayList;
import smartenrol.dao.CourseDAO;
import smartenrol.model.Course;

/**
 *
 * @author Haijun
 */
public class CourseController {
    
    Course currentCourse; 
    ArrayList<Course> currentProgramCourseList;
    
    /**
     * This method feeds the currentCourse attribute (currentCourse on the Course page) by calling the method from DAO class.
     * @param departmentID 
     * @param courseNumber 
     */
    public void getCourseByID(String departmentID, int courseNumber) {
        CourseDAO coursedao = new CourseDAO();
        currentCourse = coursedao.getCourseByID(departmentID, courseNumber);
    }
    
//    public void getCourseByProgram(String program) {
//        CourseDAO coursedao = new CourseDAO();
//        currentProgramCourseList = coursedao.getCourseByProgram(program);
//    }
    
    
} //end CourseController class
