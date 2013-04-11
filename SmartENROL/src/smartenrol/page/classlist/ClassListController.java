/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.classlist;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.javafxdata.control.TableViewFactory;
import smartenrol.dao.StudentSectionDAO;
import smartenrol.model.ClassList;
import smartenrol.model.StudentGradeRecord;
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
        
        TableView<StudentGradeRecord> classListView = TableViewFactory.
                create(StudentGradeRecord.class, classlist.getStuRecordList()).
//                selectColumns("Id Department", "Id Course", "Course Name", "Credits").
//                renameColumn("Id Department", "Dept").
//                renameColumn("Id Course", "Num").
        buildTableView();
        fxclassListView.setCenter(classListView);
        classListView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    
}
