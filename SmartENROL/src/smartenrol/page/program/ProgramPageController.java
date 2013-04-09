/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.program;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import smartenrol.dao.ProgramCoursesDAO;
import smartenrol.dao.StudentSectionDAO;
import smartenrol.model.Course;
import smartenrol.model.Program;
import smartenrol.model.User;
import smartenrol.page.SmartEnrolController;
import smartenrol.security.UserSession;

/**
 *
 * @author Jeremy
 */
public class ProgramPageController extends SmartEnrolController {

	ProgramCoursesDAO programcoursedao = new ProgramCoursesDAO();
	StudentSectionDAO studsecdao = new StudentSectionDAO();
	private Program program;
	private User currentUser;
	ArrayList<Course> courseList = new ArrayList<>();

	@FXML Text fxProgramTitle;
	@FXML Text fxDescription;


    public void init() {
        
		currentUser = UserSession.getInstance().getCurrentUser();
		courseList = programcoursedao.getCourseListByProgram(
				studsecdao.getStudentTranscript(currentUser.getIdUser()).getIdProgram());

		System.out.println("--> " + studsecdao.getStudentTranscript(currentUser.getIdUser()).getIdProgram());
		
		program = new Program(studsecdao.getStudentTranscript(currentUser.getIdUser()).getIdProgram());

			
		System.out.println("PROGRAM NAME:" + program.getProgramName());
		
		fxProgramTitle.setText(program.getProgramName());
		fxDescription.setText(program.getProgramDescription());
    }

	public void loadProgram() {


	}

}
