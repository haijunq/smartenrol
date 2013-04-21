/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.search;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import smartenrol.model.view.CourseTable;
import smartenrol.page.SmartEnrolController;

/**
 *
 * @author Jeremy
 */
public class SearchTableController extends SmartEnrolController {
    
    //@FXML private TableView<CourseSearchResult> searchResults;
    public void init() {
        
    }
    
    public void populate(ObservableList results) {
        
        //ObservableList<CourseSearchResult> data = searchResults.getItems();
        //data.addAll(results);
    }
    
}
