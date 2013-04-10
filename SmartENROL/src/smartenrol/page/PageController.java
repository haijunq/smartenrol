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
import smartenrol.page.entities.course.CoursePageController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javax.annotation.PostConstruct;
import jfxtras.labs.dialogs.MonologFX;
import jfxtras.labs.dialogs.MonologFXBuilder;
import jfxtras.labs.dialogs.MonologFXButton;
import jfxtras.labs.dialogs.MonologFXButtonBuilder;
import org.javafxdata.control.TableViewFactory;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.dao.BuildingDAO;

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
import smartenrol.security.*;
import smartenrol.sidebar.*;
import smartenrol.dao.CourseDAO;
import smartenrol.dao.ProgramDAO;
import smartenrol.model.ProgramSearchResult;
import smartenrol.model.User;
import smartenrol.page.elements.dialog.ConfirmDialog;
import smartenrol.page.entities.building.BuildingPageController;
import smartenrol.page.entities.program.ProgramPageController;
import smartenrol.page.myprofile.UpdateProfileController;

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
	@FXML private ComboBox topSearchFilterCombo;
	
	private final CourseDAO coursedao = new CourseDAO();
	private final ProgramDAO programdao = new ProgramDAO();
	private final BuildingDAO buildingdao = new BuildingDAO();
        @Autowired private Navigator navigator;
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
        @Autowired private UpdateProfileController updateProfileController;
	@Autowired private ProgramPageController programPageController;
	@Autowired private BuildingPageController buildingPageController;

        public BorderPane getInternalView() {
            return contentArea;
        }
        
	public void init() {
		if (UserSession.getInstance().isSignedIn()) {
			welcomeText.setText("Welcome back, "+getUserSession().getCurrentUser().getFullName());
			navDashboard();
		}
		topSearchFilterCombo.getSelectionModel().selectFirst();
		
	}
        
        @Autowired
        public BorderPane getContentArea() {
            return contentArea;
        }
	
	@Autowired
	public void setCoursePageController (  CoursePageController coursePageController ){
		this.coursePageController = coursePageController;
	}
	
	@FXML
	public void navDashboard()
	{   
                
		navigator.navigateInternal(this,dashboardController);
	}
	
	@FXML
	public void navMyProfile()
	{

		navigator.navigateInternal(this,myProfileController);
	}
	@FXML
	public void navUpdateProfile()
	{

		navigator.navigateInternal(this,updateProfileController);
	}
	@FXML
	public void navAddBuilding()
	{
		navigator.navigateInternal(this,addBuildingController);
	}
	
	@FXML
	public void navAddCourse()
	{
		
		navigator.navigateInternal(this,addCourseController);
	}
	
	@FXML
	public void navAddDepartment()
	{
		navigator.navigateInternal(this,addDepartmentController);
	}
	
	@FXML
	public void navAddProgram()
	{
		navigator.navigateInternal(this,addProgramController);
	}
	
	@FXML
	public void navAddSection()
	{
		navigator.navigateInternal(this,addSectionController);
	}
	
	@FXML
	public void navAddFaculty()
	{
		
		navigator.navigateInternal(this,addFacultyController);
		
	}
	
	@FXML
	public void navCoursePage()
	{
		navigator.navigateInternal(this,coursePageController);
//		courseSidebarController.load("CICS",520);
	}
	
	@FXML
	public void navTimetable()
	{
		navigator.navigateInternal(this,timetableController);
	}
	
	@FXML
	public void navMyProgramPage()
	{
		navigator.navigateInternal(this,myProgramPageController);
	}
	
	@FXML
	public void dashboardIconOnHover() {
		dashboardIcon.setImage(new Image("/smartenrol/images/se-icon-dashboard-hit.png"));
	}
	
	@FXML	// for temporary testing; free to modify it
	public void testOpenProgram() {
		
		navigator.navigateInternal(this, programPageController);
		programPageController.loadProgram(programdao.getProgrambyID("MSS"));
	}
	
	@FXML	// for temporary testing; free to modify it
	public void testOpenBuilding() {
		
		navigator.navigateInternal(this, buildingPageController);
		buildingPageController.load("CICS");
	}

	@FXML	// for temporary testing; free to modify it
	public void testOpenDepartment() {
		
		navigator.navigateInternal(this, buildingPageController);
		buildingPageController.load("CICS");
	}        
        
	
	@FXML
	public void search() {
		searchController.search(searchField.getText(),((String)topSearchFilterCombo.getValue()));
		navigator.navigateInternal(this,searchController);
	}
	
	@FXML
	public void logout() {
            ConfirmDialog logout;
            logout = new ConfirmDialog("Logout of SmartENROL",
                                             "Are you sure you want to log out of SmartEnrol?");
            navigator.navigate(loginController);
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
	
	public Controller defaultSidebar() {
            User.Type usertype = getUserSession().getCurrentUser().getUsertype();
                
                if (getUserSession().isSignedIn()) {
                    
                    if (usertype == User.Type.INSTRUCTOR) {
                        return instructorSidebarController;
                    } else if (usertype == User.Type.ADMINISTRATOR) {
                        return administratorSidebarController;
                    } else {
                        return studentSidebarController;
                    }
                    
                } else {
                    return null;
                }
            
	}
}
