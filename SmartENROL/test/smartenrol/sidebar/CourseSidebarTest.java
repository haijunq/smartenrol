/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.sidebar;

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
public class CourseSidebarTest {
    
    public CourseSidebarTest() {
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

//    /**
//     * Test of isEnrolledInCurrentSection method, of class CourseSidebar.
//     */
//    @Test
//    public void testIsEnrolledInCurrentSection() {
//        System.out.println("isEnrolledInCurrentSection");
//        CourseSidebar instance = new CourseSidebar();
//        boolean expResult = false;
//        boolean result = instance.isEnrolledInCurrentSection();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of isErolledInCurrentCourse method, of class CourseSidebar.
//     */
//    @Test
//    public void testIsErolledInCurrentCourse() {
//        System.out.println("isErolledInCurrentCourse");
//        CourseSidebar instance = new CourseSidebar();
//        boolean expResult = false;
//        boolean result = instance.isErolledInCurrentCourse();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of isDeadlinePassed method, of class CourseSidebar.
     */
    @Test
    public void testIsDeadlinePassed() {
        System.out.println("isDeadlinePassed");
        CourseSidebar instance = new CourseSidebar();
        boolean expResult = true;
        boolean result = instance.isDeadlinePassed();
        System.out.println(result);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of isPrereqValid method, of class CourseSidebar.
//     */
//    @Test
//    public void testIsPrereqValid() {
//        System.out.println("isPrereqValid");
//        CourseSidebar instance = new CourseSidebar();
//        boolean expResult = false;
//        boolean result = instance.isPrereqValid();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of isCoreqValid method, of class CourseSidebar.
//     */
//    @Test
//    public void testIsCoreqValid() {
//        System.out.println("isCoreqValid");
//        CourseSidebar instance = new CourseSidebar();
//        boolean expResult = false;
//        boolean result = instance.isCoreqValid();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}