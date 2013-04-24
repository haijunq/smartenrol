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
import smartenrol.dao.SectionDAO;
import smartenrol.dao.SectionNodeDAO;
import smartenrol.dao.StudentSectionDAO;
import smartenrol.model.Building;
import smartenrol.model.Course;
import smartenrol.model.Instructor;
import smartenrol.model.Section;
import smartenrol.model.SectionNode;
import smartenrol.model.Timetable;
import smartenrol.model.User;
import smartenrol.model.view.SectionNodeTable;
import smartenrol.page.FormController;
import smartenrol.page.SmartEnrolController;
import smartenrol.page.elements.dialog.OpenDialog;
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
	private final SectionDAO sectiondao = new SectionDAO();
	private final SectionNodeDAO secnodedao = new SectionNodeDAO();
	private IconFactory icons = new IconFactory();
	private Timetable timetable = new Timetable();

	private ArrayList<String> deptList = new ArrayList<>();
	private ArrayList<String> courseList = new ArrayList<>();
	private ArrayList<String> instructorList = new ArrayList<>();
	private ArrayList<String> locationList = new ArrayList<>();
	private ArrayList<String> yearList = new ArrayList<>();
	private ArrayList<SectionNode> sectionNode = new ArrayList<>();
	private ArrayList<User> instructorArrList = new ArrayList<>();
	private ObservableList<SectionNodeTable> sectionNodeTable = FXCollections.observableArrayList();
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

				boolean toBeAdded = true;

				if (fxDay.getValue().toString().length() > 0 &&
					fxStartTime.getValue().toString().length() > 0 &&
					fxDuration.getValue().toString().length() > 0 &&
					fxLocation.getValue().toString().length() > 0 &&
					fxRoom.getText().length() > 0) {

					int day = convertDay(fxDay.getValue().toString());
					String idLocation = fxLocation.getValue().toString(),
						   idRoom = fxRoom.getText(),
						   duration = fxDuration.getValue().toString();
					LocalTime startTime = new LocalTime(fxStartTime.getValue().toString());
					LocalTime endTime = startTime.plusMinutes(Integer.parseInt(duration.substring(0, duration.indexOf(" "))));

					SectionNode tmpSecNode = new SectionNode(day, startTime, endTime, idLocation, idRoom);
					SectionNodeTable snodeToBeAdded = new SectionNodeTable(tmpSecNode);
					
//					timetable = studsecdao.getClassroomTimetable(idLocation, idRoom);
					
					for (SectionNodeTable snode : sectionNodeTable) {

						LocalTime st = new LocalTime(snode.getStartTime());
						LocalTime et = new LocalTime(snode.getEndTime());

						if (snode.getDay() == snodeToBeAdded.getDay() &&
							snode.getIdLocation().equalsIgnoreCase(snodeToBeAdded.getIdLocation()) &&
							snode.getIdRoom().equalsIgnoreCase(snodeToBeAdded.getIdRoom()) &&
							startTime.isEqual(st) && endTime.isEqual(st))  {
							
							// given that everything is the same, for the start time of the section node to be added
							// if it is after any of the start time or before any of the end time of any section nodes in the lsit
							// DONT add

							toBeAdded = false;
							break;
						}
					}
					
					if (toBeAdded) {
						
						sectionNode.add(tmpSecNode);
						sectionNodeTable.add(snodeToBeAdded);

						System.out.println("SectionNodeTableSize = " + sectionNodeTable.size());

					} 
				}
			}
		});

		// removeSection mouse listener
		removeSection.setOnMouseClicked(new EventHandler<MouseEvent> () {

			@Override
			public void handle (MouseEvent event) {

				if (fxSectionTable.getSelectionModel().getSelectedItem() != null) {

					SectionNodeTable toBeRemoved = (SectionNodeTable) fxSectionTable.getSelectionModel().getSelectedItem();
					LocalTime st = new LocalTime(toBeRemoved.getStartTime());
					LocalTime et = new LocalTime(toBeRemoved.getEndTime());

					sectionNodeTable.remove(fxSectionTable.getSelectionModel().getSelectedIndex());

					fxSectionTable.getSelectionModel().clearSelection();

				}
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
				
				if (!(RegexHelper.validate(newValue, RegexHelper.RegExPattern.INT)) || newValue.length() == 0 )	{
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

		String warningMsg = "";
		resetError();

		if (fxDepartment.getValue().toString().length() == 0) {
			warningMsg = warningMsg + "Please select a department";
			fxDepartmentTxt.setFill(Color.RED);
		}
		if (fxCourse.getValue().toString().length() == 0) {
			warningMsg = warningMsg + "Please select a course";
			fxCourseTxt.setFill(Color.RED);
		}
		if (fxSection.getText().isEmpty()) {
			warningMsg = warningMsg + "Please enter a section number in integer format";
			fxSectionTxt.setFill(Color.RED);
		}
		if (fxYear.getValue().toString().length() == 0) {
			warningMsg = warningMsg + "Please select a year";
			fxYearTxt.setFill(Color.RED);
		}
		if (fxInstructor.getValue().toString().length() == 0) {
			warningMsg = warningMsg + "Please select an instructor";
			fxInstructorTxt.setFill(Color.RED);
		}
		if (fxType.getValue().toString().length() == 0) {
			warningMsg = warningMsg + "Please select a type";
			fxTypeTxt.setFill(Color.RED);
		}
		if (fxTerm.getValue().toString().length() == 0) {
			warningMsg = warningMsg + "Please select a term";
			fxTermTxt.setFill(Color.RED);
		}
		if (fxNumOfStudentsSlider.getValue() == 0) {
			warningMsg = warningMsg + "Class size of 0?";
			fxInstructorTxt.setFill(Color.RED);
		}
		if (fxDay.getValue().toString().length() == 0) {
			warningMsg = warningMsg + "Please select a day for the section";
			fxDayTxt.setFill(Color.RED);
		}
		if (fxStartTime.getValue().toString().length() == 0) {
			warningMsg = warningMsg + "Please select a start time for the section";
			fxStartTimeTxt.setFill(Color.RED);
		}
		if (fxDuration.getValue().toString().length() == 0) {
			warningMsg = warningMsg + "Please select a duration for the section";
			fxDurationTxt.setFill(Color.RED);
		}
		if (fxLocation.getValue().toString().length() == 0) {
			warningMsg = warningMsg + "Please select a location for the section";
			fxLocationTxt.setFill(Color.RED);
		}
		if (!RegexHelper.validate(fxRoom.getText(), RegexHelper.RegExPattern.INT) || fxRoom.getText().isEmpty()) {
			warningMsg = warningMsg + "Please select a room for the section";
			fxRoomTxt.setFill(Color.RED);
		}

		if (warningMsg.length() == 0) {

			String idDepartment = fxDepartment.getValue().toString(),
				   idSection = fxSection.getText(),
				   type = fxType.getValue().toString(),
			       term = fxTerm.getValue().toString(),
				   notes = fxNotes.getValue().toString(),
				   givenName = instructorArrList.get(fxInstructor.getSelectionModel().getSelectedIndex()).getGivenName(),
				   surname = instructorArrList.get(fxInstructor.getSelectionModel().getSelectedIndex()).getSurname(),
				   startTime = fxStartTime.getValue().toString().concat(":00"),
				   idLocation = fxLocation.getValue().toString(),
				   idRoom = fxRoom.getText();
			int idInstructor = instructorArrList.get(fxInstructor.getSelectionModel().getSelectedIndex()).getIdUser(),
				idCourse = Integer.parseInt(fxCourse.getValue().toString()),
				year = Integer.parseInt(fxYear.getValue().toString()),
		     	maxClassSize = (int) fxNumOfStudentsSlider.getValue(),
				day = fxDay.getSelectionModel().getSelectedIndex(),
				duration = Integer.parseInt(fxDuration.getValue().toString().substring(0, 
					 												fxDuration.getValue().toString().indexOf(" ")));
			LocalTime localST = new LocalTime(startTime);
			LocalTime localET = localST.plusMinutes(duration);

			System.out.println("DEPARTMENT = " + idDepartment);
			System.out.println("COURSE = " + idCourse);
			System.out.println("SECTION = " + idSection);
			System.out.println("YEAR = " + year);
			System.out.println("TERM = " + term);
			System.out.println("NOTES = " + notes);
			System.out.println("TYPE = " + type);
			System.out.println("CLASS SIZE = " + maxClassSize);
			System.out.println("INSTRUCTOR = " + idInstructor);
			System.out.println("========================================");
			System.out.println("DAY = " + day);
			System.out.println("STARTTIME = " + localST.toString("HH:mm:ss"));
			System.out.println("DURATION = " + duration);
			System.out.println("LOCATION = " + idLocation);
			System.out.println("ROOM = " + idRoom);


			int section_flag = sectiondao.addSection(new Section(idDepartment, idCourse, idSection, year, term, 
																 notes, type, maxClassSize, idInstructor));

			int sectionNode_flag = secnodedao.addSectionNode(new SectionNode(idDepartment, idCourse, idSection, year,
																 term, day, localST, localET, idLocation, idRoom)); 

			System.out.println("SECTION FLAG = " + section_flag);
			System.out.println("SECTIONNODE FLAG = " + sectionNode_flag);

			if (section_flag == 1 && sectionNode_flag == 1) {

				new OpenDialog ("Section " + idSection + " for " + idDepartment + " " + 
								idCourse + " added successfully.").display();

				post_cleanup();
			}
		} else formController.showErrors(warningMsg);
	}

	@FXML
	private void departmentComboBox() {

		String selectedDept = fxDepartment.getSelectionModel().getSelectedItem().toString();
		
		courseList.clear();
		instructorList.clear();
		fxCourse.getItems().clear();
		fxInstructor.getItems().clear();
		
		ArrayList<Course> tmpCourseList = new ArrayList<>();
		
		if (selectedDept.length() > 0) {
			
			tmpCourseList = coursedao.getCourseByDepartment(selectedDept);
			instructorArrList = instructordao.getInstructorByDept(selectedDept);
			
			if (!tmpCourseList.isEmpty()) {
				
				for (Course course : tmpCourseList)
					courseList.add(String.valueOf(course.getIdCourse()));
				
				Collections.sort(courseList);
				fxCourse.getItems().add("");
				fxCourse.getItems().addAll(courseList);
				fxCourse.getSelectionModel().selectFirst();
			}
			
			if (!instructorArrList.isEmpty()) {		// need a way to associate to the idUser
				
				for (User user : instructorArrList)
					instructorList.add(user.getGivenName() + " " + user.getSurname());
				
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

		tc0.setCellValueFactory( new PropertyValueFactory<SectionNodeTable, String>("dayOfWeek"));
		tc1.setCellValueFactory( new PropertyValueFactory<SectionNodeTable, String>("startTime"));
		tc2.setCellValueFactory( new PropertyValueFactory<SectionNodeTable, String>("endTime"));
		tc3.setCellValueFactory( new PropertyValueFactory<SectionNodeTable, String>("idLocation"));
		tc4.setCellValueFactory( new PropertyValueFactory<SectionNodeTable, String>("idRoom"));

		tableView.setItems(sectionNodeTable);

		final TableColumn[] columns = {tc0, tc1, tc2, tc3, tc4};

		for (TableColumn tc : columns) {
			tc.setSortable(false);
			tc.setResizable(false);
		}

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
		fxYear.getItems().clear();
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