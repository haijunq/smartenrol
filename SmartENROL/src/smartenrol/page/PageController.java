/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smartenrol.page;

import smartenrol.page.course.CoursePageController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
 
import smartenrol.page.*;
import smartenrol.page.administration.building.*;
import smartenrol.page.administration.course.*;
import smartenrol.page.administration.department.*;
import smartenrol.page.administration.faculty.*;
import smartenrol.page.administration.program.*;
import smartenrol.page.administration.section.*;
import smartenrol.page.dashboard.*;
import smartenrol.page.login.*;
import smartenrol.page.search.*;
import smartenrol.page.timetable.*;
import smartenrol.sidebar.*;

public class PageController extends AbstractController
{
   
    @FXML private BorderPane contentArea;
    @FXML private TextField searchField;
    
    @Autowired private DashboardController dashboardController;
    @Autowired private AddBuildingController addBuildingController;
    @Autowired private AddCourseController addCourseController;
    @Autowired private AddDepartmentController addDepartmentController;
    @Autowired private AddFacultyController addFacultyController;
    @Autowired private AddProgramController addProgramController;
    @Autowired private AddSectionController addSectionController;
    @Autowired private TimetableController timetableController;
    @Autowired private StudentSidebarController studentSidebarController;
    private CoursePageController coursePageController;
    @Autowired private CourseSidebarController courseSidebarController;
    @Autowired private SearchController searchController;
    
    @Autowired
    public void setCoursePageController (  CoursePageController coursePageController ){
      this.coursePageController = coursePageController;
    }
   
    @FXML
    public void navDashboard()
    {
        contentArea.setCenter(dashboardController.getView());
        contentArea.setRight(studentSidebarController.getView());
    }
    
    @FXML
    public void navAddBuilding()
    {
        contentArea.setCenter(addBuildingController.getView());
    }
 
    @FXML
    public void navAddCourse()
    {
        contentArea.setCenter(addCourseController.getView());
    }    
    
    @FXML
    public void navAddDepartment()
    {
        contentArea.setCenter(addDepartmentController.getView());
    }   
    
    @FXML
    public void navAddProgram()
    {
        contentArea.setCenter(addProgramController.getView());
    }
    
    @FXML
    public void navAddSection()
    {
        contentArea.setCenter(addSectionController.getView());
    }   
    
    @FXML
    public void navAddFaculty()
    {
        
        contentArea.setCenter(addFacultyController.getView());
        
    }
    
    @FXML
    public void navCoursePage()
    {
        coursePageController.init();
        contentArea.setCenter(coursePageController.getView());
        courseSidebarController.init();
        contentArea.setRight(courseSidebarController.getView());
        
        
    } 

    @FXML
    public void navTimetable()
    {
        contentArea.setRight(null);
        contentArea.setCenter(timetableController.getView());
        timetableController.openAgenda();
    }
    
    @FXML
    public void search() {
        contentArea.setRight(null);
        searchController.search(searchField.getText());
        contentArea.setCenter(searchController.getView());
    }
}