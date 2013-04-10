/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Haijun
 */
public abstract class SmartEnrolDAO {
    protected static Connection conn;
    protected static PreparedStatement ps;
    protected static ResultSet rs;
    protected static ResultSetMetaData rm;

    public SmartEnrolDAO() {
        conn = null;
        ps = null;
        rs = null;
        rm = null;
        this.initConnection();
    }

    /**
     * Initialize a connection.
     */
    protected void initConnection() {
        if (conn == null) {
            MySQLConnection mySQLConnection = MySQLConnection.getInstance();
            conn = mySQLConnection.getConnection();
        }
    }

    /**
     * This method closes the preparedstatement.
     */
    protected void psclose() {
        try {
            if (rs != null) {
                rs.close();
            }
            ps.close();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
        }
    }
    
}
