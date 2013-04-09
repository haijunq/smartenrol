/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.administration.department;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import smartenrol.SmartEnrolException;
import smartenrol.page.SmartEnrolController;

/**
 *
 * @author Jeremy
 */
public class UpdateDepartmentController extends SmartEnrolController {

    public void init() {
    }
    @ FXML
    TextField idDepartment;
    @ FXML
    TextField name;
    @ FXML
    TextField idLocation;
    @ FXML
    TextField idFaculty;
    @ FXML
    TextField description;
    @ FXML
    TextField departmentHeadID;
    @ FXML
    TextField mainContactID;

    @FXML
    public void submitForm(MouseEvent event) throws Exception {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();
            userInputValueHolder.put(IDepartmentServiceConstants.ID_DEPARTMENT, idDepartment.getText());
            userInputValueHolder.put(IDepartmentServiceConstants.NAME, name.getText());
            userInputValueHolder.put(IDepartmentServiceConstants.ID_LOCATION, idLocation.getText());
            userInputValueHolder.put(IDepartmentServiceConstants.ID_FACULTY, idFaculty.getText());
            userInputValueHolder.put(IDepartmentServiceConstants.DESCRIPTION, description.getText());
            userInputValueHolder.put(IDepartmentServiceConstants.DEPARTMENT_HEAD_ID, departmentHeadID.getText());
            userInputValueHolder.put(IDepartmentServiceConstants.MAIN_CONTACT_ID, mainContactID.getText());
            final DepartmentService departmentService = new DepartmentService(userInputValueHolder);
            departmentService.updateDepartment();
        } catch (SmartEnrolException ex) {
            Logger.getLogger(AddDepartmentController.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
    }
}

