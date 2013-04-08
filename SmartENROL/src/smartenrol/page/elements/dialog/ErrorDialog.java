/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.elements.dialog;

import jfxtras.labs.dialogs.MonologFX;

/**
 *
 * @author Jeremy
 */
public class ErrorDialog extends SmartEnrolDialog {
    
    public ErrorDialog() {
        super();
        this.setType(MonologFX.Type.ERROR);
        this.setTitle("SmartENROL Error");
        
    }
    
}
