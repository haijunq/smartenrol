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
public class PrerequisiteDAOTest {
    
    public PrerequisiteDAOTest() {
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
     * Test of getPrerequsiteByID method, of class PrerequisiteDAO.
     */
    @Test
    public void testGetPrerequsiteByID() {
        System.out.println("getPrerequsiteByID");
        String idDepartment = "CICS";
        int idCourse = 520;
        PrerequisiteDAO instance = new PrerequisiteDAO();
//        ArrayList expResult = null;
        ArrayList result = instance.getPrerequsiteByID(idDepartment, idCourse);
//        assertEquals(expResult, result);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrerequsiteCourseListByID method, of class PrerequisiteDAO.
     */
    @Test
    public void testGetPrerequsiteCourseListByID() {
        System.out.println("getPrerequsiteCourseListByID");
        String idDepartment = "CICS";
        int idCourse = 505;
        PrerequisiteDAO instance = new PrerequisiteDAO();
//        ArrayList expResult = null;
        ArrayList<Course> result = instance.getPrerequsiteCourseListByID(idDepartment, idCourse);
        System.out.println(result);
        
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}