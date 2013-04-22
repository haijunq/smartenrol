/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class StudentSectionTest {

    @Test
    public void testGetGrade() {
        StudentSection instance = new StudentSection();
        assertNull(instance.getGrade());
    }

    @Test
    public void testSetGrade() {
        Integer grade = 2;
        StudentSection instance = new StudentSection();
        instance.setGrade(grade);
        assertEquals(grade, instance.getGrade());
    }

    @Test
    public void testGetIdStudent() {
        StudentSection instance = new StudentSection();
        assertNotNull(instance.getIdStudent());
    }

    @Test
    public void testSetIdStudent() {
        int idStudent = 0;
        StudentSection instance = new StudentSection();
        instance.setIdStudent(idStudent);
        assertEquals(idStudent, instance.getIdStudent());
    }

    @Test
    public void testGetIdDepartment() {
        StudentSection instance = new StudentSection();
        assertNull(instance.getIdDepartment());
    }

    @Test
    public void testSetIdDepartment() {
        String idDepartment = "1244";
        StudentSection instance = new StudentSection();
        instance.setIdDepartment(idDepartment);
        assertEquals(idDepartment, instance.getIdDepartment());
    }

    @Test
    public void testGetIdCourse() {
        StudentSection instance = new StudentSection();
        assertNotNull(instance.getIdCourse());
    }

    @Test
    public void testSetIdCourse() {
        int idCourse = 0;
        StudentSection instance = new StudentSection();
        instance.setIdCourse(idCourse);
        assertEquals(idCourse, instance.getIdCourse());
    }

    @Test
    public void testGetIdSection() {
        StudentSection instance = new StudentSection();
        assertNull(instance.getIdSection());
    }

    @Test
    public void testSetIdSection() {
        String idSection = "1234566";
        StudentSection instance = new StudentSection();
        instance.setIdSection(idSection);
        assertEquals(idSection, instance.getIdSection());
    }

    @Test
    public void testGetYear() {
        StudentSection instance = new StudentSection();
        assertNotNull(instance.getYear());
    }

    @Test
    public void testSetYear() {
        int year = 0;
        StudentSection instance = new StudentSection();
        instance.setYear(year);
        assertEquals(year, instance.getYear());
    }

    @Test
    public void testGetTerm() {
        StudentSection instance = new StudentSection();
        assertNull(instance.getTerm());
    }

    @Test
    public void testSetTerm() {
        String term = "23";
        StudentSection instance = new StudentSection();
        instance.setTerm(term);
        assertEquals(term, instance.getTerm());
    }
}