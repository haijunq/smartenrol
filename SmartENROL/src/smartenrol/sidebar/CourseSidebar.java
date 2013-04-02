/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.sidebar;

import java.util.ArrayList;
import smartenrol.dao.CorequisiteDAO;
import smartenrol.dao.CourseDAO;
import smartenrol.dao.PrerequisiteDAO;
import smartenrol.dao.SectionDAO;
import smartenrol.model.Course;
import smartenrol.model.Section;
import smartenrol.model.Student;

/**
 *
 * @author Jeremy
 */
public class CourseSidebar {
    CourseDAO coursedao;
    PrerequisiteDAO prereqdao;
    CorequisiteDAO coreqdao;
    SectionDAO sectiondao;
    
    Student currentStudent;         //store idUser
    Course currentCourse;           //store current course idDepartment, idCourse 
    Section selectedSection;         //store idSection
    Timetable currentStudentTimetable; //store the coursePKs and timeslots for sectionNodes
    
    ArrayList<Course> currentPreReqs;
    ArrayList<Course> currentCoReqs;
    ArrayList<Course> passedCourseHistoryList;      //to compare the prereqs
    ArrayList<Program> currentCoursePrograms;       //to check whether student is in courseprogram.
                                                    //if this is the only function, consider moving it to courseDAO class.
    
    ArrayList<Section> currentCourseSectionList;    //important, student enrols bt choosing one or more in this list
    ArrayList<Student> currentSectionClassList;     //for instructor classlist.
    
    
    public boolean isSectionFull();
    public boolean isInProgram();
    public boolean isPrereqValid();
    public boolean isCoreqValid();
    
    public void entrolInSection();
    public void enterInWaitList());
    public void tropSection();
    public 
}
