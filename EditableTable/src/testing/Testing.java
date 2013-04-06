/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
/**
 *
 * @author Graham Smith
 */
public class Testing extends Application {
    private TableView table = new TableView();
    private final ObservableList<Person> data =
            FXCollections.observableArrayList(
            new Person(true, "Jacob", "Smith", "jacob.smithexample.com", "jsexample.com", 26),
            new Person(true, "Isabella", "Johnson", "isabella.johnsonexample.com", "ijexample.com", 19),
            new Person(true, "Ethan", "Williams", "ethan.williamsexample.com", "ewexample.com", 56),
            new Person(true, "Emma", "Jones", "emma.jonesexample.com", "ejexample.com", 44),
            new Person(false, "Michael", "Brown", "michael.brownexample.com", "mbexample.com", 36));
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(850);
        stage.setHeight(500);
        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));
        //Create a custom cell factory so that cells can support editing.
        Callback<TableColumn, TableCell> editableFactory = new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn p) {
                return new EditableTableCell();
            }
        };
        //A custom cell factory that creates cells that only accept numerical input.
        Callback<TableColumn, TableCell> numericFactory = new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn p) {
                return new NumericEditableTableCell();
            }
        };
        //Create the columns
        TableColumn firstNameCol = createFirstNameColumn(editableFactory);
        TableColumn lastNameCol = createLastNameColumn(editableFactory);
        TableColumn emailCol = createEmailColumns(editableFactory);
        TableColumn ageCol = createAgeColumn(numericFactory);
        //Add the columns and data to the table.
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol, ageCol);
        //Make the table editable
        table.setEditable(true);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.getChildren().addAll(label, table);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();
    }
    private TableColumn createActiveColumn(Callback<TableColumn, TableCell> checkBoxFactory) {
        TableColumn activeCol = new TableColumn("Active");
        activeCol.setMinWidth(25);
        activeCol.setCellValueFactory(new PropertyValueFactory<Person, Boolean>("active"));
        activeCol.setCellFactory(checkBoxFactory);
        activeCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, Boolean>>() {
            @Override
            public void handle(CellEditEvent<Person, Boolean> arg0) {
                for (Person p : data) {
                    p.setActive(!p.isActive());
                }
            }
        });
        return activeCol;
    }
    private TableColumn createFirstNameColumn(Callback<TableColumn, TableCell> editableFactory) {
        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        firstNameCol.setCellFactory(editableFactory);
        //Modifying the firstName property
        firstNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFirstName(t.getNewValue());
            }
        });
        return firstNameCol;
    }
    private TableColumn createLastNameColumn(Callback<TableColumn, TableCell> editableFactory) {
        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        lastNameCol.setCellFactory(editableFactory);
        //Modifying the lastName property
        lastNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLastName(t.getNewValue());
            }
        });
        return lastNameCol;
    }
    private TableColumn createEmailColumns(Callback<TableColumn, TableCell> editableFactory) {
        //Email as a two depth layer header
        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(400);
        TableColumn primaryEmailCol = new TableColumn("Primary Email");
        primaryEmailCol.setMinWidth(200);
        primaryEmailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("primaryEmail"));
        primaryEmailCol.setCellFactory(editableFactory);
        //Make this column un-editable      
        primaryEmailCol.setEditable(false);
        TableColumn secondaryEmailCol = new TableColumn("Secondary Email");
        secondaryEmailCol.setMinWidth(200);
        secondaryEmailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("secondaryEmail"));
        secondaryEmailCol.setCellFactory(editableFactory);
        emailCol.getColumns().addAll(primaryEmailCol, secondaryEmailCol);
        //Modifying the primary email property
        primaryEmailCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPrimaryEmail(t.getNewValue());
            }
        });
        //Modifying the secondary email property
        secondaryEmailCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
            @Override
            public void handle(CellEditEvent<Person, String> t) {
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSecondaryEmail(t.getNewValue());
            }
        });
        return emailCol;
    }
    private TableColumn createAgeColumn(Callback<TableColumn, TableCell> numericFactory) {
        //Age field is set to accept only numeric values.
        TableColumn ageCol = new TableColumn("Age");
        ageCol.setMinWidth(50);
        ageCol.setCellValueFactory(new PropertyValueFactory<Person, String>("age"));
        ageCol.setCellFactory(numericFactory);
        //Modifying the age property
        //This must be a long since that is what is created by the parse operation. If you set it
        //to Integer (as you would expect) you'll get a class cast excepton when you call getNewValue
        //as Long can't be cast to Integer.
        ageCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, Long>>() {
            @Override
            public void handle(CellEditEvent<Person, Long> t) {
                int newAge = t.getNewValue().intValue();
                ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAge(newAge);
            }
        });
         
        return ageCol;
    }
}
