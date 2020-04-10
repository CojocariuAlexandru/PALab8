package com.company;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Common features needed for database table - connect, close, execute query
 */

public abstract class Database {
    protected Connection databaseConnection;
    protected static int availableID;
    /**
     * Opens connection
     */
    public void connectToDatabase(){
        try {
            //Use JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //Connecting to database
            databaseConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "STUDENT");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Closes database connection
     */
    public void closeDatabase(){
        try {
            databaseConnection.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Executes a query based on string given representing the query
     * @param queryToBeExecuted
     * @return
     */
    public ResultSet executeQuery(String queryToBeExecuted){
        Statement statement;
        ResultSet returnedByQuery;
        try {
            statement = databaseConnection.createStatement();
            returnedByQuery = statement.executeQuery(queryToBeExecuted);
            return returnedByQuery;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public int getAvailableID(){
        return availableID;
    }

    /**
     * After an insert, increase the available ID which is static
     */
    public void increaseID(){ availableID = availableID + 1; }
}
