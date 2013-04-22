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
public class ProgramCoursesDAOTest {
    
    public ProgramCoursesDAOTest() {
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
     * Test of getCourseListByProgram method, of class ProgramCoursesDAO.
     */
    @Test
    public void testGetCourseListByProgram() {
        System.out.println("getCourseListByProgram");
        String idProgram = "mss";
        ProgramCoursesDAO instance = new ProgramCoursesDAO();
//        ArrayList expResult = null;
        ArrayList<Course> result = instance.getCourseListByProgram(idProgram);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        for (Course c : result) 
            System.out.println(c);
    }

    /**
     * Test of getRequiredCourseListByStudent method, of class ProgramCoursesDAO.
     */
    @Test
    public void testGetRequiredCourseListByStudent() {
        System.out.println("getRequiredCourseListByStudent");
        int idStudent = 80013003;
        ProgramCoursesDAO instance = new ProgramCoursesDAO();
//        ArrayList expResult = null;
        ArrayList<Course> result = instance.getRequiredCourseListByStudent(idStudent);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        for (Course c : result) 
            System.out.println(c);        
    }
}