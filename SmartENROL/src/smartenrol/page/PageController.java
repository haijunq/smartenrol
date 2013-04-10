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
import smartenrol.page.entities.department.DepartmentPageController;
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
	
	@FXML
	public void navDashboard()
	{   
		navigator.navigate(Page.DASHBOARD);
          
	}
	
	@FXML
	public void navMyProfile()
	{
                navigator.navigate(Page.MY_PROFILE);
	}
        
	@FXML
	public void navUpdateProfile()
	{
                navigator.navigate(Page.UPDATE_PROFILE);
	}
	@FXML
	public void navAddBuilding()
	{
		navigator.navigate(Page.ADD_BUILDING);
	}
	
	@FXML
	public void navAddCourse()
	{
		navigator.navigate(Page.ADD_COURSE);
	}
	
	@FXML
	public void navAddDepartment()
	{
		navigator.navigate(Page.ADD_DEPARTMENT);
	}
	
	@FXML
	public void navAddProgram()
	{
		navigator.navigate(Page.ADD_PROGRAM);
	}
	
	@FXML
	public void navAddSection()
	{
		navigator.navigate(Page.ADD_SECTION);
	}
	
	@FXML
	public void navAddFaculty()
	{
		navigator.navigate(Page.ADD_FACULTY);
	}
	
	@FXML
	public void navCoursePage()
	{
		Controller course = navigator.navigate(Page.COURSE);
                ((CoursePageController) course).load("CICS",505);

	}
	
	@FXML
	public void navTimetable()
	{
		navigator.navigate(Page.TIMETABLE);
	}
	
	@FXML
	public void navMyProgramPage()
	{
		navigator.navigate(Page.MY_PROGRAM);
	}
	
	@FXML
	public void dashboardIconOnHover() {
		dashboardIcon.setImage(new Image("/smartenrol/images/se-icon-dashboard-hit.png"));
	}
	
	@FXML
	public void testOpenProgram() {
		
		navigator.navigate(Page.PROGRAM);
	}
	
	@FXML
	public void testOpenBuilding() {
		
		navigator.navigate(Page.BUILDING);
	}

	@FXML
	public void testOpenDepartment() {
		
		navigator.navigate(Page.DEPARTMENT);
	}        
        
	
	@FXML
	public void search() {
            
		Controller searchController = navigator.navigate(Page.SEARCH);
                ((SearchController)searchController).search(searchField.getText(),((String)topSearchFilterCombo.getValue()));
	}
	
	@FXML
	public void logout() {
            ConfirmDialog logout;
            logout = new ConfirmDialog("Logout of SmartENROL",
                                             "Are you sure you want to log out of SmartEnrol?");
            navigator.navigate(Page.LOGIN);
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
    @Override
    public void load() {

    }	
}
