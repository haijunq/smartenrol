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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.dao.BuildingDAO;


import smartenrol.page.search.*;
import smartenrol.security.*;
import smartenrol.dao.CourseDAO;
import smartenrol.dao.ProgramDAO;
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
        @FXML
        private ImageView preSearchIcon;
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
//		((CoursePageController)navigator.navigate(Page.COURSE)).load("CICS",505);
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
	public void testClassList() {
		
		navigator.navigate(Page.CLASSLIST);
	}        
        
	
	@FXML
	public void search() {
            
		Controller searchController = navigator.navigate(Page.SEARCH);
                ((SearchController)searchController).search(searchField.getText(),((String)topSearchFilterCombo.getValue()));
	}
        
        
        @FXML
        public void lastSearch()
        {
            Controller searchController = navigator.navigate(Page.SEARCH);
            ((SearchController)searchController).lastSearch();
        }
        
        
        public void setLastSearchVisible(boolean ifvisible)
        {
            preSearchIcon.setVisible(ifvisible);
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
