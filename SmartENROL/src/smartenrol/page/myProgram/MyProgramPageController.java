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
import smartenrol.page.SmartEnrolController;

/**
 *
 * @author Jeremy
 */
public class MyProgramPageController extends SmartEnrolController {
	
	private final Transcript transcript = new Transcript();
	private final Program program = new Program();
	ArrayList<CourseGradeRecord> courseList = new ArrayList<>();
	
	int creditsEarned = 0;
	int creditsRemained = 0;
	float totalCreditsRequired = 0;
	
	@FXML BorderPane innerContent;
	@FXML Text creditsEarnedField;
	@FXML Text creditsRemainedField;
	@FXML Text infoPrompt;
	@FXML Rectangle creditsEarnedBar;
        
	public void init() {
		
		courseList = transcript.getGradeRecords();
		totalCreditsRequired = program.gettotalCreditsToGraduate();
		
		if (courseList != null) {

			for (CourseGradeRecord cgr: courseList)
				creditsEarned += cgr.getCredits();
			
			creditsEarnedField.setText(String.valueOf(creditsEarned));
			creditsRemainedField.setText(String.valueOf(totalCreditsRequired - creditsEarned));
			creditsEarnedBar.setWidth(creditsEarned / totalCreditsRequired);
			infoPrompt.setText("You have completed " + creditsEarned + " of " + totalCreditsRequired + " required credits.");
			
			TableView tableView = TableViewFactory.
					create(CourseGradeRecord.class, courseList).
					selectColumns("Course", "Grade", "Year", "Term", "Credits").
					buildTableView();
			
			tableView.setEditable(false);
			
			innerContent.setCenter(tableView);
		}		
	}
}
