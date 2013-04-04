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
import smartenrol.model.User;

/**
 *
 * @author Haijun
 */
public class UserDAOTest {
    
    public UserDAOTest() {
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
     * Test of getUserByID method, of class UserDAO.
     */
    @Test
    public void testGetUserByID() {
        System.out.println("getUserByID");
        int idUser = 80011001;
        UserDAO instance = new UserDAO();
//        User expResult = null;
        User result = instance.getUserByID(idUser);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        System.out.println(result);
    }

    /**
     * Test of getUserBySurname method, of class UserDAO.
     */
    @Test
    public void testGetUserBySurname() {
        System.out.println("getUserBySurname");
        String surname = "chang";
        UserDAO instance = new UserDAO();
//        ArrayList expResult = null;
        ArrayList result = instance.getUserBySurname(surname);
        System.out.println(result);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserInfo method, of class UserDAO.
     */
    @Test
    public void testGetUserInfo() {
        System.out.println("getUserInfo");
        String userName = "haijunq";
        String password = "haijun123";
        UserDAO instance = new UserDAO();
//        User expResult = null;
        User result = instance.getUserInfo(userName, password);
        System.out.println(result);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}