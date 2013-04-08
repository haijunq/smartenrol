/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.myprofile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.javafxdata.control.TableViewFactory;
import smartenrol.dao.UserDAO;
import smartenrol.model.User;
import smartenrol.page.SmartEnrolController;
import smartenrol.security.UserSession;

/**
 *
 * @author Jeremy
 */

public class MyProfileController extends SmartEnrolController {
    
    @FXML private Text email;
    @FXML private Text addr1;
    @FXML private Text addr2;
    @FXML private Text username;
    @FXML private Text name;
    @FXML private Text program;


    @Override
    public void init() {
       

    }
public void loadProfile()
{
 User userByID = UserSession.getInstance().getCurrentUser();
        email.setText(userByID.getEmail());
        name.setText(userByID.getFullName());
        addr1.setText(userByID.getAddr1());
        addr2.setText(userByID.getCity()+", "+userByID.getCountry());
        username.setText(userByID.getUsername());
        program.setText(userByID.getUsertype());
}
@FXML
public void changePassword(ActionEvent event)
{
    username.setText("Change Password clicked");
}
}
    
