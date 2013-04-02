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
     * Test of isCourseInProgram method, of class CourseDAO.
     */
    @Test
    public void testIsCourseInProgram() {
        System.out.println("isCourseInProgram");
        String idDepartment = "CICS";
        int idCourse = 505;
        String idProgram = "1";
        CourseDAO instance = new CourseDAO();
        boolean expResult = true;
        boolean result = instance.isCourseInProgram(idDepartment, idCourse, idProgram);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


}