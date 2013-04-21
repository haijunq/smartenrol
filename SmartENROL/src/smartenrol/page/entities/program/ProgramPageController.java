/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.entities.program;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.javafxdata.control.TableViewFactory;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.dao.ProgramCoursesDAO;
import smartenrol.dao.ProgramDAO;
import smartenrol.dao.StudentSectionDAO;
import smartenrol.model.Course;
import smartenrol.model.Program;
import smartenrol.model.view.CourseTable;
import smartenrol.page.Navigator;
import smartenrol.page.SmartEnrolController;

/**
 *
 * @author Jeremy
 */
public class ProgramPageController extends SmartEnrolController {
	
    ProgramCoursesDAO programcoursedao = new ProgramCoursesDAO();
    StudentSectionDAO studsecdao = new StudentSectionDAO();
    ProgramDAO programdao = new ProgramDAO();
    private Program currentProgram;
    ArrayList<Course> courseList = new ArrayList<>();

    @FXML BorderPane innerContent;
    @FXML TextArea fxDescription;
    @FXML Text fxProgramTitle;
    @FXML Text fxCourseList;
    @FXML Text fxCredits;

    @Autowired
    private Navigator navigator;
    
    @Override
    public void init() {

    }

    public void load(String idProgram) {

        this.currentProgram = programdao.getProgrambyID(idProgram);

        courseList = programcoursedao.getCourseListByProgram(this.currentProgram.getIdProgram());
        fxProgramTitle.setText(this.currentProgram.getProgramName());
        fxDescription.setText(this.currentProgram.getProgramDescription());
        fxCredits.setText(String.valueOf(this.currentProgram.gettotalCreditsToGraduate()));
        

        if (!courseList.isEmpty()) {
        final TableView<CourseTable> requiredTableView = new TableView<>();
        TableColumn idDepartmentCol = new TableColumn("Deptartment");
        TableColumn idCourseCol = new TableColumn("Number");
        TableColumn courseNameCol = new TableColumn("Course Name");
        TableColumn creditsCol = new TableColumn("Credits");
        
//        idDepartmentCol.setMaxWidth(80);
//        idDepartmentCol.setMinWidth(80);
//        idCourseCol.setMaxWidth(50);
//        idCourseCol.setMinWidth(50);
//        courseNameCol.setMinWidth(180);  
     
            if (!courseList.isEmpty()) {
                ArrayList<CourseTable> cotable = new ArrayList<>();
                for (Course c : courseList) {
                    cotable.add(new CourseTable(c));
                }
                requiredTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent me) {
                        if (me.getClickCount() > 1) {
                            navigator.loadSelectedItem(requiredTableView, "course");
                        }
                    }
                });
    
    
            idDepartmentCol.setCellValueFactory(
                    new PropertyValueFactory<CourseTable, String>("idDepartment"));
            idCourseCol.setCellValueFactory(
                    new PropertyValueFactory<CourseTable, Integer>("idCourse"));
            courseNameCol.setCellValueFactory(
                    new PropertyValueFactory<CourseTable, String>("name"));
            creditsCol.setCellValueFactory(
                    new PropertyValueFactory<CourseTable, Float>("credit"));

            requiredTableView.setItems(FXCollections.observableList(cotable));
      
        }
     
        else {
        }
        
        requiredTableView.getColumns().addAll(idDepartmentCol, idCourseCol, courseNameCol, creditsCol);        
        requiredTableView.setEditable(false);        
        this.innerContent.setCenter(requiredTableView);
        requiredTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);  
        }
    }
}
