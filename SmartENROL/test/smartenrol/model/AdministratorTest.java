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
public class AdministratorTest {

    public AdministratorTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetIdUser() {
        Administrator instance = new Administrator();
        assertNull(instance.getIdUser());
    }

    @Test
    public void testSetIdUser() {
        Integer idUser = new Integer("23");
        Administrator instance = new Administrator();
        instance.setIdUser(idUser);
        assertEquals(Integer.valueOf("23"), instance.getIdUser());
    }

    @Test
    public void testGetJobTitle() {
        Administrator instance = new Administrator();
        assertNull(instance.getJobTitle());
    }

    @Test
    public void testSetJobTitle() {
        String jobTitle = "TEST";
        Administrator instance = new Administrator();
        instance.setJobTitle(jobTitle);
        assertEquals(jobTitle, instance.getJobTitle());
    }

    @Test
    public void testGetOffice() {
        Administrator instance = new Administrator();
        assertNull(instance.getOffice());
    }

    @Test
    public void testSetOffice() {
        String office = "TEST";
        Administrator instance = new Administrator();
        instance.setOffice(office);
        assertEquals(office, instance.getOffice());
    }

    @Test
    public void testGetStatus() {
        Administrator instance = new Administrator();
        assertNull(instance.getStatus());
    }

    @Test
    public void testSetStatus() {
        String status = "TEST";
        Administrator instance = new Administrator();
        instance.setStatus(status);
        assertEquals(status, instance.getStatus());
    }

    @Test
    public void testGetIdSupervisor() {
        Administrator instance = new Administrator();
        assertNull(instance.getIdSupervisor());
    }

    @Test
    public void testSetIdSupervisor() {
        String idSupervisor = "TEST";
        Administrator instance = new Administrator();
        instance.setIdSupervisor(idSupervisor);
        assertEquals(idSupervisor, instance.getIdSupervisor());
    }

    @Test
    public void testGetType() {
        Administrator instance = new Administrator();
        assertNull(instance.getType());
    }

    @Test
    public void testSetType() {
        String type = "TEST";
        Administrator instance = new Administrator();
        instance.setType(type);
        assertEquals(type, instance.getType());
    }

    @Test
    public void testGetIdDepartment() {
        Administrator instance = new Administrator();
        assertNull(instance.getIdDepartment());
    }

    @Test
    public void testSetIdDepartment() {
        Department department = new Department();
        department.setIdDepartment("123454");
        Administrator instance = new Administrator();
        instance.setIdDepartment(department);
        assertEquals("123454", instance.getIdDepartment().getIdDepartment());
    }

    @Test
    public void testGetIdFaculty() {
        Administrator instance = new Administrator();
        assertNull(instance.getIdFaculty());
    }

    @Test
    public void testSetIdFaculty() {
        Faculty faculty = new Faculty();
        faculty.setIdFaculty("123454");
        Administrator instance = new Administrator();
        instance.setIdFaculty(faculty);
        assertEquals("123454", instance.getIdFaculty().getIdFaculty());
    }

    @Test
    public void testGetUser() {
        Administrator instance = new Administrator();
        assertNull(instance.getUser());
    }

    @Test
    public void testSetUser() {
        User user = new User();
        Administrator instance = new Administrator();
        instance.setUser(user);
    }

    @Test
    public void testHashCode() {
        Administrator instance = new Administrator();
        assertNotNull(instance.hashCode());
    }

    @Test
    public void testToString() {
        Administrator instance = new Administrator();
        instance.setIdUser(Integer.SIZE);
        String expResult = "smartenrol.model.Administrator[ idUser=32 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}