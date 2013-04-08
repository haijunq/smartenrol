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
     * Test of isCourseRestricted method, of class CourseDAO.
     */
    @Test
    public void testIsCourseRestricted() {
        System.out.println("isCourseRestricted");
        String idDepartment = "cics";
        int idCourse = 216;
        CourseDAO instance = new CourseDAO();
//        boolean expResult = false;
        boolean result = instance.isCourseRestricted(idDepartment, idCourse);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        System.out.println(result);
    }

//    /**
//     * Test of getCourseByID method, of class CourseDAO.
//     */
//   /*
//    @Test
//    public void testGetCourseByID() {
//        System.out.println("getCourseByID");
//        String idDepartment = "";
//        int idCourse = 0;
//        CourseDAO instance = new CourseDAO();
//        Course expResult = null;
//        Course result = instance.getCourseByID(idDepartment, idCourse);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//  */
//   
//    /**
//     * Test of getCourseByName method, of class CourseDAO.
//     */
//    @Test
//    public void testGetCourseByName() {
//        System.out.println("getCourseByName");
//        String name = "";
//        CourseDAO instance = new CourseDAO();
//        ArrayList expResult = null;
//        ArrayList result = instance.getCourseByName(name);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//  */
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
//
//    /**
//     * Test of searchCourseByKeyword method, of class CourseDAO.
//     */
//   */
    @Test
    public void testSearchCourseByKeyword() {
        System.out.println("searchCourseByKeyword");
        String[] keyword = {"measure","",""};
        String deptFilter = "";
        int levelFilter = 500;
        String programFilter = "";
        CourseDAO instance = new CourseDAO();
        //ArrayList expResult = null;
        ArrayList result = instance.searchCourseByKeyword(keyword, deptFilter, levelFilter, programFilter);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        for (int i=0; i<result.size(); i++)
        {
            System.out.println(result.get(i));
        }
        System.out.println(result.size());
    }
}