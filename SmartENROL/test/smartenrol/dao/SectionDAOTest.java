/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import smartenrol.model.Course;
import smartenrol.model.Section;

/**
 *
 * @author Haijun
 */
public class SectionDAOTest {
    
    public SectionDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSectionListByCourse method, of class SectionDAO.
//     */
//    @Test
//    public void testGetSectionListByCourse_Course() {
//        System.out.println("getSectionListByCourse");
//        Course course = null;
//        SectionDAO instance = new SectionDAO();
//        ArrayList expResult = null;
//        ArrayList result = instance.getSectionListByCourse(course);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getSectionListByCourse method, of class SectionDAO.
     */
    @Test
    public void testGetSectionListByCourse_String_int() {
        System.out.println("getSectionListByCourse");
        String idDepartment = "CICS";
        int idCourse = 520;
        SectionDAO instance = new SectionDAO();
//        ArrayList expResult = null;
        ArrayList<Section> result = instance.getSectionListByCourse(idDepartment, idCourse);
//        assertEquals(expResult, result);
        for (Section s: result)
            System.out.println(s.getIdSection());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getSectionByID method, of class SectionDAO.
     */
    @Test
    public void testGetSectionByID() {
        System.out.println("getSectionByID");
        String idDepartment = "cics";
        int idCourse = 520;
        String idSection = "b01";
        SectionDAO instance = new SectionDAO();
//        Section expResult = null;
        Section result = instance.getSectionByID(idDepartment, idCourse, idSection);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        System.out.println(result);
    }

//    /**
//     * Test of getSectionListByCourse method, of class SectionDAO.
//     */
//    @Test
//    public void testGetSectionListByCourse_Course() {
//        System.out.println("getSectionListByCourse");
//        Course course = null;
//        SectionDAO instance = new SectionDAO();
//        ArrayList expResult = null;
//        ArrayList result = instance.getSectionListByCourse(course);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getSectionListForStudent method, of class SectionDAO.
     */
    @Test
    public void testGetSectionListForStudent() {
        System.out.println("getSectionListForStudent");
        int idStudent = 80013003;
        SectionDAO instance = new SectionDAO();
//        ArrayList expResult = null;
        ArrayList result = instance.getSectionListForStudent(idStudent);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        System.out.println(result.size());
    }

    /**
     * Test of getSectionTypesOfCourse method, of class SectionDAO.
//     */
//    @Test
//    public void testGetSectionTypesOfCourse() {
//        System.out.println("getSectionTypesOfCourse");
//        String idDepartment = "";
//        int idCourse = 0;
//        SectionDAO instance = new SectionDAO();
//        int expResult = 0;
//        int result = instance.getSectionTypesOfCourse(idDepartment, idCourse);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getSectionListByCourseWithInstructorName method, of class SectionDAO.
//     */
//    @Test
//    public void testGetSectionListByCourseWithInstructorName() {
//        System.out.println("getSectionListByCourseWithInstructorName");
//        String idDepartment = "";
//        int idCourse = 0;
//        SectionDAO instance = new SectionDAO();
//        ArrayList expResult = null;
//        ArrayList result = instance.getSectionListByCourseWithInstructorName(idDepartment, idCourse);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}