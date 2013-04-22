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
public class JSONMLTest {
    
    public JSONMLTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testToJSONArray_String() {
        System.out.println("toJSONArray");
        String string = "";
        JSONArray expResult = null;
        JSONArray result = JSONML.toJSONArray(string);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToJSONArray_XMLTokener() {
        System.out.println("toJSONArray");
        XMLTokener x = null;
        JSONArray expResult = null;
        JSONArray result = JSONML.toJSONArray(x);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToJSONObject_XMLTokener() {
        System.out.println("toJSONObject");
        XMLTokener x = null;
        JSONObject expResult = null;
        JSONObject result = JSONML.toJSONObject(x);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToJSONObject_String() {
        System.out.println("toJSONObject");
        String string = "";
        JSONObject expResult = null;
        JSONObject result = JSONML.toJSONObject(string);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString_JSONArray() {
        System.out.println("toString");
        JSONArray ja = null;
        String expResult = "";
        String result = JSONML.toString(ja);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString_JSONObject() {
        System.out.println("toString");
        JSONObject jo = null;
        String expResult = "";
        String result = JSONML.toString(jo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}