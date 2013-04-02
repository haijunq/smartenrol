/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.administration.building;

/**
 *
 * @author Jeremy
 */
public class AddBuildingController {
 
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
            
}