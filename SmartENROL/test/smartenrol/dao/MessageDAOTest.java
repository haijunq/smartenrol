/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import smartenrol.model.Message;

/**
 *
 * @author Swordghost
 */
public class MessageDAOTest {
    
    public MessageDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMessageByRecepient method, of class MessageDAO.
     */
    @Test
    public void testGetMessageByRecepient() {
        System.out.println("getMessageByRecepient");
        int recepientID = 77777777;
        MessageDAO instance = new MessageDAO();
        //ArrayList expResult = null;
        ArrayList result = instance.getMessageByRecepient(recepientID);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println(result); 
        
    }

    /**
     * Test of getMessageBySender method, of class MessageDAO.
     */
    @Test
    public void testGetMessageBySender() {
        System.out.println("getMessageBySender");
        int senderID = 77777777;
        MessageDAO instance = new MessageDAO();
        //ArrayList expResult = null;
        ArrayList result = instance.getMessageBySender(senderID);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println(result);
    }
}