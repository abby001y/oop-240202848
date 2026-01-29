package com.upb.agripos.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseConnection - PostgreSQL Connection Management
 * Disesuaikan dengan MainDAOTest
 */
public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    // === DATABASE CONFIG (SAMA DENGAN MainDAOTest) ===
    private static final String DB_URL =
            "jdbc:postgresql://localhost:5432/agripos";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";
    private static final String DB_DRIVER = "org.postgresql.Driver";

    private DatabaseConnection() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            System.out.println("✓ PostgreSQL connected (agripos)");
        } catch (Exception e) {
            System.err.println("❌ Database connection failed: " + e.getMessage());
        }
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("✓ Database connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean testConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
