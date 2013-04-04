/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smartenrol.page;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import smartenrol.page.coursePage.*;
import smartenrol.page.dashboard.*;
import smartenrol.page.administration.building.*;
import org.springframework.beans.factory.annotation.Autowired;
 
public class PageController
{
    @FXML private Parent view;
    @FXML private BorderPane contentArea;

    @Autowired private CoursePageController coursePageController;
    @Autowired private DashboardController dashboardController;
    @Autowired private AddBuildingController addBuildingController;
    
    public Parent getView()
    {
        return view;   
    }

    @FXML
    public void showPage()
    {
        //courseController = new CoursePageController("CICS",520);
        contentArea.setCenter(dashboardController.getView());
    }
    
    @FXML
    public void showCoursePage()
    {
        //coursePageController = new CoursePageController();
        contentArea.setCenter(coursePageController.getView());
    }
    
    @FXML
    public void addBuilding()
    {
        //coursePageController = new CoursePageController();
        contentArea.setCenter(addBuildingController.getView());
    }
}