/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.myProgram;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.javafxdata.control.TableViewFactory;
import smartenrol.dao.StudentSectionDAO;
import smartenrol.model.*;
import smartenrol.page.AbstractController;

/**
 *
 * @author Jeremy
 */
public class MyProgramPageController extends AbstractController {
	
	private final Transcript transcript = new Transcript();
	ArrayList<CourseGradeRecord> courseList = new ArrayList<>();
	ArrayList<CourseGradeRecord> courseGradeRecord = new ArrayList<>();
	
	int creditsEarned = 0;
	int creditsRemained = 0;
	int totalCreditsRequired= 0;
	
	@FXML BorderPane innerContent;
	@FXML Text creditsEarnedField;
	@FXML Text creditsRemainedField;
	@FXML Text infoPrompt;
	@FXML Rectangle creditsEarnedBar;
	
	public void init() {
		
		courseGradeRecord = transcript.getGradeRecords();
		
		for (CourseGradeRecord cgr: courseGradeRecord) {

			creditsEarned += cgr.getCredits();
			
			courseList.add(new CourseGradeRecord(cgr.getIdDepartment(),
									  cgr.getIdCourse(),
									  cgr.getCredits(),
									  cgr.getCourseName(),
									  cgr.getYear(),
									  cgr.getTerm(),
									  cgr.getGrade()));
		}
		
		creditsEarnedField.setText(String.valueOf(creditsEarned));

		// TODO
//		totalCreditsRequired = 
//		creditsRemainedField.setText(String.valueOf(totalCreditsRequired - creditsEarned));
//		creditsEarnedBar.setWidth(creditsEarned / totalCreditsRequired);
//		infoPrompt.setText("You have completed " + creditsEarned + " of " + totalCreditsRequired + " required credits.");
		
		
//		courseList.add(new Course("CICS",505,6,"Intro to Computer Systems"));
//		courseList.add(new Course("CICS",520,3,"Databases"));
//		courseList.add(new Course("CICS",511,(float)1.50,"Computational Structures"));
		
		TableView tableView = TableViewFactory.
				create(CourseGradeRecord.class, courseList).
				selectColumns("Course", "Grade", "Year", "Term", "Credits").	
				buildTableView();
		
		tableView.setEditable(false);
		
		innerContent.setCenter(tableView);
	}
	
}
