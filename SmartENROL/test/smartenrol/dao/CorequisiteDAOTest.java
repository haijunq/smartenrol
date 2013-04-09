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
public class CorequisiteDAOTest {
    
    public CorequisiteDAOTest() {
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
     * Test of getCorequsiteCourseListByID method, of class CorequisiteDAO.
     */
    @Test
    public void testGetCorequsiteCourseListByID() {
        System.out.println("getCorequsiteCourseListByID");
        String idDepartment = "CICS";
        int idCourse = 530;
        CorequisiteDAO instance = new CorequisiteDAO();
//        ArrayList expResult = null;
        ArrayList<Course> result = instance.getCorequsiteCourseListByID(idDepartment, idCourse);
//        assertEquals(expResult, result);
                System.out.println(result);
        System.out.println(result.get(0).getCourseName());

        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getCorequsiteByID method, of class CorequisiteDAO.
     */
    @Test
    public void testGetCorequsiteByID() {
        System.out.println("getCorequsiteByID");
        String idDepartment = "CICS";
        int idCourse = 520;
        CorequisiteDAO instance = new CorequisiteDAO();
//        ArrayList expResult = null;
        ArrayList result = instance.getCorequsiteByID(idDepartment, idCourse);
//        assertEquals(expResult, result);        
                System.out.println(result);

        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}