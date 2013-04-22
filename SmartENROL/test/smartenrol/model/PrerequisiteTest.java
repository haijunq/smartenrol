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
public class PrerequisiteTest {

    public PrerequisiteTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testToString() {
        Prerequisite instance = new Prerequisite();
        instance.setIdCoursePreReq(123);
        instance.setIdDepartmentPreReq("sample");
        String expResult = "sample 123";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetIdDepartment() {
        Prerequisite instance = new Prerequisite();
        assertNull(instance.getIdDepartment());
    }

    @Test
    public void testSetIdDepartment() {
        String idDepartment = "sample";
        Prerequisite instance = new Prerequisite();
        instance.setIdDepartment(idDepartment);
        assertEquals(idDepartment, instance.getIdDepartment());
    }

    @Test
    public void testGetIdCourse() {
        Prerequisite instance = new Prerequisite();
        assertNotNull(instance.getIdCourse());
    }

    @Test
    public void testGetIdDepartmentPreReq() {
        Prerequisite instance = new Prerequisite();
        assertNull(instance.getIdDepartmentPreReq());
    }

    @Test
    public void testSetIdDepartmentPreReq() {
        String idDepartmentPreReq = "sample";
        Prerequisite instance = new Prerequisite();
        instance.setIdDepartmentPreReq(idDepartmentPreReq);
        assertEquals(idDepartmentPreReq, instance.getIdDepartmentPreReq());
    }

    @Test
    public void testGetIdCoursePreReq() {
        Prerequisite instance = new Prerequisite();
        assertNotNull(instance.getIdCoursePreReq());
    }

    @Test
    public void testSetIdCoursePreReq() {
        int idCoursePreReq = 0;
        Prerequisite instance = new Prerequisite();
        instance.setIdCoursePreReq(idCoursePreReq);
        assertEquals(idCoursePreReq, instance.getIdCoursePreReq());
    }
}