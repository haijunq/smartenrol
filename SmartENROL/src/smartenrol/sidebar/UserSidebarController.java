/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.sidebar;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.dao.SectionDAO;
import smartenrol.dao.StudentSectionDAO;
import smartenrol.model.Section;
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
        private int idUser; 
        
        @Autowired
        private Navigator navigator;
        
        @FXML
        private TextField search;
        
        @FXML
        private ListView fxsidebarList;

        @FXML
        private Text listTitle, sideTextTitle, sideTextLink, sideTextContent, fxContextInfo; 
        
        
        public void init() {
                User.Type usertype = getUserSession().getCurrentUser().getUsertype();
                idUser = getUserSession().getCurrentUser().getIdUser();
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
            ArrayList<Section> recommList = new SectionDAO().getSectionListForStudent(idUser);
            String info = "";
            for (int i = 0; i < recommList.size(); i ++) {
                if (i>0 && recommList.get(i).getIdDepartment().equals(recommList.get(i-1).getIdDepartment()) 
                        && recommList.get(i).getIdCourse() == recommList.get(i-1).getIdCourse())
                    continue;
                info = info + recommList.get(i).getCourseString() + "   ";
            }
            fxContextInfo.setText(info);
            ArrayList<VBox> courseBoxes = new ArrayList<>();            
            ArrayList<Section> currentCourseList = new StudentSectionDAO().getStudentCurrentTermCourseList(idUser, 0);
                    
            if (!currentCourseList.isEmpty()) {
                for (int i = 0; i < currentCourseList.size(); i ++) {    
                    VBox sectionItem = new VBox();
                    sectionItem.getChildren().addAll(new Text(currentCourseList.get(i).toString()), new Text(currentCourseList.get(i).getCourseName()), new Text("Enrolled."));                              
                    courseBoxes.add(sectionItem);               
                } //end for
            } else {
                VBox sectionBox = new VBox();
                sectionBox.getChildren().setAll(new Text("You have not enrolled any course for this Term."));
                courseBoxes.add(sectionBox);
            }
            
            ArrayList<Section> currentWaitList = new StudentSectionDAO().getStudentCurrentTermCourseList(idUser, 1);
            if (!currentWaitList.isEmpty()) {
                for (int i = 0; i < currentWaitList.size(); i ++) {    
                    VBox sectionItem = new VBox();
                    sectionItem.getChildren().addAll(new Text(currentWaitList.get(i).toString()), new Text(currentWaitList.get(i).getCourseName()), new Text("On Waitlist."));                              
                    courseBoxes.add(sectionItem);               
                } //end for
            }            
            
            fxsidebarList.setItems(FXCollections.observableList(courseBoxes));
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
            
            ArrayList<Section> teachingList = new SectionDAO().getSectionListForInstructor(idUser);
            

        }
   
    	@FXML
	public void search() {
            
		Controller searchController = navigator.navigate(Page.SEARCH);
                ((SearchController)searchController).search(search.getText(),searchType);
	}
    
}
