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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Jeremy
 */
public class PageController {
    
    @FXML private Parent view;
    @FXML private BorderPane mainContent;
 
    @Autowired private OneColumnPageController oneColumnPage;
    
    public Parent getView()
    {
        return view;
    }
 
    public void showOneColumnPage(ActionEvent event)
    {
        mainContent.setCenter(oneColumnPage.getView());
    }
      
}