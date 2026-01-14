package com.upb.agripos;

import com.upb.agripos.config.DatabaseConnection;
import com.upb.agripos.controller.ProductController;
import com.upb.agripos.model.Product;
import com.upb.agripos.view.ConsoleView;

public class AppMVC {
    public static void main(String[] args) {
        // Ganti dengan Nama dan NIM Anda
        System.out.println("Hello, I am [Abbi Priyoguno]-[240202848] (Week10)");

        // 1. Demonstrasi Singleton
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        db1.query("SELECT * FROM products");

        DatabaseConnection db2 = DatabaseConnection.getInstance();
        // db1 dan db2 adalah objek yang sama (alamat memori sama)
        System.out.println("Apakah db1 dan db2 sama? " + (db1 == db2));

        // 2. Demonstrasi MVC
        Product product = new Product("P01", "Pupuk Organik");
        ConsoleView view = new ConsoleView();
        ProductController controller = new ProductController(product, view);
        
        controller.showProduct();
    }
}