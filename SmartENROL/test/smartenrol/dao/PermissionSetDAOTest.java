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
import smartenrol.model.Permission;
import smartenrol.model.User;

/**
 *
 * @author Haijun
 */
public class PermissionSetDAOTest {
    
    public PermissionSetDAOTest() {
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
     * Test of getCurrentPermissionSet method, of class PermissionSetDAO.
     */
    @Test
    public void testGetCurrentPermissionSet() {
        System.out.println("getCurrentPermissionSet");
        User thisUser = new UserDAO().getUserByID(80013004);
        PermissionSetDAO instance = new PermissionSetDAO();
//        ArrayList expResult = null;
        ArrayList<Permission> result = instance.getCurrentPermissionSet(thisUser);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        for (Permission p: result)
            System.out.println(p.getFunctionname());
    }
}