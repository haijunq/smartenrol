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
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javax.persistence.Table;
import org.javafxdata.control.TableViewFactory;
import smartenrol.page.AbstractController;


/**
 * This is the Controller class for the course page showing info and pre-, co-requisite course list.
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
    @FXML Text fxdescription;
    @FXML BorderPane fxprereq;
    @FXML BorderPane fxcoreq;
    
    @Override
    public void init () {
        
    } 
    
    public void load() {
        
        currentCourse = new CourseDAO().getCourseByID("cics", 520);
        System.out.println(currentCourse.getCourseDescription());
        fxidCourse.setText(currentCourse.toString());
        fxcourseName.setText(currentCourse.getCourseName());
        fxcredits.setText(String.valueOf(currentCourse.getCredits()));
        fxdescription.setText(currentCourse.getCourseDescription());
        
        TableView<Course> pretableView = TableViewFactory.
        create(Course.class, new PrerequisiteDAO().getPrerequsiteCourseListByID(currentCourse.getIdDepartment(), currentCourse.getIdCourse())).
        selectColumns("idDeparment", "idCourse", "courseName", "credits").
        renameColumn("Id Department", "Dept").
        renameColumn("Id Course", "Num").
        buildTableView();
        
        fxprereq.setCenter(pretableView);
        
        TableView<Course> cotableView = TableViewFactory.
        create(Course.class, new CorequisiteDAO().getCorequsiteCourseListByID(currentCourse.getIdDepartment(), currentCourse.getIdCourse())).
        selectColumns("Id Department", "Id Course", "courseName", "credits").
        renameColumn("Id Department", "Dept").
        renameColumn("Id Course", "Num").
        buildTableView();
        fxcoreq.setCenter(cotableView);
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
