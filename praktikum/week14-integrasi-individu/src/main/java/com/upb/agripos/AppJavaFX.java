package com.upb.agripos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.upb.agripos.controller.PosController;
import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.service.CartService;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.view.PosView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppJavaFX extends Application {

    private Connection dbConnection;

    @Override
    public void init() throws Exception {
        // Melakukan inisialisasi berat di method init (Best Practice JavaFX)
        System.out.println("Starting Agri-POS System...");
        this.dbConnection = setupDatabase();
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            // Identitas Owner
            displayIdentity();

            // Dependency Injection Layer
            ProductDAO daoLayer = new ProductDAOImpl(dbConnection);
            ProductService serviceLayer = new ProductService(daoLayer);
            CartService basketService = new CartService(serviceLayer);

            // Interface & Interaction
            PosView mainView = new PosView();
            new PosController(serviceLayer, basketService, mainView);

            // Configure Window
            prepareStage(primaryStage, mainView);
            primaryStage.show();

        } catch (Exception e) {
            System.err.println("Critical Error: " + e.getMessage());
        }
    }

    private Connection setupDatabase() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/agripos";
        return DriverManager.getConnection(url, "postgres", "postgres");
    }

    private void displayIdentity() {
        System.out.println("=========================================");
        System.out.println("User: Abbi priyoguno | ID: 240202848");
        System.out.println("Status: Application Running");
        System.out.println("=========================================");
    }

    private void prepareStage(Stage stage, PosView view) {
        Scene scene = new Scene(view, 1024, 768); // Ukuran sedikit berbeda
        stage.setScene(scene);
        stage.setTitle("Agri-POS Terminal - 240202848 (Abbi priyoguno)");
    }

    @Override
    public void stop() throws Exception {
        // Menutup koneksi database saat aplikasi di-close
        if (dbConnection != null && !dbConnection.isClosed()) {
            dbConnection.close();
            System.out.println("Database connection closed safely.");
        }
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}