/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.Connection;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class MySQLConnectionTest {
    
    public MySQLConnectionTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        MySQLConnection expResult = null;
        MySQLConnection result = MySQLConnection.getInstance();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testConnect() {
        System.out.println("connect");
        MySQLConnection instance = new MySQLConnection();
        boolean expResult = false;
        Connection result = instance.getConnection();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        MySQLConnection instance = new MySQLConnection();
        Connection expResult = null;
        Connection result = instance.getConnection();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsDriverLoaded() {
        System.out.println("isDriverLoaded");
        MySQLConnection instance = new MySQLConnection();
        boolean expResult = false;
        fail("The test case is a prototype.");
    }

    @Test
    public void testFinalize() throws Exception {
        System.out.println("finalize");
        MySQLConnection instance = new MySQLConnection();
        fail("The test case is a prototype.");
    }
}