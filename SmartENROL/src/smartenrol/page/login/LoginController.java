/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smartenrol.page.login;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.security.*;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import smartenrol.page.SmartEnrolController;
import smartenrol.page.PageController;
 
public class LoginController extends SmartEnrolController 
{
    @FXML private BorderPane contentArea;
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private ImageView homeImage;
    @FXML private Text errorMessage;
    
    @Autowired private PageController pageController;
    
    // Dimensions of the application
    private final double MINIMUM_WINDOW_WIDTH = 800.0;
    private final double MINIMUM_WINDOW_HEIGHT = 600.0;
 
    public void init() {
        errorMessage.setText(" ");
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception 
    {
        try {
            
            final AuthenticateService authenticateService = new AuthenticateService();
            authenticateService.authenticate(username.getText(), password.getText());
            
            inject(contentArea,pageController,null);
            UserSession.getInstance();
            
        } catch (InvalidAuthenticationException ex) 
        {
            //Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            errorMessage.setText("ERROR: Invalid Credentials.");

        }
    }

}    
