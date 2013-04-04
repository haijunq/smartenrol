/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.login;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import smartenrol.security.*;

/**
 * FXML Controller class
 *
 * @author Ashwin
 */
public class LoginController implements Initializable {
    @FXML private Label errorMessage;
    @FXML private TextField userName;
    @FXML private PasswordField password;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception 
    {
        try 
        {
            final AuthenticateService authenticateService = new AuthenticateService();
            String profile = authenticateService.authenticate(userName.getText(), password.getText());
            Stage stage = (Stage) errorMessage.getScene().getWindow();
            
            if("STUDENT".equalsIgnoreCase(profile))
            {
               
            }
            else if("ADMINISTRATOR".equalsIgnoreCase(profile))
            {
                
            }
            else if("INSTRUCTOR".equalsIgnoreCase(profile))
            {
               
            }
            
        } catch (InvalidAuthenticationException ex) 
        {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            errorMessage.setTextFill(Color.RED);
            errorMessage.setText(ex.getMessage());
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    
}
