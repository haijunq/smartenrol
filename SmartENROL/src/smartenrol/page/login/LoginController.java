/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smartenrol.page.login;

import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.security.*;
import smartenrol.page.*;
import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.SequentialTransitionBuilder;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.scene.Node;
 
public class LoginController extends AbstractController 
{
    @FXML private BorderPane contentArea;
    @FXML private TextField userName;
    @FXML private PasswordField password;
    @FXML private ImageView homeImage;
    @Autowired private PageController pageController;
    
    // Dimensions of the application
    private final double MINIMUM_WINDOW_WIDTH = 800.0;
    private final double MINIMUM_WINDOW_HEIGHT = 600.0;
    
    private void openApp() {
        contentArea.setCenter(pageController.getView());
        pageController.navDashboard();
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

    /*
           Image image1 = new Image("../../images/se-home-image-1.jpg");
        Image image2 = new Image("../../images/se-home-image-2.jpg");
        homeImage.setImage(image1);
        
        SequentialTransition transitionForward = createTransition(homeImage, image2);
        SequentialTransition transitionBackward = createTransition(homeImage, image1);
        transitionForward.play();
    SequentialTransition createTransition(final ImageView iv, final Image img){
            FadeTransition fadeOutTransition 
                        = new FadeTransition(Duration.seconds(1), iv);
                fadeOutTransition.setFromValue(1.0);
                fadeOutTransition.setToValue(0.0);
                fadeOutTransition.setOnFinished(new EventHandler<ActionEvent>(){
 
                    @Override
                    public void handle(ActionEvent arg0) {
                        iv.setImage(img);
                    }
                     
                });
                 
                FadeTransition fadeInTransition 
                        = new FadeTransition(Duration.seconds(1), iv);
                fadeInTransition.setFromValue(0.0);
                fadeInTransition.setToValue(1.0);
                SequentialTransition sequentialTransition 
                        = SequentialTransitionBuilder
                        .create()
                        .children(fadeOutTransition, fadeInTransition)
                        .build();
                 
                return sequentialTransition;
    }
    */
}    
