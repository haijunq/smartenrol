/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.administration.course;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import smartenrol.page.SmartEnrolController;

/**
 *
 * @author Jeremy
 */
public class AddCourseController extends SmartEnrolController  {
    
    @FXML TextField fxCourseName;
    @FXML TextField fxCourseNumber;
    @FXML TextArea fxCourseDescription;

    @FXML ComboBox fxDepartment;
    @FXML ComboBox fxPrereqDept;
    @FXML ComboBox fxPrereqCourse;
    @FXML ComboBox fxCoreqDept;
    @FXML ComboBox fxCoreqCourse;

	@FXML TableView fxPrereqTable;
	@FXML TableView fxCoreqTable;

	@Override
    public void init() {
        
    }  
    
    @FXML
    private void submitForm(MouseEvent event) throws Exception {

	}

    @FXML
    private void addPrereq(MouseEvent event) throws Exception {

	}

    @FXML
    private void addCoreq(MouseEvent event) throws Exception {

	}
}
