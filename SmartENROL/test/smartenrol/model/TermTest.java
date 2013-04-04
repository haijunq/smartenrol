/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import org.joda.time.LocalDate;
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
public class TermTest {
    
    public TermTest() {
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
     * Test of getCurrentTerm method, of class Term.
     */
    @Test
    public void testGetCurrentTerm() {
        System.out.println("getCurrentTerm");
        Term instance = new Term();
//        String expResult = "";
//        String result = instance.getCurrentTerm();
        System.out.println(instance.getCurrentDate());
        System.out.println(instance.getCurrentYear());
        System.out.println(instance.getCurrentTerm());
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentYear method, of class Term.
     */
//    @Test
//    public void testGetCurrentYear() {
//        System.out.println("getCurrentYear");
//        Term instance = new Term();
////        int expResult = 0;
//        int result = instance.getCurrentYear();
////        assertEquals(expResult, result);
//        System.out.println(result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCurrentDate method, of class Term.
//     */
//    @Test
//    public void testGetCurrentDate() {
//        System.out.println("getCurrentDate");
//        Term instance = new Term();
////        LocalDate expResult = null;
//        LocalDate result = instance.getCurrentDate();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}