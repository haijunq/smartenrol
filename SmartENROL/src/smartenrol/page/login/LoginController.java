/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smartenrol.page.login;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import smartenrol.SmartEnrolFactory;
import smartenrol.security.*;
import smartenrol.page.*;
import smartenrol.page.dashboard.DashboardController;
 
public class LoginController
{
    @FXML private Parent view;
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
    
    public Parent getView()
    {
        return view;   
    }
}