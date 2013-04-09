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
public class ConfirmDialog {
    
    private MonologFX dialog;
    
    public ConfirmDialog(String title, String message) {
        
            MonologFXButton mlb = MonologFXButtonBuilder.create()
                .icon("/smartenrol/images/small-check.png")
                .type(MonologFXButton.Type.OK)
                .build();

            MonologFXButton mlb2 = MonologFXButtonBuilder.create()
                .cancelButton(true)
                .icon("/smartenrol/images/small-x.png")
                .type(MonologFXButton.Type.CANCEL)
                .build();
            
           dialog = MonologFXBuilder.create()
                .modal(true)
                .message(message)
                .titleText(title)
                .button(mlb)
                .button(mlb2)
                .buttonAlignment(MonologFX.ButtonAlignment.CENTER)
                .build();
    }
    
    public boolean confirm() {
            
           MonologFXButton.Type output = dialog.showDialog();
           
           if (output.equals(MonologFXButton.Type.OK))
               return true;
           else 
               return false;
           
    }
    
}
