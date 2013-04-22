/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class FacultyTest {

    public FacultyTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetIdFaculty() {
        Faculty instance = new Faculty();
        assertNull(instance.getIdFaculty());
    }

    @Test
    public void testSetIdFaculty() {
        String idFaculty = "sample";
        Faculty instance = new Faculty();
        instance.setIdFaculty(idFaculty);
        assertEquals(idFaculty, instance.getIdFaculty());
    }

    @Test
    public void testGetName() {
        Faculty instance = new Faculty();
        assertNull(instance.getName());
    }

    @Test
    public void testSetName() {
        String name = "sample name";
        Faculty instance = new Faculty();
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    @Test
    public void testGetDescription() {
        Faculty instance = new Faculty();
        assertNull(instance.getDescription());
    }

    @Test
    public void testSetDescription() {
        String description = "sample Desc";
        Faculty instance = new Faculty();
        instance.setDescription(description);
        assertEquals(description, instance.getDescription());
    }

    @Test
    public void testGetMainPhone() {
        Faculty instance = new Faculty();
        assertNull(instance.getMainPhone());
    }

    @Test
    public void testSetMainPhone() {
        String mainPhone = "1234567890";
        Faculty instance = new Faculty();
        instance.setMainPhone(mainPhone);
        assertEquals(mainPhone, instance.getMainPhone());
    }

    @Test
    public void testGetDeanID() {
        Faculty instance = new Faculty();
        assertNull(instance.getDeanID());
    }

    @Test
    public void testSetDeanID() {
        String deanID = "1234";
        Faculty instance = new Faculty();
        instance.setDeanID(deanID);
        assertEquals(deanID, instance.getDeanID());
    }

    @Test
    public void testGetMainContactID() {
        Faculty instance = new Faculty();
        assertNull(instance.getMainContactID());
    }

    @Test
    public void testSetMainContactID() {
        String mainContactID = "1212121";
        Faculty instance = new Faculty();
        instance.setMainContactID(mainContactID);
        assertEquals(mainContactID, instance.getMainContactID());
    }

    @Test
    public void testGetHeadOfficeLocationID() {
        Faculty instance = new Faculty();
        assertNull(instance.getHeadOfficeLocationID());
    }

    @Test
    public void testSetHeadOfficeLocationID() {
        Building headOfficeLocationID = new Building();
        Faculty instance = new Faculty();
        instance.setHeadOfficeLocationID(headOfficeLocationID);
        assertNotNull(instance.getHeadOfficeLocationID());
    }

    @Test
    public void testGetAdministratorCollection() {
        Faculty instance = new Faculty();
        assertNull(instance.getAdministratorCollection());
    }

    @Test
    public void testSetAdministratorCollection() {
        Collection<Administrator> administratorCollection = new ArrayList<>();
        Faculty instance = new Faculty();
        instance.setAdministratorCollection(administratorCollection);
        assertNotNull(instance.getAdministratorCollection());
    }

    @Test
    public void testGetInstructorCollection() {
        Faculty instance = new Faculty();
        assertNull(instance.getInstructorCollection());
    }

    @Test
    public void testSetInstructorCollection() {
        Collection<Instructor> instructorCollection = new ArrayList<>();
        Faculty instance = new Faculty();
        instance.setInstructorCollection(instructorCollection);
        assertNotNull(instance.getInstructorCollection());
    }

    @Test
    public void testGetDepartmentCollection() {
        Faculty instance = new Faculty();
        assertNull(instance.getDepartmentCollection());
    }

    @Test
    public void testSetDepartmentCollection() {
        Collection<Department> departmentCollection = new ArrayList<>();
        Faculty instance = new Faculty();
        instance.setDepartmentCollection(departmentCollection);
        assertNotNull(instance.getDepartmentCollection());
    }

    @Test
    public void testHashCode() {
        Faculty instance = new Faculty();
        assertNotNull(instance.hashCode());
    }

    @Test
    public void testToString() {
        Faculty instance = new Faculty();
        instance.setIdFaculty("12");
        String expResult = "smartenrol.model.Faculty[ idFaculty=12 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}