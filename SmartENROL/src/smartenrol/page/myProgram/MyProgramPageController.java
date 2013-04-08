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
import static org.junit.Assert.*;
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
	
	float creditsEarned = 0;
	float creditsRemained = 0;
	float totalCreditsRequired = 0;
	
	@FXML BorderPane innerContent;
	@FXML Text creditsEarnedField;
	@FXML Text creditsRemainedField;
	@FXML Text infoPrompt;
	@FXML Rectangle creditsEarnedBar;
        
	
	public void init() {
				// TODO
//		StudentSectionDAO.getStudentTranscript() returned the wrong resultset

		currentUser = UserSession.getInstance().getCurrentUser();
		transcript = studsecdao.getStudentTranscript(currentUser.getIdUser());
		courseList = transcript.getGradeRecords();
		totalCreditsRequired = programdao.getProgrambyID(transcript.getIdProgram()).gettotalCreditsToGraduate();

		System.out.println("GivenName: " + transcript.getGivenName());
		System.out.println("Total credits:" + totalCreditsRequired);
		System.out.println("Program:" + transcript.getIdProgram());
		
		if (courseList != null) {

			for (CourseGradeRecord cgr: courseList) 
				creditsEarned += cgr.getCredits();
			
			creditsRemained = totalCreditsRequired - creditsEarned;
			creditsEarnedField.setText(String.valueOf(creditsEarned));
			creditsRemainedField.setText(String.valueOf(creditsRemained));
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
