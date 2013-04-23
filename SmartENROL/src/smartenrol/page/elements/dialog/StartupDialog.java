/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.elements.dialog;

import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import jfxtras.labs.dialogs.MonologFX;
import jfxtras.labs.dialogs.MonologFXBuilder;
import jfxtras.labs.dialogs.MonologFXButton;
import jfxtras.labs.dialogs.MonologFXButtonBuilder;

/**
 *
 * @author Jeremy
 */
public class StartupDialog {
    
    private MonologFX dialog;
    
	public StartupDialog (String message) {

           dialog = MonologFXBuilder.create()
                .modal(true)
                .message(message)
                .titleText("SmartENROL")
                .build();
	}

    public void display() {
            
           dialog.showDialog();

    }
    
    public void close() {
          dialog.close();
    }
}
