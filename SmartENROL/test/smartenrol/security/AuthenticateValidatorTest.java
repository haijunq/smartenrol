package smartenrol.security;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AuthenticateValidatorTest {

    AuthenticateValidator authenticateValidator;

    @Before
    public void setUp() {
        authenticateValidator = new AuthenticateValidator();
    }

    @Test
    public void validateUserNameWithNull() {
        try {
            authenticateValidator.validateUserName(null);
            Assert.fail();
        } catch (InvalidAuthenticationException e) {
            Assert.assertEquals("Invalid Credentials. Please try again.", e.getMessage());
        }
    }

    @Test
    public void validateUserNameWithEmpty() {
        try {
            authenticateValidator.validateUserName("");
            Assert.fail();
        } catch (InvalidAuthenticationException e) {
            Assert.assertEquals("Invalid Credentials. Please try again.", e.getMessage());
        }
    }

    @Test
    public void validateUserNameSuccess() {
        try {
            authenticateValidator.validateUserName("Test");
            Assert.assertTrue(Boolean.TRUE);
        } catch (InvalidAuthenticationException e) {
            Assert.fail();
        }
    }

    @Test
    public void validatePasswordWithNull() {
        try {
            authenticateValidator.validatePassword(null);
            Assert.fail();
        } catch (InvalidAuthenticationException e) {
            Assert.assertEquals("Invalid Credentials. Please try again.", e.getMessage());
        }
    }

    @Test
    public void validatePasswordWithEmpty() {
        try {
            authenticateValidator.validatePassword("");
            Assert.fail();
        } catch (InvalidAuthenticationException e) {
            Assert.assertEquals("Invalid Credentials. Please try again.", e.getMessage());
        }
    }

    @Test
    public void validatePasswordSuccess() {
        try {
            authenticateValidator.validateUserName("TestPwd");
            Assert.assertTrue(Boolean.TRUE);
        } catch (InvalidAuthenticationException e) {
            Assert.fail();
        }
    }
}
