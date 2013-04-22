/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.entities.course;

import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class WalkingDistanceTest {
    
    public WalkingDistanceTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testReadJsonFromUrl() throws Exception {
        System.out.println("readJsonFromUrl");
        String url = "";
        WalkingDistance instance = new WalkingDistance();
        JSONObject expResult = null;
        JSONObject result = instance.readJsonFromUrl(url);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRun() throws Exception {
        System.out.println("run");
        WalkingDistance instance = new WalkingDistance();
        instance.run();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        WalkingDistance instance = new WalkingDistance();
        String expResult = "";
        String result = instance.getDuration();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        WalkingDistance instance = new WalkingDistance();
        String expResult = "";
        String result = instance.getDistance();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}