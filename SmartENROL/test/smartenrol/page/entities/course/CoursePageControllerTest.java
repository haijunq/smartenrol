/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.entities.course;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import smartenrol.model.Course;
import smartenrol.model.Section;
import smartenrol.model.Student;

/**
 *
 * @author Aishwarya
 */
public class CoursePageControllerTest {
    
    public CoursePageControllerTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testInit() {
        System.out.println("init");
        CoursePageController instance = new CoursePageController();
        instance.init();
        fail("The test case is a prototype.");
    }

    @Test
    public void testLoad() {
        System.out.println("load");
        String idDepartment = "";
        int idCourse = 0;
        CoursePageController instance = new CoursePageController();
        instance.load(idDepartment, idCourse);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetStudentSectionStatusMsg() {
        System.out.println("setStudentSectionStatusMsg");
        CoursePageController instance = new CoursePageController();
        instance.setStudentSectionStatusMsg();
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetStudentSectionStatusCode() {
        System.out.println("setStudentSectionStatusCode");
        ArrayList<Section> currentCourseSectionList = null;
        CoursePageController instance = new CoursePageController();
        instance.setStudentSectionStatusCode(currentCourseSectionList);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIfStudentEnrolledInSection() {
        System.out.println("ifStudentEnrolledInSection");
        Student currentStudent = null;
        Section currentSelecetedSection = null;
        CoursePageController instance = new CoursePageController();
        int expResult = 0;
        int result = instance.ifStudentEnrolledInSection(currentStudent, currentSelecetedSection);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIfStudentErolledInCourse() {
        System.out.println("ifStudentErolledInCourse");
        Student currentStudent = null;
        Course currentCourse = null;
        CoursePageController instance = new CoursePageController();
        int expResult = 0;
        int result = instance.ifStudentErolledInCourse(currentStudent, currentCourse);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsStudentEligibleForCourse() {
        System.out.println("isStudentEligibleForCourse");
        int idStudent = 0;
        String idDepartment = "";
        int idCourse = 0;
        CoursePageController instance = new CoursePageController();
        boolean expResult = false;
        boolean result = instance.isStudentEligibleForCourse(idStudent, idDepartment, idCourse);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsDeadlinePassed() {
        System.out.println("isDeadlinePassed");
        CoursePageController instance = new CoursePageController();
        boolean expResult = false;
        boolean result = instance.isDeadlinePassed();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsPrereqValid() {
        System.out.println("isPrereqValid");
        int idStudent = 0;
        String idDepartment = "";
        int idCourse = 0;
        CoursePageController instance = new CoursePageController();
        boolean expResult = false;
        boolean result = instance.isPrereqValid(idStudent, idDepartment, idCourse);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsCoreqValid() {
        System.out.println("isCoreqValid");
        int idStudent = 0;
        String idDepartment = "";
        int idCourse = 0;
        CoursePageController instance = new CoursePageController();
        boolean expResult = false;
        boolean result = instance.isCoreqValid(idStudent, idDepartment, idCourse);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsTimetableConfict() {
        System.out.println("isTimetableConfict");
        int idStudent = 0;
        String idDepartment = "";
        int idCourse = 0;
        String idSection = "";
        CoursePageController instance = new CoursePageController();
        boolean expResult = false;
        boolean result = instance.isTimetableConfict(idStudent, idDepartment, idCourse, idSection);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEntrolSection_Section() {
        System.out.println("entrolSection");
        Section currentSelectedSection = null;
        CoursePageController instance = new CoursePageController();
        instance.entrolSection(currentSelectedSection);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEntrolSection_4args() {
        System.out.println("entrolSection");
        String idDepartment = "";
        int idCourse = 0;
        String idSection = "";
        int onWaitlist = 0;
        CoursePageController instance = new CoursePageController();
        int expResult = 0;
        int result = instance.entrolSection(idDepartment, idCourse, idSection, onWaitlist);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDropSection() {
        System.out.println("dropSection");
        String idDepartment = "";
        int idCourse = 0;
        String idSection = "";
        CoursePageController instance = new CoursePageController();
        int expResult = 0;
        int result = instance.dropSection(idDepartment, idCourse, idSection);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSectionListItemOnClick() {
        System.out.println("sectionListItemOnClick");
        CoursePageController instance = new CoursePageController();
        instance.sectionListItemOnClick();
        fail("The test case is a prototype.");
    }

    @Test
    public void testEnrolButtonOnClick() {
        System.out.println("enrolButtonOnClick");
        CoursePageController instance = new CoursePageController();
        instance.enrolButtonOnClick();
        fail("The test case is a prototype.");
    }

    @Test
    public void testApplyButtonOnClick() {
        System.out.println("applyButtonOnClick");
        CoursePageController instance = new CoursePageController();
        instance.applyButtonOnClick();
        fail("The test case is a prototype.");
    }
}