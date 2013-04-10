/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.administration.section;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import smartenrol.page.SmartEnrolController;

/**
 *
 * @author Jeremy
 */
public class AddSectionController extends SmartEnrolController {
	
	@FXML ComboBox fxCourse;
	@FXML ComboBox fxInstructor;
	@FXML ComboBox fxDay;
	@FXML ComboBox fxStartTime;
	@FXML ComboBox fxLength;
	
	@FXML TableView fxSectionTable;
	@FXML Slider fxNumOfStudents;

	@Override
    public void init() {
        
    }

	@FXML
    private void submitForm(MouseEvent event) throws Exception {

	}

    @FXML
    private void addTime(MouseEvent event) throws Exception {

	}

}
