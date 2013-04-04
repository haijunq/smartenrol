/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.joda.time.LocalDate;
import smartenrol.model.Course;
import smartenrol.model.Term;

/**
 *
 * @author Haijun
 */
public class TermDAO {

    private static Connection conn; 
    private static PreparedStatement ps;
    private static ResultSet rs;
    private Term currentTerm;
    
    public TermDAO() {
        conn = null;
        ps = null;
        rs = null;
        currentTerm = new Term();
    }
    
    /**
     * Initialize a connection.
     */
    private void initConnection() {
        MySQLConnection mySQLConnection = MySQLConnection.getInstance();
        conn = mySQLConnection.getConnection();
    }   
    
     /**
     * This method closes the preparedstatement. 
     */
    private void psclose() {
        try {
            if (rs != null)
                rs.close();
            ps.close();
        } catch(SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
        }
    }
    
    /**
     * Get the enrol and drop deadline (LocalDate) for the current term.
     * @return 
     */
    public LocalDate getDeadline() {
        this.initConnection();
        LocalDate deadline = null;
        
        try {
            ps = conn.prepareStatement("SELECT * FROM Term WHERE term = ? AND year = ?");
            ps.setString(1, currentTerm.getCurrentTerm());
            ps.setString(2, String.valueOf(currentTerm.getCurrentYear()));
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                deadline = new LocalDate(rs.getString("enrollDeadline"));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return deadline;
    }
    
    /**
     * Get the deadline for a specific term.
     * @param term
     * @param year
     * @return 
     */
    public LocalDate getDeadline(String term, int year) {
        this.initConnection();
        LocalDate deadline = null;
        
        try {
            ps = conn.prepareStatement("SELECT * FROM Term WHERE term = ? AND year = ?");
            ps.setString(1, term);
            ps.setString(2, String.valueOf(year));
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                deadline = new LocalDate(rs.getString("enrollDeadline"));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return deadline;
    }


}
