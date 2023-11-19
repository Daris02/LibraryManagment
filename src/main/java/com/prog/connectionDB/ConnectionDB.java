package com.prog.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    static String databaseName = System.getenv("jdbc_url");
    static String user = System.getenv("user");
    static String password = System.getenv("password");
    static Connection connection;

    // Public Method to create connection
    public static Connection createConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(
                        databaseName, user, password);
                return connection;
            }
            return connection;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
