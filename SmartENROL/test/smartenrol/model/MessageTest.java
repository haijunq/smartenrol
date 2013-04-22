/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import org.joda.time.LocalDate;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class MessageTest {
    
    public MessageTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        Message instance = new Message();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Message instance = new Message();
        instance.setId(id);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetRecepeintID() {
        System.out.println("getRecepeintID");
        Message instance = new Message();
        int expResult = 0;
        int result = instance.getRecepeintID();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetRecepeintID() {
        System.out.println("setRecepeintID");
        int recepeintID = 0;
        Message instance = new Message();
        instance.setRecepeintID(recepeintID);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetSenderID() {
        System.out.println("getSenderID");
        Message instance = new Message();
        int expResult = 0;
        int result = instance.getSenderID();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetSenderID() {
        System.out.println("setSenderID");
        int senderID = 0;
        Message instance = new Message();
        instance.setSenderID(senderID);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetType() {
        System.out.println("getType");
        Message instance = new Message();
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "";
        Message instance = new Message();
        instance.setType(type);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        Message instance = new Message();
        String expResult = "";
        String result = instance.getMessage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String message = "";
        Message instance = new Message();
        instance.setMessage(message);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Message instance = new Message();
        instance.getDate();
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetDate() {
        System.out.println("setDate");
        LocalDate date = null;
        Message instance = new Message();
        instance.setDate(date);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Message instance = new Message();
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        Message instance = new Message();
        instance.setStatus(status);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Message instance = new Message();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}