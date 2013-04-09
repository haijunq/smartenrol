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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import jfxtras.labs.dialogs.MonologFX;
import jfxtras.labs.dialogs.MonologFXBuilder;
import jfxtras.labs.dialogs.MonologFXButton;
import jfxtras.labs.dialogs.MonologFXButtonBuilder;
import org.javafxdata.control.TableViewFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
import smartenrol.model.ProgramSearchResult;
import smartenrol.page.elements.dialog.ConfirmDialog;

public class PageController extends SmartEnrolController
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
                        loadSidebar();
                }
		
	}
	
	@Autowired
	public void setCoursePageController (  CoursePageController coursePageController ){
		this.coursePageController = coursePageController;
	}
	
	@FXML
	public void navDashboard()
	{
		inject(contentArea,dashboardController,null);
	}

	@FXML
	public void loadProfile()
	{
		inject(contentArea,myProfileController,null);
		myProfileController.loadProfile();
	}
	
	@FXML
	public void navAddBuilding()
	{
		inject(contentArea,addBuildingController,null);
	}
	
	@FXML
	public void navAddCourse()
	{
		
		inject(contentArea,addCourseController,null);
	}
	
	@FXML
	public void navAddDepartment()
	{
		inject(contentArea,addDepartmentController,null);
	}
	
	@FXML
	public void navAddProgram()
	{
		inject(contentArea,addProgramController,null);
	}
	
	@FXML
	public void navAddSection()
	{
		inject(contentArea,addSectionController,null);
	}
	
	@FXML
	public void navAddFaculty()
	{
		
		inject(contentArea,addFacultyController,null);
		
	}
	
	@FXML
	public void navCoursePage()
	{       
             inject(contentArea,coursePageController,courseSidebarController);
             courseSidebarController.load(coursedao.getCourseByID("CICS",520));
	}
	
	@FXML
	public void navTimetable()
	{
		inject(contentArea,timetableController,null);
	}
	
	@FXML
	public void navMyProgramPage()
	{
		inject(contentArea,myProgramPageController,null);
	}
	
	@FXML
	public void dashboardIconOnHover() {
		dashboardIcon.setImage(new Image("smartenrol/images/se-icon-dashboard-hit.png"));
	}
	
	@FXML
	public void search() {
		searchController.search(searchField.getText());
		inject(contentArea,searchController,null);
	}
	
	@FXML
	public void logout() {
	}
	
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
	
	public void loadSidebar() {
                if (UserSession.getInstance().isSignedIn()) {
                    switch (getUserSession().getCurrentUser().getUsertype()) {

                            case "Student":
                                    contentArea.setRight(studentSidebarController.getView());
                                    break;
                            case "Instructor":
                                    contentArea.setRight(instructorSidebarController.getView());
                                    break;
                            case "Administrator":
                                    contentArea.setRight(administratorSidebarController.getView());
                                    break;
                    }
                }
	}
}
