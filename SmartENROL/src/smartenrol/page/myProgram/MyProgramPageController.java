/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.myProgram;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.javafxdata.control.TableViewFactory;
import smartenrol.dao.StudentSectionDAO;
import smartenrol.model.*;
import smartenrol.page.SmartEnrolController;
import smartenrol.security.UserSession;
import smartenrol.dao.ProgramDAO;
import smartenrol.page.PageController;
/**
 *
 * @author Jeremy
 */
public class MyProgramPageController extends SmartEnrolController {
	
	private final StudentSectionDAO studsecdao = new StudentSectionDAO();
	private final ProgramDAO programdao = new ProgramDAO();
	ArrayList<CourseGradeRecord> courseList = new ArrayList<>();
	private Transcript transcript;
	private User currentUser;
	
	
	@FXML BorderPane innerContent;
	@FXML Text creditsEarnedField;
	@FXML Text creditsRemainedField;
	@FXML Text infoPrompt;
	@FXML Text fxProgramTitle;
	@FXML Rectangle creditsEarnedBar;
	
	VBox courseHistory;
	Text coursesTakenTitle;
	Text coursesRemainingTitle;
	TableView coursesTakenTable;
	TableView coursesRemainingTable;
	
	private User.Type userType;
	
	
	public void init() {
		
		userType = getUserSession().getCurrentUser().getUsertype();
		
		if (userType == User.Type.STUDENT) {
			
			float creditsEarned = 0;
			float creditsRemained = 0;
			float totalCreditsRequired = 0;
			float creditsEarnedPercentage = 0;
			
			currentUser = getUserSession().getCurrentUser();
			transcript = studsecdao.getStudentTranscript(currentUser.getIdUser());
			courseList = transcript.getGradeRecords();
			totalCreditsRequired = programdao.getProgrambyID(transcript.getIdProgram()).gettotalCreditsToGraduate();
			
			courseHistory = new VBox();
			coursesTakenTitle = new Text("Courses Completed:");
			coursesRemainingTitle = new Text("Courses Remaining:");
			coursesTakenTable = new TableView();
			coursesRemainingTable = new TableView();
			
			fxProgramTitle.setText(transcript.getProgramName());
			
			if (courseList != null) {
				
				System.out.println(courseList);
				for (CourseGradeRecord cgr: courseList)
					creditsEarned += cgr.getCredits();
				
				creditsEarnedPercentage = creditsEarned / totalCreditsRequired;
				creditsRemained = totalCreditsRequired - creditsEarned;
				creditsEarnedField.setText(String.valueOf(creditsEarned));
				creditsEarnedField.setLayoutX(creditsEarnedPercentage * 300 - 5);
				creditsRemainedField.setText(String.valueOf(creditsRemained));
				creditsEarnedBar.setWidth((creditsEarnedPercentage) * 300);
				infoPrompt.setText("You have completed " + creditsEarned + " of " + totalCreditsRequired + " required credits.");
				
				if (courseList.size()!=0) {
					coursesTakenTable = TableViewFactory.
							create(CourseGradeRecord.class, courseList).
							selectColumns("Course", "Grade", "Year", "Term", "Credits").
							buildTableView();
					
					coursesTakenTable.setEditable(false);
				}
				
				if (courseList.size()!=0) {
					coursesRemainingTable = TableViewFactory.
							create(CourseGradeRecord.class, courseList).
							selectColumns("Course", "Grade", "Year", "Term", "Credits").
							buildTableView();
					
					coursesRemainingTable.setEditable(false);
					
				}
				
				courseHistory.getChildren().setAll(coursesTakenTitle,
						coursesTakenTable,
						coursesRemainingTitle,
						coursesRemainingTable);
				courseHistory.setPadding(new Insets(10));
				
				innerContent.setCenter(courseHistory);
				
			}
		}
		
	}
}
