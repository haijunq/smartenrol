/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.administration.building;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Jeremy
 */
public class AddBuildingController {
 /*
    Building newBuilding;
    BuildingDAO buildingDAO;
    
    // Form Elements
    TextBox buildingNameTextBox;
    TextBox address1;
    TextBox address2;
    TextBox city;
    TextBox postalCode;
    TextBox notes;
    
    public verifyPostalCode() {
         
    }
    
    public submitForm(Action event) {
        
        newBuilding.address1 = address1.getText();
        newBuilding.address1 = address2.getText();
        newBuilding.address1 = address2.getText();
        newBuilding.address1 = address2.getText();
        newBuilding.address1 = address2.getText();
        
        buildingDAO.addBuilding(newBuilding);
    }
          */  
    @FXML private Node view;

    @FXML TextField buildingName;
    @FXML TextField buildingCode;
    @FXML TextField addr1;
    @FXML TextField addr2;
    @FXML TextField city;
    @FXML TextField postalCode;
    @FXML ComboBox province;
    
    
    public Node getView()
    {
        return view;
    }
    
    @FXML 
    public void printFormDetails() {
           
        System.out.println(buildingName.getText());
        System.out.println(buildingCode.getText());
        System.out.println(addr1.getText());
        System.out.println(addr2.getText());
        System.out.println(city.getText());
        System.out.println(postalCode.getText());
        
    }
    
}
