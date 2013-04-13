/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.administration.course;

import java.util.ArrayList;
import java.util.Collections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import smartenrol.dao.CourseDAO;
import smartenrol.dao.DepartmentDAO;
import smartenrol.model.Course;
import smartenrol.page.SmartEnrolController;

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
	private ArrayList<Course> prereqCourseList = new ArrayList<>();
	private ArrayList<Course> coreqCourseList = new ArrayList<>();
	
	@FXML TextField fxCourseName;
	@FXML TextField fxCourseNumber;
	@FXML TextField fxCredits;
	@FXML TextArea fxCourseDescription;
	
	@FXML ComboBox fxDepartment;
	@FXML ComboBox fxPrereqDept;
	@FXML ComboBox fxPrereqCourse;
	@FXML ComboBox fxCoreqDept;
	@FXML ComboBox fxCoreqCourse;
	
	@FXML CheckBox fxRestricted;
	
	@FXML TableView fxPrereqTable;
	@FXML TableView fxCoreqTable;
	
	@Override
	public void init() {
		
		// clean up
		fxDepartment.getItems().clear();
		fxPrereqDept.getItems().clear();
		fxPrereqCourse.getItems().clear();
		fxCoreqDept.getItems().clear();
		fxCoreqCourse.getItems().clear();
		prereqCourseList.clear();
		coreqCourseList.clear();
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
				updatePrereqCourseNumber();
			}
		});

		fxCoreqDept.addEventHandler(ActionEvent.ACTION,  new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				updateCoreqCourseNumber();
			}
		});
	}
	
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
