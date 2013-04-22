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
public class XMLTest {
    
    public XMLTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testEscape() {
        System.out.println("escape");
        String string = "";
        String expResult = "";
        String result = XML.escape(string);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNoSpace() {
        System.out.println("noSpace");
        String string = "";
        XML.noSpace(string);
        fail("The test case is a prototype.");
    }

    @Test
    public void testStringToValue() {
        System.out.println("stringToValue");
        String string = "";
        Object expResult = null;
        Object result = XML.stringToValue(string);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToJSONObject() {
        System.out.println("toJSONObject");
        String string = "";
        JSONObject expResult = null;
        JSONObject result = XML.toJSONObject(string);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString_Object() {
        System.out.println("toString");
        Object object = null;
        String expResult = "";
        String result = XML.toString(object);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString_Object_String() {
        System.out.println("toString");
        Object object = null;
        String tagName = "";
        String expResult = "";
        String result = XML.toString(object, tagName);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}