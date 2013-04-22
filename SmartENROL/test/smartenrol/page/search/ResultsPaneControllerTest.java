/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.search;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class ResultsPaneControllerTest {
    
    public ResultsPaneControllerTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testInit() {
        System.out.println("init");
        ResultsPaneController instance = new ResultsPaneController();
        instance.init();
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetText() {
        System.out.println("setText");
        int totalResults = 0;
        String query = "";
        String type = "";
        ResultsPaneController instance = new ResultsPaneController();
        instance.setText(totalResults, query, type);
        fail("The test case is a prototype.");
    }

    @Test
    public void testShowAll() {
        System.out.println("showAll");
        ResultsPaneController instance = new ResultsPaneController();
        instance.showAll();
        fail("The test case is a prototype.");
    }
}