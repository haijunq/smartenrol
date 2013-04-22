/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.dashboard;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.javafxdata.control.TableViewFactory;
import smartenrol.dao.MessageDAO;
import smartenrol.model.Message;
import smartenrol.model.User;
import smartenrol.page.SmartEnrolController;


public class DashboardController extends SmartEnrolController
{
	private final MessageDAO messagedao = new MessageDAO();
	
	private User currentUser;
	
	ArrayList<Message> messageList = new ArrayList<>();
	
	@FXML BorderPane innerContent;
	@FXML Text welcomeMsg;
	@FXML Text noMsg;
	
        @FXML
	public void init() {
            messageList.clear();
            User.Type usertype = getUserSession().getCurrentUser().getUsertype();
            currentUser = getUserSession().getCurrentUser();
            if (usertype.equals(User.Type.ADMINISTRATOR))
                setSidebarEnabled(false);
            else 
                setSidebarEnabled(true);
                
            welcomeMsg.setText("Welcome back, " + currentUser.getGivenName() + "!");
            messageList = messagedao.getMessageByRecepient(currentUser.getIdUser());
		
		if (!messageList.isEmpty()) {
			
			TableView tableView = TableViewFactory.
					create(Message.class, messageList).
					selectColumns("Date", "Sender ID", "Message").
					renameColumn("Sender ID", "From").
					buildTableView();
			
			tableView.setEditable(false);
			
			innerContent.setCenter(tableView);
			noMsg.setText("");
			
		} else
			
			noMsg.setText("Your message box is empty!");
	}
}
