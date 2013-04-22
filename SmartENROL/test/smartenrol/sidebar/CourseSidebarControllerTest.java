/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.sidebar;

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
public class CourseSidebarControllerTest {
    
    public CourseSidebarControllerTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testPrep() {
        System.out.println("prep");
        CourseSidebarController instance = new CourseSidebarController();
        instance.prep();
        fail("The test case is a prototype.");
    }

    @Test
    public void testInit() {
        System.out.println("init");
        CourseSidebarController instance = new CourseSidebarController();
        instance.init();
        fail("The test case is a prototype.");
    }

    @Test
    public void testLoad() {
        System.out.println("load");
        String idDepartment = "";
        int idCourse = 0;
        CourseSidebarController instance = new CourseSidebarController();
        instance.load(idDepartment, idCourse);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetStudentSectionStatusMsg() {
        System.out.println("setStudentSectionStatusMsg");
        CourseSidebarController instance = new CourseSidebarController();
        instance.setStudentSectionStatusMsg();
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetStudentSectionStatusCode() {
        System.out.println("setStudentSectionStatusCode");
        ArrayList<Section> currentCourseSectionList = null;
        CourseSidebarController instance = new CourseSidebarController();
        instance.setStudentSectionStatusCode(currentCourseSectionList);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIfStudentEnrolledInSection() {
        System.out.println("ifStudentEnrolledInSection");
        Student currentStudent = null;
        Section currentSelecetedSection = null;
        CourseSidebarController instance = new CourseSidebarController();
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
        CourseSidebarController instance = new CourseSidebarController();
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
        CourseSidebarController instance = new CourseSidebarController();
        boolean expResult = false;
        boolean result = instance.isStudentEligibleForCourse(idStudent, idDepartment, idCourse);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsDeadlinePassed() {
        System.out.println("isDeadlinePassed");
        CourseSidebarController instance = new CourseSidebarController();
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
        CourseSidebarController instance = new CourseSidebarController();
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
        CourseSidebarController instance = new CourseSidebarController();
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
        CourseSidebarController instance = new CourseSidebarController();
        boolean expResult = false;
        boolean result = instance.isTimetableConfict(idStudent, idDepartment, idCourse, idSection);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEntrolSection_Section() {
        System.out.println("entrolSection");
        Section currentSelectedSection = null;
        CourseSidebarController instance = new CourseSidebarController();
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
        CourseSidebarController instance = new CourseSidebarController();
        int expResult = 0;
        int result = instance.entrolSection(idDepartment, idCourse, idSection, onWaitlist);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEnterWaitList() {
        System.out.println("enterWaitList");
        CourseSidebarController instance = new CourseSidebarController();
        instance.enterWaitList();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDropSection() {
        System.out.println("dropSection");
        String idDepartment = "";
        int idCourse = 0;
        String idSection = "";
        CourseSidebarController instance = new CourseSidebarController();
        int expResult = 0;
        int result = instance.dropSection(idDepartment, idCourse, idSection);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSectionListItemOnClick() {
        System.out.println("sectionListItemOnClick");
        CourseSidebarController instance = new CourseSidebarController();
        instance.sectionListItemOnClick();
        fail("The test case is a prototype.");
    }

    @Test
    public void testEnrolButtonOnClick() {
        System.out.println("enrolButtonOnClick");
        CourseSidebarController instance = new CourseSidebarController();
        instance.enrolButtonOnClick();
        fail("The test case is a prototype.");
    }

    @Test
    public void testApplyButtonOnClick() {
        System.out.println("applyButtonOnClick");
        CourseSidebarController instance = new CourseSidebarController();
        instance.applyButtonOnClick();
        fail("The test case is a prototype.");
    }
}