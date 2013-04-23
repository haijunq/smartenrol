/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.image.Image;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import smartenrol.dao.connection.MySQLConnection;
import smartenrol.page.Navigator;
import smartenrol.page.SmartEnrolController;
import smartenrol.page.elements.dialog.ErrorDialog;
import smartenrol.page.elements.dialog.StartupDialog;

 
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
    private Navigator navigator;
    private AnnotationConfigApplicationContext context;
    // Dimensions of the application
    private final double MINIMUM_WINDOW_WIDTH = 800;
    private final double MINIMUM_WINDOW_HEIGHT = 600.0;
    private final int MAX_CONNECTION_ATTEMPTS = 10;
    
   /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage stage) throws Exception
    {
        //try {
            context = new AnnotationConfigApplicationContext(SmartEnrolFactory.class);
            navigator = context.getBean(Navigator.class);
            Scene scene = new Scene((Parent) navigator.getView(), MINIMUM_WINDOW_WIDTH, MINIMUM_WINDOW_HEIGHT);
            stage.setScene(scene);
            stage.getIcons().add(new Image("/smartenrol/images/se-logo-arrows.png"));
            scene.getStylesheets().add("/smartenrol/css/se-styles.css");
            stage.setTitle("Welcome to SmartENROL!");
            navigator.init();
            stage.show();
        /*} catch (RuntimeException ex) {
            ErrorDialog dialog = new ErrorDialog("Error opening application.");
            dialog.acknowledge();
            System.exit(0);
        }*/
    }

       
}
