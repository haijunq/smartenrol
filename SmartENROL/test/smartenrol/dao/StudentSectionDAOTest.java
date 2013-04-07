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
import smartenrol.model.ClassList;
import smartenrol.model.Course;
import smartenrol.model.Section;

/**
 *
 * @author Haijun
 */
public class StudentSectionDAOTest {
    
    public StudentSectionDAOTest() {
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
     * Test of isStudentEnrolledInSection method, of class StudentSectionDAO.
//     */
//    @Test
//    public void testIsStudentEnrolledInSection() {
//        System.out.println("isStudentEnrolledInSection");
//        int idStudent = 80013010;
//        String idDepartment = "CICS";
//        int idCourse = 511;
//        String idSection = "L01";
//        StudentSectionDAO instance = new StudentSectionDAO();
////        int expResult = 0;
//        int result = instance.isStudentEnrolledInSection(idStudent, idDepartment, idCourse, idSection);
////        assertEquals(expResult, result);
//        System.out.println(result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }

    /**
     * Test of getStudentCurrentTermCourseList method, of class StudentSectionDAO.
     */
    @Test
    public void testGetStudentCurrentTermCourseList() {
        System.out.println("getStudentCurrentTermCourseList");
        int idStudent = 80013010;
        StudentSectionDAO instance = new StudentSectionDAO();
//        ArrayList expResult = null;
        ArrayList<Section> result = instance.getStudentCurrentTermCourseList(idStudent);
//        assertEquals(expResult, result);
        for (Section cs : result)
        System.out.println(cs + " " + cs.getCourseName());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of isStudentEnrolledInCourse method, of class StudentSectionDAO.
     */
    @Test
    public void testIsStudentEnrolledInCourse() {
        System.out.println("isStudentEnrolledInCourse");
        int idStudent = 80013010;
        String idDepartment = "cics";
        int idCourse = 511;
        StudentSectionDAO instance = new StudentSectionDAO();
//        int expResult = 0;
        int result = instance.isStudentEnrolledInCourse(idStudent, idDepartment, idCourse);
//        assertEquals(expResult, result);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of isSectionFull method, of class StudentSectionDAO.
     */
    @Test
    public void testIsSectionFull() {
        System.out.println("isSectionFull");
        String idDepartment = "cics";
        int idCourse = 520;
        String idSection = "l01";
        StudentSectionDAO instance = new StudentSectionDAO();
//        boolean expResult = false;
        boolean result = instance.isSectionFull(idDepartment, idCourse, idSection);
        System.out.println(result);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudentHistoryCourseList method, of class StudentSectionDAO.
     */
    @Test
    public void testGetStudentHistoryCourseList() {
        System.out.println("getStudentHistoryCourseList");
        int idStudent = 80013010;
        StudentSectionDAO instance = new StudentSectionDAO();
//        ArrayList expResult = null;
        ArrayList<Section> result = instance.getStudentHistoryCourseList(idStudent);
//        assertEquals(expResult, result);
        for (Section cs : result)
        System.out.println(cs + " " + cs.getCourseName());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    
    /**
     * Test of getStudentPassedCourseList method, of class StudentSectionDAO.
     */
    @Test
    public void testGetStudentPassedCourseList() {
        System.out.println("getStudentPassedCourseList");
        int idStudent = 80013010;
        StudentSectionDAO instance = new StudentSectionDAO();
//        ArrayList expResult = null;
        ArrayList<Section> result = instance.getStudentPassedCourseList(idStudent);
//        assertEquals(expResult, result);
        for (Section cs : result)
        System.out.println(cs + " " + cs.getCourseName());        
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getSectionClassList method, of class StudentSectionDAO.
     */
    @Test
    public void testGetSectionClassList() {
        System.out.println("getSectionClassList");
        String idDepartment = "cics";
        int idCourse = 520;
        String idSection = "l01";
        StudentSectionDAO instance = new StudentSectionDAO();
//        ClassList expResult = null;
        ClassList result = instance.getSectionClassList(idDepartment, idCourse, idSection);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        System.out.println(result.getInstructorName());
        for (int i = 0; i < result.getStuRecordList().size(); i++)
            System.out.println(result.getStuRecordList().get(i).getStudentName());
    }

    /**
     * Test of isStudentEnrolledInSection method, of class StudentSectionDAO.
     */
    @Test
    public void testIsStudentEnrolledInSection() {
        System.out.println("isStudentEnrolledInSection");
        int idStudent = 80013010;
        String idDepartment = "cics";
        int idCourse = 520;
        String idSection = "b01";
        StudentSectionDAO instance = new StudentSectionDAO();
//        int expResult = 0;
        int result = instance.isStudentEnrolledInSection(idStudent, idDepartment, idCourse, idSection);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        System.out.println(result);
    }

    

}