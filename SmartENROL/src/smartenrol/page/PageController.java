/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smartenrol.page;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
 
public class PageController
{
    @FXML private Parent view;
    @FXML private BorderPane contentArea;
 
    @Autowired private ContentPaneController contentPaneController;
    //@Autowired private CoursePageController coursePageController;
    
    public Parent getView()
    {
        return view;   
    }
    
    @FXML
    public void showPage()
    {
        //courseController = new CoursePageController("CICS",520);
        contentArea.setCenter(contentPaneController.getView());
    }
    
    /*@FXML
    public void showCoursePage()
    {
        coursePageController = new CoursePageController("CICS",520);
        contentArea.setCenter(coursePageController.getView());
    }*/
 
}