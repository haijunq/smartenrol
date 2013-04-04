/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol;
import javafx.fxml.FXMLLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import smartenrol.page.*;
import smartenrol.page.coursePage.*;
import smartenrol.page.administration.building.*;
import smartenrol.page.dashboard.*;
import smartenrol.page.login.*;

/**
 * @author Jeremy
 */
@Configuration
public class SmartEnrolFactory {
    
    @Bean
    public PageController mainController() throws IOException
    {
        return (PageController) loadController("page/Page.fxml");
    }
    
    @Bean
    public CoursePageController coursePage() throws IOException
    {
        return (CoursePageController) loadController("page/coursePage/CoursePage.fxml");
    }

    @Bean
    public DashboardController dashboard() throws IOException
    {
        return (DashboardController) loadController("page/dashboard/Dashboard.fxml");
    }

    @Bean
    public AddBuildingController addBuilding() throws IOException
    {
        return (AddBuildingController) loadController("page/administration/building/AddBuilding.fxml");
    }    
    
    @Bean
    public LoginController login() throws IOException
    {
        return (LoginController) loadController("page/login/Login.fxml");
    }
    
    protected Object loadController(String url) throws IOException
    {
        try
        (InputStream fxmlStream = getClass().getResourceAsStream(url)) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(url));
            loader.load(fxmlStream);
            return loader.getController();
        }
    }
    
   }
