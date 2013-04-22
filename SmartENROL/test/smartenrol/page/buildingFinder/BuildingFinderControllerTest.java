/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.buildingFinder;

import java.net.URL;
import java.util.ResourceBundle;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class BuildingFinderControllerTest {
    
    public BuildingFinderControllerTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        BuildingFinderController instance = new BuildingFinderController();
        instance.initialize(url, rb);
        fail("The test case is a prototype.");
    }
}