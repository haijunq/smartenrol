/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Jeremy
 */
public class SmartENROL extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Image smartLogo = new Image("img/smartenrol.jpg", true);
        
        ImageView logoView = new ImageView();
        logoView.setImage(smartLogo);
        StackPane root = new StackPane();
        root.getChildren().add(logoView);
        
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add("css/se_styles.css");
        
        primaryStage.setTitle("SmartENROL Course Registration System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
