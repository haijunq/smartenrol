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
import smartenrol.dao.MessageDAO;
import smartenrol.model.Message;
import smartenrol.model.User;
import smartenrol.page.SmartEnrolController;
import smartenrol.security.UserSession;


public class DashboardController extends SmartEnrolController
{
	private final MessageDAO messagedao = new MessageDAO();
	
	private User currentUser;
	
	ArrayList<Message> messageList = new ArrayList<>();
	
	@FXML BorderPane innerContent;
	@FXML Text welcomeMsg;
	
	public void test() {
		
	}
	
	@FXML
	public void init() {
		
		currentUser = UserSession.getInstance().getCurrentUser();
		welcomeMsg.setText("Welcome back, " + currentUser.getGivenName() + "!");
		messageList = messagedao.getMessageByRecepient(currentUser.getIdUser());
		
		if (!messageList.isEmpty()) {

			TableView tableViewFrom = TableViewFactory.
					create(Message.class, messageList).
					selectColumns("Date", "Sender ID", "Message").
					renameColumn("Sender ID", "From").
					buildTableView();
			
			tableViewFrom.setEditable(false);
			
			innerContent.setCenter(tableViewFrom);
		}
	}
}
