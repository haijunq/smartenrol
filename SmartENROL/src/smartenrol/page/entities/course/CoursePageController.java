/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.entities.course;

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
import smartenrol.page.SmartEnrolController;


/**
 * This is the Controller class for the course page showing info and pre-, co-requisite course list.
 * @author Haijun
 */
public class CoursePageController extends SmartEnrolController {
    
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
    
    public void load(String idDepartment, int idCourse) {
        
        currentCourse = new CourseDAO().getCourseByID(idDepartment, idCourse);
        fxidCourse.setText(currentCourse.toString());
        fxcourseName.setText(currentCourse.getCourseName());
        fxcredits.setText(String.valueOf(currentCourse.getCredits()));
        fxdescription.setText(currentCourse.getCourseDescription());
        
        
        currentPreReqs = new PrerequisiteDAO().getPrerequsiteCourseListByID(currentCourse.getIdDepartment(), currentCourse.getIdCourse());
        TableView<Course> pretableView = new TableView<>();
        if (currentPreReqs.size() != 0)
            pretableView = TableViewFactory.
                create(Course.class, currentPreReqs).
                selectColumns("Id Department", "Id Course", "Course Name", "Credits").
                renameColumn("Id Department", "Dept").
                renameColumn("Id Course", "Num").
                buildTableView();       
        else {
            TableColumn idDepartmentCol = new TableColumn("Dept");
            TableColumn idCourseCol = new TableColumn("Num");            
            TableColumn courseNameCol = new TableColumn("Course Name");
            TableColumn creditsCol = new TableColumn("Credits");
            pretableView.getColumns().addAll(idDepartmentCol, idCourseCol, courseNameCol, creditsCol);
        }

        pretableView.setEditable(false);        
        fxprereq.setCenter(pretableView);
        pretableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        
        currentCoReqs = new CorequisiteDAO().getCorequsiteCourseListByID(currentCourse.getIdDepartment(), currentCourse.getIdCourse());
        TableView<Course> cotableView = new TableView<>();
        if (currentCoReqs.size() != 0)
            cotableView = TableViewFactory.
                create(Course.class, currentCoReqs).
                selectColumns("Id Department", "Id Course", "Course Name", "Credits").
                renameColumn("Id Department", "Dept").
                renameColumn("Id Course", "Num").
                buildTableView();
        else {
            TableColumn idDepartmentCol = new TableColumn("Dept");
            TableColumn idCourseCol = new TableColumn("Num");            
            TableColumn courseNameCol = new TableColumn("Course Name");
            TableColumn creditsCol = new TableColumn("Credits");
            cotableView.getColumns().addAll(idDepartmentCol, idCourseCol, courseNameCol, creditsCol);
        }
        
        cotableView.setEditable(false);              
        fxcoreq.setCenter(cotableView);
        cotableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

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

    @Override
    public void init() {
        
    }
    

    
} //end CoursePageController class
