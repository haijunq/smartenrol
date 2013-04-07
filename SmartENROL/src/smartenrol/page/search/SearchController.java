/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.search;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.page.AbstractController;

/**
 *
 * @author Jeremy
 */
public class SearchController extends AbstractController {
    
    @FXML protected TextField mainSearchField;
    @FXML private BorderPane innerContent;
    @FXML private BorderPane searchResultsArea;
   
    @Autowired private ResultsPaneController resultsPane;
    @Autowired private FilterController filterController;
    @Autowired private SearchTableController searchTableController;
    
    public void search(String searchQuery) {
       resultsPane.setText(0,searchQuery);
       mainSearchField.setText(searchQuery);
       innerContent.setLeft(filterController.getView());
       searchResultsArea.setTop(resultsPane.getView());
       searchResultsArea.setCenter(searchTableController.getView());
    }
    
    
    /**
     *
     */
    public void allSearch() {
        
    }
    
}
