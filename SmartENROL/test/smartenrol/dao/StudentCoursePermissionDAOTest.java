/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Haijun
 */
public class StudentCoursePermissionDAOTest {
    
    public StudentCoursePermissionDAOTest() {
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
     * Test of hasPermissionForPrerequisite method, of class StudentCoursePermissionDAO.
     */
    @Test
    public void testHasPermissionForPrerequisite() {
        System.out.println("hasPermissionForPrerequisite");
        StudentCoursePermissionDAO instance = new StudentCoursePermissionDAO(80013013, "cics", 530);
//        boolean expResult = false;
        boolean result = instance.hasPermissionForPrerequisite();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        System.out.println(result);
    }

    /**
     * Test of hasPermissionForCorequisite method, of class StudentCoursePermissionDAO.
     */
    @Test
    public void testHasPermissionForCorequisite() {
        System.out.println("hasPermissionForCorequisite");
        StudentCoursePermissionDAO instance = new StudentCoursePermissionDAO(80013013, "cics", 530);
//        boolean expResult = false;
        boolean result = instance.hasPermissionForCorequisite();
//        assertEquals(expResult, result);
//         TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
                System.out.println(result);

    }

    /**
     * Test of hasPermissionForDeadline method, of class StudentCoursePermissionDAO.
     */
    @Test
    public void testHasPermissionForDeadline() {
        System.out.println("hasPermissionForDeadline");
        StudentCoursePermissionDAO instance = new StudentCoursePermissionDAO(80013013, "cics", 530);
//        boolean expResult = false;
        boolean result = instance.hasPermissionForDeadline();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
                System.out.println(result);

    }

    /**
     * Test of hasPermissionForRestricted method, of class StudentCoursePermissionDAO.
     */
    @Test
    public void testHasPermissionForRestricted() {
        System.out.println("hasPermissionForRestricted");
        StudentCoursePermissionDAO instance = new StudentCoursePermissionDAO(80013013, "cics", 530);
//        boolean expResult = false;
        boolean result = instance.hasPermissionForRestricted();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
                System.out.println(result);

    }
}