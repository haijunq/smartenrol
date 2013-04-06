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
}