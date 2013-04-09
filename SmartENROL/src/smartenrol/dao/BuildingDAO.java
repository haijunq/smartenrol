/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.SQLException;
import smartenrol.UniqueConstraintException;
import smartenrol.model.Building;

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
}
