/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol;

import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import smartenrol.page.Page;

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
    public void start(Stage primaryStage) {
        
            stage = primaryStage;
            stage.setTitle("SmartENROL");
            
            stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            
            openApp();
            primaryStage.show();
    }
    
    /**
     * This method opens the application to the first screen.
     */
    private void openApp() {
        try {
            Page dashboard = (Page) replaceSceneContent("page/Page.fxml");
            dashboard.setApp(this);
        } catch (Exception ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
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
   
}
