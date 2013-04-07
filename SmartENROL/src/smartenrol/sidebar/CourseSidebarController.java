/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.sidebar;

import java.awt.Button;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.fxml.FXML;
import org.joda.time.LocalDate;
import smartenrol.dao.CorequisiteDAO;
import smartenrol.dao.CourseDAO;
import smartenrol.dao.PrerequisiteDAO;
import smartenrol.dao.ProgramCoursesDAO;
import smartenrol.dao.SectionDAO;
import smartenrol.dao.SectionNodeDAO;
import smartenrol.dao.StudentDAO;
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
    private final CourseDAO coursedao = new CourseDAO();
    private final PrerequisiteDAO prereqdao = new PrerequisiteDAO();
    private final CorequisiteDAO coreqdao = new CorequisiteDAO();
    private final SectionDAO sectiondao = new SectionDAO();
    private final SectionNodeDAO snodedao = new SectionNodeDAO();
    private final StudentSectionDAO stusecdao = new StudentSectionDAO();
    private final ProgramCoursesDAO progcoursedao = new ProgramCoursesDAO();
    private final TermDAO termdao = new TermDAO();
    private final StudentDAO studentdao = new StudentDAO();
    
    /*@Button
    ArrayList<Button> sectionButtons;           //buttons for sections
    ArrayList<String> statusTexts;              //information for students
    ArrayList<TextField> sectionTextFields;     //section#, day, time, instructor, classroom
    */
    private Student currentStudent;                 //store idUser
    private Timetable currentStudentTimetable;      //store the coursePKs and timeslots for sectionNodes
    private ArrayList<Section> passedCourseList;     //to compare the prereqs
    private ArrayList<Section> currentSectionList;  //store the current enrolled sections for the student
    
    private Course currentCourse;                           //store current course idDepartment, idCourse 
    private ArrayList<Section> currentCourseSectionList;    //important, student enrols by choosing one or more in this list
    private Section currentSelectedSection;                 //store idSection  
    private ArrayList<Program> currentCoursePrograms;       //to check whether student is in courseprogram.
    private ArrayList<Course> currentCoursePreReqs;
    private ArrayList<Course> currentCourseCoReqs;
    
    StudentSection newStudentSection;
    
    @FXML javafx.scene.control.Button enrolButton;
    @FXML javafx.scene.control.Button joinWaitlistButton;
    @FXML javafx.scene.control.Button specialPermissionButton;
//    ArrayList<Student> currentSectionClassList;     //for instructor coursePage sidebar.
    
    public CourseSidebarController() {
    }
    
    @FXML
    public void init() {
        enrolButton.setText("Enrol");
        
    }
        

    /**
     * Check whether the student has enrolled in the current section.
     * @param currentStudent
     * @param currentSelecetedSection
     * @return 0 if not, 1 in the waitlist, 2 if enrolled
     */
    public int ifStudentEnrolledInSection(Student currentStudent, Section currentSelecetedSection) {
        //this is a dynamic list, use local logic to test.
        return stusecdao.isStudentEnrolledInSection(currentStudent.getIdUser(), 
                currentSelectedSection.getIdDepartment(), 
                currentSelectedSection.getIdCourse(), 
                currentSelectedSection.getIdSection());
    }
    
    /**
     * Check whether the student has enrolled in the current Course.
     * @param currentStudent
     * @param currentCourse
     * @return 0 if not, 1 in the waitlist, 2 if enrolled
     */
    public int ifStudentErolledInCourse(Student currentStudent, Course currentCourse) {
        //this is a dynamic list, use local logic to test.
        return stusecdao.isStudentEnrolledInCourse(currentStudent.getIdUser(),
                currentCourse.getIdDepartment(),
                currentCourse.getIdCourse());
    }
    
 
    /**
     * Check whether the student is eligible for a specified course.
     * @param idStudent
     * @param idDepartment
     * @param idCourse
     * @return 
     */
    public boolean isStudentEligibleForCourse(int idStudent, String idDepartment, int idCourse) {
        return studentdao.isStudentEligibleForCourse(idStudent, idDepartment, idCourse);
    }
    
    /**
     * Check whether the deadline for enrolment is passed.
     * @return 
     */
    public boolean isDeadlinePassed() {
        LocalDate today = new LocalDate();        
        return today.isAfter(termdao.getDeadline());
    }
    
    /**
     * Check whether the student has taken all the prerequisites of a certain course.
     * @param idStudent
     * @param idDepartment
     * @param idCourse
     * @return 
     */
    public boolean isPrereqValid(int idStudent, String idDepartment, int idCourse) {
        currentCoursePreReqs = prereqdao.getPrerequsiteCourseListByID(idDepartment, idCourse);
        passedCourseList = stusecdao.getStudentPassedCourseList(idStudent);
        
        for (Iterator<Course> it = currentCoursePreReqs.iterator(); it.hasNext();) {
            Course prereq = it.next();
            for (Course passed : passedCourseList) {
                if (prereq.getIdDepartment().equals(passed.getIdDepartment()) && prereq.getIdCourse() == passed.getIdCourse())
                    it.remove();
            }
        }
        
        if (currentCoursePreReqs.size() == 0)
            return true;
        else 
            return false;
    }
    
    /**
     * Check whether the student has enrolled the corequisite of a course. 
     * @param idStudent
     * @param idDepartment
     * @param idCourse
     * @return 
     */
    public boolean isCoreqValid(int idStudent, String idDepartment, int idCourse) {
        currentCourseCoReqs = coreqdao.getCorequsiteCourseListByID(idDepartment, idCourse);
        currentSectionList = stusecdao.getStudentCurrentTermCourseList(idStudent);
        
        for (Iterator<Course> it = currentCourseCoReqs.iterator(); it.hasNext();) {
            Course prereq = it.next();
            for (Section passed : currentSectionList) {
                if (prereq.getIdDepartment().equals(passed.getIdDepartment()) && prereq.getIdCourse() == passed.getIdCourse())
                    it.remove();
            }
        }
        
        if (currentCoursePreReqs.size() == 0)
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
