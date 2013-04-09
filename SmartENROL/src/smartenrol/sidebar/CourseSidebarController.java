/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.sidebar;

import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.HashMap;
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
import smartenrol.dao.*;
import smartenrol.model.*;
import smartenrol.page.SmartEnrolController;
import smartenrol.security.UserSession;

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
    private ArrayList<Section> currentCourseSectionList = new ArrayList<>();    //important, student enrols by choosing one or more in this list
    private Section currentSelectedSection;                 //store idSection  
    private ArrayList<Program> currentCoursePrograms = new ArrayList<>();       //to check whether student is in courseprogram.
    private ArrayList<Course> currentCoursePreReqs = new ArrayList<>();
    private ArrayList<Course> currentCourseCoReqs = new ArrayList<>();
//    ArrayList<Student> currentSectionClassList;     //for instructor coursePage sidebar.
    
    private List<VBox> courseSectionBoxes = new ArrayList<>();
    
    private StudentSection newStudentSection;
    private ArrayList<String> sectionMsg = new ArrayList<>();
    private ArrayList<Integer> studentSectionStatusCode = new ArrayList<>();
    
    private static final HashMap<Integer, String> statusMsg = new HashMap<>();
    static {        
        statusMsg.put(0b10000000, "Enrolled.");
        statusMsg.put(0b01000000, "On waitlist.");        
        statusMsg.put(0b00100000, "Deadline passed.");
        statusMsg.put(0b00010000, "Course restriced to other Program.");
        statusMsg.put(0b00001000, "Prerequisites not passed.");
        statusMsg.put(0b00000100, "Corequisites not enrolled.");
        statusMsg.put(0b00000010, "Timetable conflict.");
        statusMsg.put(0b00000001, "Class is full");
        statusMsg.put(0b00000000, "Available to enrol.");
    }
        
    
    @FXML Button enrolButton;
    @FXML Button joinWaitlistButton;
    @FXML Button specialPermissionButton;
    @FXML ListView sectionList;
    
//    ArrayList<Student> currentSectionClassList;     //for instructor coursePage sidebar.
    public CourseSidebarController() {
    }
    
    public void prep() {
//        this.currentSectionNodes = new SectionNodeDAO().getSectionNodeListBySection("cics", 520, "L01");
        
    }
    
    @FXML
    public void init() {
        
        enrolButton.setText("Enrol");
        
               
    }
        
    public void load(String idDepartment, int idCourse) {
        
        this.currentCourse = coursedao.getCourseByID(idDepartment, idCourse);
        currentCourseSectionList = sectiondao.getSectionListByCourseWithInstructorName(
                                    currentCourse.getIdDepartment(),
                                    currentCourse.getIdCourse());       
        System.out.println(currentCourseSectionList);
        this.setStudentSectionStatusCode(currentCourseSectionList);
        this.setStudentSectionStatusMsg();
        
        
        if (currentCourseSectionList!=null) {
//            System.out.println(currentCourseSectionList);
//            for (Section thisSection : currentCourseSectionList) {
            for (int i = 0; i < currentCourseSectionList.size(); i ++) {    
                VBox sectionBox = new VBox();
                VBox sectionNodeList = new VBox();

                
                Text sectionName = new Text(currentCourseSectionList.get(i).getIdSection()+" - "+ currentCourseSectionList.get(i).getInstructorName());
                Text errorMessage = new Text(sectionMsg.get(i));
                ArrayList<SectionNode> snodes = snodedao.getSectionNodeListBySection(
                                        currentCourseSectionList.get(i).getIdDepartment(),
                                        currentCourseSectionList.get(i).getIdCourse(),
                                        currentCourseSectionList.get(i).getIdSection()); 
//                System.out.println(snodes);
                    
                
                
                if (snodes!=null) {
                    for (SectionNode thisSNode : snodes) {
                        Text thisSNodeText = new Text(thisSNode.toLongString());
                        thisSNodeText.setId("section-node");
                        sectionNodeList.getChildren().add(thisSNodeText);
                    }
                }
                
                sectionBox.getChildren().addAll(sectionName,sectionNodeList,errorMessage);
                
                courseSectionBoxes.add(sectionBox);
                
            } //end for
        } else {
            VBox sectionBox = new VBox();
            sectionBox.getChildren().setAll(new Text("No sections could be found."));
            courseSectionBoxes.add(sectionBox);
        }
        sectionList.setItems(FXCollections.observableList(courseSectionBoxes));
    }
    
    
    public void setStudentSectionStatusMsg() {
        if (!studentSectionStatusCode.isEmpty()) {
            for (int i = 0; i < studentSectionStatusCode.size(); i ++) {
                this.parseStatusCode();
                
                this.sectionMsg.add(statusMsg.get(studentSectionStatusCode.get(i)));
            } //end for

        } //end if
    }
    
    /**
     * Parse the StatusCode according to their priorities.
     */
    private void parseStatusCode() {
        if (!studentSectionStatusCode.isEmpty()) {
            for (int i = 0; i < studentSectionStatusCode.size(); i ++) {
                if ((studentSectionStatusCode.get(i) & 0x80) != 0) {
                    studentSectionStatusCode.set(i,0x80); 
                    continue;
                }
                else if ((studentSectionStatusCode.get(i) & 0x40) != 0) {
                    studentSectionStatusCode.set(i,0x40); 
                    continue;
                }
                else if ((studentSectionStatusCode.get(i) & 0x20) != 0) {
                    studentSectionStatusCode.set(i,0x20); 
                    continue;
                }
                else if ((studentSectionStatusCode.get(i) & 0x10) != 0) {
                    studentSectionStatusCode.set(i,0x10); 
                    continue;
                }
                else if ((studentSectionStatusCode.get(i) & 0x08) != 0) {
                    studentSectionStatusCode.set(i,0x08); 
                    continue;
                }
                else if ((studentSectionStatusCode.get(i) & 0x04) != 0) {
                    studentSectionStatusCode.set(i,0x04); 
                    continue;
                }
                else if ((studentSectionStatusCode.get(i) & 0x02) != 0) {
                    studentSectionStatusCode.set(i,0x02); 
                    continue;
                }                
                else if ((studentSectionStatusCode.get(i) & 0x01) != 0) {
                    studentSectionStatusCode.set(i,0x01); 
                    continue;
                }     
                else {
                    studentSectionStatusCode.set(i,0x00);
                }
//                System.out.println(studentSectionStatusCode.get(i));
            }   // end for         
        }       
    }
    
    /**
     * This method evaluates the limits for enrollment to a section and generates a StudentSectionStatusCode.
     */
    public void setStudentSectionStatusCode(ArrayList<Section> currentCourseSectionList) {
        int studentID = UserSession.getInstance().getCurrentUser().getIdUser();
        if (currentCourseSectionList.size() != 0) {
            int tempCode = 0;
            Section sectemp = currentCourseSectionList.get(0);
            int permissionCode = new StudentCoursePermissionDAO(studentID, sectemp.getIdDepartment(), sectemp.getIdCourse()).getStudentCoursePermissionCode();
            System.out.println(permissionCode);
            if (this.isDeadlinePassed()) {
                tempCode +=  0x20;                          
            }
            if (!studentdao.isStudentEligibleForCourse(studentID, sectemp.getIdDepartment(), sectemp.getIdCourse())) {
                tempCode += 0x10;                          
            }
            if (!this.isPrereqValid(studentID, sectemp.getIdDepartment(), sectemp.getIdCourse())) {
                tempCode += 0x08;                          
            }
            else if (!this.isCoreqValid(studentID, sectemp.getIdDepartment(), sectemp.getIdCourse())) {
                tempCode += 0x04;                          
            }
            
            // overwrite some of the limits for the student.
            tempCode = tempCode & permissionCode;
            
            for (Section sec : currentCourseSectionList) {
                int sectempCode = 0;
                if (stusecdao.isStudentEnrolledInSection(studentID, sec.getIdDepartment(), sec.getIdCourse(), sec.getIdSection()) == 2 ) {
                    sectempCode += 0x80;
                }
                else if (stusecdao.isStudentEnrolledInSection(studentID, sec.getIdDepartment(), sec.getIdCourse(), sec.getIdSection()) == 1) {
                    sectempCode += 0x40;
                }                
                else if (this.isTimetableConfict()) {
                    sectempCode += 0x02;
                }
                else if (stusecdao.isSectionFull(sec.getIdDepartment(), sec.getIdCourse(), sec.getIdSection())) {
                    sectempCode += 0x01;
                }
                else {}
                
                studentSectionStatusCode.add(tempCode + sectempCode);                          
                
            } // end for loop
        } // end if not null
    } // end setStudentSectionStatusCode
    
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
//        Timetable currentStudentTimetable = stusecdao.getStudentTimetable(UserSession.getInstance().getCurrentUser().getIdUser());
//        
//        return currentStudentTimetable.isConflict(currentCourseSectionList.get(2).);
        return false;
    }
          
    
    public void entrolSection(Section currentSelectedSection) {
        int studentID = UserSession.getInstance().getCurrentUser().getIdUser();
        stusecdao.enrolStudentSection(studentID, currentSelectedSection.getIdDepartment(), currentSelectedSection.getIdCourse(), currentSelectedSection.getIdSection(), 0);
    }
    
    public void entrolSection(String idDepartment, int idCourse, String idSection, int onWaitlist) {
        int studentID = UserSession.getInstance().getCurrentUser().getIdUser();
        stusecdao.enrolStudentSection(studentID, idDepartment, idCourse, idSection, onWaitlist);
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
