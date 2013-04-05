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
public class ErrorDialog extends MonologFX {
    public ErrorDialog() {
        
        this.setType(MonologFX.Type.ERROR);
        this.setResizable(false);
        this.setWidth(200);
        this.setHeight(100);
        this.setTitle("SmartENROL Error");
        this.setModal(true);
        this.centerOnScreen();
        this.addStylesheet(null);
        this.show();
        
    }
}
