/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page;

import java.sql.Timestamp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author Jeremy
 */
public class FormController extends SmartEnrolController {
        
        @FXML protected ScrollPane contentArea;
        @FXML private Pane errorBox;
        @FXML private Text notifyText, formName, lastUpdated, lastModifiedBy, dateCreated, subTitleText;
        /**
        *
        * @param form
        */
       public void init() {
                java.util.Date date= new java.util.Date();
                setLastUpdated(new Timestamp(date.getTime()).toString());
                setDateCreated(new Timestamp(date.getTime()).toString());
                setModBy(getUserSession().getCurrentUser().getFullName());
       }
        
        public void resetErrors() {
            notifyText.setVisible(false);
        }
        
        public ScrollPane getInternalView() {
            return contentArea;
        }

        public void showErrors(String errorMsg) {
            
            if (notifyText==null) 
                notifyText.setText("Errors were found. Please check your input.");
            else 
                notifyText.setText(errorMsg);
            
            notifyText.setFill(Color.RED);
            notifyText.setVisible(true);
            errorBox.setVisible(true);
        }

        public void confirmPost(String confirmMsg) {
            if (notifyText==null) 
                notifyText.setText("Record successfully modified.");
            else 
                notifyText.setText(confirmMsg);
            notifyText.setFill(Color.GREEN);
            notifyText.setVisible(true);
            errorBox.setVisible(true);
        }
     
        public void setFormName(String name) {
            this.formName.setText(name);
        }
        
        public void setLastUpdated(String lastUpdated) {
            this.lastUpdated.setText(lastUpdated);
            
        }
        
        public void setModBy(String lastModBy) {
            this.lastModifiedBy.setText(lastModBy);
        }
        
        public void setDateCreated(String dateCreated) {
            this.dateCreated.setText(dateCreated);
        }
        
        @FXML
        public void submit(ActionEvent event){
            
        }
        
        public void setSubTitleText(String subTitle) {
            this.subTitleText.setText(subTitle);
            this.subTitleText.setFill(Color.DARKGRAY);
        }
        
        public void setConfirmTitleText(String subTitle) {
            this.subTitleText.setText(subTitle);
            this.subTitleText.setFill(Color.GREEN);
        }
        
}
