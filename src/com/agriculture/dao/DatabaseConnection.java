package com.agriculture.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Database Connection Manager for Smart Agriculture System
 * 
 * IMPORTANT: Update the PASSWORD constant below with your MySQL password
 */
public class DatabaseConnection {
    
    // ============ DATABASE CONFIGURATION ============
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "agriculture_system";
    private static final String USER = "root";
    private static final String PASSWORD = "";  // <-- UPDATE THIS WITH YOUR MySQL PASSWORD
    // ================================================
    
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE 
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    
    private static Connection connection = null;
    
    /**
     * Gets a connection to the database with comprehensive error handling.
     * @return Connection object or null if connection fails
     */
    public static Connection getConnection() {
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Attempt connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
            
        } catch (ClassNotFoundException e) {
            showError("JDBC Driver Not Found!\n\n" +
                    "The MySQL Connector JAR is not in your project.\n\n" +
                    "Solution:\n" +
                    "1. Download mysql-connector-java-8.x.jar\n" +
                    "2. In NetBeans: Right-click Libraries → Add JAR/Folder\n" +
                    "3. Select the downloaded JAR file\n\n" +
                    "Download from: https://dev.mysql.com/downloads/connector/j/",
                    "Missing MySQL Connector");
            e.printStackTrace();
            
        } catch (SQLException e) {
            String errorMsg = e.getMessage().toLowerCase();
            
            if (errorMsg.contains("access denied")) {
                showError("Database Access Denied!\n\n" +
                        "Wrong username or password.\n\n" +
                        "Solution:\n" +
                        "1. Open DatabaseConnection.java\n" +
                        "2. Update PASSWORD constant (line 19)\n" +
                        "3. Current settings:\n" +
                        "   - User: " + USER + "\n" +
                        "   - Password: " + (PASSWORD.isEmpty() ? "(empty)" : "(set)") + "\n" +
                        "   - Database: " + DATABASE,
                        "Access Denied");
                        
            } else if (errorMsg.contains("unknown database")) {
                showError("Database Does Not Exist!\n\n" +
                        "Database '" + DATABASE + "' not found.\n\n" +
                        "Solution:\n" +
                        "1. Open MySQL Workbench or Command Line\n" +
                        "2. Run the SQL script: sql/database_setup.sql\n" +
                        "3. Or create manually:\n" +
                        "   CREATE DATABASE smart_agriculture;",
                        "Database Not Found");
                        
            } else if (errorMsg.contains("communications link failure") || 
                       errorMsg.contains("connection refused") ||
                       errorMsg.contains("cannot create connection")) {
                showError("Cannot Connect to MySQL Server!\n\n" +
                        "MySQL is not running or not accessible.\n\n" +
                        "Solution:\n" +
                        "1. Start MySQL Server:\n" +
                        "   - Windows: Services → MySQL → Start\n" +
                        "   - XAMPP: Start MySQL from Control Panel\n" +
                        "   - Linux: sudo systemctl start mysql\n\n" +
                        "2. Verify connection settings:\n" +
                        "   - Host: " + HOST + "\n" +
                        "   - Port: " + PORT,
                        "MySQL Server Not Running");
                        
            } else {
                showError("Database Connection Error!\n\n" +
                        "Error: " + e.getMessage() + "\n\n" +
                        "Error Code: " + e.getErrorCode() + "\n" +
                        "SQL State: " + e.getSQLState(),
                        "Connection Error");
            }
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * Closes the database connection
     */
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Shows an error dialog with detailed information
     */
    private static void showError(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Test the database connection
     */
    public static void main(String[] args) {
        System.out.println("Testing Database Connection...");
        System.out.println("Host: " + HOST);
        System.out.println("Port: " + PORT);
        System.out.println("Database: " + DATABASE);
        System.out.println("User: " + USER);
        System.out.println("Password: " + (PASSWORD.isEmpty() ? "(empty)" : "(set)"));
        System.out.println();
        
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("SUCCESS! Database connection established.");
            JOptionPane.showMessageDialog(null, 
                    "Database connection successful!\n\n" +
                    "Connected to: " + DATABASE + "@" + HOST + ":" + PORT,
                    "Connection Test", 
                    JOptionPane.INFORMATION_MESSAGE);
            closeConnection();
        } else {
            System.out.println("FAILED! Could not connect to database.");
        }
    }
}
