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
public class CorequisiteTest {

    public CorequisiteTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testToString() {
        Corequisite instance = new Corequisite();
        instance.setIdDepartmentCoReq("123");
        instance.setIdCourseCoReq(234);
        String expResult = "123 234";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetIdDepartment() {
        Corequisite instance = new Corequisite();
        assertNull(instance.getIdDepartment());
    }

    @Test
    public void testSetIdDepartment() {
        String idDepartment = "sample";
        Corequisite instance = new Corequisite();
        instance.setIdDepartment(idDepartment);
        assertEquals(idDepartment,instance.getIdDepartment());
    }

    @Test
    public void testGetIdCourse() {
        Corequisite instance = new Corequisite();
        assertNotNull(instance.getIdCourse());
    }

    @Test
    public void testSetIdCourse() {
        int idCourse = 0;
        Corequisite instance = new Corequisite();
        instance.setIdCourse(idCourse);
        assertEquals(idCourse, instance.getIdCourse());
    }

    @Test
    public void testGetIdDepartmentCoReq() {
        Corequisite instance = new Corequisite();
        assertNull(instance.getIdDepartmentCoReq());
    }

    @Test
    public void testSetIdDepartmentCoReq() {
        String idDepartmentCoReq = "sample test";
        Corequisite instance = new Corequisite();
        instance.setIdDepartmentCoReq(idDepartmentCoReq);
        assertEquals(idDepartmentCoReq, instance.getIdDepartmentCoReq());
    }

    @Test
    public void testGetIdCourseCoReq() {
        Corequisite instance = new Corequisite();
        assertNotNull(instance.getIdCourseCoReq());
    }

    @Test
    public void testSetIdCourseCoReq() {
        int idCourseCoReq = 0;
        Corequisite instance = new Corequisite();
        instance.setIdCourseCoReq(idCourseCoReq);
        assertEquals(idCourseCoReq, instance.getIdCourseCoReq());
    }
}