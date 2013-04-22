/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import smartenrol.UniqueConstraintException;
import smartenrol.model.Building;
import smartenrol.model.Department;
import smartenrol.model.Faculty;

/**
 *
 * @author Aishwarya
 */
public class DepartmentDAOTest {

    public DepartmentDAOTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testAddDepartment() throws UniqueConstraintException {
        Department department = new Department();
        department.setIdDepartment("1");
        department.setName("IT");
        Building building = new Building();
        building.setIdLocation("44");
        department.setIdLocation(building.getIdLocation());
        Faculty faculty = new Faculty();
        faculty.setIdFaculty("1234");
        department.setIdFaculty(faculty.getIdFaculty());
        department.setDescription("IT DEPT");
        department.setMainContactID("98");
        department.setDepartmentHeadID("4");
        DepartmentDAO instance = new DepartmentDAO();
        Integer expResult = 0;
        Integer result = instance.addDepartment(department);
        assertEquals(expResult, result);

    }

    @Test
    public void testUpdateDepartment() {
        Department department = new Department();
        department.setIdDepartment("1");
        department.setName("IT");
        Building building = new Building();
        building.setIdLocation("44");
        department.setIdLocation(building.getIdLocation());
        Faculty faculty = new Faculty();
        faculty.setIdFaculty("1234");
        department.setIdFaculty(faculty.getIdFaculty());
        department.setDescription("IT DEPT");
        department.setMainContactID("98");
        department.setDepartmentHeadID("4");
        DepartmentDAO instance = new DepartmentDAO();
        Integer expResult = 0;
        Integer result = instance.updateDepartment(department);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDepartmentByID() {
        String idDepartment = "1";
        DepartmentDAO instance = new DepartmentDAO();
        assertNotNull(instance.getDepartmentByID(idDepartment));
    }

    @Test
    public void testGetAllDeptID() {
        DepartmentDAO instance = new DepartmentDAO();
        assertNotNull(instance.getAllDeptID());
    }
}