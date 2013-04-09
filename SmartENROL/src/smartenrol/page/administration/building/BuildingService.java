package smartenrol.page.administration.building;

import java.util.Map;

import smartenrol.SmartEnrolException;
import smartenrol.dao.BuildingDAO;

import smartenrol.model.Building;

public class BuildingService {

    private final Map<String, String> userInputValueHolder;
    private final BuildingDAO buildingDAO;

    public BuildingService(final Map<String, String> userInputValueHolder) {
        this.userInputValueHolder = userInputValueHolder;
        buildingDAO = new BuildingDAO();
    }

    public String insertBuilding() throws SmartEnrolException {
        final BuildingValidator buildingValidator = new BuildingValidator();
        buildingValidator.validate(userInputValueHolder);
        final Building building = new Building();
        updateBuildingFromUserInput(building);
        final Integer rowUpdateCount = buildingDAO.addBuilding(building);
        String message = "";
        if (rowUpdateCount == 0) {
            message = "Insertion Failed.";
        } else {
            message = "Insertion Successful.";
            return message;
        }
        return message;
    }

    public String updateBuilding() throws SmartEnrolException {
        final BuildingValidator buildingValidator = new BuildingValidator();
        buildingValidator.validate(userInputValueHolder);
        final Building building = new Building();
        updateBuildingFromUserInput(building);
        updateBuildingFromUserInput(building);
        final Integer rowUpdateCount = buildingDAO.updateBuilding(building);
        String message = "";
        if (rowUpdateCount == 0) {
            message = "Updation Failed.";
        } else {
            message = "Updation Successful.";
        }
        return message;
    }

    private void updateBuildingFromUserInput(final Building building) {
        building.setIdLocation(userInputValueHolder.get(IBuildingServiceConstants.ID_LOCATION));
        building.setBuildingName(userInputValueHolder.get(IBuildingServiceConstants.NAME));
        building.setAddr1(userInputValueHolder.get(IBuildingServiceConstants.ADDRESS_1));
        building.setAddr2(userInputValueHolder.get(IBuildingServiceConstants.ADDRESS_2));
        building.setCity(userInputValueHolder.get(IBuildingServiceConstants.CITY));
        building.setCountry(userInputValueHolder.get(IBuildingServiceConstants.COUNTRY));
        building.setPostalCode(userInputValueHolder.get(IBuildingServiceConstants.POSTAL_CODE));
        building.setNotes(userInputValueHolder.get(IBuildingServiceConstants.NOTES));
        building.setProvince(userInputValueHolder.get(IBuildingServiceConstants.PROVINCE));
    }
}
