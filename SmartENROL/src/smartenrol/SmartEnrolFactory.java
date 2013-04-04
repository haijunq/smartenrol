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
    public ContentPaneController contentPane() throws IOException
    {
        return (ContentPaneController) loadController("page/ContentPane.fxml");
    }
    
    /*@Bean
    public CoursePageController coursePage() throws IOException
    {
        return (CoursePageController) loadController("page/CoursePage.fxml");
    } */   

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
