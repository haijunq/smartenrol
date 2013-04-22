/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class ProgramTest {

    public ProgramTest() {
    }

    @Test
    public void testGetIdProgram() {
        Program instance = new Program();
        assertNull(instance.getIdProgram());
    }

    @Test
    public void testSetIdProgram() {
        String idProgram = "12345";
        Program instance = new Program();
        instance.setIdProgram(idProgram);
        assertEquals(idProgram, instance.getIdProgram());
    }

    @Test
    public void testGetProgramName() {
        Program instance = new Program();
        assertNull(instance.getProgramName());
    }

    @Test
    public void testSetProgramName() {
        String programName = "sample test";
        Program instance = new Program();
        instance.setProgramName(programName);
        assertEquals(programName, instance.getProgramName());
    }

    @Test
    public void testGetProgramDescription() {
        Program instance = new Program();
        assertNull(instance.getProgramDescription());
    }

    @Test
    public void testSetProgramDescription() {
        String programDescription = "sample Description";
        Program instance = new Program();
        instance.setProgramDescription(programDescription);
        assertEquals(programDescription, instance.getProgramDescription());
    }

    @Test
    public void testGetStudentCollection() {
        Program instance = new Program();
        assertNull(instance.getStudentCollection());
    }

    @Test
    public void testSetStudentCollection() {
        Collection<Student> studentCollection = new ArrayList<>();
        Program instance = new Program();
        instance.setStudentCollection(studentCollection);
        assertNotNull(instance.getStudentCollection());
    }

    @Test
    public void testGetIdDepartment() {
        Program instance = new Program();
        assertNull(instance.getIdDepartment());
    }

    @Test
    public void testSetIdDepartment() {
        Department idDepartment = new Department();
        Program instance = new Program();
        instance.setIdDepartment(idDepartment.getIdDepartment());
        assertNull(instance.getIdDepartment());
    }

    @Test
    public void testHashCode() {
        Program instance = new Program();
        assertNotNull(instance.hashCode());
    }

    @Test
    public void testToString() {
        Program instance = new Program();
        instance.setIdProgram("12");
        String expResult = "smartenrol.model.Program[ idProgram=12 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}