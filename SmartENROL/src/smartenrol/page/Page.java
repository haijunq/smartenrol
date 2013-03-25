/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smartenrol.page;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import smartenrol.SmartENROL;

/**
 *
 * @author Jeremy
 */
public class Page extends AnchorPane implements Initializable {
    
    @FXML
    ImageView profileButton;
    @FXML
    AnchorPane mainContent;
    
    public void setApp(SmartENROL application){
    
    }    

    
    public void profileButtonOnMouseOver() {
       // profileButton.setImage(new Image("../images/se-icon-profile-hover.png"));
       // System.out.println("Cool!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
}
