/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.myProgram;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import org.javafxdata.control.TableViewFactory;
import smartenrol.model.Course;
import smartenrol.page.AbstractController;

/**
 *
 * @author Jeremy
 */
public class MyProgramPageController extends AbstractController {
    
    @FXML BorderPane innerContent;
    
    public void init() {
        
       ArrayList<Course> courseList = new ArrayList<>();
       
       courseList.add(new Course("CICS",505,6,"Intro to Computer Systems"));
       courseList.add(new Course("CICS",520,3,"Databases"));
       courseList.add(new Course("CICS",511,(float)1.50,"Computational Structures"));
       
       TableView tableView = TableViewFactory.
         create(Course.class, courseList).
         renameColumn("Id Department", "Dept").
         renameColumn("Id Course", "Num").
         buildTableView();
       
       innerContent.setCenter(tableView);
        
    }
    
}
