/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.SQLException;
import org.joda.time.LocalDate;
import smartenrol.model.Term;

/**
 *
 * @author Haijun
 */
public class TermDAO extends SmartEnrolDAO {
    private Term currentTerm;
    
    public TermDAO() {
        super();
        currentTerm = new Term();
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

    /**
     * Get the Term object for the current term.
     * @return 
     */
    public Term getCurrentTerm() {
        this.initConnection();
        Term thisTerm = new Term();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM Term WHERE term = ? AND year = ?");
            ps.setString(1, thisTerm.getCurrentTerm());
            ps.setString(2, String.valueOf(thisTerm.getCurrentYear()));
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                thisTerm.setStartDate(new LocalDate(rs.getString("startDate")));
                thisTerm.setEndDate(new LocalDate(rs.getString("endDate")));
                thisTerm.setDeadline(new LocalDate(rs.getString("enrollDeadline")));
                thisTerm.setDescription(rs.getString("description"));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return thisTerm;
    }
}
