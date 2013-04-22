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
public class JSONTokenerTest {
    
    public JSONTokenerTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testBack() {
        System.out.println("back");
        JSONTokener instance = null;
        instance.back();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDehexchar() {
        System.out.println("dehexchar");
        char c = ' ';
        int expResult = 0;
        int result = JSONTokener.dehexchar(c);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEnd() {
        System.out.println("end");
        JSONTokener instance = null;
        boolean expResult = false;
        boolean result = instance.end();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMore() {
        System.out.println("more");
        JSONTokener instance = null;
        boolean expResult = false;
        boolean result = instance.more();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNext_0args() {
        System.out.println("next");
        JSONTokener instance = null;
        char expResult = ' ';
        char result = instance.next();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNext_char() {
        System.out.println("next");
        char c = ' ';
        JSONTokener instance = null;
        char expResult = ' ';
        char result = instance.next(c);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNext_int() {
        System.out.println("next");
        int n = 0;
        JSONTokener instance = null;
        String expResult = "";
        String result = instance.next(n);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNextClean() {
        System.out.println("nextClean");
        JSONTokener instance = null;
        char expResult = ' ';
        char result = instance.nextClean();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNextString() {
        System.out.println("nextString");
        char quote = ' ';
        JSONTokener instance = null;
        String expResult = "";
        String result = instance.nextString(quote);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNextTo_char() {
        System.out.println("nextTo");
        char delimiter = ' ';
        JSONTokener instance = null;
        String expResult = "";
        String result = instance.nextTo(delimiter);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNextTo_String() {
        System.out.println("nextTo");
        String delimiters = "";
        JSONTokener instance = null;
        String expResult = "";
        String result = instance.nextTo(delimiters);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNextValue() {
        System.out.println("nextValue");
        JSONTokener instance = null;
        Object expResult = null;
        Object result = instance.nextValue();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSkipTo() {
        System.out.println("skipTo");
        char to = ' ';
        JSONTokener instance = null;
        char expResult = ' ';
        char result = instance.skipTo(to);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSyntaxError() {
        System.out.println("syntaxError");
        String message = "";
        JSONTokener instance = null;
        JSONException expResult = null;
        JSONException result = instance.syntaxError(message);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        JSONTokener instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}