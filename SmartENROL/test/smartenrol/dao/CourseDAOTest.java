/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import smartenrol.model.Course;

/**
 *
 * @author Haijun
 */
public class CourseDAOTest {
    
    public CourseDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCourseByID method, of class CourseDAO.
     */
    @Test
    public void testGetCourseByID() {
        System.out.println("getCourseByID");
        String idDepartment = "CICS";
        int idCourse = 500;
        CourseDAO instance = new CourseDAO();
//        Course expResult = null;
        Course result = instance.getCourseByID(idDepartment, idCourse);
//        assertEquals(expResult, result);
        System.out.println(result.getCourseName()+result.getCredits()+result.isRestricted());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getCourseByName method, of class CourseDAO.
     */
    @Test
    public void testGetCourseByName() {
        System.out.println("getCourseByName");
        String name = "software";
        CourseDAO instance = new CourseDAO();
//        ArrayList expResult = null;
        ArrayList<Course> result = instance.getCourseByName(name);
//        assertEquals(expResult, result);
        for (Course c: result)
            System.out.println(c.isRestricted());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

//    /**
//     * Test of getCourseByLevel method, of class CourseDAO.
//     */
//    @Test
//    public void testGetCourseByLevel() {
//        System.out.println("getCourseByLevel");
//        String idDepartment = "";
//        int level = 0;
//        CourseDAO instance = new CourseDAO();
//        ArrayList expResult = null;
//        ArrayList result = instance.getCourseByLevel(idDepartment, level);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateCourse method, of class CourseDAO.
//     */
//    @Test
//    public void testUpdateCourse() {
//        System.out.println("updateCourse");
//        Course course = null;
//        CourseDAO instance = new CourseDAO();
//        int expResult = 0;
//        int result = instance.updateCourse(course);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addCourse method, of class CourseDAO.
//     */
//    @Test
//    public void testAddCourse() {
//        System.out.println("addCourse");
//        Course course = null;
//        CourseDAO instance = new CourseDAO();
//        int expResult = 0;
//        int result = instance.addCourse(course);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removeCourse method, of class CourseDAO.
//     */
//    @Test
//    public void testRemoveCourse() {
//        System.out.println("removeCourse");
//        Course course = null;
//        CourseDAO instance = new CourseDAO();
//        int expResult = 0;
//        int result = instance.removeCourse(course);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}