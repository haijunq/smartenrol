/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.json;

import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class JSONObjectTest {
    
    public JSONObjectTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testAccumulate() {
        System.out.println("accumulate");
        String key = "";
        Object value = null;
        JSONObject instance = new JSONObject();
        JSONObject expResult = null;
        JSONObject result = instance.accumulate(key, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAppend() {
        System.out.println("append");
        String key = "";
        Object value = null;
        JSONObject instance = new JSONObject();
        JSONObject expResult = null;
        JSONObject result = instance.append(key, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDoubleToString() {
        System.out.println("doubleToString");
        double d = 0.0;
        String expResult = "";
        String result = JSONObject.doubleToString(d);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGet() {
        System.out.println("get");
        String key = "";
        JSONObject instance = new JSONObject();
        Object expResult = null;
        Object result = instance.get(key);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetBoolean() {
        System.out.println("getBoolean");
        String key = "";
        JSONObject instance = new JSONObject();
        boolean expResult = false;
        boolean result = instance.getBoolean(key);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDouble() {
        System.out.println("getDouble");
        String key = "";
        JSONObject instance = new JSONObject();
        double expResult = 0.0;
        double result = instance.getDouble(key);
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetInt() {
        System.out.println("getInt");
        String key = "";
        JSONObject instance = new JSONObject();
        int expResult = 0;
        int result = instance.getInt(key);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetJSONArray() {
        System.out.println("getJSONArray");
        String key = "";
        JSONObject instance = new JSONObject();
        JSONArray expResult = null;
        JSONArray result = instance.getJSONArray(key);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetJSONObject() {
        System.out.println("getJSONObject");
        String key = "";
        JSONObject instance = new JSONObject();
        JSONObject expResult = null;
        JSONObject result = instance.getJSONObject(key);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetLong() {
        System.out.println("getLong");
        String key = "";
        JSONObject instance = new JSONObject();
        long expResult = 0L;
        long result = instance.getLong(key);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetNames_JSONObject() {
        System.out.println("getNames");
        JSONObject jo = null;
        String[] expResult = null;
        String[] result = JSONObject.getNames(jo);
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetNames_Object() {
        System.out.println("getNames");
        Object object = null;
        String[] expResult = null;
        String[] result = JSONObject.getNames(object);
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetString() {
        System.out.println("getString");
        String key = "";
        JSONObject instance = new JSONObject();
        String expResult = "";
        String result = instance.getString(key);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testHas() {
        System.out.println("has");
        String key = "";
        JSONObject instance = new JSONObject();
        boolean expResult = false;
        boolean result = instance.has(key);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIncrement() {
        System.out.println("increment");
        String key = "";
        JSONObject instance = new JSONObject();
        JSONObject expResult = null;
        JSONObject result = instance.increment(key);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsNull() {
        System.out.println("isNull");
        String key = "";
        JSONObject instance = new JSONObject();
        boolean expResult = false;
        boolean result = instance.isNull(key);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testKeys() {
        System.out.println("keys");
        JSONObject instance = new JSONObject();
        Iterator expResult = null;
        Iterator result = instance.keys();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testKeySet() {
        System.out.println("keySet");
        JSONObject instance = new JSONObject();
        Set expResult = null;
        Set result = instance.keySet();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testLength() {
        System.out.println("length");
        JSONObject instance = new JSONObject();
        int expResult = 0;
        int result = instance.length();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNames() {
        System.out.println("names");
        JSONObject instance = new JSONObject();
        JSONArray expResult = null;
        JSONArray result = instance.names();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNumberToString() {
        System.out.println("numberToString");
        Number number = null;
        String expResult = "";
        String result = JSONObject.numberToString(number);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOpt() {
        System.out.println("opt");
        String key = "";
        JSONObject instance = new JSONObject();
        Object expResult = null;
        Object result = instance.opt(key);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptBoolean_String() {
        System.out.println("optBoolean");
        String key = "";
        JSONObject instance = new JSONObject();
        boolean expResult = false;
        boolean result = instance.optBoolean(key);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptBoolean_String_boolean() {
        System.out.println("optBoolean");
        String key = "";
        boolean defaultValue = false;
        JSONObject instance = new JSONObject();
        boolean expResult = false;
        boolean result = instance.optBoolean(key, defaultValue);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptDouble_String() {
        System.out.println("optDouble");
        String key = "";
        JSONObject instance = new JSONObject();
        double expResult = 0.0;
        double result = instance.optDouble(key);
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptDouble_String_double() {
        System.out.println("optDouble");
        String key = "";
        double defaultValue = 0.0;
        JSONObject instance = new JSONObject();
        double expResult = 0.0;
        double result = instance.optDouble(key, defaultValue);
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptInt_String() {
        System.out.println("optInt");
        String key = "";
        JSONObject instance = new JSONObject();
        int expResult = 0;
        int result = instance.optInt(key);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptInt_String_int() {
        System.out.println("optInt");
        String key = "";
        int defaultValue = 0;
        JSONObject instance = new JSONObject();
        int expResult = 0;
        int result = instance.optInt(key, defaultValue);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptJSONArray() {
        System.out.println("optJSONArray");
        String key = "";
        JSONObject instance = new JSONObject();
        JSONArray expResult = null;
        JSONArray result = instance.optJSONArray(key);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptJSONObject() {
        System.out.println("optJSONObject");
        String key = "";
        JSONObject instance = new JSONObject();
        JSONObject expResult = null;
        JSONObject result = instance.optJSONObject(key);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptLong_String() {
        System.out.println("optLong");
        String key = "";
        JSONObject instance = new JSONObject();
        long expResult = 0L;
        long result = instance.optLong(key);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptLong_String_long() {
        System.out.println("optLong");
        String key = "";
        long defaultValue = 0L;
        JSONObject instance = new JSONObject();
        long expResult = 0L;
        long result = instance.optLong(key, defaultValue);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptString_String() {
        System.out.println("optString");
        String key = "";
        JSONObject instance = new JSONObject();
        String expResult = "";
        String result = instance.optString(key);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOptString_String_String() {
        System.out.println("optString");
        String key = "";
        String defaultValue = "";
        JSONObject instance = new JSONObject();
        String expResult = "";
        String result = instance.optString(key, defaultValue);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_String_boolean() {
        System.out.println("put");
        String key = "";
        boolean value = false;
        JSONObject instance = new JSONObject();
        JSONObject expResult = null;
        JSONObject result = instance.put(key, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_String_Collection() {
        System.out.println("put");
        String key = "";
        Collection value = null;
        JSONObject instance = new JSONObject();
        JSONObject expResult = null;
        JSONObject result = instance.put(key, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_String_double() {
        System.out.println("put");
        String key = "";
        double value = 0.0;
        JSONObject instance = new JSONObject();
        JSONObject expResult = null;
        JSONObject result = instance.put(key, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_String_int() {
        System.out.println("put");
        String key = "";
        int value = 0;
        JSONObject instance = new JSONObject();
        JSONObject expResult = null;
        JSONObject result = instance.put(key, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_String_long() {
        System.out.println("put");
        String key = "";
        long value = 0L;
        JSONObject instance = new JSONObject();
        JSONObject expResult = null;
        JSONObject result = instance.put(key, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_String_Map() {
        System.out.println("put");
        String key = "";
        Map value = null;
        JSONObject instance = new JSONObject();
        JSONObject expResult = null;
        JSONObject result = instance.put(key, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut_String_Object() {
        System.out.println("put");
        String key = "";
        Object value = null;
        JSONObject instance = new JSONObject();
        JSONObject expResult = null;
        JSONObject result = instance.put(key, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPutOnce() {
        System.out.println("putOnce");
        String key = "";
        Object value = null;
        JSONObject instance = new JSONObject();
        JSONObject expResult = null;
        JSONObject result = instance.putOnce(key, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPutOpt() {
        System.out.println("putOpt");
        String key = "";
        Object value = null;
        JSONObject instance = new JSONObject();
        JSONObject expResult = null;
        JSONObject result = instance.putOpt(key, value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testQuote_String() {
        System.out.println("quote");
        String string = "";
        String expResult = "";
        String result = JSONObject.quote(string);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testQuote_String_Writer() throws Exception {
        System.out.println("quote");
        String string = "";
        Writer w = null;
        Writer expResult = null;
        Writer result = JSONObject.quote(string, w);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemove() {
        System.out.println("remove");
        String key = "";
        JSONObject instance = new JSONObject();
        Object expResult = null;
        Object result = instance.remove(key);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testStringToValue() {
        System.out.println("stringToValue");
        String string = "";
        Object expResult = null;
        Object result = JSONObject.stringToValue(string);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testTestValidity() {
        System.out.println("testValidity");
        Object o = null;
        JSONObject.testValidity(o);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToJSONArray() {
        System.out.println("toJSONArray");
        JSONArray names = null;
        JSONObject instance = new JSONObject();
        JSONArray expResult = null;
        JSONArray result = instance.toJSONArray(names);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString_0args() {
        System.out.println("toString");
        JSONObject instance = new JSONObject();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString_int() {
        System.out.println("toString");
        int indentFactor = 0;
        JSONObject instance = new JSONObject();
        String expResult = "";
        String result = instance.toString(indentFactor);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValueToString() {
        System.out.println("valueToString");
        Object value = null;
        String expResult = "";
        String result = JSONObject.valueToString(value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testWrap() {
        System.out.println("wrap");
        Object object = null;
        Object expResult = null;
        Object result = JSONObject.wrap(object);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testWrite_Writer() {
        System.out.println("write");
        Writer writer = null;
        JSONObject instance = new JSONObject();
        Writer expResult = null;
        Writer result = instance.write(writer);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testWriteValue() throws Exception {
        System.out.println("writeValue");
        Writer writer = null;
        Object value = null;
        int indentFactor = 0;
        int indent = 0;
        Writer expResult = null;
        Writer result = JSONObject.writeValue(writer, value, indentFactor, indent);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIndent() throws Exception {
        System.out.println("indent");
        Writer writer = null;
        int indent = 0;
        JSONObject.indent(writer, indent);
        fail("The test case is a prototype.");
    }

    @Test
    public void testWrite_3args() {
        System.out.println("write");
        Writer writer = null;
        int indentFactor = 0;
        int indent = 0;
        JSONObject instance = new JSONObject();
        Writer expResult = null;
        Writer result = instance.write(writer, indentFactor, indent);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}