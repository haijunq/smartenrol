/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol;

import javafx.stage.Stage;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class SmartENROLTest {
    
    public SmartENROLTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        SmartENROL.main(args);
        fail("The test case is a prototype.");
    }

    @Test
    public void testStart() throws Exception {
        System.out.println("start");
        Stage stage = null;
        SmartENROL instance = new SmartENROL();
        instance.start(stage);
        fail("The test case is a prototype.");
    }
}