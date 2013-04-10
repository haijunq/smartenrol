package smartenrol.dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * This is a singleton class conencting to a MySQL database. 
 * To get a instance of the connection, use getConnection().
 */ 
public class MySQLConnection {
    
    private static MySQLConnection conn_smarten_data = null;
    protected Connection connection = null;
    protected boolean driverLoaded = false;
    private final String serverURL = "jdbc:mysql://smartEnrol.ca:3306/smarten_data";
    private final String username = "smarten_conn";
    private final String password = "Smart2013";        // need MD5 encryption later

    protected MySQLConnection() {

    }

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
     * Loads the MySQL JDBC driver and connects to the database.
     * @return	true if the connection is successful; false otherwise.
     */
    public boolean connect() {
        try {	   
            if (!driverLoaded)  {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                driverLoaded = true; 
            }
            connection = DriverManager.getConnection(serverURL, username, password);
            connection.setAutoCommit(false);
            return true; 
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            return false;
        }
    }
    
    /**
     * Gets the connection.
     * @return	the Connection object
     */
    public Connection getConnection() {
        System.err.println("This Connection: " + connection);
        if (connection == null)
            this.connect();
        return this.connection; 
    }

    /**
     * Check whether the JDBC driver is loaded.
     * @return	true if the driver is loaded; false otherwise
     */
    public boolean isDriverLoaded() {
        return driverLoaded; 
    }

    /**
     * This method allows members of this class to clean up after itself 
     * before it is garbage collected. It is called by the garbage collector.
     */ 
    @Override
    protected void finalize() throws Throwable {
        if (connection != null) {
            connection.close();
        }
        // finalize() must call super.finalize() as the last thing it does
        super.finalize();	
    }
}

