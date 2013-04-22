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
 * @author Administrator
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
     * Test of searchUserbyKeyword method, of class UserDAO.
     */
    @Test
    public void testSearchUserbyKeyword() {
        System.out.println("searchUserbyKeyword");
        String[] keyword = {"chang","",""};
        String type = "any";
        UserDAO instance = new UserDAO();
       // ArrayList expResult = null;
        ArrayList result = instance.searchUserbyKeyword(keyword, type);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println(result.size());
        for (int i=0; i<result.size();i++)
        {
             System.out.println(result.get(i));
        }
           
    }
}