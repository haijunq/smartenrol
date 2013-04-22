/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class is solely for checking the special permission table.
 * @author Haijun
 */
public class StudentCoursePermissionDAO extends SmartEnrolDAO {
    private ArrayList<String> permission = new ArrayList<>();
    
    public StudentCoursePermissionDAO(){
        super();
    }
    
    public StudentCoursePermissionDAO(int idStudent, String idDepartment, int idCourse) {
        super();        
        this.initConnection();
        
        try {
            ps = conn.prepareStatement("SELECT type FROM StudentCourseSpecialPermission WHERE idUser = ? AND idDepartment = ? AND idCourse = ?");
            ps.setInt(1, idStudent);
            ps.setString(2, idDepartment);
            ps.setInt(3, idCourse);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
        }

        // parse the resultset
        try {
            while (rs.next()) {
                permission.add(rs.getString("type"));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
        }        
        
        this.psclose();
        
    }
    
    public boolean hasPermissionForPrerequisite() {
        return this.permission.contains("prereq");
    }
    
    public boolean hasPermissionForCorequisite() {
        return this.permission.contains("coreq");
    }
    
    public boolean hasPermissionForDeadline() {
        return this.permission.contains("deadline");
    }
    
    public boolean hasPermissionForRestricted() {
        return this.permission.contains("restricted");
    }
    
    /**
     * This method returns a permission mask for the StudentSectionStatusCode.
     * @return 
     */
    public int getStudentCoursePermissionCode() {
        int code = 0xFF; 
        if (this.hasPermissionForDeadline()) 
            code = code & 0b11011111;
        if (this.hasPermissionForRestricted())
            code = code & 0b11101111;
        if (this.hasPermissionForPrerequisite())
            code = code & 0b11110111;
        if (this.hasPermissionForCorequisite())
            code = code & 0b11111011;
        return code;
    }    
    
    /**
     * This method add a special permission for a student to a course. 
     * @param idStudent
     * @param idDepartment
     * @param idCourse
     * @param type
     * @return 1 if success, 0 otherwise
     */
    public int addStudentSpecialPermission(int idStudent, String idDepartment, int idCourse, String type) {
        this.initConnection();
        int count=0;    
        try {
            ps = conn.prepareStatement("insert into StudentCourseSpecialPermission \n" +
                                    "values (?, ?, ?, ?)");
            ps.setInt(1, idStudent);
            ps.setString(2, idDepartment);
            ps.setInt(3, idCourse);
            ps.setString(4, type);
            count = ps.executeUpdate();
        
            conn.commit();
            this.psclose();
            return count;
            
        } catch (SQLException sqlex) {
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
}
