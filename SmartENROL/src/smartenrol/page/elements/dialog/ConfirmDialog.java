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
    private String title;
    private String message;

    public ConfirmDialog(String title, String message) {
        this.title = title;
        this.message = message;
    }
    
    public ConfirmDialog() {
        this.title = null;
        this.message = null;
    }
     
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    public boolean confirm() {
        
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
                .message(getMessage())
                .titleText(getTitle())
                .button(mlb)
                .button(mlb2)
                .buttonAlignment(MonologFX.ButtonAlignment.CENTER)
                .build();
        
           MonologFXButton.Type output = dialog.showDialog();
           
           if (output.equals(MonologFXButton.Type.OK))
               return true;
           else 
               return false;
           
    }
    
}
