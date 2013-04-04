/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

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
public class TermDAOTest {
    
    public TermDAOTest() {
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
     * Test of getDeadline method, of class TermDAO.
     */
    @Test
    public void testGetDeadline() {
        System.out.println("getDeadline");
        String term = "summer";
        int year = 2013;
        TermDAO instance = new TermDAO();
//        LocalDate expResult = null;
        LocalDate result = instance.getDeadline(term, year);
//        assertEquals(expResult, result);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeadline method, of class TermDAO.
     */
    @Test
    public void testGetDeadline_String_int() {
        System.out.println("getDeadline");
        TermDAO instance = new TermDAO();
//        LocalDate expResult = null;
        LocalDate result = instance.getDeadline();
        System.out.println(result);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}