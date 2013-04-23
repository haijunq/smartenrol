/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.dashboard;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.javafxdata.control.TableViewFactory;
import smartenrol.dao.MessageDAO;
import smartenrol.dao.StudentCoursePermissionDAO;

import smartenrol.model.Message;

import smartenrol.model.User;
import smartenrol.model.view.MessageTable;

import smartenrol.page.SmartEnrolController;
import smartenrol.page.elements.dialog.OpenDialog;

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
    Button processbtn;

    @FXML
    public void init() {
        processbtn.setDisable(true);
    
        User.Type usertype = getUserSession().getCurrentUser().getUsertype();
        currentUser = getUserSession().getCurrentUser();
        if (usertype.equals(User.Type.ADMINISTRATOR)) {
            setSidebarEnabled(false);
            processbtn.setVisible(true);
        } else {
            setSidebarEnabled(true);
            processbtn.setVisible(false);
        }
        welcomeMsg.setText("Welcome back, " + currentUser.getGivenName() + "!");
        populateMessageList();
        setMessageTableView();
        innerContent.setCenter(tableView);
       

    }

    private void populateMessageList() {
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
      
    }
    
    public void processRequest()
    {
//        System.out.println("Processing...");
//        String[] result = (((MessageTable) tableView.getSelectionModel().getSelectedItem()).parseEnrolRequest());
//                        for (int i = 0; i < result.length; i++) {
//                            System.out.println(result[i]);
//                        }
        MessageTable selected=(MessageTable) tableView.getSelectionModel().getSelectedItem();
        if (!(selected == null)) 
        {
            String[] data = selected.parseEnrolRequest();
            String confirmmsg="";
            int r = 0;
            if (data.length == 4) 
            {
                r = new StudentCoursePermissionDAO().addStudentSpecialPermission(selected.getSenderID(), data[1], Integer.parseInt(data[2]), data[0]);
            }
            if (r == 1) 
            {
                
                new OpenDialog("The following request has been processed\n" + selected.getMessage()).display();
                System.out.println(messagedao.markMessageAsProcessed(selected.getId()));
                refreshTable();
                confirmmsg="Your request for ["+data[1]+" "+data[2]+" "+data[3]+"] has been approved.";
                System.out.println(messagedao.sendMessage(currentUser.getIdUser(), selected.getSenderID(), confirmmsg));
            }
        }
        else
            System.out.println("no selection");
            
       
        
    }
    
    private void refreshTable()
    {
        populateMessageList();
        tableView.setItems(FXCollections.observableList(messageTableList));
        innerContent.setCenter(tableView);
    }
    
    private void setMessageTableView() {
        tableView = new TableView<>();

       
        TableColumn dateCol = new TableColumn("Date");
        TableColumn idCol = new TableColumn("From ID");
        TableColumn nameCol = new TableColumn("From Name");
        TableColumn messageCol = new TableColumn("Message");
        TableColumn statusCol = new TableColumn("Status");
        
        messageCol.setMinWidth(200);
        dateCol.setMinWidth(80);
        idCol.setMinWidth(80);
        nameCol.setMinWidth(80);
        statusCol.setMinWidth(80);
        tableView.setItems(FXCollections.observableList(messageTableList));
   
        dateCol.setCellValueFactory(
                new PropertyValueFactory<MessageTable, String>("date"));
        idCol.setCellValueFactory(
                new PropertyValueFactory<MessageTable, Integer>("senderID"));
        nameCol.setCellValueFactory(
                new PropertyValueFactory<MessageTable, String>("senderName"));
        messageCol.setCellValueFactory(
                new PropertyValueFactory<MessageTable, String>("message"));
        statusCol.setCellValueFactory(
                new PropertyValueFactory<MessageTable, String>("status"));
     
        tableView.getColumns().setAll(statusCol, dateCol, idCol, nameCol, messageCol);
        tableView.setEditable(false);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
       
        if (!messageTableList.isEmpty()) {
            tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent me) {
                    if (me.getClickCount() > 0) {
                        MessageTable selected = (MessageTable) tableView.getSelectionModel().getSelectedItem();
                        if (!(selected == null)) {
                            //speical approval
                            if (!selected.isProcessed()) {
                                if (selected.isSpeicialApproval()) {
                                    processbtn.setDisable(false);
                                } else {
                                    processbtn.setDisable(true);
                                }
                                //change status to read
                                if (selected.isNew()) {
                                    int r = new MessageDAO().markMessageAsRead(selected.getId());
                                    refreshTable();
                                }
                            } else {
                                processbtn.setDisable(true);
                            }
                        }


                    }
                }
            });
        }
        
    }
}
