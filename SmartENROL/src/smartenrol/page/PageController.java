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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.dao.BuildingDAO;


import smartenrol.page.search.*;
import smartenrol.security.*;
import smartenrol.dao.CourseDAO;
import smartenrol.dao.ProgramDAO;
import smartenrol.model.User;
import smartenrol.page.elements.dialog.ConfirmDialog;
import smartenrol.page.elements.icons.Icon;
import smartenrol.page.elements.icons.IconFactory;

public class PageController extends SmartEnrolController
{
	
	@FXML private BorderPane contentArea;
	@FXML private TextField searchField;
	
	@FXML private HBox icon2Holder, icon3Holder, icon4Holder, icon1Holder;
        @FXML private Label icon1Text, icon2Text, icon3Text, icon4Text;
        
        private IconFactory icons;
        private Icon icon1,icon2,icon3,icon4;
        
	@FXML private ImageView universalSearchIcon;
        @FXML private ImageView preSearchIcon;
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
                
                initIcons();
                
		if (UserSession.getInstance().isSignedIn()) {
			welcomeText.setText(getUserSession().getCurrentUser().getFullName()+", Master of Software Systems");
			navDashboard();
                        
                        if (UserSession.getInstance().getCurrentUser().getUsertype()==User.Type.ADMINISTRATOR) {
                            initAdministrator();
                        } else if (UserSession.getInstance().getCurrentUser().getUsertype()==User.Type.INSTRUCTOR) {
                            initInstructor();
                        } else {
                            initStudent();
                        }
		}
                
		topSearchFilterCombo.getSelectionModel().selectFirst();

        }
        
        public void initIcons() {
            
            icons = new IconFactory();
            
            icon1Holder.getChildren().remove(icon1);
            icon2Holder.getChildren().remove(icon2);
            icon3Holder.getChildren().remove(icon3);
            icon4Holder.getChildren().remove(icon4);
            
            icon1 = icons.getIcon(IconFactory.IconType.DASHBOARD);
            icon1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent me) {
                            navDashboard();
                        }
            });
            icon1Text.setText("DASHBOARD");
            icon1Holder.getChildren().add(icon1);
            
            icon2 = icons.getIcon(IconFactory.IconType.MY_PROFILE);
            icon2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent me) {
                            navMyProfile();
                        }
            });
            icon2Text.setText("MY PROFILE");
            icon2Holder.getChildren().add(icon2);
            
            icon3Text.setText("");
            icon4Text.setText("");
            
        }
        
        public void initStudent() {
            icon3 = icons.getIcon(IconFactory.IconType.MY_PROGRAM);
            icon3.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent me) {
                            navMyProgramPage();
                        }
            });
            icon3Text.setText("MY PROGRAM");
            icon3Holder.getChildren().add(icon3);
            
            icon4 = icons.getIcon(IconFactory.IconType.TIMETABLE);
            icon4.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent me) {
                            navTimetable();
                        }
            });
            icon4Text.setText("TIMETABLE");
            icon4Holder.getChildren().add(icon4);
        }
        
        public void initInstructor() {
            icon3 = icons.getIcon(IconFactory.IconType.TIMETABLE);
            icon3.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent me) {
                            navTimetable();
                        }
            });
            icon3Text.setText("TIMETABLE");
            icon3Holder.getChildren().add(icon3);
        }
        
        public void initAdministrator() {
            icon3 = icons.getIcon(IconFactory.IconType.ACTIVITY_HISTORY);
            icon3.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent me) {
                            //navActivityHistory();
                        }
            });
            icon3Text.setText("ACTIVITY HISTORY");
            icon3Holder.getChildren().add(icon3);
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
