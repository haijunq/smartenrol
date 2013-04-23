/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import smartenrol.UniqueConstraintException;
import smartenrol.model.Building;
import smartenrol.model.Department;
import smartenrol.model.Faculty;

/**
 *
 * @author Jeremy
 */
public class DepartmentDAO extends SmartEnrolDAO {

    public DepartmentDAO() {
        super();
    }

    /**
     * Add building method is used in the building controller to create
     * buildings
     */
    public int addDepartment(Department department) throws UniqueConstraintException {
        this.initConnection();
        int count = 0;
        try {
            ps = conn.prepareStatement("INSERT INTO department (idDepartment,idAdmin,description,deptHeadName,name,idFaculty,idLocation) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1,department.getIdDepartment());
            ps.setInt(2, department.getIdAdmin());
            ps.setString(3, department.getDescription());
            ps.setString(4, department.getDeptHeadName());
            ps.setString(5, department.getName());
            ps.setString(6, department.getIdFaculty());
            ps.setString(7, department.getIdLocation());
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

    public int updateDepartment(final Department department) {
        this.initConnection();
        int count = 0;
        try {
            ps = conn.prepareStatement("UPDATE department SET idAdmin = ?,description = ?,deptHeadName = ?,name = ?,idFaculty = ?,idLocation = ? WHERE idDepartment = ?");
            
            ps.setInt(1, department.getIdAdmin());
            ps.setString(2, department.getDescription());
            ps.setString(3, department.getDeptHeadName());
            ps.setString(4, department.getName());
            ps.setString(5, department.getIdFaculty());
            ps.setString(6, department.getIdLocation());
            ps.setString(7, department.getIdDepartment());
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
     * get department by idDepartment
     *
     * @param String idDepartment
     * @return Department
     *
     */
    public Department getDepartmentByID(String idDepartment) {
        this.initConnection();
        Department department = new Department();

        try {
            ps = conn.prepareStatement("SELECT * FROM Department WHERE idDepartment = ?");
            ps.setString(1, idDepartment);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                department.setIdDepartment(rs.getString("idDepartment"));
                department.setIdAdmin(rs.getInt("idAdmin"));
                department.setDescription(rs.getString("description"));
                department.setName(rs.getString("name"));
                department.setIdFaculty(rs.getString("idFaculty"));
                department.setIdLocation(rs.getString("idLocation"));
                department.setEmail(rs.getString("email"));
                department.setPhone(rs.getString("phone"));
                department.setDeptHeadName(rs.getString("deptHeadName"));
            }

        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }

        this.psclose();
        return department;
    }
    
    public ArrayList<String> getAllDeptID()
    {
         
        this.initConnection();
        ArrayList<String> deptList = new ArrayList<>();
        try {
            ps = conn.prepareStatement("SELECT idDepartment FROM Department");
          
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {

            while (rs.next()) 
               deptList.add(rs.getString("idDepartment"));

        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }

        this.psclose();
        return deptList;
    
    }
    
     public ArrayList<Department> searchDepartmentbyKeyword(String[] keyword) {
        this.initConnection();
        ArrayList<Department> deptlist = new ArrayList<>();
        String querystr="select idDepartment, name, idLocation, phone, email from Department where (idDepartment=? or name LIKE ?) AND (idDepartment=? or name LIKE ?)";
        
        try {
            ps = conn.prepareStatement(querystr);
            ps.setString(1, keyword[0]);
            ps.setString(2, "%"+keyword[0]+"%");
           
            ps.setString(3, keyword[1]);
            ps.setString(4, "%"+keyword[1]+"%");
            
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }
          
        try {
            while (rs.next()) {
            deptlist.add(new Department(
                    rs.getString("idDepartment"),
                    rs.getString("name"),
                    rs.getString("idLocation"),
                    rs.getString("phone"),
                    rs.getString("email")
                    ));
            
            
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }            
    
          
          
        this.psclose();
        return deptlist;
    
    }
}
