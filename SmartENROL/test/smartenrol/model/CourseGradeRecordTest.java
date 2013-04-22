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
public class CourseGradeRecordTest {

    public CourseGradeRecordTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetCourse() {
        CourseGradeRecord instance = new CourseGradeRecord();
        assertNotNull(instance.getCourse());
    }

    @Test
    public void testGetIdDepartment() {
        CourseGradeRecord instance = new CourseGradeRecord();
        assertNull(instance.getIdDepartment());
    }

    @Test
    public void testSetIdDepartment() {
        String idDepartment = "12344";
        CourseGradeRecord instance = new CourseGradeRecord();
        instance.setIdDepartment(idDepartment);
        assertEquals(idDepartment, instance.getIdDepartment());
    }

    @Test
    public void testGetIdCourse() {
        CourseGradeRecord instance = new CourseGradeRecord();
        assertNotNull(instance.getIdCourse());
    }

    @Test
    public void testSetIdCourse() {
        int idCourse = 0;
        CourseGradeRecord instance = new CourseGradeRecord();
        instance.setIdCourse(idCourse);
        assertEquals(idCourse, instance.getIdCourse());
    }

    @Test
    public void testGetCredits() {
        CourseGradeRecord instance = new CourseGradeRecord();
        assertNotNull(instance.getCredits());
    }

    @Test
    public void testSetCredits() {
        float credits = 0.0F;
        CourseGradeRecord instance = new CourseGradeRecord();
        instance.setCredits(credits);
        assertNotNull(instance.getCredits());
    }

    @Test
    public void testGetCourseName() {
        CourseGradeRecord instance = new CourseGradeRecord();
        assertNull(instance.getCourseName());
    }

    @Test
    public void testSetCourseName() {
        String courseName = "sample Name";
        CourseGradeRecord instance = new CourseGradeRecord();
        instance.setCourseName(courseName);
        assertEquals(courseName, instance.getCourseName());
    }

    @Test
    public void testGetYear() {
        CourseGradeRecord instance = new CourseGradeRecord();
        assertEquals(0,instance.getYear());
    }

    @Test
    public void testSetYear() {
        int year = 0;
        CourseGradeRecord instance = new CourseGradeRecord();
        instance.setYear(year);
        assertEquals(year, instance.getYear());
    }

    @Test
    public void testGetTerm() {
        CourseGradeRecord instance = new CourseGradeRecord();
        assertNull(instance.getTerm());
    }

    @Test
    public void testSetTerm() {
        String term = "sample test";
        CourseGradeRecord instance = new CourseGradeRecord();
        instance.setTerm(term);
        assertEquals(term, instance.getTerm());
    }

    @Test
    public void testGetGrade() {
        CourseGradeRecord instance = new CourseGradeRecord();
        assertNotNull(instance.getGrade());
    }

    @Test
    public void testSetGrade() {
        int grade = 0;
        CourseGradeRecord instance = new CourseGradeRecord();
        instance.setGrade(grade);
        assertEquals(grade, instance.getGrade());
    }
}