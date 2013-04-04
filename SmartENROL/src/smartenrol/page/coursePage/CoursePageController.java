/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.coursePage;
/*
import java.util.ArrayList;
import javafx.scene.text.Text;
import smartenrol.dao.CorequisiteDAO;
import smartenrol.dao.CourseDAO;
import smartenrol.dao.PrerequisiteDAO;
import smartenrol.model.Course;
*/
import javafx.fxml.FXML;
import javafx.scene.Node;


/**
 *
 * @author Haijun
 */
public class CoursePageController {
    /*CourseDAO coursedao;
    PrerequisiteDAO prereqdao;
    CorequisiteDAO coreqdao;
    Course currentCourse;  //Course object contains lists of prereqs and coreqs. 
    ArrayList<Course> currentPreReqs;
    ArrayList<Course> currentCoReqs;
    Text courseTitle;
    Text courseID;
    */
    @FXML private Node view;
    /*
    public CoursePageController(String idDepartment, int idCourse) {
        coursedao = new CourseDAO();
        prereqdao = new PrerequisiteDAO();
        currentCourse = coursedao.getCourseByID(idDepartment, idCourse);       
        currentPreReqs = prereqdao.getPrerequsiteCourseListByID(idDepartment, idCourse);        
        currentCoReqs = coreqdao.getCorequsiteCourseListByID(idDepartment, idCourse);
        displayCourse();
    }
    */
    
    
//    /**
//     * This method feeds the currentCourse attributes (currentCourse on the Course page) by calling the method from DAO class.
//     * @param idDepartment 
//     * @param idCourse 
//     */
//    public void getCourseByID(String idDepartment, int idCourse) {        
//        currentCourse = coursedao.getCourseByID(idDepartment, idCourse);
//    }
    
//    public void getPrerequisiteByID(String idDepartment, int idCourse) {
//        currentPreReqs = prereqdao.getPrerequsiteByID(idDepartment, idCourse);        
//    }
    
//    /**
//     * This method adds a course record to the Course table in the database.
//     * @param newCourse new course record must have not null primary key
//     */
//    public void addCourse(Course newCourse) {
//        coursedao.addCourse(newCourse);
//    }
//    
//    /**
//     * This method updates an exsiting course (the currentCourse) with new inputs. 
//     * @param course 
//     */
//    public void updateCourse() {
//        coursedao.updateCourse(currentCourse);
//    }
//    
//    /**
//     * This method deletes an existing course (the currentCourse).
//     * @return 
//     */
//    public void removeCourse() {
//        coursedao.removeCourse(currentCourse);
//    }
    
//    public void getCourseByProgram(String program) {
//        CourseDAO coursedao = new CourseDAO();
//        currentProgramCourseList = coursedao.getCourseByProgram(program);
//    }
    
   /* 
    public Course getCurrentCourse() {
    	return this.currentCourse;
    }

    public ArrayList<Course> getCurrentPreReqs() {
        return currentPreReqs;
    }

    public ArrayList<Course> getCurrentCoReqs() {
        return currentCoReqs;
    }
    
    public void displayCourse() {
        
        courseTitle.setText(currentCourse.getCourseName());
        courseID.setText(currentCourse.toString());
   
    }
    */
    public Node getView()
    {
        return view;
    }    
    
} //end CoursePageController class
