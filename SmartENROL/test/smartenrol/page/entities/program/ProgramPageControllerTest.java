/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.entities.program;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import smartenrol.model.Program;

/**
 *
 * @author Aishwarya
 */
public class ProgramPageControllerTest {
    
    public ProgramPageControllerTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testInit() {
        System.out.println("init");
        ProgramPageController instance = new ProgramPageController();
        instance.init();
        fail("The test case is a prototype.");
    }

    @Test
    public void testLoadProgram() {
        System.out.println("loadProgram");
        Program currentProgram = null;
        ProgramPageController instance = new ProgramPageController();
        fail("The test case is a prototype.");
    }
}