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
import smartenrol.model.SectionNode;

/**
 *
 * @author Haijun
 */
public class SectionNodeDAOTest {
    
    public SectionNodeDAOTest() {
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
     * Test of getSectionNodeListBySection method, of class SectionNodeDAO.
     */
//    SectionNode sn = new SectionNode
    
    @Test
    public void testGetSectionNodeListBySection() {
        System.out.println("getSectionNodeListBySection");
        String idDepartment = "cics";
        int idCourse = 520;
        String idSection = "L01";
        SectionNodeDAO instance = new SectionNodeDAO();
//        ArrayList expResult = null;
        ArrayList<SectionNode> result = instance.getSectionNodeListBySection(idDepartment, idCourse, idSection);
//        assertEquals(expResult, result);
        for (SectionNode sn: result)
        System.out.println(sn.getStartTime().toString("HH:mm"));
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getSectionNodeByCourse method, of class SectionNodeDAO.
     */
//    @Test
//    public void testGetSectionNodeByCourse() {
//        System.out.println("getSectionNodeByCourse");
//        String idDepartment = "";
//        int idCourse = 0;
//        SectionNodeDAO instance = new SectionNodeDAO();
//        ArrayList expResult = null;
//        ArrayList result = instance.getSectionNodeByCourse(idDepartment, idCourse);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getSectionNodeByClassRoom method, of class SectionNodeDAO.
     */
//    @Test
//    public void testGetSectionNodeByClassRoom() {
//        System.out.println("getSectionNodeByClassRoom");
//        String idLocation = "";
//        String idRoom = "";
//        SectionNodeDAO instance = new SectionNodeDAO();
//        ArrayList expResult = null;
//        ArrayList result = instance.getSectionNodeByClassRoom(idLocation, idRoom);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of removeSection method, of class SectionNodeDAO.
     */
//    @Test
//    public void testRemoveSection() {
//        System.out.println("removeSection");
//        SectionNode snode = null;
//        SectionNodeDAO instance = new SectionNodeDAO();
//        int expResult = 0;
//        int result = instance.removeSection(snode);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of updateSection method, of class SectionNodeDAO.
     */
//    @Test
//    public void testUpdateSection() {
//        System.out.println("updateSection");
//        SectionNode snode = null;
//        SectionNodeDAO instance = new SectionNodeDAO();
//        int expResult = 0;
//        int result = instance.updateSection(snode);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}