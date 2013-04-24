/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.administration.building;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.dao.BuildingDAO;
import smartenrol.model.Building;
import smartenrol.page.FormController;
import smartenrol.page.SmartEnrolController;
import smartenrol.security.RegexHelper;


/**
 *
 * @author Jeremy
 */
public class AddBuildingController extends SmartEnrolController {

    @Autowired private FormController formController;

    @FXML
    TextField fxbuildingName;
    @FXML
    TextField fxbuildingCode;
    @FXML
    TextField fxaddr1;
    @FXML
    TextField fxaddr2;
    @FXML
    TextField fxcity;
    @FXML
    TextField fxpostalCode;
    @FXML
    ComboBox fxprovince;

    public void init() {
        formController.setFormName("Add Buidling");
        
        formController.getSubmitButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                try {
                    submitForm();
                } catch (Exception ex) {}
            }
        });
    }
    

    @FXML
    private void submitForm() throws Exception {
        String warningMsg = "";
        
        if (!RegexHelper.validate(this.fxbuildingName.getText(), RegexHelper.RegExPattern.COURSE_NAME) || this.fxbuildingName.getText().isEmpty()) 
            warningMsg = warningMsg + "Please enter a building name with a maximum of 45 characters.\n";
        if (!RegexHelper.validate(this.fxbuildingCode.getText(), RegexHelper.RegExPattern.UPPSERCASE_LETTER) || this.fxbuildingCode.getText().isEmpty()) 
            warningMsg = warningMsg + "Please enter a building ID with a maximum of 45 characters.\n";
        if (this.fxaddr1.getText().isEmpty()) 
            warningMsg = warningMsg + "Please enter the building address.\n";
        if (!RegexHelper.validate(this.fxcity.getText(), RegexHelper.RegExPattern.LETTER_DIGIT) || this.fxcity.getText().isEmpty()) 
            warningMsg = warningMsg + "Please enter a valid city.\n";
        if (!RegexHelper.validate(this.fxpostalCode.getText(), RegexHelper.RegExPattern.POSTAL_CODE) || this.fxcity.getText().isEmpty()) 
            warningMsg = warningMsg + "Please enter a valid postal code.\n";        

        
        if(!warningMsg.isEmpty()) {
            formController.showErrors(warningMsg);
        }
        else {
            Building bldg = new Building();
            
            bldg.setBuildingName(this.fxbuildingName.getText());
            bldg.setIdLocation(this.fxbuildingCode.getText());
            bldg.setAddr1(this.fxaddr1.getText());          
            bldg.setAddr1(this.fxaddr2.getText());
            bldg.setCity(this.fxcity.getText());
            bldg.setPostalCode(this.fxpostalCode.getText());
            bldg.setProvince(this.fxprovince.getValue().toString());
            
             if (new BuildingDAO().addBuilding(bldg) == 1)
                formController.showErrors("You have successfully add the new Building.");
            else 
                formController.showErrors("The building was not added successfully. Please try again.");

        }
        
        
        
        
    }
        @Override
    public void load() {

    }
}
