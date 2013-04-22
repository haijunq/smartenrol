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
public class CDLTest {
    
    public CDLTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testRowToJSONArray() {
        System.out.println("rowToJSONArray");
        JSONTokener x = null;
        JSONArray expResult = null;
        JSONArray result = CDL.rowToJSONArray(x);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRowToJSONObject() {
        System.out.println("rowToJSONObject");
        JSONArray names = null;
        JSONTokener x = null;
        JSONObject expResult = null;
        JSONObject result = CDL.rowToJSONObject(names, x);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRowToString() {
        System.out.println("rowToString");
        JSONArray ja = null;
        String expResult = "";
        String result = CDL.rowToString(ja);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToJSONArray_String() {
        System.out.println("toJSONArray");
        String string = "";
        JSONArray expResult = null;
        JSONArray result = CDL.toJSONArray(string);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToJSONArray_JSONTokener() {
        System.out.println("toJSONArray");
        JSONTokener x = null;
        JSONArray expResult = null;
        JSONArray result = CDL.toJSONArray(x);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToJSONArray_JSONArray_String() {
        System.out.println("toJSONArray");
        JSONArray names = null;
        String string = "";
        JSONArray expResult = null;
        JSONArray result = CDL.toJSONArray(names, string);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToJSONArray_JSONArray_JSONTokener() {
        System.out.println("toJSONArray");
        JSONArray names = null;
        JSONTokener x = null;
        JSONArray expResult = null;
        JSONArray result = CDL.toJSONArray(names, x);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString_JSONArray() {
        System.out.println("toString");
        JSONArray ja = null;
        String expResult = "";
        String result = CDL.toString(ja);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString_JSONArray_JSONArray() {
        System.out.println("toString");
        JSONArray names = null;
        JSONArray ja = null;
        String expResult = "";
        String result = CDL.toString(names, ja);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}