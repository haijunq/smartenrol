/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.administration.course;

import java.util.ArrayList;
import java.util.Collections;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import smartenrol.dao.CourseDAO;
import smartenrol.dao.DepartmentDAO;
import smartenrol.model.Course;
import smartenrol.model.view.CourseTable;
import smartenrol.page.SmartEnrolController;
import smartenrol.page.elements.icons.Icon;
import smartenrol.page.elements.icons.IconFactory;
import smartenrol.security.RegexHelper;

/**
 *
 * @author Jeremy
 */
public class AddCourseController extends SmartEnrolController  {
	
	private final DepartmentDAO departmentdao = new DepartmentDAO();
	private final CourseDAO coursedao = new CourseDAO();
	private ArrayList<String> deptList = new ArrayList<>();
	private ArrayList<String> prereqCourseNumber = new ArrayList<>();
	private ArrayList<String> coreqCourseNumber = new ArrayList<>();
	private ObservableList<CourseTable> prereq = FXCollections.observableArrayList();
	private ObservableList<CourseTable> coreq = FXCollections.observableArrayList();

	private final String PREREQTABLE = "PrereqTable";
	private final String COREQTABLE = "CoreqTable";
	
	@FXML private TextField fxCourseName;
	@FXML private TextField fxCourseNumber;
	@FXML private TextField fxCredits;
	@FXML private TextArea fxCourseDescription;
	
	@FXML private ComboBox fxDepartment;
	@FXML private ComboBox fxPrereqDept;
	@FXML private ComboBox fxPrereqCourse;
	@FXML private ComboBox fxCoreqDept;
	@FXML private ComboBox fxCoreqCourse;
	
	@FXML private CheckBox fxRestricted;
	
	@FXML private TableView fxPrereqTable;
	@FXML private TableView fxCoreqTable;
	
	@FXML private ScrollPane fxScrollPane;

	@Override
	public void init() {
		
		// clean up
		fxDepartment.getItems().clear();
		fxPrereqDept.getItems().clear();
		fxPrereqCourse.getItems().clear();
		fxCoreqDept.getItems().clear();
		fxCoreqCourse.getItems().clear();
		prereqCourseNumber.clear();
		coreqCourseNumber.clear();
		deptList.clear();
		
		// populate drop down menu
		deptList = departmentdao.getAllDeptID();
		Collections.sort(deptList);
		
		fxDepartment.getItems().add("");
		fxPrereqDept.getItems().add("");
		fxCoreqDept.getItems().add("");
		
		fxDepartment.getItems().addAll(deptList);
		fxPrereqDept.getItems().addAll(deptList);
		fxCoreqDept.getItems().addAll(deptList);
		
		fxDepartment.getSelectionModel().selectFirst();
		fxPrereqDept.getSelectionModel().selectFirst();
		fxCoreqDept.getSelectionModel().selectFirst();
		
		// add action listener
		fxPrereqDept.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
//				updatePrereqCourseNumber();
				updateCourseNumber(prereqCourseNumber, fxPrereqDept, fxPrereqCourse);
		}
		});
		
		fxCoreqDept.addEventHandler(ActionEvent.ACTION,  new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
//				updateCoreqCourseNumber();
				updateCourseNumber(coreqCourseNumber, fxCoreqDept, fxCoreqCourse);
			}
		});
		
		formatTable(fxPrereqTable);
		formatTable(fxCoreqTable);
	}
	
	@FXML
	private void updateCourseNumber(ArrayList<String> courseNumber, ComboBox comboDeptList, ComboBox comboCourseNumber){
		
		ArrayList<Course> courseList;
		courseNumber.clear();
		comboCourseNumber.getItems().clear();
		
		if (comboDeptList.getValue().toString().length() > 0) {
			
			courseList = coursedao.getCourseByDepartment(comboDeptList.getValue().toString());
			
			if (!courseList.isEmpty()) {
				
				for (Course course: courseList)
					
					courseNumber.add(String.valueOf(course.getIdCourse()));
				
				Collections.sort(courseNumber);
				comboCourseNumber.getItems().add("");
				comboCourseNumber.getItems().addAll(courseNumber);
				comboCourseNumber.getSelectionModel().selectFirst();
				
			}
		}
	}
/*	
	@FXML
	private void updatePrereqCourseNumber() {
		
		prereqCourseNumber.clear();
		fxPrereqCourse.getItems().clear();
		
		if (!(fxPrereqDept.getValue() == null)) {
			
			prereqCourseList = coursedao.getCourseByDepartment(fxPrereqDept.getValue().toString());
			
			if (!prereqCourseList.isEmpty()) {
				
				for (Course course: prereqCourseList)
					
					prereqCourseNumber.add(String.valueOf(course.getIdCourse()));
				
				Collections.sort(prereqCourseNumber);
				fxPrereqCourse.getItems().add("");
				fxPrereqCourse.getItems().addAll(prereqCourseNumber);
				fxPrereqCourse.getSelectionModel().selectFirst();
			}
		}
	}
	
	@FXML
	private void updateCoreqCourseNumber() {
		
		coreqCourseNumber.clear();
		fxCoreqCourse.getItems().clear();
		
		if (!(fxCoreqDept.getValue() == null)) {
			
			coreqCourseList = coursedao.getCourseByDepartment(fxCoreqDept.getValue().toString());
			
			if (!coreqCourseList.isEmpty()) {
				
				for (Course course: coreqCourseList)
					
					coreqCourseNumber.add(String.valueOf(course.getIdCourse()));
				
				Collections.sort(coreqCourseNumber);
				fxCoreqCourse.getItems().add("");
				fxCoreqCourse.getItems().addAll(coreqCourseNumber);
				fxCoreqCourse.getSelectionModel().selectFirst();
			}
		}
	}
*/	
	@FXML
	private void submitForm(MouseEvent event) throws Exception {
		
		String warningMsg = "";

		if (fxCourseName.getText().length() <= 0) 
			warningMsg = warningMsg + "Please enter a course name.\n";
		if (fxDepartment.getValue().toString().length() <= 0)
			warningMsg = warningMsg + "Please select a department.\n";
		if (fxCourseNumber.getText().length() <= 0) 
			warningMsg = warningMsg + "Please enter a course number.\n";
		else if (!RegexHelper.validate(fxCourseNumber.getText(), RegexHelper.RegExPattern.INT))
			warningMsg = warningMsg + "Course number is in integer format. Please try again.\n";
		if (fxCredits.getText().length() <= 0) 
			warningMsg = warningMsg + "Please enter the credit amount.\n";
		else if (!RegexHelper.validate(fxCredits.getText(), RegexHelper.RegExPattern.FLOAT))
			warningMsg = warningMsg + "Credit is in float format. Please try again.\n";
			
		if (warningMsg.length() > 0) 

			coursedao.addCourse(new Course(fxDepartment.getValue().toString(),
								Integer.parseInt(fxCourseNumber.getText()),
								Float.parseFloat(fxCredits.getText()),
								fxCourseName.getText(),
								fxCourseDescription.getText(),
								fxRestricted.isSelected()));
		
	}

	@FXML
	private void addPrereq(MouseEvent event) throws Exception {

		boolean toBeAdded = true;
		
		if (fxPrereqDept.getValue().toString().length() > 0 && fxPrereqCourse.getValue().toString().length() > 0) {

			CourseTable prereqToBeAdded = new CourseTable(fxPrereqDept.getValue().toString(), Integer.parseInt(fxPrereqCourse.getValue().toString()));

			for (CourseTable ct : prereq) {
				
				if (ct.getCourse().equalsIgnoreCase(prereqToBeAdded.getCourse())) {

					toBeAdded = false;
					break;
				}
			}
			
			if (toBeAdded) prereq.add(prereqToBeAdded);
		}
	}
	
	@FXML
	private void addCoreq(MouseEvent event) throws Exception {

		boolean toBeAdded = true;

		if (fxCoreqDept.getValue().toString().length() > 0 && fxCoreqCourse.getValue().toString().length() > 0) {

			CourseTable coreqToBeAdded = new CourseTable(fxCoreqDept.getValue().toString(), Integer.parseInt(fxCoreqCourse.getValue().toString()));

			for (CourseTable ct : coreq) {

				if (ct.getCourse().equalsIgnoreCase(coreqToBeAdded.getCourse())) {

					toBeAdded = false;
					break;
				}
			}
			
			if (toBeAdded) coreq.add(coreqToBeAdded);
		}
	}
	
	private void formatTable(final TableView tableView) {
		
		tableView.setEditable(false);
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		TableColumn tc0 = (TableColumn) tableView.getColumns().get(0);		// course
		TableColumn tc1 = (TableColumn) tableView.getColumns().get(1);		// button

		tc0.setSortable(false);
		tc1.setSortable(false);

		tc0.setResizable(false);
		tc1.setResizable(false);

		tc0.setCellValueFactory( new PropertyValueFactory<CourseTable, String>("course"));

		// button column for remove
		tc1.setCellValueFactory(
			new Callback<TableColumn.CellDataFeatures<CourseTable, Boolean>, ObservableValue<Boolean>>() {

				@Override
				public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<CourseTable, Boolean> p) {
					return new SimpleBooleanProperty(p.getValue() != null);
				}
			}
		);

        tc1.setCellFactory(
			new Callback<TableColumn<CourseTable, Boolean>, TableCell<CourseTable, Boolean>>() {

				@Override
				public TableCell<CourseTable, Boolean> call(TableColumn<CourseTable, Boolean> p) {
					return tableView.getId().equalsIgnoreCase(PREREQTABLE) ? new ButtonCell(fxPrereqTable) : new ButtonCell(fxCoreqTable);
				}
			}
        );

		tableView.setItems(tableView.getId().equalsIgnoreCase(PREREQTABLE) ? prereq : coreq);

		final TableColumn[] columns = {tc0, tc1};

		// disable column reordering
		tableView.getColumns().addListener(new ListChangeListener() {
			public boolean suspended;
			
			@Override
			public void onChanged(Change change) {
				change.next();
				if (change.wasReplaced() && !suspended) {
					this.suspended = true;
					tableView.getColumns().setAll((Object) columns);
					this.suspended = false;
				}
			}
		});
	}

	private class ButtonCell extends TableCell<CourseTable, Boolean> {

//		Icon cellButton = new IconFactory().getIcon(IconFactory.IconType.REMOVE);
		Button cellButton = new Button("X");
       
        ButtonCell(final TableView tableView){

            cellButton.setOnMouseClicked(new EventHandler<MouseEvent>(){

                @Override
                public void handle(MouseEvent event) {
                    
					System.out.println("ERRRR!!!");
			
//					tableView.getFocusModel().getFocusedItem();
					CourseTable toBeRemoved = (CourseTable) tableView.getSelectionModel().getSelectedItem();
					prereq.get(tableView.getSelectionModel().getSelectedIndex());
					System.out.println("--->" + toBeRemoved);
					if (tableView.getId().equalsIgnoreCase(PREREQTABLE)) {

						for (CourseTable ct : prereq) {

							if (ct.getCourse().equalsIgnoreCase(toBeRemoved.getCourse())) {
								
								prereq.remove(ct);
								break;
							}
						}

					} else {

						for (CourseTable ct : coreq) {

							if (ct.getCourse().equalsIgnoreCase(toBeRemoved.getCourse())) {
								
								coreq.remove(ct);
								break;
							}
						}
					}
                }
            });
        }

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);

            if(!empty)
                setGraphic(cellButton);
            
        }

    }

	public void removeSelectedItem(TableView tableView, ObservableList<Course> oList) {

		Object selectedItem = null;
		selectedItem = tableView.getFocusModel().getFocusedItem();
		
	}
}