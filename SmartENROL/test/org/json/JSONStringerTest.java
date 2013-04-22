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
public class JSONStringerTest {
    
    public JSONStringerTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        JSONStringer instance = new JSONStringer();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}