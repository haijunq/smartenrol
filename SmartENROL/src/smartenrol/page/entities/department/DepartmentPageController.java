/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.entities.department;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import smartenrol.dao.DepartmentDAO;
import smartenrol.dao.ProgramDAO;
import smartenrol.model.Department;
import smartenrol.model.Program;
import smartenrol.model.view.ProgramTable;
import smartenrol.page.SmartEnrolController;

/**
 *
 * @author MrAtheist
 */
public class DepartmentPageController extends SmartEnrolController{
//    private final DepartmentDAO deptdao = new DepartmentDAO();
    private Department department;
    private ArrayList<Program> programList;

    @FXML BorderPane fxProgramList;
    @FXML Text fxDepartmentName;
    @FXML TextArea fxDepartmentDescription;
    @FXML TextArea fxAddress;
    @FXML TextArea fxEmailPhone;
    @FXML Text fxidDepartment;
    @FXML Text fxidDepartment2;
    

    @Override
    public void init(){
        load("cics");
    }

    public void load(String idDepartment) {

        this.department = new DepartmentDAO().getDepartmentByID(idDepartment);
        this.programList = new ProgramDAO().getProgrambyDepartment(idDepartment);

        if (this.department != null) {
            fxidDepartment.setText(department.getIdDepartment());
            fxidDepartment2.setText(department.getIdDepartment());
            fxDepartmentName.setText(department.getName());
            fxDepartmentDescription.setText(department.getDescription());
            fxAddress.setText(department.toString());
        }
        
        final TableView<ProgramTable> programTableView = new TableView<>();
        TableColumn idProgramCol = new TableColumn("Program ID");
        TableColumn programNameCol = new TableColumn("Program Name");
        TableColumn idDepartmentCol = new TableColumn("Department ID");
        TableColumn totalCreditsCol = new TableColumn("Credits to graduate"); 
        
        if (!this.programList.isEmpty()) {

            ArrayList<ProgramTable> programTable = new ArrayList<>();
            for (Program p : programList)
                programTable.add(new ProgramTable(p));

            idProgramCol.setCellValueFactory(
                    new PropertyValueFactory<ProgramTable, String>("program"));
            programNameCol.setCellValueFactory(
                    new PropertyValueFactory<ProgramTable, String>("name"));        
            idDepartmentCol.setCellValueFactory(
                    new PropertyValueFactory<ProgramTable, String>("department"));
            totalCreditsCol.setCellValueFactory(
                    new PropertyValueFactory<ProgramTable, String>("totalCredit"));         

            programTableView.setItems(FXCollections.observableList(programTable));

        }
     
        else {
        }
        
        programTableView.getColumns().addAll(idProgramCol, programNameCol, idDepartmentCol, totalCreditsCol);        
        programTableView.setEditable(false);        
        this.fxProgramList.setCenter(programTableView);
        programTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);          
        
        
    }
}
