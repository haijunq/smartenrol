/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.sidebar;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
import smartenrol.page.classlist.ClassListController;
import smartenrol.page.entities.course.CoursePageController;
import smartenrol.page.entities.user.AdminProfileController;
import smartenrol.page.search.SearchController;

/**
 *
 * @author Jeremy
 */
public class UserSidebarController extends SmartEnrolController {

    private String searchType;
    private int idUser; 
    private EventHandler sectionClickHandler;

    @Autowired
    private Navigator navigator;

    @FXML
    private TextField search;

    @FXML
    private ListView fxsidebarList;

    @FXML
    private Text listTitle, sideTextTitle, sideTextLink, sideTextContent, fxContextInfo, fxmsgCount; 

    @FXML
    private Button fxaddFaculty, fxaddDepartment, fxaddProgram, fxaddCourse, fxaddSection, fxaddStudent, fxaddInstructor, fxaddAdministrator;

    public void init() {
            setSidebarEnabled(false);

            User.Type usertype = getUserSession().getCurrentUser().getUsertype();
            idUser = getUserSession().getCurrentUser().getIdUser();
            
            if (usertype == User.Type.INSTRUCTOR || usertype == User.Type.STUDENT) {
                fxaddFaculty.setVisible(false);
                fxaddDepartment.setVisible(false);
                fxaddProgram.setVisible(false);
                fxaddCourse.setVisible(false);
                fxaddSection.setVisible(false);
                fxaddStudent.setVisible(false);
                fxaddInstructor.setVisible(false);
                fxaddAdministrator.setVisible(false);
            }
            
            
            
            if (getUserSession().isSignedIn()) {

                if (usertype == User.Type.INSTRUCTOR) {
                    final SidebarInstructor insbar = new SidebarInstructor();
                    this.sectionClickHandler = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            if (event.getClickCount() > 1) {
                                insbar.loadClassList();
                            }
                        }
                    };                   
                    insbar.initInstructor();            

                } else if (usertype == User.Type.ADMINISTRATOR) {
                    initAdministrator();
                } else {
                    final SidebarStudent stubar = new SidebarStudent();
                    this.sectionClickHandler = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            if (event.getClickCount() > 1) {
                                stubar.loadCoursePage();
                            }
                        }
                    };   
                    stubar.initStudent();
                }
            } else {
                navigator.navigate(Page.LOGIN);
            }               

    }


    /**
     * This inner class is for the student sidebar view and actions.
     */
    private class SidebarStudent {
        private ArrayList<Section> recommList;
        private ArrayList<Section> passedList;
        private ArrayList<Section> totalList = new ArrayList<>(); // enrolled and onWaitlist
                
        // set the view of the sidebar for the student
        public void initStudent() {
            sideTextTitle.setText("Recommended Course");
            sideTextContent.setText("We think you would like this one.");
            searchType = "Course";
            listTitle.setText("You have enrolled the following sections: ");
            fxmsgCount.setVisible(false);

            recommList = new SectionDAO().getSectionListForStudent(idUser);
            passedList = new StudentSectionDAO().getStudentPassedCourseList(idUser);
            for (Iterator<Section> it = recommList.iterator(); it.hasNext();) {
                Section rec = it.next();
                for (Section pass: passedList) {
                    if (rec.getIdDepartment().equals(pass.getIdDepartment()) && rec.getIdCourse() == pass.getIdCourse())
                        it.remove();
                }
            }                 
            
            String info = "";
            
            for (int i = 0; i < recommList.size(); i ++) {
                if (i>0 && recommList.get(i).getIdDepartment().equals(recommList.get(i-1).getIdDepartment()) 
                        && recommList.get(i).getIdCourse() == recommList.get(i-1).getIdCourse())
                    continue;
                info = info + recommList.get(i).getCourseString() + ",  ";
            }
            fxContextInfo.setText(info.substring(0, info.length()-3));
            ArrayList<VBox> courseBoxes = new ArrayList<>();            
            ArrayList<Section> currentCourseList = new StudentSectionDAO().getStudentCurrentTermCourseList(idUser, 0);

            // fill the list with student's enrolled sections
            if (!currentCourseList.isEmpty()) {
                for (int i = 0; i < currentCourseList.size(); i ++) {    
                    VBox sectionItem = new VBox();
                    sectionItem.addEventHandler(MouseEvent.MOUSE_CLICKED, sectionClickHandler);
                    sectionItem.getChildren().addAll(new Text(currentCourseList.get(i).toString()), new Text(currentCourseList.get(i).getCourseName()), new Text("Enrolled."));                              
                    courseBoxes.add(sectionItem);               
                } //end for
            } else {
                VBox sectionBox = new VBox();
                sectionBox.getChildren().setAll(new Text("You have not enrolled any course for this term."));
                courseBoxes.add(sectionBox);
            }
            this.totalList.addAll(currentCourseList);

            ArrayList<Section> currentWaitList = new StudentSectionDAO().getStudentCurrentTermCourseList(idUser, 1);
            if (!currentWaitList.isEmpty()) {
                for (int i = 0; i < currentWaitList.size(); i ++) {    
                    VBox sectionItem = new VBox();
                    sectionItem.addEventHandler(MouseEvent.MOUSE_CLICKED, sectionClickHandler);
                    sectionItem.getChildren().addAll(new Text(currentWaitList.get(i).toString()), new Text(currentWaitList.get(i).getCourseName()), new Text("On Waitlist."));                              
                    courseBoxes.add(sectionItem);               
                } //end for
            }            
            this.totalList.addAll(currentWaitList);
            fxsidebarList.setItems(FXCollections.observableList(courseBoxes));
        }
        
        private void loadCoursePage() {
            int index = fxsidebarList.getSelectionModel().getSelectedIndex();
            ((CoursePageController) navigator.navigate(Page.COURSE)).load(totalList.get(index).getIdDepartment(), totalList.get(index).getIdCourse());
        }
    }

    public void initAdministrator() {
        sideTextTitle.setText("Recent Activity Summary");
        sideTextContent.setText("A snapshot of what's going on.");
        listTitle.setVisible(false);
        this.fxsidebarList.setVisible(false);
        searchType = "Student";
        this.fxContextInfo.setText("You have      new messages.");
        this.fxsidebarList.setVisible(false);
        
    }
    
    public void refreshMessageCount(int count) {
        if (getUserSession().getCurrentUser().getUsertype() == User.Type.ADMINISTRATOR) 
            this.fxmsgCount.setText(String.valueOf(count));
    }

        

    private class SidebarInstructor {
        private ArrayList<Section> teachingList;
        
        public void initInstructor() {
            sideTextTitle.setText("My Teaching Schedule");
            sideTextContent.setText("A snapshot of what's going on.");
            listTitle.setText("You are teaching the following sections: ");     
            fxmsgCount.setVisible(false);
            searchType = "Staff";

            teachingList = new SectionDAO().getSectionListForInstructor(idUser);
            fxContextInfo.setText("You are teaching " + teachingList.size() + " sections in this term.");

            ArrayList<VBox> courseBoxes = new ArrayList<>();            

            if (!teachingList.isEmpty()) {
                for (int i = 0; i < teachingList.size(); i ++) {    
                    VBox sectionItem = new VBox();
                    sectionItem.addEventHandler(MouseEvent.MOUSE_CLICKED, sectionClickHandler);
                    sectionItem.getChildren().addAll(new Text(teachingList.get(i).getSectionTypeString()), new Text(teachingList.get(i).getCourseName()));                              
                    courseBoxes.add(sectionItem);               
                } //end for

            } else {
                VBox sectionBox = new VBox();
                sectionBox.getChildren().setAll(new Text("You are not teaching any sections in this term."));
                courseBoxes.add(sectionBox);

            }        
            fxsidebarList.setItems(FXCollections.observableList(courseBoxes));
        }
        
        private void loadClassList() {
            int index = fxsidebarList.getSelectionModel().getSelectedIndex();
            ((ClassListController) navigator.navigate(Page.CLASSLIST)).load(teachingList.get(index).getIdDepartment(),teachingList.get(index).getIdCourse(),teachingList.get(index).getIdSection());
        }
    }

    @FXML
    public void search() {

        Controller searchController = navigator.navigate(Page.SEARCH);
        ((SearchController)searchController).search(search.getText(),searchType);
    }
    
    
    @FXML
    public void addCourse() {
        navigator.navigate(Page.ADD_COURSE);
    }
    
    @FXML
    public void addSection() {
        navigator.navigate(Page.ADD_SECTION);
        
    }
    
    @FXML
    public void addProgram() {
        navigator.navigate(Page.ADD_PROGRAM);
        
    }
        
    @FXML
    public void addStudent() {
            ((AdminProfileController)navigator.navigate(Page.ADD_USER)).load(0, FormType.ADD_STUDENT);
        
    }
    @FXML
    public void addInstructor() {
            ((AdminProfileController)navigator.navigate(Page.ADD_USER)).load(0, FormType.ADD_INSTRUCTOR);
   
    }
        
    @FXML
    public void addAdministrator() {
            ((AdminProfileController)navigator.navigate(Page.ADD_USER)).load(0, FormType.ADD_ADMINISTRATOR);
        
    }            

    @FXML
    public void addFaculty() {
        navigator.navigate(Page.ADD_FACULTY);

    }     
    
    @FXML
    public void addDepartment() {
        navigator.navigate(Page.ADD_DEPARTMENT);

    }
    
    @FXML
    public void addBuilding() {
        navigator.navigate(Page.ADD_BUILDING);
        
    }
}
