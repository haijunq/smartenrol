/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class ProgramSearchResultTest {
    
    public ProgramSearchResultTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetProgram() {
        System.out.println("getProgram");
        ProgramSearchResult instance = null;
        String expResult = "";
        String result = instance.getProgram();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        ProgramSearchResult instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDepartment() {
        System.out.println("getDepartment");
        ProgramSearchResult instance = null;
        String expResult = "";
        String result = instance.getDepartment();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTotalcredit() {
        System.out.println("getTotalcredit");
        ProgramSearchResult instance = null;
        float expResult = 0.0F;
        float result = instance.getTotalcredit();
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        ProgramSearchResult instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}