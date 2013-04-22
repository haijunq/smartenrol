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
public class InstructorTest {
    
    @Test
    public void testGetIdUser() {
        Instructor instance = new Instructor();
        assertNull(instance.getIdUser());
    }

    @Test
    public void testSetIdUser() {
        Integer idUser = 12;
        Instructor instance = new Instructor();
        instance.setIdUser(idUser);
        assertEquals(idUser, instance.getIdUser());
    }

    @Test
    public void testGetJobTitle() {
        Instructor instance = new Instructor();
        assertNull(instance.getJobTitle());
    }

    @Test
    public void testSetJobTitle() {
        String jobTitle = "sample job";
        Instructor instance = new Instructor();
        instance.setJobTitle(jobTitle);
        assertEquals(jobTitle, instance.getJobTitle());
    }

    @Test
    public void testGetBackground() {
        Instructor instance = new Instructor();
        assertNull(instance.getBackground());
    }

    @Test
    public void testSetBackground() {
        String background = "black";
        Instructor instance = new Instructor();
        instance.setBackground(background);
        assertEquals(background, instance.getBackground());
    }

    @Test
    public void testGetStatus() {
        Instructor instance = new Instructor();
        assertNull(instance.getStatus());
    }

    @Test
    public void testSetStatus() {
        String status = "pass";
        Instructor instance = new Instructor();
        instance.setStatus(status);
        assertEquals(status, instance.getStatus());
    }

    @Test
    public void testGetType() {
        Instructor instance = new Instructor();
        assertNull(instance.getType());
    }

    @Test
    public void testSetType() {
        String type = "sample";
        Instructor instance = new Instructor();
        instance.setType(type);
        assertEquals(type, instance.getType());
    }

    @Test
    public void testGetOffice() {
        Instructor instance = new Instructor();
        assertNull(instance.getOffice());
    }

    @Test
    public void testSetOffice() {
        String office = "sample";
        Instructor instance = new Instructor();
        instance.setOffice(office);
        assertEquals(office, instance.getOffice());
    }

    @Test
    public void testGetUser() {
       Instructor instance = new Instructor();
        assertNull(instance.getUser());
    }

    @Test
    public void testSetUser() {
        User user = new User();
        Instructor instance = new Instructor();
        instance.setUser(user);
        assertNotNull(instance.getUser());
    }

    @Test
    public void testGetIdFaculty() {
        Instructor instance = new Instructor();
        assertNull(instance.getIdFaculty());
    }

    @Test
    public void testSetIdFaculty() {
        Faculty idFaculty = new Faculty();
        Instructor instance = new Instructor();
        instance.setIdFaculty(idFaculty);
        assertNotNull(instance.getIdFaculty());
    }

    @Test
    public void testHashCode() {
        Instructor instance = new Instructor();
        assertNotNull(instance.hashCode());
    }
}