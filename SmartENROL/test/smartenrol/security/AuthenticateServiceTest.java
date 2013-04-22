/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.security;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author Aishwarya
 */
public class AuthenticateServiceTest {

    private AuthenticateService authenticateService;

    public AuthenticateServiceTest() {
    }

    @Before
    public void setUp() {
        authenticateService = new AuthenticateService();
    }

    /**
     * Test of authenticate method, of class AuthenticateService.
     */
    @Test
    public void authenticateWithNull() {
        try {
            authenticateService.authenticate(null, null);
            Assert.fail();
        } catch (InvalidAuthenticationException e) {
            Assert.assertEquals("Invalid Credentials. Please try again.", e.getMessage());
        }
    }

    @Test
    public void authenticateWithNullandEmpty() {
        try {
            authenticateService.authenticate(null, "");
            Assert.fail();
        } catch (InvalidAuthenticationException e) {
            Assert.assertEquals("Invalid Credentials. Please try again.", e.getMessage());
        }
    }

    @Test
    public void authenticateWithNullandEmpty1() {
        try {
            authenticateService.authenticate("", null);
            Assert.fail();
        } catch (InvalidAuthenticationException e) {
            Assert.assertEquals("Invalid Credentials. Please try again.", e.getMessage());
        }
    }

    @Test
    public void authenticateWithEmpty() {
        try {
            authenticateService.authenticate("", "");
            Assert.fail();
        } catch (InvalidAuthenticationException e) {
            Assert.assertEquals("Invalid Credentials. Please try again.", e.getMessage());
        }
    }

    @Test
    public void authenticateWithSpace() {
        try {
            authenticateService.authenticate("   ", "   ");
            Assert.fail();
        } catch (InvalidAuthenticationException e) {
            Assert.assertEquals("Invalid Credentials. Please try again.", e.getMessage());
        }
    }

    @Test
    public void authenticateWithSpecialCharacters() {
        try {
            authenticateService.authenticate("~!@#$%^&*()+", "TEST");
            Assert.fail();
        } catch (InvalidAuthenticationException e) {
            Assert.assertEquals("Invalid Credentials. Please try again.", e.getMessage());
        }
    }

    @Test
    public void authenticateWithSpecialCharacters1() {
        try {
            authenticateService.authenticate("TEST", "~!@#$%^&*()+");
            Assert.fail();
        } catch (InvalidAuthenticationException e) {
            Assert.assertEquals("Invalid Credentials. Please try again.", e.getMessage());
        }
    }

    @Test
    public void authenticateWithSpecialCharacters2() {
        try {
            authenticateService.authenticate("~!@#$%^&*()+", "~!@#$%^&*()+");
            Assert.fail();
        } catch (InvalidAuthenticationException e) {
            Assert.assertEquals("Invalid Credentials. Please try again.", e.getMessage());
        }
    }
    
    @Test
    public void authenticateWithNumbers() {
        try {
            authenticateService.authenticate("1234567890", "1234567890");
            Assert.fail();
        } catch (InvalidAuthenticationException e) {
            Assert.assertEquals("Invalid Credentials. Please try again.", e.getMessage());
        }
    }
    
    @Test
    public void authenticate() {
        try {
            authenticateService.authenticate("ADMIN", "ADMIN");
            Assert.fail();
        } catch (InvalidAuthenticationException e) {
            Assert.assertEquals("Invalid Credentials. Please try again.", e.getMessage());
        }
    }
}