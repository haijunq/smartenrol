/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.sidebar;

import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.javafxdata.control.TableViewFactory;
import org.joda.time.LocalDate;
import smartenrol.dao.CorequisiteDAO;
import smartenrol.dao.CourseDAO;
import smartenrol.dao.InstructorDAO;
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
import smartenrol.model.SectionNode;
import smartenrol.model.Student;
import smartenrol.model.StudentSection;
import smartenrol.model.Timetable;
import smartenrol.page.SmartEnrolController;

/**
 *
 * @author Jeremy
 */
public class CourseSidebarController extends SmartEnrolController {
    
    private final CourseDAO coursedao = new CourseDAO();
    private final PrerequisiteDAO prereqdao = new PrerequisiteDAO();
    private final CorequisiteDAO coreqdao = new CorequisiteDAO();
    private final SectionDAO sectiondao = new SectionDAO();
    private final SectionNodeDAO snodedao = new SectionNodeDAO();
    private final StudentSectionDAO stusecdao = new StudentSectionDAO();
    private final ProgramCoursesDAO progcoursedao = new ProgramCoursesDAO();
    private final TermDAO termdao = new TermDAO();
    private final StudentDAO studentdao = new StudentDAO();
    private final InstructorDAO instructordao = new InstructorDAO();
    
    /*@Button
    ArrayList<Button> sectionButtons;           //buttons for sections
    ArrayList<String> statusTexts;              //information for students
    ArrayList<TextField> sectionTextFields;     //section#, day, time, instructor, classroom
    */
    private Student currentStudent;                 //store idUser
    private Timetable currentStudentTimetable;      //store the coursePKs and timeslots for sectionNodes
    private ArrayList<Section> passedCourseList;     //to compare the prereqs
    private ArrayList<Section> currentSectionList;  //store the current enrolled sections for the student
    private ArrayList<SectionNode> currentSectionNodes;
    
    private Course currentCourse;                           //store current course idDepartment, idCourse 
    private ArrayList<Section> currentCourseSectionList;    //important, student enrols by choosing one or more in this list
    private Section currentSelectedSection;                 //store idSection  
    private ArrayList<Program> currentCoursePrograms;       //to check whether student is in courseprogram.
    private ArrayList<Course> currentCoursePreReqs;
    private ArrayList<Course> currentCourseCoReqs;
//    ArrayList<Student> currentSectionClassList;     //for instructor coursePage sidebar.
    
    private List<VBox> courseSectionBoxes = new ArrayList<>();
    
    StudentSection newStudentSection;
    
    @FXML Button enrolButton;
    @FXML Button joinWaitlistButton;
    @FXML Button specialPermissionButton;
    @FXML ListView sectionList;
    
//    ArrayList<Student> currentSectionClassList;     //for instructor coursePage sidebar.
    public CourseSidebarController() {
    }
    
    public void prep() {
        this.currentSectionNodes = new SectionNodeDAO().getSectionNodeListBySection("cics", 520, "L01");
        
    }
    
    @FXML
    public void init() {
        
        enrolButton.setText("Enrol");
               
    }
        
    public void load(Course currentCourse) {
        
        this.currentCourse = currentCourse;
        currentCourseSectionList = sectiondao.getSectionListByCourse(
                                    currentCourse.getIdDepartment(),
                                    currentCourse.getIdCourse());
        
        if (currentCourseSectionList!=null) {
            System.out.println(currentCourseSectionList);
            for (Section thisSection : currentCourseSectionList) {
                
                VBox sectionBox = new VBox();
                VBox sectionNodeList = new VBox();

                Text sectionName = new Text(thisSection.getIdSection()+" - "+instructordao.getUserByID(thisSection.getIdInstructor()).getFullName());
                Text errorMessage = new Text("CLASS IS FULL");
                ArrayList<SectionNode> snodes = snodedao.getSectionNodeListBySection(
                                        thisSection.getIdDepartment(),
                                        thisSection.getIdCourse(),
                                        thisSection.getIdSection()); 
                System.out.println(snodes);
                    
                
                
                if (snodes!=null) {
                    for (SectionNode thisSNode : snodes) {
                        Text thisSNodeText = new Text(thisSNode.toString());
                        thisSNodeText.setId("section-node");
                        sectionNodeList.getChildren().add(thisSNodeText);
                    }
                }
                
                sectionBox.getChildren().addAll(sectionName,sectionNodeList,errorMessage);
                
                courseSectionBoxes.add(sectionBox);
                
            }
        } else {
            VBox sectionBox = new VBox();
            sectionBox.getChildren().setAll(new Text("No sections could be found."));
            courseSectionBoxes.add(sectionBox);
        }
        sectionList.setItems(FXCollections.observableList(courseSectionBoxes));
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
