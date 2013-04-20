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
        private Text listTitle, searchTitle, searchText; 
        
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
            searchTitle.setText("Course Finder:");
            searchText.setText("Easily find courses and programs by using the search form below.");
            listTitle.setText("This Semester at a Glance:");
            searchType = "Course";
        }
        
        public void initAdministrator() {
            searchTitle.setText("Student Finder:");
            searchText.setText("Easily find students and faculty by using the search form below.");
            listTitle.setText("Recently Enrolled Students:");
            searchType = "Student";
        }
        
        public void initInstructor() {
            searchTitle.setText("Staff Finder");
            searchText.setText("Easily find colleagues by using the search form below.");
            listTitle.setText("This Semester Teaching Schedule:");
            searchType = "Staff";
        }
   
    	@FXML
	public void search() {
            
		Controller searchController = navigator.navigate(Page.SEARCH);
                ((SearchController)searchController).search(search.getText(),searchType);
	}
    
}
