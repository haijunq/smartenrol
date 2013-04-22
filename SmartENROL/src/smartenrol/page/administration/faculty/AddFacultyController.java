/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.administration.faculty;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.SmartEnrolException;
import smartenrol.page.Navigator;
import smartenrol.page.SmartEnrolController;
import smartenrol.page.error.ErrorController;

/**
 *
 * @author Jeremy
 */
public class AddFacultyController extends SmartEnrolController  {
    
    @Autowired private Navigator navigator;
    
    public void init() {
        
        if (!hasAccess())
            ((ErrorController)navigator.navigate(Page.ERROR)).load(PageError.ACCESS_DENIED);

    }
    
    public boolean hasAccess() {
        if (getUserSession().checkPermission("add-faculty"))
            return true;
        else 
            return false;
    }
    /*
    @FXML
    public void submitForm(MouseEvent event) throws Exception {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();
            userInputValueHolder.put(IFacultyServiceConstants.ID_FACULTY, idFaculty.getText());
            userInputValueHolder.put(IFacultyServiceConstants.NAME, facultyName.getText());
            //userInputValueHolder.put(IFacultyServiceConstants.DESCRIPTION, Description.getText());
            //userInputValueHolder.put(IFacultyServiceConstants.HEAD_OFFICE_LOCATION, HeadOfficeLocation.getText());
            //userInputValueHolder.put(IFacultyServiceConstants.MAIN_PHONE, MainPhone.getText());
            //userInputValueHolder.put(IFacultyServiceConstants.DEAN_ID, DeanID.getText());
            //userInputValueHolder.put(IFacultyServiceConstants.MAIN_CONTACT_ID, MainContactID.getText());
            final FacultyService facultyService = new FacultyService(userInputValueHolder);
            facultyService.insertFaculty();
        } catch (SmartEnrolException ex) {
            Logger.getLogger(AddFacultyController.class.getName()).log(Level.SEVERE, null, ex.getMessage());
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
    