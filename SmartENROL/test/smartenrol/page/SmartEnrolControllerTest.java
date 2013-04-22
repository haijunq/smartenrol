/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page;

import javafx.scene.Node;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import smartenrol.security.UserSession;

/**
 *
 * @author Aishwarya
 */
public class SmartEnrolControllerTest {
    
    public SmartEnrolControllerTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetView() {
        System.out.println("getView");
        SmartEnrolController instance = new SmartEnrolControllerImpl();
        Node expResult = null;
        Node result = instance.getView();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetInternalView() {
        System.out.println("getInternalView");
        SmartEnrolController instance = new SmartEnrolControllerImpl();
        Node expResult = null;
        Node result = instance.getInternalView();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInit() {
        System.out.println("init");
        SmartEnrolController instance = new SmartEnrolControllerImpl();
        instance.init();
        fail("The test case is a prototype.");
    }

    @Test
    public void testLoad() {
        System.out.println("load");
        SmartEnrolController instance = new SmartEnrolControllerImpl();
        instance.load();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetUserSession() {
        System.out.println("getUserSession");
        SmartEnrolController instance = new SmartEnrolControllerImpl();
        UserSession expResult = null;
        UserSession result = instance.getUserSession();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetView() {
        System.out.println("setView");
        Node view = null;
        SmartEnrolController instance = new SmartEnrolControllerImpl();
        instance.setView(view);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetSidebarEnabled() {
        System.out.println("getSidebarEnabled");
        SmartEnrolController instance = new SmartEnrolControllerImpl();
        boolean expResult = false;
        boolean result = instance.getSidebarEnabled();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetSidebarEnabled() {
        System.out.println("setSidebarEnabled");
        boolean sidebarEnabled = false;
        SmartEnrolController instance = new SmartEnrolControllerImpl();
        instance.setSidebarEnabled(sidebarEnabled);
        fail("The test case is a prototype.");
    }

    public class SmartEnrolControllerImpl extends SmartEnrolController {
    }
}