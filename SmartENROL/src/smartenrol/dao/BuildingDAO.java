/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import smartenrol.UniqueConstraintException;
//import static smartenrol.dao.SmartEnrolDAO.ps;
import smartenrol.model.Building;
import smartenrol.model.Course;

/**
 *
 * @author Jeremy
 */
public class BuildingDAO extends SmartEnrolDAO {

    public BuildingDAO() {
        super();
    }

    /**
     * Add building method is used in the building controller to create
     * buildings
     */
    public int addBuilding(Building building) throws UniqueConstraintException {
        this.initConnection();
        int count = 0;
        try {
            ps = conn.prepareStatement("INSERT INTO Buidling VALUES (?, ?, ?, ?, ?, 'Canada', ? ,'', ?");
            ps.setString(1,building.getIdLocation());
            ps.setString(2, building.getAddr1());
            ps.setString(3, building.getAddr2());
            ps.setString(4, building.getCity());
            ps.setString(5, building.getProvince());
            ps.setString(6, building.getPostalCode());
            ps.setString(7, building.getBuildingName());
            count = ps.executeUpdate();
            conn.commit();
            this.psclose();
            return count;

        } catch (SQLException sqlex) {
             if (sqlex.getErrorCode() == 1169) {
                throw new UniqueConstraintException("Duplicate entries are not allowed from insertion in this table");
            }
            System.err.println("SQLException: " + sqlex.getMessage());
            try {
                conn.rollback();
            } catch (SQLException sqlex2) {
                System.err.println("SQLException: " + sqlex2.getMessage());
            }
            this.psclose();
            return 0;
        }
    }

    public int updateBuilding(final Building building) {
        this.initConnection();
        int count = 0;
        try {
            ps = conn.prepareStatement("UPDATE Building SET Addr1 = ?, Addr2 = ?,City = ?,Province = ?,Country = ?,PostalCode = ?,Notes = ?,BuildingName = ? WHERE IDLocation = ?");
            ps.setString(1, building.getAddr1());
            ps.setString(2, building.getAddr2());
            ps.setString(3, building.getCity());
            ps.setString(4, building.getProvince());
            ps.setString(5, building.getCountry());
            ps.setString(6, building.getPostalCode());
            ps.setString(7, building.getNotes());
            ps.setString(8, building.getBuildingName());
            ps.setString(9, building.getIdLocation());
            count = ps.executeUpdate();
            conn.commit();
            this.psclose();
            return count;
        } catch (final SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            try {
                conn.rollback();
            } catch (final SQLException sqlex2) {
                System.err.println("SQLException: " + sqlex2.getMessage());
            }
            this.psclose();
            return count;
        }
    }

/**
     * Return a list of all buildings
     * @return Arraylist of buildings
     */
    public ArrayList<Building> getAllBuilding() {
        this.initConnection();
        ArrayList<Building> buildingList = new ArrayList<>();
        
        try {

            ps = conn.prepareStatement("SELECT idLocation FROM Building");
            rs = ps.executeQuery();

        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }


        // parse the resultset
        try {
            while (rs.next()) 
                buildingList.add(new Building(rs.getString("idLocation")));
            
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return buildingList;
    }
    
	/**
     * get building by idLocation
     *
     * @param String idLocation
     * @return Building
     *
     */
    public Building getBuildingbyID(String idLocation) {
        this.initConnection();
        Building building = new Building();

        try {
            ps = conn.prepareStatement("SELECT * FROM Building WHERE idLocation = ?");
            ps.setString(1, idLocation);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                building.setIdLocation(rs.getString("idLocation"));
                building.setAddr1(rs.getString("addr1"));
                building.setAddr2(rs.getString("addr2"));
                building.setCity(rs.getString("city"));
                building.setProvince(rs.getString("province"));
                building.setCountry(rs.getString("country"));
                building.setPostalCode(rs.getString("postalCode"));
                building.setNotes(rs.getString("notes"));
                building.setBuildingName(rs.getString("buildingName"));
            }

        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }

        this.psclose();
        return building;
    }

}
