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
public class JSONWriterTest {
    
    public JSONWriterTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testArray() {
        System.out.println("array");
        JSONWriter instance = null;
        JSONWriter expResult = null;
        JSONWriter result = instance.array();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEndArray() {
        System.out.println("endArray");
        JSONWriter instance = null;
        JSONWriter expResult = null;
        JSONWriter result = instance.endArray();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEndObject() {
        System.out.println("endObject");
        JSONWriter instance = null;
        JSONWriter expResult = null;
        JSONWriter result = instance.endObject();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testKey() {
        System.out.println("key");
        String string = "";
        JSONWriter instance = null;
        JSONWriter expResult = null;
        JSONWriter result = instance.key(string);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testObject() {
        System.out.println("object");
        JSONWriter instance = null;
        JSONWriter expResult = null;
        JSONWriter result = instance.object();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValue_boolean() {
        System.out.println("value");
        boolean b = false;
        JSONWriter instance = null;
        JSONWriter expResult = null;
        JSONWriter result = instance.value(b);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValue_double() {
        System.out.println("value");
        double d = 0.0;
        JSONWriter instance = null;
        JSONWriter expResult = null;
        JSONWriter result = instance.value(d);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValue_long() {
        System.out.println("value");
        long l = 0L;
        JSONWriter instance = null;
        JSONWriter expResult = null;
        JSONWriter result = instance.value(l);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValue_Object() {
        System.out.println("value");
        Object object = null;
        JSONWriter instance = null;
        JSONWriter expResult = null;
        JSONWriter result = instance.value(object);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}