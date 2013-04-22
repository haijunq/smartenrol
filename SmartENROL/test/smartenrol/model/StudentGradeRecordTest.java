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
public class StudentGradeRecordTest {

    public StudentGradeRecordTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetStudentName() {
        StudentGradeRecord instance = new StudentGradeRecord();
        assertNotNull(instance.getStudentName());
    }

    @Test
    public void testGetIdStudent() {
        StudentGradeRecord instance = new StudentGradeRecord();
        assertNotNull(instance.getIdStudent());
    }

    @Test
    public void testSetIdStudent() {
        int idStudent = 12345;
        StudentGradeRecord instance = new StudentGradeRecord();
        instance.setIdStudent(idStudent);
        assertEquals(idStudent, instance.getIdStudent());
    }

    @Test
    public void testGetIdProgram() {
        StudentGradeRecord instance = new StudentGradeRecord();
        assertNull(instance.getIdProgram());
    }

    @Test
    public void testSetIdProgram() {
        String idProgram = "sample";
        StudentGradeRecord instance = new StudentGradeRecord();
        instance.setIdProgram(idProgram);
        assertEquals(idProgram, instance.getIdProgram());
    }

    @Test
    public void testGetGivenName() {
        StudentGradeRecord instance = new StudentGradeRecord();
        assertNull(instance.getGivenName());
    }

    @Test
    public void testSetGivenName() {
        String givenName = "sample Name";
        StudentGradeRecord instance = new StudentGradeRecord();
        instance.setGivenName(givenName);
        assertEquals(givenName, instance.getGivenName());
    }

    @Test
    public void testGetSurname() {
        StudentGradeRecord instance = new StudentGradeRecord();
        assertNull(instance.getSurname());
    }

    @Test
    public void testSetSurname() {
        String surname = "sample";
        StudentGradeRecord instance = new StudentGradeRecord();
        instance.setSurname(surname);
        assertEquals(surname, instance.getSurname());
    }

    @Test
    public void testGetGrade() {
        StudentGradeRecord instance = new StudentGradeRecord();
        assertNotNull(instance.getGrade());
    }

    @Test
    public void testSetGrade() {
        int grade = 0;
        StudentGradeRecord instance = new StudentGradeRecord();
        instance.setGrade(grade);
        assertEquals(grade, instance.getGrade());
    }
}