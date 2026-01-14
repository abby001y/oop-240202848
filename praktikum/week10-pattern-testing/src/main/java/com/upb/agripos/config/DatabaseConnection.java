package com.upb.agripos.config;

public class DatabaseConnection {
    // 1. Atribut static instance
    private static DatabaseConnection instance;

    // 2. Private Constructor agar tidak bisa di-instantiate dari luar
    private DatabaseConnection() {
        System.out.println("Koneksi Database Baru Berhasil Dibuat.");
    }

    // 3. Method static untuk mendapatkan satu-satunya instance
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void query(String sql) {
        System.out.println("Menjalankan query: " + sql);
    }
}