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
     */
    @Test
    public void testIsStudentEnrolledInSection() {
        System.out.println("isStudentEnrolledInSection");
        int idStudent = 80013011;
        String idDepartment = "CICS";
        int idCourse = 520;
        String idSection = "L01";
        StudentSectionDAO instance = new StudentSectionDAO();
//        int expResult = 0;
        int result = instance.isStudentEnrolledInSection(idStudent, idDepartment, idCourse, idSection);
//        assertEquals(expResult, result);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudentCurrentTermCourseList method, of class StudentSectionDAO.
     */
    @Test
    public void testGetStudentCurrentTermCourseList() {
        System.out.println("getStudentCurrentTermCourseList");
        int idStudent = 80013010;
        StudentSectionDAO instance = new StudentSectionDAO();
//        ArrayList expResult = null;
        ArrayList<Course> result = instance.getStudentCurrentTermCourseList(idStudent);
//        assertEquals(expResult, result);
        for (Course cs : result)
        System.out.println(cs.getCourseName());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}