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
import smartenrol.page.OneColumnPageController;
import smartenrol.page.PageController;
 
/**
 *
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
    public OneColumnPageController page1Controller() throws IOException
    {
        return (OneColumnPageController) loadController("page/OneColumnPage.fxml");
    }
 
    protected Object loadController(String url) throws IOException
    {
        try
        (InputStream fxmlStream = getClass().getResourceAsStream(url)) {
            FXMLLoader loader = new FXMLLoader();
            loader.load(fxmlStream);
            return loader.getController();
        }
    }
    
}