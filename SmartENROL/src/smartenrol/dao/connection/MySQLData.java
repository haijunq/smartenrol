/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 *
 * @author Jeremy
 */
public class MySQLData {

    private Properties props;
    private ComboPooledDataSource pooledData;
    private static MySQLData mysqlData;

    private MySQLData() throws IOException, SQLException {

        props = Utils.readProperties("smartdata.properties");
        pooledData = new ComboPooledDataSource();
        pooledData.setJdbcUrl(props.getProperty("jdbcUrl"));
        pooledData.setUser(props.getProperty("username"));
        pooledData.setPassword(props.getProperty("password"));
        pooledData.setInitialPoolSize(new Integer((String) props.getProperty("initialPoolSize")));
        pooledData.setAcquireIncrement(new Integer((String) props.getProperty("acquireIncrement")));
        pooledData.setMaxPoolSize(new Integer((String) props.getProperty("maxPoolSize")));
        pooledData.setMinPoolSize(new Integer((String) props.getProperty("minPoolSize")));
        pooledData.setMaxStatements(new Integer((String) props.getProperty("maxStatements")));
        pooledData.getConnection();

    }

    public static MySQLData getInstance() throws IOException, SQLException {
        if (mysqlData == null) {
            mysqlData = new MySQLData();
            return mysqlData;
        } else {
            return mysqlData;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.pooledData.getConnection();
    }
}
