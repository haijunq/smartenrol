/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.classlist;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import org.joda.time.LocalDate;
import smartenrol.dao.StudentSectionDAO;
import smartenrol.dao.TermDAO;
import smartenrol.model.ClassList;
import smartenrol.model.StudentGradeRecord;
import smartenrol.model.Term;
import smartenrol.model.User;
import smartenrol.model.view.StudentGradeRecordTable;
import smartenrol.page.SmartEnrolController;

/**
 * This page shows the classlist of a section.
 * @author Haijun
 * 
 */
public class ClassListController extends SmartEnrolController {
    private final StudentSectionDAO stusecdao = new StudentSectionDAO();
    private ClassList classlist;
    private final Term currentTerm = new TermDAO().getCurrentTerm();
    
    @FXML Button fxsubmit;
    @FXML BorderPane fxclassListView;
    @FXML Text fxsectionID;
    @FXML Text fxcourseName;
    @FXML Text fxtermyear;
    @FXML Text fxclassSize;
    @FXML Button modifySectionButton;
    @FXML Button deleteSectionButton;
    
    @Override
    public void init() {
        
        if (getUserSession().getCurrentUser().getUsertype() == User.Type.ADMINISTRATOR || 
                getUserSession().getCurrentUser().getUsertype() == User.Type.INSTRUCTOR)
            setSidebarEnabled(false);
        
        // still need to add.....if User.Type = instructor, limit the time, if administrator, can edit all.        
        if (!currentTerm.isInCurrentTerm(new LocalDate()))
            fxsubmit.setDisable(true);
        

    }
    
    public void load(String idDepartment, int idCourse, String idSection) {
        this.classlist = stusecdao.getSectionClassList(idDepartment, idCourse, idSection);

        fxsectionID.setText(classlist.toString());
        fxcourseName.setText(classlist.getCourseName());
        fxtermyear.setText(classlist.getYearTerm());
        fxclassSize.setText(String.valueOf(classlist.getStuRecordList().size()));
        if (classlist.getStuRecordList().isEmpty())
            fxsubmit.setDisable(true);
        else 
            fxsubmit.setDisable(false);
        
        TableView<StudentGradeRecord> classListView = new TableView<>();
        TableColumn idStudentCol = new TableColumn("Student#");
        TableColumn givenNameCol = new TableColumn("Given Name");
        TableColumn surnameCol = new TableColumn("Surname");
        TableColumn idProgramCol = new TableColumn("Program");
        TableColumn gradeCol = new TableColumn("Grade");

        classListView.setEditable(true);
        Callback<TableColumn, TableCell> cellFactory =
             new Callback<TableColumn, TableCell>() {
                 public TableCell call(TableColumn p) {
                    return new EditingCell();
                 }
             };

        idStudentCol.setCellValueFactory(new PropertyValueFactory<StudentGradeRecordTable, Integer>("idStudent"));
        givenNameCol.setCellValueFactory(new PropertyValueFactory<StudentGradeRecordTable, Integer>("givenName"));
        surnameCol.setCellValueFactory(new PropertyValueFactory<StudentGradeRecordTable, Integer>("surname"));
        idProgramCol.setCellValueFactory(new PropertyValueFactory<StudentGradeRecordTable, Integer>("idProgram"));
        gradeCol.setCellValueFactory(new PropertyValueFactory<StudentGradeRecordTable, Integer>("grade"));
        
        gradeCol.setCellFactory(cellFactory);
        gradeCol.setOnEditCommit(new EventHandler<CellEditEvent<StudentGradeRecord, Integer>>() {
            @Override
            public void handle(CellEditEvent<StudentGradeRecord, Integer> t) {
                ((StudentGradeRecord) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
                ).setGrade(t.getNewValue());             
            }
        });
        
        
        classListView.setItems(FXCollections.observableList(classlist.getStuRecordList()));
        classListView.getColumns().addAll(idStudentCol, givenNameCol, surnameCol, idProgramCol, gradeCol);
        
        fxclassListView.setCenter(classListView);
        classListView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        if (getUserSession().getCurrentUser().getIdUser() != this.classlist.getIdInstructor()) {
            this.fxsubmit.setDisable(true);
        }
    }
 
    @FXML
    public void submitGrade() {
        if (this.classlist.getStuRecordList().isEmpty())
            return;
        for (int i = 0; i < this.classlist.getStuRecordList().size(); i ++) {
            this.stusecdao.updateGrade(
                    this.classlist.getStuRecordList().get(i).getIdStudent(), 
                    this.classlist.getIdDepartment(), 
                    this.classlist.getIdCourse(), 
                    this.classlist.getYear(),
                    this.classlist.getTerm(),
                    this.classlist.getStuRecordList().get(i).getGrade());
        }               
    } 
    
    /**
     * This innerclass is for the focus change editing.
     */
    class EditingCell extends TableCell<StudentGradeRecordTable, Integer> {
 
        private TextField textField;
 
        public EditingCell() {
        }
 
        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createTextField();
                setText(null);
                setGraphic(textField);
                textField.selectAll();
            }
        }
 
        @Override
        public void cancelEdit() {
            super.cancelEdit();
 
            setText(String.valueOf(getItem()));
            setGraphic(null);
        }
 
        @Override
        public void updateItem(Integer item, boolean empty) {
            super.updateItem(item, empty);
 
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(null);
                }
            }
        }
 
        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
            textField.focusedProperty().addListener(new ChangeListener<Boolean>(){
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, 
                    Boolean arg1, Boolean arg2) {
                        if (!arg2) {
                            commitEdit(isGradeValid(textField.getText()) ? Integer.parseInt(textField.getText()):0);
                        }
                }
            });
        }
 
        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
        
       /** Check whether a String can be converted to a valid positive int number between 0 - 100.
	 * @param str a String
	 * @return if str can be converted to positive int bwteen 0 -100, return true. Otherwise, false.
	 */
	public boolean isGradeValid(String str) {
            try {
                Integer.parseInt(str);
                if (Integer.parseInt(str) >= 0 && Integer.parseInt(str) <= 100) 
                        return true;			
                else 
                        return false;
            } catch (NumberFormatException nfe) {}
            return false;
	}
    } //end EditingCell class

}
