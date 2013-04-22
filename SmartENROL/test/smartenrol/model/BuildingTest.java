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
public class BuildingTest {

    public BuildingTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetIdLocation() {
        Building instance = new Building();
        assertNull(instance.getIdLocation());
    }

    @Test
    public void testSetIdLocation() {
        String idLocation = "sample";
        Building instance = new Building();
        instance.setIdLocation(idLocation);
        assertEquals(idLocation, instance.getIdLocation());
    }

    @Test
    public void testGetAddr1() {
        Building instance = new Building();
        assertNull(instance.getAddr1());
    }

    @Test
    public void testSetAddr1() {
        String addr1 = "sample";
        Building instance = new Building();
        instance.setAddr1(addr1);
        assertEquals(addr1, instance.getAddr1());
    }

    @Test
    public void testGetAddr2() {
        Building instance = new Building();
        assertNull(instance.getAddr2());
    }

    @Test
    public void testSetAddr2() {
        String addr2 = "sample";
        Building instance = new Building();
        instance.setAddr2(addr2);
        assertEquals(addr2, instance.getAddr2());
    }

    @Test
    public void testGetCity() {
        Building instance = new Building();
        assertNull(instance.getCity());
    }

    @Test
    public void testSetCity() {
        String city = "city";
        Building instance = new Building();
        instance.setCity(city);
        assertEquals(city, instance.getCity());
    }

    @Test
    public void testGetProvince() {
        Building instance = new Building();
        assertNull(instance.getProvince());
    }

    @Test
    public void testSetProvince() {
        String province = "province";
        Building instance = new Building();
        instance.setProvince(province);
        assertEquals(province, instance.getProvince());
    }

    @Test
    public void testGetCountry() {
        Building instance = new Building();
        assertNull(instance.getCountry());
    }

    @Test
    public void testSetCountry() {
        String country = "country";
        Building instance = new Building();
        instance.setCountry(country);
        assertEquals(country, instance.getCountry());
    }

    @Test
    public void testGetPostalCode() {
        Building instance = new Building();
        assertNull(instance.getPostalCode());
    }

    @Test
    public void testSetPostalCode() {
        String postalCode = "postal";
        Building instance = new Building();
        instance.setPostalCode(postalCode);
        assertEquals(postalCode, instance.getPostalCode());
    }

    @Test
    public void testGetNotes() {
        Building instance = new Building();
        assertNull(instance.getNotes());
    }

    @Test
    public void testSetNotes() {
        String notes = "notes";
        Building instance = new Building();
        instance.setNotes(notes);
        assertEquals(notes, instance.getNotes());
    }

    @Test
    public void testGetBuildingName() {
        Building instance = new Building();
        assertNull(instance.getBuildingName());
    }

    @Test
    public void testSetBuildingName() {
        String buildingName = "sample_Building";
        Building instance = new Building();
        instance.setBuildingName(buildingName);
        assertEquals(buildingName, instance.getBuildingName());
    }

    @Test
    public void testGetFacultyCollection() {
        Building instance = new Building();
        assertNull(instance.getFacultyCollection());
    }

    @Test
    public void testSetFacultyCollection() {
        Collection<Faculty> facultyCollection = new ArrayList<>();
        Building instance = new Building();
        instance.setFacultyCollection(facultyCollection);
        assertNotNull(instance.getFacultyCollection());
    }

    @Test
    public void testGetDepartmentCollection() {
        Building instance = new Building();
        assertNull(instance.getDepartmentCollection());
    }

    @Test
    public void testSetDepartmentCollection() {
        Collection<Department> departmentCollection = new ArrayList<>();
        Building instance = new Building();
        instance.setDepartmentCollection(departmentCollection);
        assertNotNull(instance.getDepartmentCollection());
    }

    @Test
    public void testHashCode() {
        Building instance = new Building();
        assertNotNull(instance.hashCode());
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Building instance = new Building();
        instance.setIdLocation("32");
        String result = instance.toString();
        assertNotNull(result);
    }
}