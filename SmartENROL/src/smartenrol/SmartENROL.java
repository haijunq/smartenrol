/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol;

import java.io.InputStream;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.layout.AnchorPane;
import smartenrol.page.PageController;
import smartenrol.SmartEnrolFactory;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
 
/**
 * The SmartENROL application is an enrolment software that allows students to 
 * register in classes and for instructors and administrators to manage
 * enrolment information.
 * @author Peter Lee
 * @author Terry Liu
 * @author Haijun Qiao
 * @author Ashwin Raju
 * @author Jeremy Wallace
 * @author Mohsin Yasin
 */
public class SmartENROL extends Application {
    
    private Stage stage;
    
    // Dimensions of the application
    private final double MINIMUM_WINDOW_WIDTH = 800;
    private final double MINIMUM_WINDOW_HEIGHT = 600.0;
    
   /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Application.launch(SmartENROL.class, (java.lang.String[])null);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        AnnotationConfigApplicationContext context 
        = new AnnotationConfigApplicationContext(SmartEnrolFactory.class);

        PageController sampleController = context.getBean(PageController.class);
        Scene scene = new Scene((Parent) sampleController.getView(), MINIMUM_WINDOW_WIDTH, MINIMUM_WINDOW_HEIGHT);
        scene.getStylesheets().add("css/SmartENROL.css");
        stage.setScene(scene);
        stage.setTitle("SmartENROL System");
        stage.show();
    
    }
       
    /*
    private Initializable replaceSceneContent(String fxml) throws Exception {
        
        FXMLLoader loader = new FXMLLoader();
        InputStream in = SmartENROL.class.getResourceAsStream(fxml);
        
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(SmartENROL.class.getResource(fxml));
        
        AnchorPane page;
        
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        } 
        
        Scene scene = new Scene(page, 800, 600);
        stage.setScene(scene);
        stage.sizeToScene();
        
        scene.getStylesheets().add("css/SmartENROL.css");
        
        return (Initializable) loader.getController();
    }
   */
}
