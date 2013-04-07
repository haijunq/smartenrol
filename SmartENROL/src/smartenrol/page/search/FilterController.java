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
public class FilterController extends AbstractController {
     
    @FXML Text resultsText;
    
    public void setText(int totalResults, String query) {
        
        resultsText.setText(totalResults+" results found for "+query);
        
    }
    
}
