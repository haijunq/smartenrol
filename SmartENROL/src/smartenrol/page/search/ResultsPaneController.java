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
    @FXML Text numResults;
    @FXML Text searchQuery;
    @Autowired private SearchController searchController;
    String type;
    public void init() {
        
    }
    public void setText(int totalResults, String query, String type) {
        
        if (type==null)
            type = "result";
        
            if (totalResults==1) {
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

        if (query.length()>0)
        {
             numResults.setText(totalResults+" ");
             resultsText.setText(type+" found for ");
             searchQuery.setText(query+".");
        }
        else
        {
             numResults.setText(totalResults+" ");
             resultsText.setText(type+" found.");
             searchQuery.setText("");
        }
    } 
        @FXML
        public void showAll()
        {
            searchController.showAll();
        }
    
    
}
