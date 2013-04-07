/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.sidebar;

import java.sql.Date;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.joda.time.LocalDate;
import smartenrol.dao.CorequisiteDAO;
import smartenrol.dao.CourseDAO;
import smartenrol.dao.PrerequisiteDAO;
import smartenrol.dao.ProgramCoursesDAO;
import smartenrol.dao.SectionDAO;
import smartenrol.dao.SectionNodeDAO;
import smartenrol.dao.StudentSectionDAO;
import smartenrol.dao.TermDAO;
import smartenrol.model.Course;
import smartenrol.model.Program;
import smartenrol.model.Section;
import smartenrol.model.Student;
import smartenrol.model.StudentSection;
import smartenrol.model.Term;
import smartenrol.model.Timetable;
import smartenrol.page.AbstractController;

/**
 *
 * @author Jeremy
 */
public class CourseSidebarController extends AbstractController {
    CourseDAO coursedao;
    PrerequisiteDAO prereqdao;
    CorequisiteDAO coreqdao;
    SectionDAO sectiondao;
    SectionNodeDAO snodedao;
    StudentSectionDAO stusecdao;
    ProgramCoursesDAO progcoursedao;
    TermDAO termdao;
    
    /*@Button
    ArrayList<Button> sectionButtons;           //buttons for sections
    ArrayList<String> statusTexts;              //information for students
    ArrayList<TextField> sectionTextFields;     //section#, day, time, instructor, classroom
    */
    Student currentStudent;                 //store idUser
    Timetable currentStudentTimetable;      //store the coursePKs and timeslots for sectionNodes
    ArrayList<Course> passedCourseList;     //to compare the prereqs
    ArrayList<Section> currentEnrolledSectionList;  //store the current enrolled sections for the student
    
    Course currentCourse;                           //store current course idDepartment, idCourse 
    ArrayList<Section> currentCourseSectionList;    //important, student enrols by choosing one or more in this list
    Section currentSelectedSection;                 //store idSection  
    ArrayList<Program> currentCoursePrograms;       //to check whether student is in courseprogram.
    ArrayList<Course> currentCoursePreReqs;
    ArrayList<Course> currentCourseCoReqs;
    
    StudentSection newStudentSection;
    
    @FXML Button enrolButton;
    @FXML Button joinWaitlistButton;
    @FXML Button specialPermissionButton;
    
//    ArrayList<Student> currentSectionClassList;     //for instructor coursePage sidebar.
    
    /*public CourseSidebarController() {
        
    }*/
    
    @FXML
    public void init() {
        enrolButton.setText("Enrol");
    }
    
    /*
    public boolean isEnrolledInCurrentSection() {
        //this is a dynamic list, use local logic to test.
        //return stusecdao.isStudentEnrolledInSection(currentStudent, currentSelectedSection);
        return false;
    }
    
    public boolean isErolledInCurrentCourse() {
        //this is a dynamic list, use local logic to test.
        //return stusecdao.isStudentEnrolledInCourse(currentStudent, currentCourse);
        return false;
    }
     */
   /* public boolean isEnrolDeadlinePassed() {
       // Date enrolDeadline = termdao.getEnrolDeadline();
        //compare currentDate vs enrolDealline
        //return deadline.isBefore(currentTerm.getCurrentDate());
    }*/
    
 
    /**
p     * @return 
     */
    public boolean isCurrentStudentInCourseProgram() {
       /* if (!currentCourse.getIsRestricted()) 
            return true;
        else {
            for (Program prog : currentCoursePrograms) {
                if (progcoursedao.isStudentInProgram(currentStudent, prog)){
                    return true;
                }
                
            }
            return false;
        }*/
        return true;
    }
    
    public boolean isPrereqValid() {
        int count = 0;
//        ArrayList<Course> notTakenPreReqs;
        for (Course prereq : currentCoursePreReqs) {
            for (Course passed : passedCourseList) {
                if (prereq.getIdDepartment().equals(passed.getIdDepartment()) && prereq.getIdCourse() == passed.getIdCourse())
                    count ++;
            }
        }
        if (currentCoursePreReqs.size() == count)
            return true;
        else 
            return false;
    }
    
    public boolean isCoreqValid() {
        int count = 0;
//        ArrayList<Course> notTakenCoReqs;
        for (Course coreq : currentCourseCoReqs) {
            for (Section enrol : currentEnrolledSectionList) {
                if (coreq.getIdDepartment().equals(enrol.getIdDepartment()) && coreq.getIdCourse() == enrol.getIdCourse())
                    count ++;
            }
        }
        if (currentCourseCoReqs.size() == count)
            return true;
        else 
            return false;
    }
    
    public boolean isTimetableConfict() {
        return true;
    }
    
    public boolean isCurrentSectionFull(Section sec) {
        //if (sec.getMaxClassSize() == stusecdao.getEnrolNumberOfSection(sec))
        //    return true;
        //else 
            return false;
        
    }
        
    
    public void entrolSection() {
        //make a new StudentSection oject
        //stusecdao.insertStudentSection(newStudentSection);
    }
    
    public void enterWaitList() {
        //where is waitlists stored?
    }
    
    
    public void dropSection() {
        //stusecdao.removeStudentSection(newStudentSection);
    }
/*
    public void enrolButtonOnClick( event) {
        this.enrolSection();
    }
    
    public void dropButtonOnClick(event) {
        this.dropSection();
    }
    */
}
