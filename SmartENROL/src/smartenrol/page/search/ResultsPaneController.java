/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.search;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.page.SmartEnrolController;

/**
 *
 * @author Jeremy
 */
public class ResultsPaneController extends SmartEnrolController {
     
    @FXML Text resultsText;
    @Autowired private SearchController searchController;
    String type;
    public void init() {
        
    }
    public void setText(int totalResults, String query, String type) {
        
        if (type!=null) {
            if (totalResults<=1) {
                type = type.toLowerCase();
                if (type.equalsIgnoreCase("people"))
                {
                    type="person";
                }
            } else {
                if (!(type.equalsIgnoreCase("people")))
                {
                    type = type.toLowerCase() + "s";
                }
            }
        } else {
            type = "blnk";
        }
        if (query.length()>0)
        {
             resultsText.setText(totalResults+" "+type+" found for "+query);
        }
        else
        {
             resultsText.setText(totalResults+" "+type+" found");
        }
    } 
        @FXML
        public void showAll()
        {
            searchController.showAll();
        }
    
    
}
