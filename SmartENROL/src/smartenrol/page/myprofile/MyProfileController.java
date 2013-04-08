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
import smartenrol.page.AbstractController;

/**
 *
 * @author Jeremy
 */

public class MyProfileController extends AbstractController {
    
    @FXML private Text email;
    @FXML private Text addr1;
    @FXML private Text addr2;
    @FXML private Text username;
    @FXML private Text name;


    @Override
    public void init() {
       

    }
public void loadProfile()
{
 User userByID = new UserDAO().getUserByID(77777777);
        email.setText(userByID.getEmail());
        name.setText(userByID.getFullName());
        addr1.setText(userByID.getAddr1());
        addr2.setText(userByID.getCity()+", "+userByID.getCountry());
        username.setText(userByID.getUsername());
}
@FXML
public void changePassword(ActionEvent event)
{
username.setText("Change Password clicked");
}
}
    
