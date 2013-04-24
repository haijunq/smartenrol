/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.entities.course;

import smartenrol.dao.CorequisiteDAO;
import smartenrol.dao.CourseDAO;
import smartenrol.dao.PrerequisiteDAO;
import smartenrol.model.Course;

import javafx.scene.control.*;
import smartenrol.dao.SectionDAO;
import smartenrol.dao.SectionNodeDAO;
import smartenrol.dao.StudentCoursePermissionDAO;
import smartenrol.dao.StudentDAO;
import smartenrol.dao.StudentSectionDAO;
import smartenrol.dao.TermDAO;
import smartenrol.model.Program;
import smartenrol.model.Section;
import smartenrol.model.SectionNode;
import smartenrol.model.Student;
import smartenrol.model.Timetable;

import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.dao.*;
import smartenrol.model.User;
import smartenrol.model.view.CourseTable;
import smartenrol.page.Navigator;
import smartenrol.page.SmartEnrolController;
import smartenrol.page.classlist.ClassListController;
import smartenrol.page.elements.dialog.OpenDialog;
import smartenrol.security.UserSession;


/**
 * This is the Controller class for the course page showing info and pre-, co-requisite course lists
 * and do all the logics for enrolment and applying special request.
 * @author Haijun
 */
public class CoursePageController extends SmartEnrolController {
    private final CourseDAO coursedao = new CourseDAO();
    private final PrerequisiteDAO prereqdao = new PrerequisiteDAO();
    private final CorequisiteDAO coreqdao = new CorequisiteDAO();
    private final SectionDAO sectiondao = new SectionDAO();
    private final SectionNodeDAO snodedao = new SectionNodeDAO();
    private final StudentSectionDAO stusecdao = new StudentSectionDAO();
    private final TermDAO termdao = new TermDAO();
    private final StudentDAO studentdao = new StudentDAO();
    private final MessageDAO msgdao = new MessageDAO();
    
    private Student currentStudent;                 //store idUser
    private Timetable currentStudentTimetable;      //store the coursePKs and timeslots for sectionNodes
    private ArrayList<Section> passedCourseList=new ArrayList<>();        //to compare the prereqs
    private ArrayList<Section> currentStudentEnrolledSectionList=new ArrayList<>();     //store the current enrolled sections for the student
    private ArrayList<SectionNode> currentSectionNodes=new ArrayList<>();   
    
    private Course currentCourse;                           //store current course idDepartment, idCourse 
    private ArrayList<Section> currentCourseSectionList = new ArrayList<>();    //important, student enrols by choosing one or more in this list
    private Section currentSelectedSection;                 //store idSection  
    private ArrayList<Program> currentCoursePrograms = new ArrayList<>();       //to check whether student is in courseprogram.
    private ArrayList<Course> currentCoursePreReqs = new ArrayList<>();
    private ArrayList<Course> currentCourseCoReqs = new ArrayList<>();
    
    private List<VBox> courseSectionBoxes = new ArrayList<>();
    
    private ArrayList<String> sectionMsg = new ArrayList<>();
    private ArrayList<Integer> studentSectionStatusCode = new ArrayList<>();
    private boolean coreqFlag = false;          //corequisite considtion is not a crucial one, student can go ahead to enrol, but a remind message will be sent to the student. 
    private boolean deadlineFlag = false;       //deadline flag is used for both enrol and drop.
    private EventHandler sectionClickHandler;
    
    private static final HashMap<Integer, String> statusMsg = new HashMap<>();
    static {        
        statusMsg.put(0b10000000, "Enrolled.");
        statusMsg.put(0b01000000, "On waitlist.");        
        statusMsg.put(0b00100000, "Enrol deadline passed.");
        statusMsg.put(0b00010000, "Course restriced to other Program.");
        statusMsg.put(0b00001000, "Prerequisites not passed.");
        statusMsg.put(0b00000100, "Corequisites not enrolled.");
        statusMsg.put(0b00000010, "Timetable conflict.");
        statusMsg.put(0b00000001, "Class is full.");
        statusMsg.put(0b00000000, "Available to enrol.");
    }
    
    @Autowired
    private Navigator navigator;        
    
    @FXML Button enrolButton;
    @FXML Button applyButton;

    @FXML ListView sectionList;
    @FXML Text fxidCourse;
    @FXML Text fxcourseName;
    @FXML Text fxcredits;
    @FXML TextArea fxdescription;
    @FXML BorderPane fxprereq;
    @FXML BorderPane fxcoreq;
    @FXML BorderPane internalContent;
    
    @Override
    public void init () {

        if (getUserSession().getCurrentUser().getUsertype() == User.Type.STUDENT) {
            enrolButton.setText("Enrol");
            applyButton.setText("Apply");
            enrolButton.setDisable(true);
            applyButton.setDisable(true);

            if (currentCourse != null)
                load(currentCourse.getIdDepartment(), currentCourse.getIdCourse());
        }
        else {
            this.applyButton.setVisible(false);
            this.enrolButton.setVisible(false);
            if (currentCourse != null)
                load(currentCourse.getIdDepartment(), currentCourse.getIdCourse());            
        }
        
        
    } 
    
    public void load(String idDepartment, int idCourse) {   
        clearOldEntities();
        setViewCourseInfo(idDepartment, idCourse);
        setViewPreReqsTable(idDepartment, idCourse); 
        setViewCoReqsTable(idDepartment, idCourse);
            setViewSectionList(idDepartment, idCourse);
    }
    
    private void clearOldEntities() {
        passedCourseList.clear();
        currentSectionNodes.clear();
        currentCourseSectionList.clear();
        currentCoursePrograms.clear();
        currentCoursePreReqs.clear();
        currentCourseCoReqs.clear();
        courseSectionBoxes.clear();
        sectionMsg.clear();
//        sectionList.clear();
        studentSectionStatusCode.clear();
    }   
    
    /**
     * This method sets the course information. 
     * @param idDepartment
     * @param idCourse 
     */
    private void setViewCourseInfo(String idDepartment, int idCourse) {
         // set the course information
        currentCourse = coursedao.getCourseByID(idDepartment, idCourse);
        fxidCourse.setText(currentCourse.toString());
        fxcourseName.setText(currentCourse.getCourseName());
        fxcredits.setText(String.valueOf(currentCourse.getCredits()));
        fxdescription.setText(currentCourse.getCourseDescription());
    }
        
    /**
     * This method populates the table view of prerequisite courses.
     * @param idDepartment
     * @param idCourse 
     */
    private void setViewPreReqsTable(String idDepartment, int idCourse) {
        // set the table view for pre-requisite.
        currentCoursePreReqs = prereqdao.getPrerequsiteCourseListByID(currentCourse.getIdDepartment(), currentCourse.getIdCourse());
        final TableView<CourseTable> pretableView = new TableView<>();
        TableColumn idDepartmentCol = new TableColumn("Deptartment");
        TableColumn idCourseCol = new TableColumn("Number");
        TableColumn courseNameCol = new TableColumn("Course Name");
        TableColumn creditsCol = new TableColumn("Credits");
        
        idDepartmentCol.setMaxWidth(80);
        idDepartmentCol.setMinWidth(80);
        idCourseCol.setMaxWidth(50);
        idCourseCol.setMinWidth(50);
        courseNameCol.setMinWidth(180);  
        
        if (!currentCoursePreReqs.isEmpty()) {
            ArrayList<CourseTable> pretable = new ArrayList<>();
            for (Course c : currentCoursePreReqs)
                pretable.add(new CourseTable(c));

            pretableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent me) {
                    if (me.getClickCount() > 1) {
                        navigator.loadSelectedItem(pretableView,"course");
                    }
                    
                }
            });
    
    
            idDepartmentCol.setCellValueFactory(
                    new PropertyValueFactory<CourseTable, String>("idDepartment"));
            idCourseCol.setCellValueFactory(
                    new PropertyValueFactory<CourseTable, Integer>("idCourse"));
            courseNameCol.setCellValueFactory(
                    new PropertyValueFactory<CourseTable, String>("name"));
            creditsCol.setCellValueFactory(
                    new PropertyValueFactory<CourseTable, Float>("credit"));

            pretableView.setItems(FXCollections.observableList(pretable));
      
        }
     
        else {
        }
        
        pretableView.getColumns().addAll(idDepartmentCol, idCourseCol, courseNameCol, creditsCol);        
        pretableView.setEditable(false);        
        fxprereq.setCenter(pretableView);
        pretableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);  
    }
    
    /**
     * This method populates the table view of corequisite courses.
     * @param idDepartment
     * @param idCourse 
     */
    private void setViewCoReqsTable(String idDepartment, int idCourse) {
          // set the table view 
        currentCourseCoReqs = coreqdao.getCorequsiteCourseListByID(currentCourse.getIdDepartment(), currentCourse.getIdCourse());
        final TableView<CourseTable> cotableView = new TableView<>();
        TableColumn idDepartmentCol = new TableColumn("Deptartment");
        TableColumn idCourseCol = new TableColumn("Number");
        TableColumn courseNameCol = new TableColumn("Course Name");
        TableColumn creditsCol = new TableColumn("Credits");
        
        idDepartmentCol.setMaxWidth(80);
        idDepartmentCol.setMinWidth(80);
        idCourseCol.setMaxWidth(50);
        idCourseCol.setMinWidth(50);
        courseNameCol.setMinWidth(180);  
        
        if (!currentCourseCoReqs.isEmpty()) {
            ArrayList<CourseTable> cotable = new ArrayList<>();
            for (Course c : currentCourseCoReqs)
                cotable.add(new CourseTable(c));
    
            cotableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent me) {
                    if (me.getClickCount() > 1) {
                        navigator.loadSelectedItem(cotableView,"course");
                    }
                }
            });
    
    
            idDepartmentCol.setCellValueFactory(
                    new PropertyValueFactory<CourseTable, String>("idDepartment"));
            idCourseCol.setCellValueFactory(
                    new PropertyValueFactory<CourseTable, Integer>("idCourse"));
            courseNameCol.setCellValueFactory(
                    new PropertyValueFactory<CourseTable, String>("name"));
            creditsCol.setCellValueFactory(
                    new PropertyValueFactory<CourseTable, Float>("credit"));

            cotableView.setItems(FXCollections.observableList(cotable));
      
        }
     
        else {
        }
        
        cotableView.getColumns().addAll(idDepartmentCol, idCourseCol, courseNameCol, creditsCol);        
        cotableView.setEditable(false);        
        fxcoreq.setCenter(cotableView);
        cotableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);  
    }

    /**
     * This method populates the ListView of the course section for student users.
     * @param idDepartment
     * @param idCourse 
     */
    private void setViewSectionList(String idDepartment, int idCourse) {
             
        currentCourseSectionList = sectiondao.getSectionListByCourseWithInstructorName(currentCourse.getIdDepartment(), currentCourse.getIdCourse());       

        if (getUserSession().getInstance().getCurrentUser().getUsertype() == User.Type.STUDENT) {
            this.setStudentSectionStatusCode(currentCourseSectionList);
            this.setStudentSectionStatusMsg();       
        }
        if (!currentCourseSectionList.isEmpty()) {
//            System.out.println(currentCourseSectionList);
//            for (Section thisSection : currentCourseSectionList) {
            for (int i = 0; i < currentCourseSectionList.size(); i ++) {    
                VBox sectionBox = new VBox();
                VBox sectionNodeList = new VBox();
                Text errorMessage = new Text();
                
                Text sectionName = new Text(currentCourseSectionList.get(i).getIdSection()+" - "+ currentCourseSectionList.get(i).getInstructorName());
                if (getUserSession().getInstance().getCurrentUser().getUsertype() == User.Type.STUDENT) {
                    errorMessage.setText(sectionMsg.get(i));
                } else {
                    this.sectionClickHandler = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            if (event.getClickCount() > 1) {
                                loadClassList();
                            }
                        }
                    };              
                }
                ArrayList<SectionNode> snodes = snodedao.getSectionNodeListBySection(
                                        currentCourseSectionList.get(i).getIdDepartment(),
                                        currentCourseSectionList.get(i).getIdCourse(),
                                        currentCourseSectionList.get(i).getIdSection()); 
                
                if (snodes!=null) {
                    for (SectionNode thisSNode : snodes) {
                        Text thisSNodeText = new Text(thisSNode.toLongString());
                        System.out.println(thisSNode.toLongString());
                        thisSNodeText.setId("section-node");
                        sectionNodeList.getChildren().add(thisSNodeText);
                    }
                }
                if (getUserSession().getInstance().getCurrentUser().getUsertype() == User.Type.STUDENT) {
                    sectionBox.getChildren().addAll(sectionName,sectionNodeList,errorMessage);      
                }
                else {
                    sectionBox.getChildren().addAll(sectionName,sectionNodeList);                          
                    sectionBox.addEventHandler(MouseEvent.MOUSE_CLICKED, sectionClickHandler);
                }
                courseSectionBoxes.add(sectionBox);               
            } //end for
        } else {
            VBox sectionBox = new VBox();
            sectionBox.getChildren().setAll(new Text("This course is not offered in this term."));
            courseSectionBoxes.add(sectionBox);
        }
        sectionList.setItems(FXCollections.observableList(courseSectionBoxes));
    }
     
    /**
     * This method helps to navigate to the classlist page when instructor or administrator double-click on the section item.
     */
    private void loadClassList() {
        int index = sectionList.getSelectionModel().getSelectedIndex();
        ((ClassListController) navigator.navigate(Page.CLASSLIST)).load(currentCourseSectionList.get(index).getIdDepartment(),
                currentCourseSectionList.get(index).getIdCourse(),currentCourseSectionList.get(index).getIdSection());
    }
        
    /**
     * This method sets the message for each section for this student.
     */
    public void setStudentSectionStatusMsg() {
        if (!studentSectionStatusCode.isEmpty()) {
            for (int i = 0; i < studentSectionStatusCode.size(); i ++) {
                this.parseStatusCode();                
                this.sectionMsg.add(statusMsg.get(studentSectionStatusCode.get(i)));
                if ((studentSectionStatusCode.get(i) & 0x80) != 0 && deadlineFlag) {
                    this.sectionMsg.set(i, "Enrolled, drop deadline passed.");
                }
            } //end for

        } //end if
    }
    
    /**
     * Parse the StatusCode according to their priorities.
     */
    private void parseStatusCode() {
        if (!studentSectionStatusCode.isEmpty()) {
            for (int i = 0; i < studentSectionStatusCode.size(); i ++) {
                if (studentSectionStatusCode.get(i) == 0) {
                    continue;
                }
                
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
                    deadlineFlag = true;
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
//                    studentSectionStatusCode.set(i,0x04); 
                    // if coreq is not valid, mark the coreqFlag and set this bit to be zero.
                    studentSectionStatusCode.set(i,studentSectionStatusCode.get(i) & 0x03); 
                    this.coreqFlag = true;
//                    continue;
                }
//                else if ((studentSectionStatusCode.get(i) & 0x02) != 0) {
                if ((studentSectionStatusCode.get(i) & 0x02) != 0) {
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
        studentSectionStatusCode.clear();

        if (currentCourseSectionList.size() != 0) {
            int tempCode = 0;
            Section sectemp = currentCourseSectionList.get(0);
            int permissionCode = new StudentCoursePermissionDAO(studentID, sectemp.getIdDepartment(), sectemp.getIdCourse()).getStudentCoursePermissionCode();

            if (this.isDeadlinePassed()) {
                tempCode +=  0x20;                          
            }
            if (!studentdao.isStudentEligibleForCourse(studentID, sectemp.getIdDepartment(), sectemp.getIdCourse())) {
                tempCode += 0x10;                          
            }
            if (!this.isPrereqValid(studentID, sectemp.getIdDepartment(), sectemp.getIdCourse())) {
                tempCode += 0x08;                          
            }
            if (!this.isCoreqValid(studentID, sectemp.getIdDepartment(), sectemp.getIdCourse())) {
                tempCode += 0x04;                          
            }
//            System.out.println(tempCode);
//            System.out.println(permissionCode);
            
            // overwrite some of the limits for the student.
            tempCode = tempCode & permissionCode;
//            System.out.println(tempCode);
            
            for (Section sec : currentCourseSectionList) {
                int sectempCode = 0;
                if (stusecdao.isStudentEnrolledInSection(studentID, sec.getIdDepartment(), sec.getIdCourse(), sec.getIdSection()) == 2 ) {
                    sectempCode += 0x80;
                }
                else if (stusecdao.isStudentEnrolledInSection(studentID, sec.getIdDepartment(), sec.getIdCourse(), sec.getIdSection()) == 1) {
                    sectempCode += 0x40;
                }                
                else if (this.isTimetableConfict(studentID, sec.getIdDepartment(), sec.getIdCourse(), sec.getIdSection())) {
                    sectempCode += 0x02;
                }
                else if (stusecdao.isSectionFull(sec.getIdDepartment(), sec.getIdCourse(), sec.getIdSection())) {
                    sectempCode += 0x01;
                }
                else {}
//                            System.out.println(sectempCode);

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
        currentStudentEnrolledSectionList = stusecdao.getStudentCurrentTermCourseList(idStudent, 0);
//        System.out.println("coreq of 530" + currentCourseCoReqs);
            
        for (Section current : currentStudentEnrolledSectionList) {
        
            for (Iterator<Course> it = currentCourseCoReqs.iterator(); it.hasNext();) {
                Course coreq = it.next();
                if (coreq.getIdDepartment().equals(current.getIdDepartment()) && coreq.getIdCourse() == current.getIdCourse())
                    it.remove();
            }
        }
        
        if (currentCoursePreReqs.size() == 0)
            return true;
        else 
            return false;
    }
    
    /**
     * This method check whether the student has a timetable conflict with the section.
     * @param idStudent
     * @param idDepartment
     * @param idCourse
     * @param idSection
     * @return 
     */
    public boolean isTimetableConfict(int idStudent, String idDepartment, int idCourse, String idSection) {
        Timetable currentStudentTimetable = stusecdao.getStudentTimetable(idStudent);
        
        // need to loop through all the sections.
        return currentStudentTimetable.isConflict(snodedao.getSectionNodeListBySection(idDepartment, idCourse, idSection));
//        return false;
    }
          
    /**
     * Enroll the student for the selected section and insert the record to database.
     * @param currentSelectedSection 
     */
    public void entrolSection(Section currentSelectedSection) {
        int studentID = UserSession.getInstance().getCurrentUser().getIdUser();
        stusecdao.enrolStudentSection(studentID, currentSelectedSection.getIdDepartment(), currentSelectedSection.getIdCourse(), currentSelectedSection.getIdSection(), 0);
    }
    
    /**
     * Enroll the student for the section class.
     * @param idDepartment
     * @param idCourse
     * @param idSection
     * @param onWaitlist
     * @return 1 if success, 0 otherwise
     */
    public int entrolSection(String idDepartment, int idCourse, String idSection, int onWaitlist) {
        int studentID = UserSession.getInstance().getCurrentUser().getIdUser();
        return stusecdao.enrolStudentSection(studentID, idDepartment, idCourse, idSection, onWaitlist);
    }    
    
    /**
     * This method is deprecated. 
     */
//    public void enterWaitList() {
//        //realized by enrolSection().
//    }
    
    /**
     * Remove the student from the section class or waitlist.
     * @param idDepartment
     * @param idCourse
     * @param idSection
     * @return 
     */
    public int dropSection(String idDepartment, int idCourse, String idSection) {
        int studentID = UserSession.getInstance().getCurrentUser().getIdUser();
        return stusecdao.removeStudentSection(studentID, idDepartment, idCourse, idSection);   
    }
    
    @FXML
    public void sectionListItemOnClick() {
        if (this.currentCourseSectionList.isEmpty())
            return;
        
        if (getUserSession().getInstance().getCurrentUser().getUsertype() != User.Type.STUDENT)
            return;
        
        if (this.sectionList.getSelectionModel().getSelectedItem() != null ) {
            if ((this.studentSectionStatusCode.get(this.sectionList.getSelectionModel().getSelectedIndex()) & 0xc0 ) != 0) {
                this.enrolButton.setText("Drop");
                if (deadlineFlag) {
                    this.enrolButton.setDisable(true);
                    this.applyButton.setDisable(false);
                }
                else {
                    this.enrolButton.setDisable(false);
                    this.applyButton.setDisable(true);                
                }
            }
            else if ((this.studentSectionStatusCode.get(this.sectionList.getSelectionModel().getSelectedIndex()) & 0x3c ) != 0) {
                this.enrolButton.setText("Enrol");
                this.enrolButton.setDisable(true);
                this.applyButton.setDisable(false);            
            }
            else if (this.studentSectionStatusCode.get(this.sectionList.getSelectionModel().getSelectedIndex()) == 0x02) {    
                this.enrolButton.setText("Enrol");
                this.enrolButton.setDisable(true);
                this.applyButton.setDisable(true);
            }
            else if (this.studentSectionStatusCode.get(this.sectionList.getSelectionModel().getSelectedIndex()) == 0x01 ) {   
                this.enrolButton.setText("Join Waitlist");
                this.enrolButton.setDisable(false);
                this.applyButton.setDisable(true);            
            }        
            else if (this.studentSectionStatusCode.get(this.sectionList.getSelectionModel().getSelectedIndex()) == 0x00 ) {   
                this.enrolButton.setText("Enrol");
                this.enrolButton.setDisable(false);
                this.applyButton.setDisable(true);            
            }
        }
    }
    
    @FXML
    public void enrolButtonOnClick() {
//        System.out.println(this.sectionList.getSelectionModel().getSelectedIndex());
//        System.out.println(this.studentSectionStatusCode.get(this.sectionList.getSelectionModel().getSelectedIndex()));
        String msgtoInstructor = "";
        String msgtoSelf = "";        
        int index = this.sectionList.getSelectionModel().getSelectedIndex();
        
        int studentID = UserSession.getInstance().getCurrentUser().getIdUser();        
        if ((this.studentSectionStatusCode.get(index) & 0xC0) != 0) {
            if (stusecdao.removeStudentSection(studentID, 
                    this.currentCourseSectionList.get(index).getIdDepartment(), 
                    this.currentCourseSectionList.get(index).getIdCourse(), 
                    this.currentCourseSectionList.get(index).getIdSection()) == 1) {
                msgtoSelf = "You have withdrawn the section [" + this.currentCourseSectionList.get(index).toString() +"].";
                this.studentSectionStatusCode.set(index, this.studentSectionStatusCode.get(index) & 0x3F);
            }
            if ((msgdao.sendSelfMessage(studentID, msgtoSelf)) == 1)
                System.out.println("You dropped a section.");    
            init();
            return;
        }
        
        // write record to database.
        int isWritten = stusecdao.enrolStudentSection(studentID, 
                    this.currentCourseSectionList.get(index).getIdDepartment(), 
                    this.currentCourseSectionList.get(index).getIdCourse(), 
                    this.currentCourseSectionList.get(index).getIdSection(),
                    this.studentSectionStatusCode.get(index) & 0x01); 
           
     
        
        if (this.studentSectionStatusCode.get(index) == 0x00) {
            msgtoSelf = "You have enrolled the section [" + this.currentCourseSectionList.get(index).toString() + "].";            
        } 
        else if (this.studentSectionStatusCode.get(index) == 0x01) {
            msgtoSelf = "You have joined the waitlist of the section [" + this.currentCourseSectionList.get(index).toString() + "].";                        
            msgtoInstructor = "The student " + studentID + " has joined the waitlist of the section [" + this.currentCourseSectionList.get(index).toString() + "].";                        
        }
      
        if ((msgdao.sendSelfMessage(studentID, msgtoSelf)) == 1) {
            System.out.println("You have enrolled a section.");   
        }
        if (!msgtoInstructor.equals(""))
            msgdao.sendSelfMessage(this.currentCourseSectionList.get(index).getIdInstructor(), msgtoInstructor);
        // corequisite issue
        if (this.coreqFlag) {
            msgtoSelf = "You have unenrolled co-requisite for the course [" + this.currentCourseSectionList.get(index).getCourseString() + "].";
            if ((msgdao.sendSelfMessage(studentID, msgtoSelf)) == 1)
                System.out.println("You have coreq issue.");      
        }
        if (isWritten == 1)
            this.studentSectionStatusCode.set(index, this.studentSectionStatusCode.get(index) | 0x80);
        init();
    }
    
    @FXML
    public void applyButtonOnClick() {
        int studentID = UserSession.getInstance().getCurrentUser().getIdUser();        
        String msgtoAdmin;
        String msgtoSelf;
        String type;
        int index = this.sectionList.getSelectionModel().getSelectedIndex(); 
        
        if ((this.studentSectionStatusCode.get(index) & 0x80) != 0) {
            msgtoAdmin = "The student " + studentID + " is applying to drop the section [" + this.currentCourseSectionList.get(index).toString() + "] because of deadline passed.";
            msgtoSelf = "You have applied to drop the section [" + this.currentCourseSectionList.get(index).toString() + "] because of deadline passed.";    
            type = "deadline";
        }
        else if ((this.studentSectionStatusCode.get(index) & 0x20) != 0) {
            msgtoAdmin = "The student " + studentID + " is applying to enrol the section [" + this.currentCourseSectionList.get(index).toString() + "] because of deadline passed.";
            msgtoSelf = "You have applied to enrol the section [" + this.currentCourseSectionList.get(index).toString() + "] because of deadline passed.";
            type = "deadline";
        }
        else if ((this.studentSectionStatusCode.get(index) & 0x10) != 0) {
            msgtoAdmin = "The student " + studentID + " is applying to enrol the section [" + this.currentCourseSectionList.get(index).toString() + "] because of course restricted to other program.";
            msgtoSelf = "You have applied to enrol the section [" + this.currentCourseSectionList.get(index).toString() + "] because of course restricted to other program.";   
            type = "restricted";
        }
        else if ((this.studentSectionStatusCode.get(index) & 0x08) != 0) {
            msgtoAdmin = "The student " + studentID + " is applying to enrol the section [" + this.currentCourseSectionList.get(index).toString() + "] because of invalid prereq.";
            msgtoSelf = "You have applied to enrol the section [" + this.currentCourseSectionList.get(index).toString() + "] because of invalid prereq.";      
            type = "prereq";
        }        
        else {
            msgtoAdmin = "The student " + studentID + " is applying to enrol the section [" + this.currentCourseSectionList.get(index).toString() + "].";
            msgtoSelf = "You have applied to enrol the section [" + this.currentCourseSectionList.get(index).toString() + "].";   
            type = "info";
        }
        
        if ((msgdao.sendStudentRequestMessage(studentID, msgtoAdmin, type) + msgdao.sendSelfMessage(studentID, msgtoSelf)) == 2) {
            // display message box?
            System.out.println("Your application has been forwarded to the Administrator.");
            OpenDialog dlg = new OpenDialog("Your application has been forwarded to the Administrator.");
            dlg.display();
        }
        init();
    }
    
    
} //end CoursePageController class
