/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smartenrol.page;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import smartenrol.page.course.CoursePageController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
 
import smartenrol.page.*;
import smartenrol.page.administration.building.*;
import smartenrol.page.administration.course.*;
import smartenrol.page.administration.department.*;
import smartenrol.page.administration.faculty.*;
import smartenrol.page.administration.program.*;
import smartenrol.page.administration.section.*;
import smartenrol.page.dashboard.*;
import smartenrol.page.login.LoginController;
import smartenrol.page.myProgram.MyProgramPageController;
import smartenrol.page.myprofile.MyProfileController;
import smartenrol.page.search.*;
import smartenrol.page.timetable.*;
import smartenrol.security.UserSession;
import smartenrol.sidebar.*;
import smartenrol.dao.CourseDAO;
import smartenrol.model.Course;
public class PageController extends AbstractController
{
   
    @FXML private BorderPane contentArea;
    @FXML private TextField searchField;
    
    @FXML private ImageView dashboardIcon;
    @FXML private ImageView myProfileIcon;
    @FXML private ImageView timetableIcon;
    @FXML private ImageView myProgramIcon;
    @FXML private ImageView universalSearchIcon;
    @FXML private Text welcomeText;
    
    private final CourseDAO coursedao = new CourseDAO();
    @Autowired private DashboardController dashboardController;
    @Autowired private AddBuildingController addBuildingController;
    @Autowired private AddCourseController addCourseController;
    @Autowired private AddDepartmentController addDepartmentController;
    @Autowired private AddFacultyController addFacultyController;
    @Autowired private AddProgramController addProgramController;
    @Autowired private AddSectionController addSectionController;
    @Autowired private TimetableController timetableController;
    @Autowired private StudentSidebarController studentSidebarController;
    @Autowired private InstructorSidebarController instructorSidebarController;
    @Autowired private AdministratorSidebarController administratorSidebarController;
    @Autowired private CoursePageController coursePageController;
    @Autowired private CourseSidebarController courseSidebarController;
    @Autowired private SearchController searchController;
    @Autowired private LoginController loginController;
    @Autowired private MyProgramPageController myProgramPageController;
    @Autowired private MyProfileController myProfileController;

    public void init() {
        if (UserSession.getInstance().isSignedIn()) {
            welcomeText.setText("Welcome back, "+getUserSession().getCurrentUser().getFullName());
        }
    
    }
    
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
    public void loadProfile()
    {
        contentArea.setCenter(myProfileController.getView());
        myProfileController.loadProfile();
    }
	/*	switch (getUserSession().getCurrentUser().getUsertype()) {

			case "Student":
				contentArea.setRight(studentSidebarController.getView());
				break;
			case "Instructor":
				contentArea.setRight(instructorSidebarController.getView());
				break;
			case "Administrator":
				contentArea.setRight(administratorSidebarController.getView());
				break;
    	}*/

    
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
//        coursePageController = new CoursePageController("cics", 520);
        coursePageController.init();
        contentArea.setCenter(coursePageController.getView());
        courseSidebarController.load(coursedao.getCourseByID("CICS",520));
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
    public void navMyProgramPage()
    {
        contentArea.setCenter(myProgramPageController.getView());
    }
    
    @FXML
    public void dashboardIconOnHover() {
        dashboardIcon.setImage(new Image("../images/se-dashboard-icon-hit.png"));
    }
    
    @FXML
    public void search() {
        contentArea.setRight(null);
        searchController.search(searchField.getText());
        contentArea.setCenter(searchController.getView());
    }
    
    @FXML
    public void logout() {
    }
//<<<<<<< HEAD
    @FXML
public void showFaq(ActionEvent event)
{
String link="http://www.smartenrol.ca";
        try {
            Desktop.getDesktop().browse(URI.create(link));
        } catch (IOException ex) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
        @FXML
public void showAbout(ActionEvent event)
{
String link="http://www.smartenrol.ca";
        try {
            Desktop.getDesktop().browse(URI.create(link));
        } catch (IOException ex) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
            @FXML
public void showManual(ActionEvent event)
{
String link="http://www.smartenrol.ca";
        try {
            Desktop.getDesktop().browse(URI.create(link));
        } catch (IOException ex) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
//}
//
