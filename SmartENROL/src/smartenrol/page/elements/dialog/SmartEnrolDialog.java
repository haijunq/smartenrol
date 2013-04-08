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
public class SmartEnrolDialog extends MonologFX {
    
    public SmartEnrolDialog() {
        this.setResizable(false);
        this.setWidth(200);
        this.setHeight(100);
        this.setModal(true);
        this.centerOnScreen();
        this.addStylesheet(null);
        this.show();
        
    }
    
}
