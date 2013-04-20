/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.classlist;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import smartenrol.dao.StudentSectionDAO;
import smartenrol.model.ClassList;
import smartenrol.model.StudentGradeRecord;
import smartenrol.model.view.StudentGradeRecordTable;
import smartenrol.page.SmartEnrolController;

/**
 *
 * @author Jeremy
 * This page also allows administrator to add/remove a student to the class (special approval). 
 */
public class ClassListController extends SmartEnrolController {
    private final StudentSectionDAO stusecdao = new StudentSectionDAO();
    private ClassList classlist;
    
    @FXML Button fxsubmit;
    @FXML BorderPane fxclassListView;
    @FXML Text fxsectionID;
    @FXML Text fxcourseName;
    @FXML Text fxtermyear;
    @FXML Text fxclassSize;
    
    @Override
    public void init() {
        
        this.load("cics", 520, "L01");  

    }
    
    public void load(String idDepartment, int idCourse, String idSection) {
        this.classlist = stusecdao.getSectionClassList(idDepartment, idCourse, idSection);
        
        fxsectionID.setText(classlist.toString());
        fxcourseName.setText(classlist.getCourseName());
        fxtermyear.setText(classlist.getYearTerm());
        fxclassSize.setText(String.valueOf(classlist.getStuRecordList().size()));
        
        TableView<StudentGradeRecord> classListView = new TableView<>();
        TableColumn idStudentCol = new TableColumn("Student#");
        TableColumn givenNameCol = new TableColumn("Given Name");
        TableColumn surnameCol = new TableColumn("Surname");
        TableColumn idProgramCol = new TableColumn("Program");
        TableColumn gradeCol = new TableColumn("Grade");

        idStudentCol.setCellValueFactory(new PropertyValueFactory<StudentGradeRecordTable, Integer>("idStudent"));
        givenNameCol.setCellValueFactory(new PropertyValueFactory<StudentGradeRecordTable, Integer>("givenName"));
        surnameCol.setCellValueFactory(new PropertyValueFactory<StudentGradeRecordTable, Integer>("surname"));
        idProgramCol.setCellValueFactory(new PropertyValueFactory<StudentGradeRecordTable, Integer>("idProgram"));
        gradeCol.setCellValueFactory(new PropertyValueFactory<StudentGradeRecordTable, Integer>("grade"));
        
        classListView.setItems(FXCollections.observableList(classlist.getStuRecordList()));
        classListView.getColumns().addAll(idStudentCol, givenNameCol, surnameCol, idProgramCol, gradeCol);
        
        fxclassListView.setCenter(classListView);
        classListView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    
}
