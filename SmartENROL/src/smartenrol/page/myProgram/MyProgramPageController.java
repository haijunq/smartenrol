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
import smartenrol.security.UserSession;
import smartenrol.dao.ProgramDAO;
/**
 *
 * @author Jeremy
 */
public class MyProgramPageController extends SmartEnrolController {
	
	StudentSectionDAO studsecdao = new StudentSectionDAO();
	ProgramDAO programdao = new ProgramDAO();
	ArrayList<CourseGradeRecord> courseList = new ArrayList<>();
	private Transcript transcript;
	private User currentUser;
	
	
	@FXML BorderPane innerContent;
	@FXML Text creditsEarnedField;
	@FXML Text creditsRemainedField;
	@FXML Text infoPrompt;
	@FXML Text fxProgramTitle;
	@FXML Rectangle creditsEarnedBar;
        
	
	public void init() {

		float creditsEarned = 0;
		float creditsRemained = 0;
		float totalCreditsRequired = 0;
		float creditsEarnedPercentage = 0;

		currentUser = UserSession.getInstance().getCurrentUser();
		transcript = studsecdao.getStudentTranscript(currentUser.getIdUser());
		courseList = transcript.getGradeRecords();
		totalCreditsRequired = programdao.getProgrambyID(transcript.getIdProgram()).gettotalCreditsToGraduate();

		fxProgramTitle.setText(transcript.getProgramName());

		if (courseList != null) {

			for (CourseGradeRecord cgr: courseList) 
				creditsEarned += cgr.getCredits();
			
			creditsEarnedPercentage = creditsEarned / totalCreditsRequired;
			creditsRemained = totalCreditsRequired - creditsEarned;
			creditsEarnedField.setText(String.valueOf(creditsEarned));
			creditsEarnedField.setLayoutX(creditsEarnedPercentage * 300 - 5);
			creditsRemainedField.setText(String.valueOf(creditsRemained));
			creditsEarnedBar.setWidth((creditsEarnedPercentage) * 300);
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
