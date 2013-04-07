/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.course;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.text.Text;
import smartenrol.dao.CorequisiteDAO;
import smartenrol.dao.CourseDAO;
import smartenrol.dao.PrerequisiteDAO;
import smartenrol.model.Course;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javax.persistence.Table;
import smartenrol.page.AbstractController;


/**
 *
 * @author Haijun
 */
public class CoursePageController extends AbstractController {
    CourseDAO coursedao;
    PrerequisiteDAO prereqdao;
    CorequisiteDAO coreqdao;
    Course currentCourse;  //Course object contains lists of prereqs and coreqs. 
    ArrayList<Course> currentPreReqs;
    ArrayList<Course> currentCoReqs;

    
    
    @FXML Text fxidCourse;
    @FXML Text fxcourseName;
    @FXML Text fxcredits;
    @FXML TextArea fxdescription;
    @FXML TableView<Table> fxprereq;
//    @FXML TableView<Table> fxcoreq;
    
    @FXML TableColumn<Table, String> fxpidDepartment;
    @FXML TableColumn<Table, Integer> fxpidCourse;
    @FXML TableColumn<Table, String> fxpcourseName;
    @FXML TableColumn<Table, String> fxpcredits;
    
    final ObservableList<Table> prereqTable = FXCollections.observableArrayList();
    
    @FXML
    public void init (String idDepartment, Integer idCourse) {
        currentCourse = new CourseDAO().getCourseByID(idDepartment, idCourse);
        fxidCourse.setText(currentCourse.toString());
        fxcourseName.setText(currentCourse.getCourseName());
        fxcredits.setText(String.valueOf(currentCourse.getCredits()));
        fxdescription.setText(currentCourse.getCourseDescription());
        
        
        
//        for (Course c : new PrerequisiteDAO().getPrerequsiteCourseListByID("cics", 520))
//            prereqTable.add(new Table(c.getIdDepartment(), c.getIdCourse(), c.getCourseName(), c.getCredits()));
    } 
    
    
//    public CoursePageController(String idDepartment, int idCourse) {
//        coursedao = new CourseDAO();
//        prereqdao = new PrerequisiteDAO();
//        currentCourse = coursedao.getCourseByID(idDepartment, idCourse);       
//        currentPreReqs = prereqdao.getPrerequsiteCourseListByID(idDepartment, idCourse);        
//        currentCoReqs = coreqdao.getCorequsiteCourseListByID(idDepartment, idCourse);
//        
//    }
//    
    
    

//    /** This method feeds the currentCourse attributes (currentCourse on the Course page) by calling the method from DAO class.
//     * @param idDepartment 
//     * @param idCourse 
//     */
//    public void getCourseByID(String idDepartment, int idCourse) {        
//        currentCourse = coursedao.getCourseByID(idDepartment, idCourse);
//    }
//    
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
    
//    /**
//     * This method updates an exsiting course (the currentCourse) with new inputs. 
//     * @param course 
//     */
//    public void updateCourse() {
//        coursedao.updateCourse(currentCourse);
//    }
    
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
    

    public Course getCurrentCourse() {
    	return this.currentCourse;
    }

    public ArrayList<Course> getCurrentPreReqs() {
        return currentPreReqs;
    }

    public ArrayList<Course> getCurrentCoReqs() {
        return currentCoReqs;
    }
    

    
} //end CoursePageController class
