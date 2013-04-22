/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.json;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class JSONExceptionTest {
    
    public JSONExceptionTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetCause() {
        System.out.println("getCause");
        JSONException instance = null;
        Throwable expResult = null;
        Throwable result = instance.getCause();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}