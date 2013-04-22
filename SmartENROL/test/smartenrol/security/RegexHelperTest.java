/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.security;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jeremy
 */
public class RegexHelperTest {
    
    public RegexHelperTest() {
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
     * Test of validate method, of class RegexHelper.
     */
    @Test
    public void testValidate() {
        String input = "12";
        System.out.println("validate "+input);
        RegexHelper.RegExPattern regEx = RegexHelper.RegExPattern.INT;
        Boolean expResult = true;
        Boolean result = RegexHelper.validate(input, regEx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The value you recieved was: "+result);
    }
}
