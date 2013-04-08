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
import smartenrol.model.Program;

/**
 *
 * @author Administrator
 */
public class ProgramDAOTest {
    
    public ProgramDAOTest() {
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
     * Test of getProgrambyID method, of class ProgramDAO.
     */
    @Test
    public void testGetProgrambyID() {
        System.out.println("getProgrambyID");
        String idProgram = "MSS";
        ProgramDAO instance = new ProgramDAO();
        //Program expResult = null;
        Program result = instance.getProgrambyID(idProgram);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println(result.getIdProgram());
        System.out.println(result.getIdDepartment());
        System.out.println(result.getProgramName());
        System.out.println(result.getProgramDescription());
        System.out.println(result.gettotalCreditsToGraduate());
    }

    /**
     * Test of searchProgrambyKeyword method, of class ProgramDAO.
     */
    @Test
    public void testSearchProgrambyKeyword() {
        System.out.println("searchProgrambyKeyword");
        String[] keyword = {"","ME","engineer"};
        ProgramDAO instance = new ProgramDAO();
       // ArrayList expResult = null;
        ArrayList result = instance.searchProgrambyKeyword(keyword);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println(result);
    }
}