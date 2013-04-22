/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.dashboard;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.javafxdata.control.TableViewFactory;
import smartenrol.dao.MessageDAO;

import smartenrol.model.Message;

import smartenrol.model.User;
import smartenrol.model.view.MessageTable;

import smartenrol.page.SmartEnrolController;

public class DashboardController extends SmartEnrolController {

    private final MessageDAO messagedao = new MessageDAO();
    private User currentUser;
    private TableView tableView = null;
    ArrayList<Message> messageList = new ArrayList<>();
    ArrayList<MessageTable> messageTableList = new ArrayList<>();
    @FXML
    BorderPane innerContent;
    @FXML
    Text welcomeMsg;
    @FXML
    Text noMsg;

    @FXML
    public void init() {
        messageList.clear();
        User.Type usertype = getUserSession().getCurrentUser().getUsertype();
        currentUser = getUserSession().getCurrentUser();
        if (usertype.equals(User.Type.ADMINISTRATOR)) {
            setSidebarEnabled(false);
        } else {
            setSidebarEnabled(true);
        }
        welcomeMsg.setText("Welcome back, " + currentUser.getGivenName() + "!");
        messageList.clear();
        messageList = messagedao.getMessageByRecepient(currentUser.getIdUser());

        if (!messageList.isEmpty()) {
            messageTableList.clear();
            for (Message m : messageList) {
                messageTableList.add(new MessageTable(m));
            }
            noMsg.setText("");
        } else {
            messageTableList = new ArrayList<>();
            noMsg.setText("Your message box is empty!");

        }
        setMessageTableView();
        innerContent.setCenter(tableView);

    }

    private void setMessageTableView() {
//        tableView=null;

        tableView = new TableView<>();

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TableColumn dateCol = new TableColumn("Date");
        TableColumn idCol = new TableColumn("From ID");
        TableColumn nameCol = new TableColumn("From Name");
        TableColumn messageCol = new TableColumn("Message");
        messageCol.setMinWidth(200);

        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                if (me.getClickCount() > 1) {
//                    navigator.loadSelectedItem(tableView, "program");
                    if (((MessageTable) tableView.getSelectionModel().getSelectedItem()).isSpeicialApproval())
                    {
                        String[] result = (((MessageTable) tableView.getSelectionModel().getSelectedItem()).parseEnrolRequest());
                        for (int i = 0; i < result.length; i++) {
                            System.out.println(result[i]);
                        }
                    }
                   
                }
            }
        });

        dateCol.setCellValueFactory(
                new PropertyValueFactory<MessageTable, String>("date"));
        idCol.setCellValueFactory(
                new PropertyValueFactory<MessageTable, Integer>("senderID"));
        nameCol.setCellValueFactory(
                new PropertyValueFactory<MessageTable, String>("senderName"));
        messageCol.setCellValueFactory(
                new PropertyValueFactory<MessageTable, String>("message"));

        tableView.setItems(FXCollections.observableList(messageTableList));

        tableView.getColumns().setAll(dateCol, idCol, nameCol, messageCol);

        tableView.setEditable(false);
    }
}
