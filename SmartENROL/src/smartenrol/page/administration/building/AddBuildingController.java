/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.administration.building;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import smartenrol.page.AbstractController;

/**
 *
 * @author Jeremy
 */
public class AddBuildingController extends AbstractController {
    
    @FXML private Node view;

    @FXML TextField buildingName;
    @FXML TextField buildingCode;
    @FXML TextField addr1;
    @FXML TextField addr2;
    @FXML TextField city;
    @FXML TextField postalCode;
    @FXML ComboBox province;
    
    public void init() {
        
    }
    
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
