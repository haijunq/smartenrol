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
public class XMLTokenerTest {
    
    public XMLTokenerTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testNextCDATA() {
        System.out.println("nextCDATA");
        XMLTokener instance = null;
        String expResult = "";
        String result = instance.nextCDATA();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNextContent() {
        System.out.println("nextContent");
        XMLTokener instance = null;
        Object expResult = null;
        Object result = instance.nextContent();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNextEntity() {
        System.out.println("nextEntity");
        char ampersand = ' ';
        XMLTokener instance = null;
        Object expResult = null;
        Object result = instance.nextEntity(ampersand);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNextMeta() {
        System.out.println("nextMeta");
        XMLTokener instance = null;
        Object expResult = null;
        Object result = instance.nextMeta();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNextToken() {
        System.out.println("nextToken");
        XMLTokener instance = null;
        Object expResult = null;
        Object result = instance.nextToken();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSkipPast() {
        System.out.println("skipPast");
        String to = "";
        XMLTokener instance = null;
        boolean expResult = false;
        boolean result = instance.skipPast(to);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}