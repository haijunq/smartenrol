/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.administration.building;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import smartenrol.SmartEnrolException;

/**
 *
 * @author Aishwarya
 */
public class BuildingServiceTest {

    public BuildingServiceTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of insertBuildingModule method, of class BuildingService.
     */
    @Test
    public void testInsertBuildingModule() {
        try {
            System.out.println("insertBuildingModule");
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();
            userInputValueHolder.put(IBuildingServiceConstants.ID_LOCATION, "SAMPLE");
            userInputValueHolder.put(IBuildingServiceConstants.NAME, "SOME_NAME");
            userInputValueHolder.put(IBuildingServiceConstants.PROVINCE, "SOME_PROVINCE");
            userInputValueHolder.put(IBuildingServiceConstants.ADDRESS_1, "SOME_ADDRESS1");
            userInputValueHolder.put(IBuildingServiceConstants.ADDRESS_2, "SOME_ADDRESS2");
            userInputValueHolder.put(IBuildingServiceConstants.CITY, "SOME_CITY");
            userInputValueHolder.put(IBuildingServiceConstants.POSTAL_CODE, "123456");
            userInputValueHolder.put(IBuildingServiceConstants.NOTES, "TEST");
            userInputValueHolder.put(IBuildingServiceConstants.COUNTRY, "SOME_COUNTRY");
            final BuildingService buildingService = new BuildingService(userInputValueHolder);
            buildingService.insertBuilding();
        } catch (SmartEnrolException ex) {
            Logger.getLogger(BuildingServiceTest.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
    }

    /**
     * Test of updateBuildingModule method, of class BuildingService.
     */
    @Test
    public void testUpdateBuildingModule() {
        try {
            System.out.println("updateBuildingModule");
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();
            userInputValueHolder.put(IBuildingServiceConstants.ID_LOCATION, "SAMPLE");
            userInputValueHolder.put(IBuildingServiceConstants.NAME, "SOME_NAME");
            userInputValueHolder.put(IBuildingServiceConstants.PROVINCE, "SOME_PROVINCE_UPDATE_DEMO");
            userInputValueHolder.put(IBuildingServiceConstants.ADDRESS_1, "SOME_ADDRESS1");
            userInputValueHolder.put(IBuildingServiceConstants.ADDRESS_2, "SOME_ADDRESS2");
            userInputValueHolder.put(IBuildingServiceConstants.CITY, "SOME_CITY");
            userInputValueHolder.put(IBuildingServiceConstants.POSTAL_CODE, "123456");
            userInputValueHolder.put(IBuildingServiceConstants.NOTES, "TEST");
            userInputValueHolder.put(IBuildingServiceConstants.COUNTRY, "SOME_COUNTRY");
            final BuildingService buildingService = new BuildingService(userInputValueHolder);
            buildingService.updateBuilding();
        } catch (SmartEnrolException ex) {
            Logger.getLogger(BuildingServiceTest.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
    }
}