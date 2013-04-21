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
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.LabelBuilder;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorInput;
import javafx.stage.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.paint.Color;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import smartenrol.page.Navigator;
 
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
    
    public static void main(String[] args)
    {

        launch(args);
    }

    public void start(Stage stage) throws Exception
    {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(SmartEnrolFactory.class);
        
        Navigator mainController = context.getBean(Navigator.class);
        
        Scene scene = new Scene((Parent) mainController.getView(), MINIMUM_WINDOW_WIDTH, MINIMUM_WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.getIcons().add(new Image("/smartenrol/images/se-logo-arrows.png"));
        scene.getStylesheets().add("/smartenrol/css/se-styles.css");
        stage.setTitle("Welcome to SmartENROL!");
        mainController.init();
        stage.show();
        
        /*Blend blend = new Blend();
        blend.setMode(BlendMode.COLOR_BURN);
        ColorInput colorInput = new ColorInput();
        colorInput.setPaint(Color.STEELBLUE);
        blend.setTopInput(colorInput);
        stage.getScene().getRoot().setEffect(blend);
        modalPopup();*/
        //ErrorDialog error = new ErrorDialog();
 
    }
    
    public void loading() {
        final Stage dialog = new Stage(StageStyle.TRANSPARENT);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(stage);
        dialog.setScene(
          new Scene(
            HBoxBuilder.create().styleClass("modal-dialog").children(
              LabelBuilder.create().text("Will you like this page?").build(),
              ButtonBuilder.create().text("Yes").defaultButton(true).onAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent actionEvent) {
                  stage.getScene().getRoot().setEffect(null);
                  dialog.close();
                }
              }).build(),
              ButtonBuilder.create().text("No").cancelButton(true).onAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent actionEvent) {
                  // abort action and close the dialog.
                  stage.getScene().getRoot().setEffect(null);
                  dialog.close();
                }
              }).build()
            ).build()
            , Color.TRANSPARENT
          )
        );
        dialog.getScene().getStylesheets().add(getClass().getResource("/smartenrol/css/modal-dialog.css").toExternalForm());
        dialog.show();
    }
       
}
