/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.json;

import java.io.Writer;
import java.util.Collection;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class JSONArrayTest {
    
    public JSONArrayTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        JSONArray instance = new JSONArray();
        Object expResult = null;
        Object result = instance.get(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetBoolean() {
        System.out.println("getBoolean");
        int index = 0;
        JSONArray instance = new JSONArray();
        boolean expResult = false;
        boolean result = instance.getBoolean(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDouble() {
        System.out.println("getDouble");
        int index = 0;
        JSONArray instance = new JSONArray();
        double expResult = 0.0;
        double result = instance.getDouble(index);
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetInt() {
        System.out.println("getInt");
        int index = 0;
        JSONArray instance = new JSONArray();
        int expResult = 0;
        int result = instance.getInt(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetJSONArray() {
        System.out.println("getJSONArray");
        int index = 0;
        JSONArray instance = new JSONArray();
        JSONArray expResult = null;
        JSONArray result = instance.getJSONArray(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetJSONObject() {
        System.out.println("getJSONObject");
        int index = 0;
        JSONArray instance = new JSONArray();
        JSONObject expResult = null;
        JSONObject result = instance.getJSONObject(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetLong() {
        System.out.println("getLong");
        int index = 0;
        JSONArray instance = new JSONArray();
        long expResult = 0L;
        long result = instance.getLong(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetString() {
        System.out.println("getString");
        int index = 0;
        JSONArray instance = new JSONArray();
        String expResult = "";
        String result = instance.getString(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsNull() {
        System.out.println("isNull");
        int index = 0;
        JSONArray instance = new JSONArray();
        boolean expResult = false;
        boolean result = instance.isNull(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testJoin() {
        System.out.println("join");
        String separator = "";
        JSONArray instance = new JSONArray();
        String expResult = "";
        String result = instance.join(separator);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testLength() {
        System.out.println("length");
        JSONArray instance = new JSONArray();
        int expResult = 0;
        int result = instance.length();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOpt() {
        System.out.println("opt");
        int index = 0;
        JSONArray instance = new JSONArray();
        Object expResult = null;
        Object result = instance.opt(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptBoolean_int() {
        System.out.println("optBoolean");
        int index = 0;
        JSONArray instance = new JSONArray();
        boolean expResult = false;
        boolean result = instance.optBoolean(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptBoolean_int_boolean() {
        System.out.println("optBoolean");
        int index = 0;
        boolean defaultValue = false;
        JSONArray instance = new JSONArray();
        boolean expResult = false;
        boolean result = instance.optBoolean(index, defaultValue);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptDouble_int() {
        System.out.println("optDouble");
        int index = 0;
        JSONArray instance = new JSONArray();
        double expResult = 0.0;
        double result = instance.optDouble(index);
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptDouble_int_double() {
        System.out.println("optDouble");
        int index = 0;
        double defaultValue = 0.0;
        JSONArray instance = new JSONArray();
        double expResult = 0.0;
        double result = instance.optDouble(index, defaultValue);
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptInt_int() {
        System.out.println("optInt");
        int index = 0;
        JSONArray instance = new JSONArray();
        int expResult = 0;
        int result = instance.optInt(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptInt_int_int() {
        System.out.println("optInt");
        int index = 0;
        int defaultValue = 0;
        JSONArray instance = new JSONArray();
        int expResult = 0;
        int result = instance.optInt(index, defaultValue);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptJSONArray() {
        System.out.println("optJSONArray");
        int index = 0;
        JSONArray instance = new JSONArray();
        JSONArray expResult = null;
        JSONArray result = instance.optJSONArray(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptJSONObject() {
        System.out.println("optJSONObject");
        int index = 0;
        JSONArray instance = new JSONArray();
        JSONObject expResult = null;
        JSONObject result = instance.optJSONObject(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptLong_int() {
        System.out.println("optLong");
        int index = 0;
        JSONArray instance = new JSONArray();
        long expResult = 0L;
        long result = instance.optLong(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptLong_int_long() {
        System.out.println("optLong");
        int index = 0;
        long defaultValue = 0L;
        JSONArray instance = new JSONArray();
        long expResult = 0L;
        long result = instance.optLong(index, defaultValue);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptString_int() {
        System.out.println("optString");
        int index = 0;
        JSONArray instance = new JSONArray();
        String expResult = "";
        String result = instance.optString(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptString_int_String() {
        System.out.println("optString");
        int index = 0;
        String defaultValue = "";
        JSONArray instance = new JSONArray();
        String expResult = "";
        String result = instance.optString(index, defaultValue);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_boolean() {
        System.out.println("put");
        boolean value = false;
        JSONArray instance = new JSONArray();
        JSONArray expResult = null;
        JSONArray result = instance.put(value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_Collection() {
        System.out.println("put");
        Collection value = null;
        JSONArray instance = new JSONArray();
        JSONArray expResult = null;
        JSONArray result = instance.put(value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_double() {
        System.out.println("put");
        double value = 0.0;
        JSONArray instance = new JSONArray();
        JSONArray expResult = null;
        JSONArray result = instance.put(value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_int() {
        System.out.println("put");
        int value = 0;
        JSONArray instance = new JSONArray();
        JSONArray expResult = null;
        JSONArray result = instance.put(value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_long() {
        System.out.println("put");
        long value = 0L;
        JSONArray instance = new JSONArray();
        JSONArray expResult = null;
        JSONArray result = instance.put(value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_Map() {
        System.out.println("put");
        Map value = null;
        JSONArray instance = new JSONArray();
        JSONArray expResult = null;
        JSONArray result = instance.put(value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_Object() {
        System.out.println("put");
        Object value = null;
        JSONArray instance = new JSONArray();
        JSONArray expResult = null;
        JSONArray result = instance.put(value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_int_boolean() {
        System.out.println("put");
        int index = 0;
        boolean value = false;
        JSONArray instance = new JSONArray();
        JSONArray expResult = null;
        JSONArray result = instance.put(index, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_int_Collection() {
        System.out.println("put");
        int index = 0;
        Collection value = null;
        JSONArray instance = new JSONArray();
        JSONArray expResult = null;
        JSONArray result = instance.put(index, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_int_double() {
        System.out.println("put");
        int index = 0;
        double value = 0.0;
        JSONArray instance = new JSONArray();
        JSONArray expResult = null;
        JSONArray result = instance.put(index, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_int_int() {
        System.out.println("put");
        int index = 0;
        int value = 0;
        JSONArray instance = new JSONArray();
        JSONArray expResult = null;
        JSONArray result = instance.put(index, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_int_long() {
        System.out.println("put");
        int index = 0;
        long value = 0L;
        JSONArray instance = new JSONArray();
        JSONArray expResult = null;
        JSONArray result = instance.put(index, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_int_Map() {
        System.out.println("put");
        int index = 0;
        Map value = null;
        JSONArray instance = new JSONArray();
        JSONArray expResult = null;
        JSONArray result = instance.put(index, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_int_Object() {
        System.out.println("put");
        int index = 0;
        Object value = null;
        JSONArray instance = new JSONArray();
        JSONArray expResult = null;
        JSONArray result = instance.put(index, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemove() {
        System.out.println("remove");
        int index = 0;
        JSONArray instance = new JSONArray();
        Object expResult = null;
        Object result = instance.remove(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToJSONObject() {
        System.out.println("toJSONObject");
        JSONArray names = null;
        JSONArray instance = new JSONArray();
        JSONObject expResult = null;
        JSONObject result = instance.toJSONObject(names);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString_0args() {
        System.out.println("toString");
        JSONArray instance = new JSONArray();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString_int() {
        System.out.println("toString");
        int indentFactor = 0;
        JSONArray instance = new JSONArray();
        String expResult = "";
        String result = instance.toString(indentFactor);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testWrite_Writer() {
        System.out.println("write");
        Writer writer = null;
        JSONArray instance = new JSONArray();
        Writer expResult = null;
        Writer result = instance.write(writer);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testWrite_3args() {
        System.out.println("write");
        Writer writer = null;
        int indentFactor = 0;
        int indent = 0;
        JSONArray instance = new JSONArray();
        Writer expResult = null;
        Writer result = instance.write(writer, indentFactor, indent);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}