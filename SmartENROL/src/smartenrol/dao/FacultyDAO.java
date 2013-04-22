/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.SQLException;
import smartenrol.model.Faculty;
import smartenrol.UniqueConstraintException;

/**
 *
 * @author Terry Liu
 */
public class FacultyDAO extends SmartEnrolDAO {

    public FacultyDAO() {
        super();
    }

    public int addFaculty(Faculty faculty) throws UniqueConstraintException {
        this.initConnection();
        int count = 0;
        try {
            ps = conn.prepareStatement("INSERT INTO faculty (idFaculty,deanID,description,mainContactID,mainPhone,name,headOfficeLocationID) VALUES (?,?,?,?,?,?,?);");
            ps.setString(1, faculty.getIdFaculty());
            ps.setString(2, faculty.getDeanID());
            ps.setString(3, faculty.getDescription());
            ps.setString(4, faculty.getMainContactID());
            ps.setString(5, faculty.getMainPhone());
            ps.setString(6, faculty.getName());
            ps.setString(7, faculty.getHeadOfficeLocationID().getIdLocation());

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

    public int updateFaculty(final Faculty faculty) {
        this.initConnection();
        int count = 0;
        try {
            ps = conn.prepareStatement("UPDATE faculty SET deanID = ?,description = ?,mainContactID = ?,mainPhone = ?,name = ?,headOfficeLocationID = ? WHERE idFaculty = ?");
            ps.setString(1, faculty.getDeanID());
            ps.setString(2, faculty.getDescription());
            ps.setString(3, faculty.getMainContactID());
            ps.setString(4, faculty.getMainPhone());
            ps.setString(5, faculty.getName());
            ps.setString(6, faculty.getHeadOfficeLocationID().getIdLocation());
            ps.setString(7, faculty.getIdFaculty());
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
