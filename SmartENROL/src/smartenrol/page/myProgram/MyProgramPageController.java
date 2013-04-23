/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.myProgram;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.javafxdata.control.TableViewFactory;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.dao.MessageDAO;
import smartenrol.dao.StudentSectionDAO;
import smartenrol.model.*;
import smartenrol.page.SmartEnrolController;
import smartenrol.security.UserSession;
import smartenrol.dao.ProgramDAO;
import smartenrol.model.view.CourseGradeRecordTable;
import smartenrol.page.Navigator;
import smartenrol.page.PageController;
import smartenrol.page.elements.dialog.OpenDialog;
import smartenrol.page.entities.course.CoursePageController;
import smartenrol.page.error.ErrorController;
/**
 *
 * @author Jeremy
 */
public class MyProgramPageController extends SmartEnrolController {
	
    private final StudentSectionDAO studsecdao = new StudentSectionDAO();
    private final ProgramDAO programdao = new ProgramDAO();
    private final MessageDAO msgdao = new MessageDAO();
    private Transcript transcript;
    private ArrayList<Section> passedCourseList;
    private ArrayList<Course> remainingCourseList;
    private User currentUser;
    private EventHandler remainingCourseClickHandler;

    @Autowired
    private Navigator navigator;

    @FXML Text creditsEarnedField;
    @FXML Text creditsRemainedField;
    @FXML Text infoPrompt;
    @FXML Text fxProgramTitle;
    @FXML Rectangle creditsEarnedBar;
    @FXML BorderPane fxcourseTakenTable;
    @FXML ListView fxcourseRemainingList;
    @FXML Button fxapplyTranscript;
    @FXML Button fxapplyToGraduate;
    @FXML Button fxapplySwitchProgram;

    private User.Type userType;


    public void init() {

        load();
    }
        
      
    public void load() {
        userType = getUserSession().getCurrentUser().getUsertype();

        if (userType == User.Type.STUDENT) {

            float creditsEarned = 0;
            float creditsRemained = 0;
            float totalCreditsRequired = 0;
            float creditsEarnedPercentage = 0;

            currentUser = getUserSession().getCurrentUser();
            transcript = studsecdao.getStudentTranscript(currentUser.getIdUser());
            passedCourseList = studsecdao.getStudentPassedCourseList(currentUser.getIdUser());
            remainingCourseList = studsecdao.getStudentRemainingCourseList(currentUser.getIdUser());
            totalCreditsRequired = programdao.getProgrambyID(transcript.getIdProgram()).gettotalCreditsToGraduate();
            fxProgramTitle.setText(transcript.getProgramName());

            if (!this.passedCourseList.isEmpty())
                for (Section psec: this.passedCourseList) {
                    creditsEarned += psec.getCredits();
                }
                           
            if (creditsEarned < totalCreditsRequired)
                this.fxapplyToGraduate.setDisable(true);
            creditsEarnedPercentage = creditsEarned / totalCreditsRequired;
            creditsRemained = totalCreditsRequired - creditsEarned;
            creditsEarnedField.setText(String.valueOf(creditsEarned));
            creditsEarnedField.setLayoutX(creditsEarnedPercentage * 300 - 5);
            creditsRemainedField.setText(String.valueOf(creditsRemained));
            creditsEarnedBar.setWidth((creditsEarnedPercentage) * 300);
            infoPrompt.setText("You have completed " + creditsEarned + " of " + totalCreditsRequired + " required credits.");            

                
            final TableView<CourseGradeRecordTable> coursesTakenTableView = new TableView();
            TableColumn idDepartmentCol = new TableColumn("Dept");
            TableColumn idCourseCol = new TableColumn("Num");
            TableColumn courseNameCol = new TableColumn("Course Name");
            TableColumn creditCol = new TableColumn("Credit");
            TableColumn yearCol = new TableColumn("Year");
            TableColumn termCol = new TableColumn("Term");
            TableColumn gradeCol = new TableColumn("Grade");
            
            if (!this.transcript.getGradeRecords().isEmpty()) {       
                ArrayList<CourseGradeRecordTable> historyTable = new ArrayList<>();
                for (CourseGradeRecord cgr: this.transcript.getGradeRecords()) {
                    historyTable.add(new CourseGradeRecordTable(cgr));
                }             

                
                coursesTakenTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent me) {
                        if (me.getClickCount() > 1) {
                            navigator.loadSelectedItem(coursesTakenTableView,"transcript");
                        }
                    }
                });
                               
                idDepartmentCol.setCellValueFactory(new PropertyValueFactory<CourseGradeRecordTable, Integer>("idDepartment"));
                idCourseCol.setCellValueFactory(new PropertyValueFactory<CourseGradeRecordTable, Integer>("idCourse"));
                courseNameCol.setCellValueFactory(new PropertyValueFactory<CourseGradeRecordTable, Integer>("name"));
                creditCol.setCellValueFactory(new PropertyValueFactory<CourseGradeRecordTable, Integer>("credit"));
                yearCol.setCellValueFactory(new PropertyValueFactory<CourseGradeRecordTable, Integer>("year"));
                termCol.setCellValueFactory(new PropertyValueFactory<CourseGradeRecordTable, Integer>("term"));
                gradeCol.setCellValueFactory(new PropertyValueFactory<CourseGradeRecordTable, Integer>("grade"));
                
                coursesTakenTableView.setItems(FXCollections.observableList(historyTable));

            }// end set table view
            coursesTakenTableView.getColumns().addAll(idDepartmentCol, idCourseCol, courseNameCol, creditCol, yearCol, termCol, gradeCol);
            coursesTakenTableView.setEditable(false);             
            coursesTakenTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            this.fxcourseTakenTable.setCenter(coursesTakenTableView);
            
            
            ArrayList<VBox> remainingCourseBoxes = new ArrayList<>();
            if (!this.remainingCourseList.isEmpty()) {
                this.remainingCourseClickHandler = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() > 1) {
                            loadCoursePage();
                        }
                    }
                }; 
                for (int i = 0; i < remainingCourseList.size(); i ++) {
                    VBox courseItem = new VBox(); 
                    courseItem.addEventHandler(MouseEvent.MOUSE_CLICKED, remainingCourseClickHandler);
                    courseItem.getChildren().addAll(new Text(remainingCourseList.get(i).toString() + "                                        Credit: " + String.valueOf(remainingCourseList.get(i).getCredits())), new Text(remainingCourseList.get(i).getCourseName()));                              
                    remainingCourseBoxes.add(courseItem);  
                } 

            }
            else {
                VBox courseItem = new VBox();
                courseItem.getChildren().setAll(new Text("Congratulations, you have passed all the required courses!"));
                remainingCourseBoxes.add(courseItem);    
            }
            this.fxcourseRemainingList.setItems(FXCollections.observableList(remainingCourseBoxes));
        }// end if student
        else {
            ((ErrorController) navigator.navigate(Page.ERROR)).load(PageError.NO_PAGE_HERE);
        }
    }// load method
    
    private void loadCoursePage() {
        int index = this.fxcourseRemainingList.getSelectionModel().getSelectedIndex();
        ((CoursePageController) navigator.navigate(Page.COURSE)).load(this.remainingCourseList.get(index).getIdDepartment(), this.remainingCourseList.get(index).getIdCourse());
    }
    
    @FXML
    private void applyTranscriptButtonOnClick() {
        String msgtoAdmin = "The student " + getUserSession().getCurrentUser().getIdUser() + " is applying for an official transript.";
        String msgtoSelf = "You have applied for an official transcript.";   
        String type = "transcript";
        
        if ((msgdao.sendStudentRequestMessage(getUserSession().getCurrentUser().getIdUser(), msgtoAdmin, type) + msgdao.sendSelfMessage(getUserSession().getCurrentUser().getIdUser(), msgtoSelf)) == 2) {
            // display message box?
            System.out.println("Your application has been forwarded to the Administrator.");   
            OpenDialog dlg = new OpenDialog("Your application has been forwarded to the Administrator.");
            dlg.display();
        }
    }
    
    @FXML
    private void applyToGraduateButtonOnClick() {
        String msgtoAdmin = "The student " + getUserSession().getCurrentUser().getIdUser() + " is applying to graduate.";
        String msgtoSelf = "You have applied to graduate.";   
        String type = "graduate";
        
        if ((msgdao.sendStudentRequestMessage(getUserSession().getCurrentUser().getIdUser(), msgtoAdmin, type) + msgdao.sendSelfMessage(getUserSession().getCurrentUser().getIdUser(), msgtoSelf)) == 2) {
            // display message box?
            System.out.println("Your application has been forwarded to the Administrator.");       
            OpenDialog dlg = new OpenDialog("Your application has been forwarded to the Administrator.");
            dlg.display();
        }
    }
    
    @FXML
    private void applySwitchProgramOnClick() {
        String msgtoAdmin = "The student " + getUserSession().getCurrentUser().getIdUser() + " is applying to switch program.";
        String msgtoSelf = "You have applied to switch program.";   
        String type = "swicth";
        
        if ((msgdao.sendStudentRequestMessage(getUserSession().getCurrentUser().getIdUser(), msgtoAdmin, type) + msgdao.sendSelfMessage(getUserSession().getCurrentUser().getIdUser(), msgtoSelf)) == 2) {
            // display message box?
            System.out.println("Your application has been forwarded to the Administrator.");    
            OpenDialog dlg = new OpenDialog("Your application has been forwarded to the Administrator.");
            dlg.display();
        }   
    }
}
