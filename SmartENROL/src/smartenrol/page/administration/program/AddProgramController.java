/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.administration.program;

import java.util.ArrayList;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.dao.CourseDAO;
import smartenrol.dao.DepartmentDAO;
import smartenrol.dao.ProgramCoursesDAO;
import smartenrol.dao.ProgramDAO;
import smartenrol.model.Course;
import smartenrol.model.view.CourseTable;
import smartenrol.page.FormController;
import smartenrol.page.SmartEnrolController;
import smartenrol.page.elements.icons.Icon;
import smartenrol.page.elements.icons.IconFactory;
import smartenrol.security.RegexHelper;

/**
 *
 * @author Jeremy
 */
public class AddProgramController extends SmartEnrolController  {

	private final DepartmentDAO departmentdao = new DepartmentDAO();
	private final CourseDAO coursedao = new CourseDAO();
	private final ProgramDAO programdao = new ProgramDAO();
	private final ProgramCoursesDAO programcoursesdao = new ProgramCoursesDAO();
	private ArrayList<String> deptList = new ArrayList<>();
	private ArrayList<String> courseList = new ArrayList<>();
	private ObservableList<CourseTable> courseTable = FXCollections.observableArrayList();
	private IconFactory icons = new IconFactory();

	private Icon addCourse, removeCourse;

	@Autowired
	private FormController formController;

	@FXML
	private TextField fxProgramID, fxProgramName, fxCredits;
	
	@FXML
	private TextArea fxDescription;

	@FXML 
	private ComboBox fxDepartment, fxCourse;

	@FXML
	private TableView fxProgramTable;

	@FXML
	private Text fxProgramIDTxt, fxProgramNameTxt, fxDepartmentTxt, fxCreditsTxt;

	@FXML
	private HBox fxButtons;

	
    public void init() {

		formController.setFormName("Add Program");
		init_cleanup();

		// populate drop down menu for department
		deptList = departmentdao.getAllDeptID();
		Collections.sort(deptList);
        
		fxDepartment.getItems().add("");
		fxDepartment.getItems().addAll(deptList);
		fxDepartment.getSelectionModel().selectFirst();

		fxDepartment.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle (ActionEvent event) {

				ArrayList<Course> tmpCourseList = new ArrayList<>();
				fxCourse.getItems().clear();

				if (fxDepartment.getValue() != null && fxDepartment.getValue().toString().length() > 0) {

					tmpCourseList = coursedao.getCourseByDepartment(fxDepartment.getValue().toString());

					if (!tmpCourseList.isEmpty()) {

						for (Course course: tmpCourseList)
							courseList.add(String.valueOf(course.getIdCourse()));
						
						Collections.sort(courseList);
						fxCourse.getItems().add("");
						fxCourse.getItems().addAll(courseList);
						fxCourse.getSelectionModel().selectFirst();

					}
				}
			}
		});

		addCourse = icons.getIcon(IconFactory.IconType.ADD);
		addCourse.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				boolean toBeAdded = true;
				
				if (fxDepartment.getValue().toString().length() > 0 && fxCourse.getValue().toString().length() > 0) {
					
					CourseTable courseToBeAdded = new CourseTable(coursedao.getCourseByID(fxDepartment.getValue().toString(), Integer.parseInt(fxCourse.getValue().toString())));
					
					for (CourseTable ct : courseTable) {
						
						if (ct.getCourse().equalsIgnoreCase(courseToBeAdded.getCourse())) {
							
							toBeAdded = false;
							break;
						}
					}
					
					if (toBeAdded) courseTable.add(courseToBeAdded);

				}
			}
		});

		removeCourse = icons.getIcon(IconFactory.IconType.ADD);
		removeCourse.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				
				if (fxProgramTable.getSelectionModel().getSelectedItem() != null) {
					
					CourseTable toBeRemoved = (CourseTable) fxProgramTable.getSelectionModel().getSelectedItem();
					
					for (CourseTable ct : courseTable) {
						
						if (ct.getCourse().equalsIgnoreCase(toBeRemoved.getCourse())) {
							
							courseTable.remove(ct);
							break;
						}
					}
				}
			}
		});


		fxButtons.getChildren().add(addCourse);
		fxButtons.getChildren().add(removeCourse);

		formController.getSubmitButton().setOnMouseClicked(new EventHandler<MouseEvent> () {

			@Override
			public void handle (MouseEvent event) {

				submitForm();
				
			}
		});

	}

	private void submitForm() {
		
		String programName = fxProgramName.getText(),
			   programID = fxProgramID.getText(),
			   programDesc = fxDescription.getText(),
			   department = fxDepartment.getValue().toString(),
			   warningMsg = "";

		if (!RegexHelper.validate(fxProgramID.getText(), RegexHelper.RegExPattern.UPPERCASE_LETTER) || fxCredits.getText().isEmpty()) {
			fxCreditsTxt.setFill(Color.RED);
			warningMsg = warningMsg + "Please enter a ID for the program";
		}

		if (programName == null || programName.isEmpty()) {
			fxProgramNameTxt.setFill(Color.RED);
			warningMsg = warningMsg + "Please enter a progran name.\n";
		}

		if (department == null || department.isEmpty()) {
			fxDepartmentTxt.setFill(Color.RED);
			warningMsg = warningMsg + "Please select a department.\n";
		}

		if (!RegexHelper.validate(fxCredits.getText(), RegexHelper.RegExPattern.INT) || fxCredits.getText().isEmpty()) {
			fxCreditsTxt.setFill(Color.RED);
			warningMsg = warningMsg + "Please enter the credits amount in float format";
		}

		if (warningMsg.length() == 0) {

//			int program_flag = programdao.addProgram(new Program (
//					programName, )))
		} else formController.showErrors(warningMsg);
	}

	private void resetError() {

		fxProgramIDTxt.setFill(Color.BLACK);
		fxProgramNameTxt.setFill(Color.BLACK);
		fxDepartmentTxt.setFill(Color.BLACK);
		fxCreditsTxt.setFill(Color.BLACK);
	}

	private void init_cleanup() {

		fxProgramName.setText("");
		fxProgramID.setText("");
		fxDescription.setText("");
		fxCredits.setText("");
		fxDepartment.getItems().clear();
		fxCourse.getItems().clear();
		deptList.clear();
		courseList.clear();
		courseTable.clear();
		resetError();

	}

	/**
	 *  gui clean up upon successfully adding a course
	 */
	private void post_cleanup(){
		
		fxDepartment.getSelectionModel().selectFirst();
		fxCourse.getItems().clear();
		courseTable.clear();
		fxProgramName.setText("");
		fxDescription.setText("");
		fxProgramID.setText("");
		fxCredits.setText("");
		resetError();
		
	}

	private void formatTable (final TableView tableView) {
		
		tableView.setEditable(false);
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		TableColumn tc0 = (TableColumn) tableView.getColumns().get(0);		// day
		TableColumn tc1 = (TableColumn) tableView.getColumns().get(1);		// startTime
		TableColumn tc2 = (TableColumn) tableView.getColumns().get(2);		// endTime
		
		tc0.setCellValueFactory( new PropertyValueFactory<CourseTable, String>("course"));
		tc1.setCellValueFactory( new PropertyValueFactory<CourseTable, String>("name"));
		tc2.setCellValueFactory( new PropertyValueFactory<CourseTable, Float>("credit"));

		tableView.setItems(courseTable);
		
		final TableColumn[] columns = {tc0, tc1, tc2};
		
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
}
