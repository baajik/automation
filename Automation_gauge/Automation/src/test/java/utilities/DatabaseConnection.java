package utilities;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;

/**
 * @author erlan.beisen
 * August, 16 2019
 * PostgreSQL Java Database Connection
 */
public class DatabaseConnection {

    private static Logger logger;
    private static Connection connection;

    protected DatabaseConnection () { init (); }

    private void init () {
        logger = logger == null ? Logger.getLogger(DatabaseConnection.class) : logger;
        connection = connection == null ? connection() : connection;
    }

    private Connection connection () {
        Connection connection = null;
        String dbUrl = "jdbc:postgresql://" + System.getenv("database_url");
        String dbPort = System.getenv("database_port");
        String dbName = System.getenv("database_name");
        String dbUserId = System.getenv("database_user_id");
        String dbUserPassword = System.getenv("database_user_password");
        String connectionUrl = dbUrl + ":" + dbPort + "/" + dbName + "?user=" + dbUserId + "&password=" + dbUserPassword;
        try {
            connection = DriverManager.getConnection(connectionUrl);
        } catch ( SQLException e ) {
            logger.error("Could not connect to Database\n" + e.getMessage());
        }
        return connection;
    }

    protected List<Map<String, Object>> getQueryResults ( String query ) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        Map<String, Object> rowMap;
        try ( Statement statement = connection.createStatement() ) {
            ResultSet resultSet = statement.executeQuery( query );
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columns = resultSetMetaData.getColumnCount();

            while ( resultSet.next() ) {
                rowMap = new HashMap<>();
                for ( int index = 1; index <= columns; index++ ) {
                    rowMap.put(resultSetMetaData.getColumnLabel(index), resultSet.getObject(index));
                }
                resultList.add(rowMap);
            }
            statement.close();
            resultSet.close();
            logger.info("Query \"" + query + "\" executed");
        } catch ( SQLException e ) {
            logger.error(e.getMessage());
        }
        return resultList;
    }

    protected String getQueryResult ( String query ) {
        String result = "";
        try ( Statement statement = connection.createStatement() ) {
            ResultSet resultSet = statement.executeQuery( query );
            result = resultSet.next() ? resultSet.getString(1) : "";
            statement.close();
            resultSet.close();
            logger.info("Query \"" + query + "\" executed");
        } catch ( SQLException e ) {
            logger.error(e.getMessage());
        }
        return result;
    }

    protected void executeStoreProcedure ( String storeProcedure ) {
        try ( CallableStatement callableStatement = connection.prepareCall(storeProcedure) ) {
            callableStatement.executeQuery();
            logger.info("Store Procedure \"" + storeProcedure + "\" executed");
        } catch ( SQLException e ) {
            logger.error(e.getMessage());
        }
    }

    static void closeDatabaseConnection () {
        if ( connection != null ) {
            try {
                connection.close();
                connection = null;
            } catch ( SQLException e ) {
                logger.error("Could not close Database connection\n" + e.getMessage());
            }
        }
    }
}
