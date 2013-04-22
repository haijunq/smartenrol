/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.timetable;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class TimetableControllerTest {
    
    public TimetableControllerTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testOpenAgenda() {
        System.out.println("openAgenda");
        TimetableController instance = new TimetableController();
        instance.openAgenda();
        fail("The test case is a prototype.");
    }
}