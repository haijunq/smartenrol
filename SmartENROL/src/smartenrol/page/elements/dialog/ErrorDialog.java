/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.elements.dialog;

import javafx.scene.image.Image;
import jfxtras.labs.dialogs.MonologFX;
import jfxtras.labs.dialogs.MonologFXBuilder;
import jfxtras.labs.dialogs.MonologFXButton;
import jfxtras.labs.dialogs.MonologFXButtonBuilder;

/**
 *
 * @author Jeremy
 */
public class ErrorDialog {
    
    private MonologFX dialog;
    
    public ErrorDialog(String message) {
        
            MonologFXButton mlb = MonologFXButtonBuilder.create()
                .icon("/smartenrol/images/small-check.png")
                .type(MonologFXButton.Type.OK)
                .build();

           dialog = MonologFXBuilder.create()
                .modal(true)
                .message(message)
                .titleText("SmartENROL Error")
                .button(mlb)
                .buttonAlignment(MonologFX.ButtonAlignment.CENTER)
                .build();
           
    }
    
    public void display() {
            
           dialog.showDialog();

    }
    
}
