/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.entities.user;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.dao.UserDAO;
import smartenrol.model.User;
import smartenrol.page.Navigator;
import smartenrol.page.PageController;
import smartenrol.page.SmartEnrolController;
import smartenrol.security.UserSession;

/**
 *
 * @author Jeremy
 */

public class UserController extends SmartEnrolController {
    
    UserDAO userdao = new UserDAO();
    
    @FXML private Text email;
    @FXML private Text addr1;
    @FXML private Text addr2;
    @FXML private Text username;
    @FXML private Text name;
    @FXML private Text program;
    @FXML private Text phone;
    
    @FXML private Button updateBtn;
    @Autowired private PageController pageController;
    
    @Override
    public void init() {
        

    }
    
    public void load(String idUser) {
        /*if (idUser==getUserSession().getCurrentUser().getIdUser()) {
            email.setText(userByID.getEmail());
            name.setText(userByID.getFullName());
            addr1.setText(userByID.getAddr1());
            addr2.setText(userByID.getCity()+", "+userByID.getCountry());
            username.setText(userByID.getUsername());
            program.setText(userByID.getUsertype().name());
            phone.setText(userByID.getPhone());
        }*/
    }

    
    @FXML
    public void updateProfile(ActionEvent event)
    {
        Navigator navigator = new Navigator();
        navigator.navigate(Page.UPDATE_PROFILE);
    }
}
    
