package com.upb.agripos.dao;

import com.upb.agripos.model.Product;
import java.sql.*;

public class ProductDAO {
    private String url = "jdbc:postgresql://localhost:5432/agripos_db";
    private String user = "postgres";
    private String pass = "password_anda";

    public void insert(Product p) throws SQLException {
        String sql = "INSERT INTO products (code, name, price, stock) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, p.getCode());
            pstmt.setString(2, p.getName());
            pstmt.setDouble(3, p.getPrice());
            pstmt.setInt(4, p.getStock());
            pstmt.executeUpdate();
        }
    }
}