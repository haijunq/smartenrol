/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.administration.course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Callback;
import smartenrol.dao.CorequisiteDAO;
import smartenrol.dao.CourseDAO;
import smartenrol.dao.DepartmentDAO;
import smartenrol.dao.PrerequisiteDAO;
import smartenrol.model.Corequisite;
import smartenrol.model.Course;
import smartenrol.model.Prerequisite;
import smartenrol.model.view.CourseTable;
import smartenrol.page.SmartEnrolController;
import smartenrol.page.elements.dialog.ErrorDialog;
import smartenrol.page.elements.dialog.OpenDialog;
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
	private final PrerequisiteDAO prereqdao = new PrerequisiteDAO();
	private final CorequisiteDAO coreqdao = new CorequisiteDAO();
	private ArrayList<String> deptList = new ArrayList<>();
	private ArrayList<String> prereqCourseNumber = new ArrayList<>();
	private ArrayList<String> coreqCourseNumber = new ArrayList<>();
	private ObservableList<CourseTable> prereq = FXCollections.observableArrayList();
	private ObservableList<CourseTable> coreq = FXCollections.observableArrayList();
	private IconFactory icons = new IconFactory();
	
	private final String PREREQTABLE = "PrereqTable";
	private final String COREQTABLE = "CoreqTable";
	private Icon addPrereqIcon, addCoreqIcon, removePrereqIcon, removeCoreqIcon;
	
	@FXML
	private TextField fxCourseName, fxCourseNumber, fxCredits, fxCourseDescription;

	@FXML
	private Text fxCourseNameTxt, fxCourseNumberTxt, fxCreditsTxt, fxDepartmentTxt;
	
	@FXML
	private ComboBox fxDepartment, fxPrereqDept, fxPrereqCourse, fxCoreqDept, fxCoreqCourse;
	
	@FXML
	private CheckBox fxRestricted;
	
	@FXML 
	private TableView fxPrereqTable, fxCoreqTable;

	@FXML 
	private HBox fxPrereqButtons, fxCoreqButtons;
	
	@FXML 
	private ScrollPane fxScrollPane;
	
	@Override
	public void init() {
		
		cleanUp();
		
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
				updateCourseNumber(prereqCourseNumber, fxPrereqDept, fxPrereqCourse);
			}
		});
		
		fxCoreqDept.addEventHandler(ActionEvent.ACTION,  new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				updateCourseNumber(coreqCourseNumber, fxCoreqDept, fxCoreqCourse);
			}
		});
		
		addPrereqIcon = icons.getIcon(IconFactory.IconType.ADD);
		addPrereqIcon.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				boolean toBeAdded = true;
				
				if (fxPrereqDept.getValue().toString().length() > 0 && fxPrereqCourse.getValue().toString().length() > 0) {
					
					CourseTable prereqToBeAdded = new CourseTable(new Course(fxPrereqDept.getValue().toString(), Integer.parseInt(fxPrereqCourse.getValue().toString())));
					
					for (CourseTable ct : prereq) {
						
						if (ct.getCourse().equalsIgnoreCase(prereqToBeAdded.getCourse())) {
							
							toBeAdded = false;
							break;
						}
					}
					
					if (toBeAdded) prereq.add(prereqToBeAdded);
				}
			}
		});

		addCoreqIcon = icons.getIcon(IconFactory.IconType.ADD);
		addCoreqIcon.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				boolean toBeAdded = true;
				
				if (fxCoreqDept.getValue().toString().length() > 0 && fxCoreqCourse.getValue().toString().length() > 0) {
					
					CourseTable coreqToBeAdded = new CourseTable(new Course(fxCoreqDept.getValue().toString(), Integer.parseInt(fxCoreqCourse.getValue().toString())));
					
					for (CourseTable ct : coreq) {
						
						if (ct.getCourse().equalsIgnoreCase(coreqToBeAdded.getCourse())) {
							
							toBeAdded = false;
							break;
						}
					}
					
					if (toBeAdded) coreq.add(coreqToBeAdded);
				}
			}
		});

		removePrereqIcon = icons.getIcon(IconFactory.IconType.REMOVE_SELECTED);
		removePrereqIcon.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle (MouseEvent me) {
				try {
					removeSelectedItems(me);
				} catch (Exception ex) {
					Logger.getLogger(AddCourseController.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});

		removeCoreqIcon = icons.getIcon(IconFactory.IconType.REMOVE_SELECTED);
		removeCoreqIcon.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle (MouseEvent me) {
				try {
					removeSelectedItems(me);
				} catch (Exception ex) {
					Logger.getLogger(AddCourseController.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
		
		fxPrereqButtons.getChildren().add(addPrereqIcon);
		fxPrereqButtons.getChildren().add(removePrereqIcon);
		
		fxCoreqButtons.getChildren().add(addCoreqIcon);
		fxCoreqButtons.getChildren().add(removeCoreqIcon);

		formatTable(fxPrereqTable);
		formatTable(fxCoreqTable);
	}

	private void cleanUp(){

		fxDepartment.getItems().clear();
		fxPrereqDept.getItems().clear();
		fxPrereqCourse.getItems().clear();
		fxCoreqDept.getItems().clear();
		fxCoreqCourse.getItems().clear();
		prereqCourseNumber.clear();
		coreqCourseNumber.clear();
		deptList.clear();
		prereq.clear();
		coreq.clear();

	}

	private void resetError(){

		fxCourseNameTxt.setFill(Color.RED);
		fxCourseNumberTxt.setFill(Color.RED);
		fxCreditsTxt.setFill(Color.RED);
		fxDepartmentTxt.setFill(Color.RED);
	}
	
	/**
	 * Not sure if it's because the params are passed by reference and causing sql bugs
	 * @param courseNumber
	 * @param comboDeptList
	 * @param comboCourseNumber 
	 */
	@FXML
	private void updateCourseNumber(ArrayList<String> courseNumber, ComboBox comboDeptList, ComboBox comboCourseNumber){
		
		ArrayList<Course> courseList = new ArrayList<>();
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
	 
	@FXML
	private void submitForm(MouseEvent event) throws Exception {
		
		String warningMsg = "";
		resetError();
		
		if (!RegexHelper.validate(fxCourseName.getText(), RegexHelper.RegExPattern.COURSE_NAME)){
			warningMsg = warningMsg + "Please enter a course name with a maximum of 45 characters.\n";
			fxCourseNameTxt.setFill(Color.RED);
		}
		if (fxDepartment.getValue().toString().length() <= 0) {
			warningMsg = warningMsg + "Please select a department.\n";
			fxDepartmentTxt.setFill(Color.RED);
		}
		if (!RegexHelper.validate(fxCourseNumber.getText(), RegexHelper.RegExPattern.COURSE_NUMBER)) {
			warningMsg = warningMsg + "Please enter a course number in integer format with a maximum of 11 digits.\n";
			fxCourseNumberTxt.setFill(Color.RED);
		}
		if (!RegexHelper.validate(fxCredits.getText(), RegexHelper.RegExPattern.FLOAT) || fxCredits.getText().isEmpty()) {
			warningMsg = warningMsg + "Please enter the credit amount.\n";
			fxCreditsTxt.setFill(Color.RED);
		}
		
		if (warningMsg.length() == 0) {
			
			String courseDept = fxDepartment.getValue().toString();
			int courseNumber = Integer.parseInt(fxCourseNumber.getText());
			float courseCredits = Float.parseFloat(fxCredits.getText());
			String courseName =  fxCourseName.getText();
			String courseDesc = fxCourseDescription.getText();
			boolean courseRestriction = fxRestricted.isSelected();

			int course_flag = coursedao.addCourse(new Course(courseDept, courseNumber, courseCredits, courseName, courseDesc, courseRestriction));

			if (!prereq.isEmpty()) {
				
				for (CourseTable ct : prereq) 

					prereqdao.addPrerequisite(new Prerequisite(courseDept, courseNumber, ct.getIdDepartment(), ct.getIdCourse()));
			}	

			if (!coreq.isEmpty()) {
				
				for (CourseTable ct : coreq) 

					coreqdao.addCorequisite(new Corequisite(courseDept, courseNumber, ct.getIdDepartment(), ct.getIdCourse()));
			}	

			if (course_flag == 1) {

				new OpenDialog("Course " + fxDepartment.getValue().toString() + " " + fxCourseNumber.getText() + 
								" added successfully.").display();
				cleanUp();

			}

		} else 

			new ErrorDialog(warningMsg).display();
		
	}

	private void formatTable(final TableView tableView) {
		
		tableView.setEditable(false);
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		tableView.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {

			@Override
			public void onChanged(Change<? extends Integer> change) {

//				if (change.getList().size() >= 1) 
//					System.out.println("YEA!");
				
			}

		});
		
		TableColumn tc0 = (TableColumn) tableView.getColumns().get(0);		// course
		TableColumn tc1 = (TableColumn) tableView.getColumns().get(1);		// name
		TableColumn tc2 = (TableColumn) tableView.getColumns().get(2);		// credits
		
		tc0.setSortable(false);
		tc1.setSortable(false);
		tc2.setSortable(false);
		
		tc0.setResizable(false);
		tc1.setResizable(false);
		tc2.setResizable(false);
		
		tc0.setCellValueFactory( new PropertyValueFactory<CourseTable, String>("course"));
		tc1.setCellValueFactory( new PropertyValueFactory<CourseTable, String>("name"));
		tc2.setCellValueFactory( new PropertyValueFactory<CourseTable, Float>("credit"));
		
/*		// button column for remove
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
*/
		
		tableView.setItems(tableView.getId().equalsIgnoreCase(PREREQTABLE) ? prereq : coreq);
		
		final TableColumn[] columns = {tc0, tc1, tc2};
		
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
	
	/** Depreciated
	 * 
	 */
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
	
	public void removeSelectedItems(MouseEvent me) throws Exception {
		
		if (me.getSource() == removePrereqIcon) {

			if (fxPrereqTable.getSelectionModel().getSelectedItem() != null) {

				CourseTable toBeRemoved = (CourseTable) fxPrereqTable.getSelectionModel().getSelectedItem();

				for (CourseTable ct : prereq) {
					
					if (ct.getCourse().equalsIgnoreCase(toBeRemoved.getCourse())) {
						
						prereq.remove(ct);
						break;
					}
				}
			}

		} else {

			if (fxCoreqTable.getSelectionModel().getSelectedItem() != null) {

				CourseTable toBeRemoved = (CourseTable) fxCoreqTable.getSelectionModel().getSelectedItem();

				for (CourseTable ct : coreq) {
					
					if (ct.getCourse().equalsIgnoreCase(toBeRemoved.getCourse())) {
						
						coreq.remove(ct);
						break;

					}
				}
			}
		}
	}
}