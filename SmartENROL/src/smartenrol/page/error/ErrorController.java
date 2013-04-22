/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.error;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import smartenrol.page.SmartEnrolController;

/**
 *
 * @author Jeremy
 */

public class ErrorController extends SmartEnrolController {
    
    @FXML private Text fxSystemMessage;
    @FXML private Text fxName;
    
    @Override
    public void init() {
        
    }
    
    public void load(PageError errorType) {
        switch (errorType) {
            case ACCESS_DENIED:
                fxName.setText("Access denied.");
                fxSystemMessage.setText("Sorry, you do not have access to this page.");
                break;
            case NO_PAGE_HERE:
                fxName.setText("No page was found.");
                fxSystemMessage.setText("Sorry, no page could be found.");
                break;
        }
    }
}
    
