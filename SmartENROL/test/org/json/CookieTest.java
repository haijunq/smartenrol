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
public class CookieTest {
    
    public CookieTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testEscape() {
        System.out.println("escape");
        String string = "";
        String expResult = "";
        String result = Cookie.escape(string);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToJSONObject() {
        System.out.println("toJSONObject");
        String string = "";
        JSONObject expResult = null;
        JSONObject result = Cookie.toJSONObject(string);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        JSONObject jo = null;
        String expResult = "";
        String result = Cookie.toString(jo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUnescape() {
        System.out.println("unescape");
        String string = "";
        String expResult = "";
        String result = Cookie.unescape(string);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}