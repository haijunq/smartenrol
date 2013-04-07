/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.search;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import org.javafxdata.control.TableViewFactory;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.model.Course;
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
    //@Autowired private SearchTableController searchTableController;

    public void search(String searchQuery) {
       
       resultsPane.setText(0,searchQuery,"course");
       mainSearchField.setText(searchQuery);
       innerContent.setLeft(filterController.getView());
       searchResultsArea.setTop(resultsPane.getView());
       
       ArrayList<Course> courseList = new ArrayList<>();
       
       courseList.add(new Course("CICS",505,6,"Intro to Computer Systems"));
       courseList.add(new Course("CICS",520,3,"Databases"));
       courseList.add(new Course("CICS",511,(float)1.50,"Computational Structures"));
       
       TableView tableView = TableViewFactory.
         create(Course.class, courseList).
         selectColumns("idDeparment", "idCourse", "courseName", "credits").
//         renameColumn("Id Department", "Dept").
//         renameColumn("Id Course", "Num").
         buildTableView();
       
       searchResultsArea.setCenter(tableView);
    
    }
    
    
    /**
     *
     */
    public void allSearch() {
        
    }
    
}
