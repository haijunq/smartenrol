/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.dashboard;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.javafxdata.control.TableViewFactory;
import smartenrol.page.AbstractController;


public class DashboardController extends AbstractController
{
//    ArrayList<Message> messageList = new ArrayList<>();
	
	@FXML BorderPane innerContent;
	@FXML Text welcomeMsg;
	
    public void test() {
        
    }
    
	@FXML
    public void init() {
        
		welcomeMsg.setText("Welcome back, " + getUserSession().getCurrentUser().getGivenName() + "!");

//		TableView tableViewFrom = TableViewFactory.
//				create(Message.class, messageList).
//				selectColumns("Date", "From", "Message").	
//				buildTableView();
//		
//		tableViewFrom.setEditable(false);
//		
//		innerContent.setCenter(tableViewFrom);
    
	}
    
	
}