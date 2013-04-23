/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.administration.section;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import smartenrol.dao.BuildingDAO;
import smartenrol.dao.CourseDAO;
import smartenrol.dao.DepartmentDAO;
import smartenrol.dao.InstructorDAO;
import smartenrol.model.Building;
import smartenrol.model.Course;
import smartenrol.model.Instructor;
import smartenrol.page.SmartEnrolController;
import smartenrol.page.elements.icons.Icon;
import smartenrol.page.elements.icons.IconFactory;
import smartenrol.security.RegexHelper;

/**
 *
 * @author Jeremy
 */
public class AddSectionController extends SmartEnrolController {
	
	private final BuildingDAO buildingdao = new BuildingDAO();
	private final DepartmentDAO departmentdao = new DepartmentDAO();
	private final CourseDAO coursedao = new CourseDAO();
	private final InstructorDAO instructordao = new InstructorDAO();
	private IconFactory icons = new IconFactory();

	private ArrayList<String> deptList = new ArrayList<>();
	private ArrayList<String> courseList = new ArrayList<>();
	private ArrayList<String> instructorList = new ArrayList<>();
	private ArrayList<String> locationList = new ArrayList<>();
	private Icon addSection, removeSection;

	@FXML 
	private ComboBox fxDepartment, fxCourse, fxType, fxInstructor,
					 fxYear, fxTerm, fxNotes,
					 fxDay, fxStartTime, fxDuration, fxLocation;
	
	@FXML
	private TextField fxSection, fxNumOfStudents, fxRoom;

	@FXML 
	private Text fxDepartmentTxt, fxCourseTxt, fxSectionTxt, fxTypeTxt,
			     fxInstructorTxt, fxYearTxt, fxTermTxt, fxNotesTxt,
				 fxDayTxt, fxStartTimeTxt, fxDurationTxt,
				 fxLocationTxt, fxRoomTxt;

	@FXML
	private TableView fxSectionTable;
	
	@FXML 
	private Slider fxNumOfStudentsSlider;

	@FXML
	private HBox fxButtons;

	@Override
    public void init() {
        
		init_cleanup();

		// populate department
		deptList = departmentdao.getAllDeptID();
		Collections.sort(deptList);
		fxDepartment.getItems().add("");
		fxDepartment.getItems().addAll(deptList);
		fxDepartment.getSelectionModel().selectFirst();

		// populate location
		for (Building b : buildingdao.getAllBuilding())
			locationList.add(b.getIdLocation());
		Collections.sort(locationList);
		fxLocation.getItems().add("");
		fxLocation.getItems().addAll(locationList);
		fxLocation.getSelectionModel().selectFirst();

		// slider change listener
		fxNumOfStudentsSlider.valueProperty().addListener(new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

				fxNumOfStudents.setText(String.valueOf(newValue.intValue()));
			}
		});

		// textfield change listener
		fxNumOfStudents.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				
				System.out.println("---> " + newValue);
				if (!(RegexHelper.validate(newValue, RegexHelper.RegExPattern.INT)) || newValue.length() == 0)	{
					System.out.println("ERR");
					newValue = "0";
				}

				Integer.parseInt(newValue);
				if (newValue.endsWith("f") || newValue.endsWith("d"))
					fxNumOfStudents.setText(newValue.substring(0, newValue.length()-1));
				
				fxNumOfStudentsSlider.setValue(Double.parseDouble(newValue));
			}
		});


		addSection = icons.getIcon(IconFactory.IconType.ADD);
		removeSection = icons.getIcon(IconFactory.IconType.REMOVE_SELECTED);
		fxButtons.getChildren().add(addSection);
		fxButtons.getChildren().add(removeSection);
    }

	@FXML
    private void submitForm(MouseEvent event) throws Exception {

	}

    @FXML
    private void addTime(MouseEvent event) throws Exception {

	}

	@FXML
	private void departmentComboBox() {

		String selectedDept = fxDepartment.getSelectionModel().getSelectedItem().toString();
		
		courseList.clear();
		instructorList.clear();
		fxCourse.getItems().clear();
		fxInstructor.getItems().clear();
		
		ArrayList<Course> tmpCourseList = new ArrayList<>();
		ArrayList<Instructor> tmpInstructorList = new ArrayList<>();
		
		if (selectedDept.length() > 0) {
			
			System.out.println("---> " + selectedDept);
			tmpCourseList = coursedao.getCourseByDepartment(selectedDept);
			tmpInstructorList = instructordao.getInstructorByDept(selectedDept);
			
			if (!tmpCourseList.isEmpty()) {
				
				for (Course course : tmpCourseList)
					courseList.add(String.valueOf(course.getIdCourse()));
				
				Collections.sort(courseList);
				fxCourse.getItems().add("");
				fxCourse.getItems().addAll(courseList);
				fxCourse.getSelectionModel().selectFirst();
			}
			
			if (!tmpInstructorList.isEmpty()) {		// need a way to associate to the idUser
				
				for (Instructor instructor : tmpInstructorList)
					instructorList.add(instructor.getFullName());
				
				Collections.sort(instructorList);
				fxInstructor.getItems().add("");
				fxInstructor.getItems().addAll(instructorList);
				fxInstructor.getSelectionModel().selectFirst();
			}
		}
	}

	private void init_cleanup(){

		fxDepartment.getItems().clear();
		fxCourse.getItems().clear();
		fxInstructor.getItems().clear();
		fxLocation.getItems().clear();
		fxType.getSelectionModel().selectFirst();
		fxYear.getSelectionModel().selectFirst();
		fxTerm.getSelectionModel().selectFirst();
		fxNotes.getSelectionModel().selectFirst();
		fxDay.getSelectionModel().selectFirst();
		fxStartTime.getSelectionModel().selectFirst();
		fxDuration.getSelectionModel().selectFirst();
		fxNumOfStudentsSlider.setValue(0);
		fxNumOfStudents.setText("0");
		fxSection.setText("");
		fxRoom.setText("");
		deptList.clear();
		instructorList.clear();
		courseList.clear();
		locationList.clear();

	}

	private void post_cleanup() {

		fxDepartment.getSelectionModel().selectFirst();
		fxType.getSelectionModel().selectFirst();
		fxYear.getSelectionModel().selectFirst();
		fxTerm.getSelectionModel().selectFirst();
		fxNotes.getSelectionModel().selectFirst();
		fxDay.getSelectionModel().selectFirst();
		fxStartTime.getSelectionModel().selectFirst();
		fxDuration.getSelectionModel().selectFirst();
		fxLocation.getSelectionModel().selectFirst();
		fxCourse.getItems().clear();
		fxNumOfStudentsSlider.setValue(0);
		fxNumOfStudents.setText("0");
		fxSection.setText("");
		fxRoom.setText("");

	}

	private void resetError(){

		fxDepartmentTxt.setFill(Color.BLACK);
		fxCourseTxt.setFill(Color.BLACK);
		fxSectionTxt.setFill(Color.BLACK);
		fxTypeTxt.setFill(Color.BLACK);
		fxInstructorTxt.setFill(Color.BLACK);
		fxYearTxt.setFill(Color.BLACK);
		fxTermTxt.setFill(Color.BLACK);
		fxNotesTxt.setFill(Color.BLACK);
		fxDayTxt.setFill(Color.BLACK);
		fxDurationTxt.setFill(Color.BLACK);
		fxStartTimeTxt.setFill(Color.BLACK);
		fxLocationTxt.setFill(Color.BLACK);
		fxRoomTxt.setFill(Color.BLACK);
	}
	
}