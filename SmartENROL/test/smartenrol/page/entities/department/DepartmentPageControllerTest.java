/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.entities.department;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class DepartmentPageControllerTest {
    
    public DepartmentPageControllerTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testInit() {
        System.out.println("init");
        DepartmentPageController instance = new DepartmentPageController();
        instance.init();
        fail("The test case is a prototype.");
    }

    @Test
    public void testLoad() {
        System.out.println("load");
        String idDepartment = "";
        DepartmentPageController instance = new DepartmentPageController();
        instance.load(idDepartment);
        fail("The test case is a prototype.");
    }
}