/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.entities.building;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.javafxdata.control.TableViewFactory;
import smartenrol.dao.BuildingDAO;
import smartenrol.model.Building;
import smartenrol.page.SmartEnrolController;

/**
 *
 * @author MrAtheist
 */
public class BuildingPageController extends SmartEnrolController {
	
	BuildingDAO buildingdao = new BuildingDAO();
	Building building;
	ArrayList<Building> buildingList = new ArrayList<>();
	
	@FXML BorderPane innerContent;
	@FXML Text fxBuildingName;
	@FXML Text fxBuildingAddress;
	
	@Override
	public void init() {
		
		System.out.println("Entering Building Directory");
	}
	
	public void load(String idLocation) {
		
		building = new BuildingDAO().getBuildingbyID(idLocation);
		
		if (building != null) {
			
			fxBuildingName.setText(building.getBuildingName());
			fxBuildingAddress.setText(building.getAddr1() + ", " +
									  building.getAddr2() + ", " +
									  building.getCity() + ", \n" +
									  building.getProvince() + ", " +
					  				  building.getCountry() + ", " +
									  building.getPostalCode());
			
		}
	}
}
