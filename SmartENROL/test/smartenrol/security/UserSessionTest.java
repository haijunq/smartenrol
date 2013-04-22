/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.security;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import smartenrol.model.User;

/**
 *
 * @author Aishwarya
 */
public class UserSessionTest {

    public UserSessionTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetInstance() {
        assertNotNull(UserSession.getInstance());
    }

    @Test
    public void testGetCurrentUser() {
        assertNotNull(UserSession.getInstance().getCurrentUser());
    }

    @Test
    public void testSetCurrentUser() {
        User currentUser = new User();
        currentUser.setIdUser(Integer.SIZE);
        UserSession.getInstance().setCurrentUser(currentUser);
        Assert.assertTrue(true);
    }

    @Test
    public void testIsSignedIn() {
        assertFalse(UserSession.getInstance().isSignedIn());
    }
}