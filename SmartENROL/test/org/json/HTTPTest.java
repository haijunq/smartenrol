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
public class HTTPTest {
    
    public HTTPTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testToJSONObject() {
        System.out.println("toJSONObject");
        String string = "";
        JSONObject expResult = null;
        JSONObject result = HTTP.toJSONObject(string);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        JSONObject jo = null;
        String expResult = "";
        String result = HTTP.toString(jo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}