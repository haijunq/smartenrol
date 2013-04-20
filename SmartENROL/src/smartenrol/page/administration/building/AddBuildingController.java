/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.administration.building;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import smartenrol.SmartEnrolException;
import smartenrol.page.SmartEnrolController;


/**
 *
 * @author Jeremy
 */
public class AddBuildingController extends SmartEnrolController {

    @FXML
    private Node view;
    @FXML
    TextField buildingName;
    @FXML
    TextField buildingCode;
    @FXML
    TextField addr1;
    @FXML
    TextField addr2;
    @FXML
    TextField city;
    @FXML
    TextField postalCode;
    @FXML
    ComboBox province;

    public void init() {
        setSidebarEnabled(true);
    }
    
    public Node getView() {
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

    @FXML
    private void submitForm(MouseEvent event) throws Exception {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();
            userInputValueHolder.put(IBuildingServiceConstants.ID_LOCATION, buildingCode.getText());
            userInputValueHolder.put(IBuildingServiceConstants.NAME, buildingName.getText());
            userInputValueHolder.put(IBuildingServiceConstants.PROVINCE, String.valueOf(province.getValue()));
            userInputValueHolder.put(IBuildingServiceConstants.ADDRESS_1, addr1.getText());
            userInputValueHolder.put(IBuildingServiceConstants.ADDRESS_2, addr2.getText());
            userInputValueHolder.put(IBuildingServiceConstants.CITY, city.getText());
            userInputValueHolder.put(IBuildingServiceConstants.POSTAL_CODE, postalCode.getText());
            final BuildingService buildingService = new BuildingService(userInputValueHolder);
            buildingService.insertBuilding();
        } catch (SmartEnrolException ex) {
            Logger.getLogger(AddBuildingController.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
    }
        @Override
    public void load() {

    }
}
