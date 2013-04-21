/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.sidebar;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.model.User;
import smartenrol.page.Controller;
import smartenrol.page.Navigator;
import smartenrol.page.SmartEnrolController;
import smartenrol.page.search.SearchController;

/**
 *
 * @author Jeremy
 */
public class UserSidebarController extends SmartEnrolController {

        private String searchType;
        
        @Autowired
        private Navigator navigator;
        
        @FXML
        private TextField search;
        
        @FXML
        private ListView list;

        @FXML
        private Text listTitle, sideTextTitle, sideTextLink, sideTextContent; 
        
        public void init() {
                User.Type usertype = getUserSession().getCurrentUser().getUsertype();
                if (getUserSession().isSignedIn()) {
                    
                    if (usertype == User.Type.INSTRUCTOR) {
                        initInstructor();
                    } else if (usertype == User.Type.ADMINISTRATOR) {
                        initAdministrator();
                    } else {
                        initStudent();
                    }
                } else {
                    navigator.navigate(Page.LOGIN);
                }
        }
        
        public void initStudent() {
            sideTextTitle.setText("Recommended Course");
            sideTextContent.setText("We think you would like this one.");
            sideTextLink.setText("Find more courses like this one.");
            searchType = "Course";
        }
        
        public void initAdministrator() {
            sideTextTitle.setText("Recent Activity Summary");
            sideTextContent.setText("A snapshot of what's going on.");
            listTitle.setText("New Students:");
            sideTextLink.setText("Show all activity.");
            searchType = "Student";
        }
        
        public void initInstructor() {
            sideTextTitle.setText("My Teaching Schedule");
            sideTextContent.setText("A snapshot of what's going on.");
            sideTextLink.setText("Show the timetable in calendar view.");
            listTitle.setText("Timetable");
            searchType = "Staff";
        }
   
    	@FXML
	public void search() {
            
		Controller searchController = navigator.navigate(Page.SEARCH);
                ((SearchController)searchController).search(search.getText(),searchType);
	}
    
}
