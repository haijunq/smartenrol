/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import smartenrol.model.Building;

/**
 *
 * @author Aishwarya
 */
public class BuildingDAOTest {

    public BuildingDAOTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testAddBuilding() throws Exception {
        Building building = new Building();
        BuildingDAO instance = new BuildingDAO();
        int expResult = 0;
        building.setIdLocation("123456789");
        building.setBuildingName("Sample Test");
        building.setAddr1("SOME_ADDRESS1");
        building.setAddr2("SOME_ADDRESS2");
        building.setCity("SOME_CITY");
        building.setCountry("SOME_COUNTRY");
        building.setPostalCode("12345");
        building.setNotes("sample");
        building.setProvince("SOME_PROVINCE");
        int result = instance.addBuilding(building);
        assertNotNull(result);
    }

    @Test
    public void testUpdateBuilding() {
        Building building = new Building();
        BuildingDAO instance = new BuildingDAO();
        building.setIdLocation("123456789");
        building.setBuildingName("Sample Test");
        building.setAddr1("SOME_ADDRESS1_UPDT");
        building.setAddr2("SOME_ADDRESS2");
        building.setCity("SOME_CITY");
        building.setCountry("SOME_COUNTRY");
        building.setPostalCode("12345");
        building.setNotes("sample");
        building.setProvince("SOME_PROVINCE");
        int result = instance.updateBuilding(building);
        assertNotNull(result);
    }

    @Test
    public void testGetAllBuilding() {
        BuildingDAO instance = new BuildingDAO();
        assertNotNull(instance.getAllBuilding());
    }

    @Test
    public void testGetBuildingbyID() {
        String idLocation = "123456789";
        BuildingDAO instance = new BuildingDAO();
        assertNotNull(instance.getBuildingbyID(idLocation));
    }
}