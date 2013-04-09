/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.entities.program;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.javafxdata.control.TableViewFactory;
import smartenrol.dao.ProgramCoursesDAO;
import smartenrol.dao.ProgramDAO;
import smartenrol.dao.StudentSectionDAO;
import smartenrol.model.Course;
import smartenrol.model.Program;
import smartenrol.page.SmartEnrolController;

/**
 *
 * @author Jeremy
 */
public class ProgramPageController extends SmartEnrolController {
	
	ProgramCoursesDAO programcoursedao = new ProgramCoursesDAO();
	StudentSectionDAO studsecdao = new StudentSectionDAO();
	ProgramDAO programdao = new ProgramDAO();
	private Program currentProgram;
	private String programID;
	ArrayList<Course> courseList = new ArrayList<>();
	
	@FXML BorderPane innerContent;
	@FXML Text fxProgramTitle;
	@FXML Text fxDescription;
	
	
	@Override
	public void init() {
		
		System.out.println("Entering Program Page");
	}
	
	public void loadProgram(Program currentProgram) {
		
		this.currentProgram = currentProgram;
		
		courseList = programcoursedao.getCourseListByProgram(this.currentProgram.getIdProgram());
		fxProgramTitle.setText(this.currentProgram.getProgramName());
		fxDescription.setText(this.currentProgram.getProgramDescription());

		if (!courseList.isEmpty()) {
			
			TableView tableView = TableViewFactory.
					create(Course.class, courseList).
					selectColumns("Id Department", "Id Course", "Credits").
					renameColumn("Id Department", "Dept").
					renameColumn("Id Course", "ID").
					buildTableView();
			
			tableView.setEditable(false);
			innerContent.setCenter(tableView);
		}
	}
}
