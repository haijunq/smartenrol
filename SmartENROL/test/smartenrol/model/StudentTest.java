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
public class StudentTest {

    public StudentTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetIdUser() {
        Student instance = new Student();
        assertNull(instance.getIdUser());

    }

    @Test
    public void testSetIdUser() {
        Integer idUser = 12;
        Student instance = new Student();
        instance.setIdUser(idUser);
        assertEquals(idUser, instance.getIdUser());
    }

    @Test
    public void testGetStatus() {
        Student instance = new Student();
        assertNull(instance.getStatus());
    }

    @Test
    public void testSetStatus() {
        String status = "sample";
        Student instance = new Student();
        instance.setStatus(status);
        assertEquals(status, instance.getStatus());
    }

    @Test
    public void testGetDateStarted() {
        Student instance = new Student();
        assertNull(instance.getDateStarted());
    }

    @Test
    public void testGetType() {
        Student instance = new Student();
        assertNull(instance.getType());
    }

    @Test
    public void testGetProgram() {
        Student instance = new Student();
        assertNull(instance.getProgramName());
    }

    @Test
    public void testHashCode() {
        Student instance = new Student();
        assertNotNull(instance.hashCode());
    }

    @Test
    public void testToString() {
        Student instance = new Student();
        instance.setIdStudent(12);
        String expResult = "smartenrol.model.User[ idUser=12 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}