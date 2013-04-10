/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.search;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import smartenrol.page.SmartEnrolController;

/**
 *
 * @author Jeremy
 */
public class ResultsPaneController extends SmartEnrolController {
     
    @FXML Text resultsText;
    String type;
    public void init() {
        
    }
    public void setText(int totalResults, String query, String type) {
        
        if (type!=null) {
            if (totalResults==1) {
                type = type.toLowerCase();
            } else {
                type = type.toLowerCase() + "s";
            }
        } else {
            type = "blnk";
        }
        resultsText.setText(totalResults+" "+type+" found for "+query);
        
    }
    
}
