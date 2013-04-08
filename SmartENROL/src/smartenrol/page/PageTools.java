/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page;

import javafx.scene.layout.BorderPane;

/**
 *
 * @author Jeremy
 */
public class PageTools {
    
     public void inject(BorderPane contentArea, Controller view, Controller sidebar) {
 
            contentArea.setCenter(view.getView());
            view.init();
            
            if (sidebar!=null) {
                contentArea.setRight(view.getView());
                sidebar.init();
            }
            
    }
}
