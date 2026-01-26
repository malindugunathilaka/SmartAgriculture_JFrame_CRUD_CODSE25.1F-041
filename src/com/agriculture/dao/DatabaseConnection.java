package com.agriculture.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton Database Connection Class
 * Change PASSWORD on line 14 to match your MySQL password
 */
public class DatabaseConnection {
    private static Connection connection = null;
    private static final String URL = "jdbc:mysql://localhost:3306/agriculture_system";
    private static final String USER = "root";
    private static final String PASSWORD = "";  // <<< CHANGE THIS TO YOUR MYSQL PASSWORD

    private DatabaseConnection() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database Connected Successfully!");
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println("Database Connection Failed: " + e.getMessage());
            }
        }
        return connection;
    }
}
