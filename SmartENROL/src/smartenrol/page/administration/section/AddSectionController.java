/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.administration.section;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import smartenrol.dao.CourseDAO;
import smartenrol.dao.DepartmentDAO;
import smartenrol.dao.InstructorDAO;
import smartenrol.page.SmartEnrolController;
import smartenrol.page.elements.icons.Icon;
import smartenrol.page.elements.icons.IconFactory;

/**
 *
 * @author Jeremy
 */
public class AddSectionController extends SmartEnrolController {
	
	private final DepartmentDAO departmentdao = new DepartmentDAO();
	private final CourseDAO coursedao = new CourseDAO();
	private final InstructorDAO instructordao = new InstructorDAO();
	private IconFactory icons = new IconFactory();

	private ArrayList<String> deptList = new ArrayList<>();
	private Icon addSection, removeSection;

	@FXML 
	private ComboBox fxDepartment, fxCourse, fxInstructor, fxDay, fxStartTime, fxDuration;
	
	@FXML 
	private Text fxDepartmentTxt, fxCourseTxt, fxInstructorTxt,fxDayTxt, fxStartTimeTxt, fxDurationTxt;

	@FXML
	private TableView fxSectionTable;
	
	@FXML 
	private Slider fxNumOfStudents;

	@Override
    public void init() {
        
    }

	@FXML
    private void submitForm(MouseEvent event) throws Exception {

	}

    @FXML
    private void addTime(MouseEvent event) throws Exception {

	}


	private void cleanUp(){

		fxDepartment.getItems().clear();
		fxCourse.getItems().clear();
		fxInstructor.getItems().clear();
		fxDay.getItems().clear();
		fxStartTime.getItems().clear();
		fxDuration.getItems().clear();
		fxNumOfStudents.setValue(0);
		deptList.clear();

	}

	private void resetError(){

		fxCourseTxt.setFill(Color.BLACK);
		fxInstructorTxt.setFill(Color.BLACK);
		fxDayTxt.setFill(Color.BLACK);
		fxDepartmentTxt.setFill(Color.BLACK);
		fxDurationTxt.setFill(Color.BLACK);
	}
	
}
