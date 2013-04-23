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
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.dao.BuildingDAO;
import smartenrol.dao.CourseDAO;
import smartenrol.dao.DepartmentDAO;
import smartenrol.dao.InstructorDAO;
import smartenrol.dao.StudentSectionDAO;
import smartenrol.model.Building;
import smartenrol.model.Course;
import smartenrol.model.Instructor;
import smartenrol.model.SectionNode;
import smartenrol.model.Timetable;
import smartenrol.model.view.SectionNodeTable;
import smartenrol.page.FormController;
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
	private final StudentSectionDAO studsecdao = new StudentSectionDAO();
	private IconFactory icons = new IconFactory();
	private Timetable timetable = new Timetable();

	private ArrayList<String> deptList = new ArrayList<>();
	private ArrayList<String> courseList = new ArrayList<>();
	private ArrayList<String> instructorList = new ArrayList<>();
	private ArrayList<String> locationList = new ArrayList<>();
	private ArrayList<String> yearList = new ArrayList<>();
	private ArrayList<SectionNode> section = new ArrayList<>();
	private ArrayList<SectionNodeTable> sectionNodeTable = new ArrayList<>();
	private Icon addSection, removeSection;

	@Autowired
	private FormController formController;

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
        
		formController.setFormName("Add Section");
		init_cleanup();

		// populate department combo box
		deptList = departmentdao.getAllDeptID();
		Collections.sort(deptList);
		fxDepartment.getItems().add("");
		fxDepartment.getItems().addAll(deptList);
		fxDepartment.getSelectionModel().selectFirst();

		// populate location combo box
		for (Building b : buildingdao.getAllBuilding())
			locationList.add(b.getIdLocation());
		Collections.sort(locationList);
		fxLocation.getItems().add("");
		fxLocation.getItems().addAll(locationList);
		fxLocation.getSelectionModel().selectFirst();

		// populate year combo box
//		for (int i = new LocalDate().getYear(), j = 0; j <= 4; j++ ) 
//			yearList.add(String.valueOf(i + j));
//		Collections.sort(yearList);
		fxYear.getItems().add("");
		fxYear.getItems().addAll("2013");
		fxYear.getSelectionModel().selectFirst();

		// initialize buttons
		addSection = icons.getIcon(IconFactory.IconType.ADD);
		removeSection = icons.getIcon(IconFactory.IconType.REMOVE_SELECTED);
		fxButtons.getChildren().add(addSection);
		fxButtons.getChildren().add(removeSection);

		formatTable(fxSectionTable);
		
		// addSecion mouse listener
		addSection.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle (MouseEvent event) {

				if (fxDay.getValue().toString().length() > 0 &&
					fxStartTime.getValue().toString().length() > 0 &&
					fxDuration.getValue().toString().length() > 0 &&
					fxLocation.getValue().toString().length() > 0 &&
					fxRoom.getText().length() > 0) {

					int day = convertDay(fxDay.getValue().toString());
					LocalTime startTime = new LocalTime(fxStartTime.getValue().toString());
					LocalTime endTime = startTime.plusMinutes(Integer.parseInt(fxDuration.getValue().toString().substring(0, 1)));
					String idLocation = fxLocation.getValue().toString(),
						   idRoom = fxRoom.getText();

					SectionNode tmpSecNode = new SectionNode(day, startTime, endTime, idLocation, idRoom);
					SectionNodeTable snodeToBeAdded = new SectionNodeTable(tmpSecNode);
					
					timetable = studsecdao.getClassroomTimetable(idLocation, idRoom);

					System.out.println("zzzzz");
					if (section.isEmpty()) {
						
					System.out.println("xxxxxxx");
						section.add(tmpSecNode);
						sectionNodeTable.add(snodeToBeAdded);

					} else if (!timetable.isConflict(section)) {

					System.out.println("zzzzzzzz");
						section.add(tmpSecNode);
						sectionNodeTable.add(snodeToBeAdded);

					}
				}
			}
		});

		// removeSection mouse listener
		removeSection.setOnMouseClicked(new EventHandler<MouseEvent> () {

			@Override
			public void handle (MouseEvent event) {


			}
		});
		
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
				
				if (!(RegexHelper.validate(newValue, RegexHelper.RegExPattern.INT)) || newValue.length() == 0)	{
					newValue = "0";
					fxNumOfStudents.setText("");
				}

				fxNumOfStudentsSlider.setValue(Double.parseDouble(newValue));
			}
		});

		
		formController.getSubmitButton().setOnMouseClicked(new EventHandler<MouseEvent> () {

			@Override
			public void handle (MouseEvent event) {

				submitForm();
			}
		});
    }
			

	@FXML
    private void submitForm() {

		
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


	private void formatTable (final TableView tableView) {

		tableView.setEditable(false);
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		TableColumn tc0 = (TableColumn) tableView.getColumns().get(0);		// day
		TableColumn tc1 = (TableColumn) tableView.getColumns().get(1);		// startTime
		TableColumn tc2 = (TableColumn) tableView.getColumns().get(2);		// endTime
		TableColumn tc3 = (TableColumn) tableView.getColumns().get(3);		// location
		TableColumn tc4 = (TableColumn) tableView.getColumns().get(4);		// room

		final TableColumn[] columns = {tc0, tc1, tc2, tc3, tc4};

		for (TableColumn tc : columns) {
			tc.setSortable(false);
			tc.setResizable(false);
		}

		tc0.setCellValueFactory( new PropertyValueFactory<SectionNodeTable, String>("dayOfWeek"));
		tc1.setCellValueFactory( new PropertyValueFactory<SectionNodeTable, String>("startTime"));
		tc2.setCellValueFactory( new PropertyValueFactory<SectionNodeTable, String>("endTime"));
		tc3.setCellValueFactory( new PropertyValueFactory<SectionNodeTable, String>("idLocation"));
		tc4.setCellValueFactory( new PropertyValueFactory<SectionNodeTable, String>("idRoom"));

		tableView.setItems(FXCollections.observableArrayList(sectionNodeTable));

		// disable column reordering
		tableView.getColumns().addListener(new ListChangeListener() {
		
			public boolean suspended;
			
			@Override
			public void onChanged(Change change) {
				change.next();
				if (change.wasReplaced() && !suspended) {
					this.suspended = true;
					tableView.getColumns().setAll(columns);
					this.suspended = false;
				}
			}
		
		});

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
	
	private void removeSelectedItem(MouseEvent me) throws Exception {

		if (me.getSource() == addSection) {

			
		} 
	}

	private int convertDay(String day) {

		int day_num = 0;
		switch (day) {

			case "Monday":		
				day_num = 1;
				break;
			case "Tuesday":
				day_num = 2;
				break;
			case "Wednesday":
				day_num = 3;
				break;
			case "Thursday":
				day_num = 4;
				break;
			case "Friday":	
				day_num = 5;
				break;
			case "Saturday":
				day_num = 6;
				break;
			case "Sunday":
				day_num = 7;
				break;
			default: day_num = 0;
		}

		return day_num;
	}
}