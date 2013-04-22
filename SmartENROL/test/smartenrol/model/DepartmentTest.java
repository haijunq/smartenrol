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
public class DepartmentTest {

    public DepartmentTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetIdDepartment() {
        Department instance = new Department();
        assertNull(instance.getIdDepartment());
    }

    @Test
    public void testSetIdDepartment() {
        String idDepartment = "sample";
        Department instance = new Department();
        instance.setIdDepartment(idDepartment);
        assertEquals(idDepartment, instance.getIdDepartment());
    }

    @Test
    public void testGetName() {
        Department instance = new Department();
        assertNull(instance.getName());
    }

    @Test
    public void testSetName() {
        String name = "sample";
        Department instance = new Department();
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    @Test
    public void testGetDescription() {
        Department instance = new Department();
        assertNull(instance.getDescription());
    }

    @Test
    public void testSetDescription() {
        String description = "sample test";
        Department instance = new Department();
        instance.setDescription(description);
        assertEquals(description, instance.getDescription());
    }

    @Test
    public void testGetDepartmentHeadID() {
        Department instance = new Department();
        assertNull(instance.getDepartmentHeadID());
    }

    @Test
    public void testSetDepartmentHeadID() {
        System.out.println("setDepartmentHeadID");
        String departmentHeadID = "sample";
        Department instance = new Department();
        instance.setDepartmentHeadID(departmentHeadID);
        assertEquals(departmentHeadID, instance.getDepartmentHeadID());
    }

    @Test
    public void testGetMainContactID() {
        Department instance = new Department();
        assertNull(instance.getMainContactID());
    }

    @Test
    public void testSetMainContactID() {
        System.out.println("setMainContactID");
        String mainContactID = "1234567890";
        Department instance = new Department();
        instance.setMainContactID(mainContactID);
        assertEquals(mainContactID, instance.getMainContactID());
    }

    @Test
    public void testGetAdministratorCollection() {
        Department instance = new Department();
        assertNull(instance.getAdministratorCollection());
    }

    @Test
    public void testSetAdministratorCollection() {
        Collection<Administrator> administratorCollection = new ArrayList<>();
        Department instance = new Department();
        instance.setAdministratorCollection(administratorCollection);
        assertNotNull(instance.getAdministratorCollection());
    }

    @Test
    public void testGetIdLocation() {
        Department instance = new Department();
        assertNull(instance.getIdLocation());
    }

    @Test
    public void testSetIdLocation() {
        Building building = new Building();
        building.setIdLocation("12345");
        Department instance = new Department();
        instance.setIdLocation(building.getIdLocation());
        assertEquals(building.getIdLocation(), instance.getIdLocation());
    }

    @Test
    public void testGetIdFaculty() {
        Department instance = new Department();
        assertNull(instance.getIdFaculty());
    }

    @Test
    public void testHashCode() {
        Department instance = new Department();
        assertNotNull(instance.hashCode());
    }

    @Test
    public void testToString() {
        Department instance = new Department();
        instance.setIdDepartment("12");
        String result = instance.toString();
        assertNotNull(result);
    }
}