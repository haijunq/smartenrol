/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class PageControllerTest {
    
    public PageControllerTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testNavDashboard() {
        System.out.println("navDashboard");
        PageController instance = new PageController();
        instance.navDashboard();
        fail("The test case is a prototype.");
    }

    @Test
    public void testNavAddBuilding() {
        System.out.println("navAddBuilding");
        PageController instance = new PageController();
        instance.navAddBuilding();
        fail("The test case is a prototype.");
    }

    @Test
    public void testNavAddCourse() {
        System.out.println("navAddCourse");
        PageController instance = new PageController();
        instance.navAddCourse();
        fail("The test case is a prototype.");
    }

    @Test
    public void testNavAddDepartment() {
        System.out.println("navAddDepartment");
        PageController instance = new PageController();
        instance.navAddDepartment();
        fail("The test case is a prototype.");
    }

    @Test
    public void testNavAddProgram() {
        System.out.println("navAddProgram");
        PageController instance = new PageController();
        instance.navAddProgram();
        fail("The test case is a prototype.");
    }

    @Test
    public void testNavAddSection() {
        System.out.println("navAddSection");
        PageController instance = new PageController();
        instance.navAddSection();
        fail("The test case is a prototype.");
    }

    @Test
    public void testNavAddFaculty() {
        System.out.println("navAddFaculty");
        PageController instance = new PageController();
        instance.navAddFaculty();
        fail("The test case is a prototype.");
    }

    @Test
    public void testNavTimetable() {
        System.out.println("navTimetable");
        PageController instance = new PageController();
        instance.navTimetable();
        fail("The test case is a prototype.");
    }
}