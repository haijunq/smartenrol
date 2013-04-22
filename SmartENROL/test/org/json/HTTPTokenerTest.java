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
public class HTTPTokenerTest {
    
    public HTTPTokenerTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testNextToken() {
        System.out.println("nextToken");
        HTTPTokener instance = null;
        String expResult = "";
        String result = instance.nextToken();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}