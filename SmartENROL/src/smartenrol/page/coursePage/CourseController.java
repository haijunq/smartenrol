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
    
    Course currentCourse;  //Course object contains lists of prereqs and coreqs. 
    
    /**
     * This method feeds the currentCourse attribute (currentCourse on the Course page) by calling the method from DAO class.
     * @param idDepartment 
     * @param idCourse 
     */
    public void getCourseByID(String idDepartment, int idCourse) {
        CourseDAO coursedao = new CourseDAO();
        currentCourse = coursedao.getCourseByID(idDepartment, idCourse);
    }
    
//    public void getCourseByProgram(String program) {
//        CourseDAO coursedao = new CourseDAO();
//        currentProgramCourseList = coursedao.getCourseByProgram(program);
//    }
    
    
} //end CourseController class
