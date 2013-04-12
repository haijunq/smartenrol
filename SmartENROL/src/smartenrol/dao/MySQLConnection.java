package smartenrol.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import smartenrol.dao.connection.*;


/**
 * This is a singleton class conencting to a MySQL database. 
 * To get a instance of the connection, use getConnection().
 */ 
public class MySQLConnection {
    
    private static MySQLConnection conn_smarten_data = null;
    protected Connection connection = null;

    /**
     * Static method returns a single instance of MySQLConnection.
     * @return	a single instance of MySQLConnection
     */
    public static MySQLConnection getInstance()  {
        if (conn_smarten_data == null) {
            conn_smarten_data = new MySQLConnection();
        }
        return conn_smarten_data;
    }
    
    /**
     * Gets the connection.
     * @return	the Connection object
     */
    public Connection getConnection() {
        try {
            //System.err.println("This Connection: " + connection);
            
            if ((connection!=null)&&(connection.isValid(0))) {
                return connection;
                } else {
                try {
                    connection = MySQLData.getInstance().getConnection();
                } catch (IOException ex) {
                    Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
                return connection;
 
                 }
            } catch (SQLException ex) {
                Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;
       		
    }

}

