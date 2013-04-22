/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import org.joda.time.LocalTime;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class CourseSectionNodeTest {
    
    public CourseSectionNodeTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetDayOfWeek() {
        System.out.println("getDayOfWeek");
        CourseSectionNode instance = null;
        String expResult = "";
        String result = instance.getDayOfWeek();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDay() {
        System.out.println("getDay");
        CourseSectionNode instance = null;
        int expResult = 0;
        int result = instance.getDay();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetDay() {
        System.out.println("setDay");
        int day = 0;
        CourseSectionNode instance = null;
        instance.setDay(day);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetStartTime() {
        System.out.println("getStartTime");
        CourseSectionNode instance = null;
        instance.getStartTime();
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetStartTime() {
        System.out.println("setStartTime");
        LocalTime startTime = null;
        CourseSectionNode instance = null;
        instance.setStartTime(startTime);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");
        CourseSectionNode instance = null;
        instance.getEndTime();
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        LocalTime endTime = null;
        CourseSectionNode instance = null;
        instance.setEndTime(endTime);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetIdLocation() {
        System.out.println("getIdLocation");
        CourseSectionNode instance = null;
        String expResult = "";
        String result = instance.getIdLocation();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetIdLocation() {
        System.out.println("setIdLocation");
        String idLocation = "";
        CourseSectionNode instance = null;
        instance.setIdLocation(idLocation);
        fail("The test case is a prototype.");
    }
}