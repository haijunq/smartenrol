/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smartenrol.page;
 
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.page.login.LoginController;

public class Navigator extends SmartEnrolController 
{
    @Autowired private LoginController loginController;
    @FXML private BorderPane mainBlock;
   
    public void init() {
        mainBlock.setCenter(loginController.getView());
    }
    
    public void navigate(Controller controller) {
        mainBlock.setCenter(controller.getView());
        controller.init();
    }
    
    public void navigateInternal(Controller controller, Controller internal) {
        ((BorderPane)controller.getInternalView()).setCenter(internal.getView());
        internal.init();
    }

}    
