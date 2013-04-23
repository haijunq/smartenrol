/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.administration.department;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.dao.BuildingDAO;
import smartenrol.dao.DepartmentDAO;
import smartenrol.dao.FacultyDAO;
import smartenrol.dao.UserDAO;
import smartenrol.model.Department;
import smartenrol.page.FormController;
import smartenrol.page.SmartEnrolController;
import smartenrol.page.elements.dialog.ErrorDialog;
import smartenrol.page.elements.dialog.OpenDialog;
import smartenrol.security.RegexHelper;

/**
 *
 * @author Jeremy
 */
public class AddDepartmentController extends SmartEnrolController {

    @Autowired private FormController formController;

    @FXML TextField fxidDepartment, fxdepartmentName, fxemail, fxphone, fxadminName;
    @FXML TextArea fxdescription;
    @FXML ComboBox fxidLocation, fxidFaculty, fxidAdmin;
    @FXML Button fxsubmitButton;
    private EventHandler updateHandler;
    
    public void init() {
        
        formController.setFormName("Add Department");

        
        
        this.initFacultyComboBox();
        this.initBuildingComboBox();
        this.initIdAdminComboBox();
        
        
//        formController.getSubmitButton().getOnMouseClicked();
    }
    
    @FXML
    public void submitForm(MouseEvent event) throws Exception {
        String warningMsg = "";

        if (!RegexHelper.validate(this.fxdepartmentName.getText(), RegexHelper.RegExPattern.LETTER_DIGIT) || this.fxdepartmentName.getText().isEmpty()) 
            warningMsg = warningMsg + "Please enter a department name with a maximum of 45 characters.\n";
        if (!RegexHelper.validate(this.fxidDepartment.getText(), RegexHelper.RegExPattern.UPPSERCASE_LETTER) || this.fxidDepartment.getText().isEmpty()) 
            warningMsg = warningMsg + "Please enter a department ID with a maximum of 10 uppercase characters.\n";        
        if (this.fxdescription.getText().isEmpty()) 
            warningMsg = warningMsg + "Please enter description of the department.\n";   
        if (this.fxidFaculty.getValue().toString().equals(""))
            warningMsg = warningMsg + "Please select a faculty.\n";   
        if (this.fxidLocation.getValue().toString().equals(""))
            warningMsg = warningMsg + "Please select a building.\n";     
        if (!RegexHelper.validate(this.fxemail.getText(), RegexHelper.RegExPattern.EMAIL) || this.fxemail.getText().isEmpty()) 
            warningMsg = warningMsg + "Please enter a valid email address.\n";        
        if (!RegexHelper.validate(this.fxphone.getText(), RegexHelper.RegExPattern.PHONE_NUMBER) || this.fxphone.getText().isEmpty()) 
            warningMsg = warningMsg + "Please enter a valid contact phone number.\n";     
        if (this.fxidAdmin.getValue().toString().equals(""))
            warningMsg = warningMsg + "Please select head ID of the department.\n";   
        
        if (!warningMsg.isEmpty()) {
            
            formController.showErrors(warningMsg);
        
        }
        else {
            Department dept = new Department();
            dept.setIdDepartment(this.fxidDepartment.getText());
            dept.setName(this.fxdepartmentName.getText());
            dept.setDescription(this.fxdescription.getText());
            dept.setIdFaculty(this.fxidFaculty.getValue().toString());
            dept.setIdLocation(this.fxidLocation.getValue().toString());
            dept.setDeptHeadName(this.fxadminName.getText());
            dept.setEmail(this.fxemail.getText());
            dept.setPhone(this.fxphone.getText());
            dept.setIdAdmin(Integer.parseInt(this.fxidAdmin.getValue().toString()));
            
            if (new DepartmentDAO().addDepartment(dept) == 1)
                formController.showErrors("You have successfully add the new department.");
            else 
                formController.showErrors("The department was not added successfully. Please try again.");
        }
        

    }
    

    /**
     * This private method populates the Faculty Combobox.
     */
    private void initFacultyComboBox() {
        ArrayList<String> facultylist = new ArrayList<>();
        facultylist=new FacultyDAO().getAllFacultyID();
        fxidFaculty.getItems().clear();
        fxidFaculty.getItems().add("");
        fxidFaculty.getItems().addAll(facultylist);
        fxidFaculty.getSelectionModel().selectFirst();
    }
    
    private void initBuildingComboBox() {
        ArrayList<String> buildinglist = new ArrayList<>();
        buildinglist=new BuildingDAO().getAllBuildingAsString();
        fxidLocation.getItems().clear();
        fxidLocation.getItems().add("");
        fxidLocation.getItems().addAll(buildinglist);
        fxidLocation.getSelectionModel().selectFirst();
    }    

    /**
     * This private method populates the Administrator Combobox.
     */
    private void initIdAdminComboBox() {
        this.updateHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setAdminName();
            }
        };
        ArrayList<Integer> adminlist = new ArrayList<>();
        adminlist = new UserDAO().getAllAdminID();
//        fxidAdmin.addEventHandler(ActionEvent.ACTION,updateHandler);
        fxidAdmin.getItems().clear();
        fxidAdmin.getItems().add("");
        fxidAdmin.getItems().addAll(adminlist);
        fxidAdmin.getSelectionModel().selectFirst();
        fxidAdmin.addEventHandler(ActionEvent.ACTION,updateHandler);
        fxadminName.setDisable(true);
    }   
    
    /**
     * This method set the administrator name according to the selection in the idAdmin. 
     */
    private void setAdminName() {
        if (fxidAdmin.getValue().toString() != "" && fxidAdmin.getValue().toString() != null) {
            int id = Integer.parseInt(fxidAdmin.getValue().toString());
            fxadminName.setText(new UserDAO().getUserByID(id).getFullName());
        }
        else
            fxadminName.setText("");            
    }
}
