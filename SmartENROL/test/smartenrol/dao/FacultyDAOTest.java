/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import smartenrol.model.Building;
import smartenrol.model.Faculty;

/**
 *
 * @author Aishwarya
 */
public class FacultyDAOTest {

    public FacultyDAOTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testAddFaculty() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setIdFaculty("1");
        Building building = new Building();
        building.setIdLocation("1");
        faculty.setHeadOfficeLocationID(building);
        faculty.setName("Name");
        faculty.setDescription("description");
        faculty.setMainPhone("9996545");
        faculty.setDeanID("113");
        faculty.setMainContactID("123445");
        FacultyDAO instance = new FacultyDAO();
        Integer expResult = 0;
        Integer result = instance.addFaculty(faculty);
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateFaculty() {
        Faculty faculty = new Faculty();
        faculty.setIdFaculty("1");
        Building building = new Building();
        building.setIdLocation("1");
        faculty.setHeadOfficeLocationID(building);
        faculty.setName("Name");
        faculty.setDescription("description");
        faculty.setMainPhone("9996545");
        faculty.setDeanID("113");
        faculty.setMainContactID("123445");
        FacultyDAO instance = new FacultyDAO();
        Integer expResult = 0;
        Integer result = instance.updateFaculty(faculty);
        assertEquals(expResult, result);
    }
}