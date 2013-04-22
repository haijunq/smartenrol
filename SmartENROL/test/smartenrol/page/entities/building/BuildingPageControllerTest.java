/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.entities.building;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class BuildingPageControllerTest {
    
    public BuildingPageControllerTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testInit() {
        System.out.println("init");
        BuildingPageController instance = new BuildingPageController();
        instance.init();
        fail("The test case is a prototype.");
    }

    @Test
    public void testLoad() {
        System.out.println("load");
        String idLocation = "";
        BuildingPageController instance = new BuildingPageController();
        instance.load(idLocation);
        fail("The test case is a prototype.");
    }
}