/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smartenrol.page.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.security.*;
import smartenrol.page.*;

 
public class LoginController extends AbstractController 
{
    @FXML private BorderPane contentArea;
    @FXML private TextField userName;
    @FXML private PasswordField password;
    @Autowired private PageController pageController;
    
    // Dimensions of the application
    private final double MINIMUM_WINDOW_WIDTH = 800;
    private final double MINIMUM_WINDOW_HEIGHT = 600.0;
    
    private void openApp() {
        contentArea.setCenter(pageController.getView());
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception 
    {
        //try {
            final AuthenticateService authenticateService = new AuthenticateService();
            //String profile = authenticateService.authenticate(userName.getText(), password.getText());
            String profile = "STUDENT";
            if("STUDENT".equalsIgnoreCase(profile))
            {
               openApp();
            }
            else if("ADMINISTRATOR".equalsIgnoreCase(profile))
            {
                openApp();
            }
            else if("INSTRUCTOR".equalsIgnoreCase(profile))
            {
                openApp();
            }
            
        /*} catch (InvalidAuthenticationException ex) 
        {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex.getMessage());
           
        }*/
    }

}