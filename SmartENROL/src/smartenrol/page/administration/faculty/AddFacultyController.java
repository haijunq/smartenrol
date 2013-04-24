/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.administration.faculty;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.dao.BuildingDAO;
import smartenrol.dao.FacultyDAO;
import smartenrol.dao.UserDAO;
import smartenrol.model.Faculty;
import smartenrol.page.FormController;
import smartenrol.page.SmartEnrolController;
import smartenrol.security.RegexHelper;

/**
 *
 * @author Jeremy
 */
public class AddFacultyController extends SmartEnrolController  {
    
//    @Autowired private Navigator navigator;
    @Autowired private FormController formController;
    
    @FXML TextField fxfacultyName, fxidFaculty, fxphone; 
    @FXML TextArea fxdescription;
    @FXML ComboBox fxheadOffice, fxdeanID, fxmainContactID;
    @FXML Button fxsubmit;      
    
    public void init() {
        formController.setFormName("Add Faculty");
        
        this.initHeadOfficeComboBox();
        this.initIDComboBoxes();
        
        formController.getSubmitButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                try {
                    submitForm();
                } catch (Exception ex) {
//                    Logger.getLogger(AddDepartmentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.fxsubmit.setVisible(false);
    }
    
    private void initHeadOfficeComboBox() {
        ArrayList<String> buildinglist = new ArrayList<>();
        buildinglist=new BuildingDAO().getAllBuildingAsString();
        fxheadOffice.getItems().clear();
        fxheadOffice.getItems().add("");
        fxheadOffice.getItems().addAll(buildinglist);
        fxheadOffice.getSelectionModel().selectFirst();
    }
    
    private void initIDComboBoxes() {
        ArrayList<Integer> adminlist = new ArrayList<>();
        adminlist = new UserDAO().getAllAdminID();
        fxdeanID.getItems().clear();
        fxdeanID.getItems().add("");
        fxdeanID.getItems().addAll(adminlist);
        fxdeanID.getSelectionModel().selectFirst();
        fxmainContactID.getItems().clear();
        fxmainContactID.getItems().add("");
        fxmainContactID.getItems().addAll(adminlist);
        fxmainContactID.getSelectionModel().selectFirst(); 
    }
    
    @FXML
    public void submitForm() throws Exception {
        String warningMsg = "";

        if (!RegexHelper.validate(this.fxfacultyName.getText(), RegexHelper.RegExPattern.LETTER_DIGIT) || this.fxfacultyName.getText().isEmpty()) 
            warningMsg = warningMsg + "Please enter a faculty name with a maximum of 45 characters.\n";
        if (!RegexHelper.validate(this.fxidFaculty.getText(), RegexHelper.RegExPattern.UPPSERCASE_LETTER) || this.fxidFaculty.getText().isEmpty()) 
            warningMsg = warningMsg + "Please enter a faculty ID with a maximum of 10 uppercase characters.\n";        
        if (this.fxdescription.getText().isEmpty()) 
            warningMsg = warningMsg + "Please enter description of the faculty.\n";   
        if (this.fxheadOffice.getValue().toString().equals(""))
            warningMsg = warningMsg + "Please select the head office building.\n";   
        if (this.fxdeanID.getValue().toString().equals(""))
            warningMsg = warningMsg + "Please select the head's ID.\n";           
        if (!RegexHelper.validate(this.fxphone.getText(), RegexHelper.RegExPattern.PHONE_NUMBER) || this.fxphone.getText().isEmpty()) 
            warningMsg = warningMsg + "Please enter a valid contact phone number.\n";     
        if (this.fxmainContactID.getValue().toString().equals(""))
            warningMsg = warningMsg + "Please select main contact ID of the faculty.\n";   
        
        if (!warningMsg.isEmpty()) {
            formController.showErrors(warningMsg);
        }
        else {
            Faculty faculty = new Faculty();
            faculty.setName(this.fxfacultyName.getText());
            faculty.setDescription(this.fxdescription.getText());
            faculty.setIdFaculty(this.fxidFaculty.getText());
            faculty.setHeadOfficeLocationID(this.fxheadOffice.getValue().toString());
            faculty.setDeanID(this.fxdeanID.getValue().toString());
            faculty.setMainPhone(this.fxphone.getText());
            faculty.setMainContactID(this.fxmainContactID.getValue().toString());
            
            if (new FacultyDAO().addFaculty(faculty) == 1)
                formController.showErrors("You have successfully add the new falcuty.");
            else 
                formController.showErrors("The faculty was not added successfully. Please try again.");
        }        
    }

 /*   
idFaculty
facultyName
description
headOfficeLocation
mainPhone
deanID
mainContactID
*/
    
}
    