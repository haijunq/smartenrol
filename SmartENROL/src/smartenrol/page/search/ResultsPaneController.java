/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.search;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import smartenrol.page.AbstractController;

/**
 *
 * @author Jeremy
 */
public class ResultsPaneController extends AbstractController {
     
    @FXML Text resultsText;
    String type;
    
    public void setText(int totalResults, String query, String type) {
        
        if (totalResults==1) {
            type = type.toLowerCase();
        } else {
            type = type.toLowerCase() + "s";
        }

        resultsText.setText(totalResults+" "+type+" found for "+query);
        
    }
    
}
