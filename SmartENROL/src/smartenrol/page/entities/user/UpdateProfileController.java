/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.entities.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.dao.UserDAO;
import smartenrol.model.User;
import smartenrol.page.SmartEnrolController;
import smartenrol.security.UserSession;

/**
 *
 * @author Jeremy
 */
public class UpdateProfileController extends SmartEnrolController {

    @FXML private TextField username;
    @FXML private TextField addr1;
    @FXML private TextField email;
    @FXML private TextField phone;
    
@Override
        public void init() {
        User userByID = UserSession.getInstance().getCurrentUser();
        username.setText(userByID.getUsername()); 
        username.setDisable(true);
        addr1.setText(userByID.getAddr1());
        email.setText(userByID.getEmail());
        phone.setText(userByID.getPhone());
        
       }
        
 @FXML
    public void UpdateProfile(ActionEvent event)
    {
       User userByID = UserSession.getInstance().getCurrentUser();
      
        userByID.setAddr1(addr1.getText());
        userByID.setEmail(email.getText());
        userByID.setPhone(phone.getText());
        new UserDAO().updateProfile(userByID);
        
    }
}