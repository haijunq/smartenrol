/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import smartenrol.dao.connection.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        conn = MySQLConnection.getInstance().getConnection();
        //System.out.println("TESTING MYSQL: "+conn);
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
            //conn.close();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
        }
    }
    
}
