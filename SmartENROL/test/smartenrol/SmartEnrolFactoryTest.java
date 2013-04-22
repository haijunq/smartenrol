/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import smartenrol.page.PageController;
import smartenrol.page.administration.building.AddBuildingController;
import smartenrol.page.administration.course.AddCourseController;
import smartenrol.page.administration.department.AddDepartmentController;
import smartenrol.page.administration.faculty.AddFacultyController;
import smartenrol.page.administration.program.AddProgramController;
import smartenrol.page.administration.section.AddSectionController;
import smartenrol.page.dashboard.DashboardController;
import smartenrol.page.login.LoginController;
import smartenrol.page.timetable.TimetableController;


/**
 *
 * @author Aishwarya
 */
public class SmartEnrolFactoryTest {
    
    public SmartEnrolFactoryTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testMainController() throws Exception {
        System.out.println("mainController");
        SmartEnrolFactory instance = new SmartEnrolFactory();
        PageController expResult = null;
        PageController result = instance.mainController();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDashboard() throws Exception {
        System.out.println("dashboard");
        SmartEnrolFactory instance = new SmartEnrolFactory();
        DashboardController expResult = null;
        DashboardController result = instance.dashboard();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        SmartEnrolFactory instance = new SmartEnrolFactory();
        LoginController expResult = null;
        LoginController result = instance.login();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAdminAddBuilding() throws Exception {
        System.out.println("adminAddBuilding");
        SmartEnrolFactory instance = new SmartEnrolFactory();
        AddBuildingController expResult = null;
        AddBuildingController result = instance.adminAddBuilding();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAdminAddCourse() throws Exception {
        System.out.println("adminAddCourse");
        SmartEnrolFactory instance = new SmartEnrolFactory();
        AddCourseController expResult = null;
        AddCourseController result = instance.adminAddCourse();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAdminAddDepartment() throws Exception {
        System.out.println("adminAddDepartment");
        SmartEnrolFactory instance = new SmartEnrolFactory();
        AddDepartmentController expResult = null;
        AddDepartmentController result = instance.adminAddDepartment();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAdminAddFaculty() throws Exception {
        System.out.println("adminAddFaculty");
        SmartEnrolFactory instance = new SmartEnrolFactory();
        AddFacultyController expResult = null;
        AddFacultyController result = instance.adminAddFaculty();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAdminAddProgram() throws Exception {
        System.out.println("adminAddProgram");
        SmartEnrolFactory instance = new SmartEnrolFactory();
        AddProgramController expResult = null;
        AddProgramController result = instance.adminAddProgram();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAdminAddSection() throws Exception {
        System.out.println("adminAddSection");
        SmartEnrolFactory instance = new SmartEnrolFactory();
        AddSectionController expResult = null;
        AddSectionController result = instance.adminAddSection();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testTimetable() throws Exception {
        System.out.println("timetable");
        SmartEnrolFactory instance = new SmartEnrolFactory();
        TimetableController expResult = null;
        TimetableController result = instance.timetable();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

   

    @Test
    public void testLoadController() throws Exception {
        System.out.println("loadController");
        String url = "";
        SmartEnrolFactory instance = new SmartEnrolFactory();
        Object expResult = null;
        Object result = instance.loadController(url);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}