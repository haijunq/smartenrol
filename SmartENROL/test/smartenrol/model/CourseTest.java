/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class CourseTest {

    public CourseTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testToString() {
        Course instance = new Course();
        instance.setIdCourse(123);
        instance.setIdDepartment("123");
        String expResult = "123 123";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetIdDepartment() {
        Course instance = new Course();
        assertNull(instance.getIdDepartment());
    }

    @Test
    public void testSetIdDepartment() {
        System.out.println("setIdDepartment");
        String idDepartment = "sample Department";
        Course instance = new Course();
        instance.setIdDepartment(idDepartment);
        assertEquals(idDepartment, instance.getIdDepartment());
    }

    @Test
    public void testGetIdCourse() {
        Course instance = new Course();
        assertNotNull(instance.getIdCourse());
    }

    @Test
    public void testSetIdCourse() {
        int idCourse = 0;
        Course instance = new Course();
        instance.setIdCourse(idCourse);
        assertEquals(idCourse, instance.getIdCourse());
    }

    @Test
    public void testGetCredits() {
        Course instance = new Course();
        assertNotNull(instance.getCredits());
    }

    @Test
    public void testSetCredits() {
        System.out.println("setCredits");
        float credits = 0.0F;
        Course instance = new Course();
        instance.setCredits(credits);
        assertNotNull(instance.getCredits());
    }

    @Test
    public void testGetCourseName() {
        Course instance = new Course();
        assertNull(instance.getCourseName());
    }

    @Test
    public void testSetCourseName() {
        String courseName = "sample Course Name";
        Course instance = new Course();
        instance.setCourseName(courseName);
        assertEquals(courseName, instance.getCourseName());
    }

    @Test
    public void testGetCourseDescription() {
        Course instance = new Course();
        assertNull(instance.getCourseDescription());
    }

    @Test
    public void testSetCourseDescription() {
        String courseDescription = "sample test";
        Course instance = new Course();
        instance.setCourseDescription(courseDescription);
        assertEquals(courseDescription, instance.getCourseDescription());
    }

    @Test
    public void testIsRestricted() {
        Course instance = new Course();
        assertFalse(instance.isRestricted());
    }

    @Test
    public void testSetIsRestricted() {
        boolean isRestricted = true;
        Course instance = new Course();
        instance.setIsRestricted(isRestricted);
        assertTrue(instance.isRestricted());
    }
}