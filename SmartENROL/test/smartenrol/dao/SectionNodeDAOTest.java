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
}