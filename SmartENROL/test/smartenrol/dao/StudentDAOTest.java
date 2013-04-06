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
import smartenrol.model.Student;

/**
 *
 * @author Haijun
 */
public class StudentDAOTest {
    
    public StudentDAOTest() {
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
     * Test of getStudentByID method, of class StudentDAO.
     */
    @Test
    public void testGetStudentByID() {
        System.out.println("getStudentByID");
        int idStudent = 80013010;
        StudentDAO instance = new StudentDAO();
//        Student expResult = null;
        Student result = instance.getStudentByID(idStudent);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        System.out.println(result.getStudentName());
    }

    /**
     * Test of getStudentByProgram method, of class StudentDAO.
     */
    @Test
    public void testGetStudentByProgram() {
        System.out.println("getStudentByProgram");
        String idProgram = "mss";
        StudentDAO instance = new StudentDAO();
//        ArrayList expResult = null;
        ArrayList<Student> result = instance.getStudentByProgram(idProgram);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        for (Student stu: result) 
            System.out.println(stu.getStudentName());
    }

    /**
     * Test of isStudentEligibleForCourse method, of class StudentDAO.
     */
    @Test
    public void testIsStudentEligibleForCourse() {
        System.out.println("isStudentEligibleForCourse");
        int idStudent = 80013010;
        String idDepartment = "cics";
        int idCourse = 530;
        StudentDAO instance = new StudentDAO();
//        boolean expResult = false;
        boolean result = instance.isStudentEligibleForCourse(idStudent, idDepartment, idCourse);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        System.out.println(result);
    }
}