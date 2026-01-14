package com.upb.agripos;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppJavaFX extends Application {
    private ProductService productService = new ProductService();

    // UI Components
    private TextField txtCode = new TextField();
    private TextField txtName = new TextField();
    private TextField txtPrice = new TextField();
    private TextField txtStock = new TextField();
    private Button btnAdd = new Button("Simpan Produk");
    private ListView<String> listView = new ListView<>();

    @Override
    public void start(Stage stage) {
        // Form Layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        grid.add(new Label("Kode:"), 0, 0);
        grid.add(txtCode, 1, 0);
        grid.add(new Label("Nama:"), 0, 1);
        grid.add(txtName, 1, 1);
        grid.add(new Label("Harga:"), 0, 2);
        grid.add(txtPrice, 1, 2);
        grid.add(new Label("Stok:"), 0, 3);
        grid.add(txtStock, 1, 3);
        grid.add(btnAdd, 1, 4);

        // Event Handler (Event-Driven Programming)
        btnAdd.setOnAction(e -> {
            try {
                // 1. Ambil data dari View & Map ke Model
                Product p = new Product(
                        txtCode.getText(),
                        txtName.getText(),
                        Double.parseDouble(txtPrice.getText()),
                        Integer.parseInt(txtStock.getText()));

                // 2. Panggil Service (Bukan DAO langsung!)
                productService.addProduct(p);

                // 3. Update View jika berhasil
                listView.getItems().add(p.getCode() + " - " + p.getName() + " [BERHASIL]");
                clearForm();
                showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data tersimpan ke database.");

            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Harga/Stok harus angka!");
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
            }
        });

        VBox root = new VBox(10, grid, new Label(" Log Aktivitas:"), listView);
        stage.setScene(new Scene(root, 400, 500));
        stage.setTitle("Agri-POS v1.0 (GUI Dasar)");
        stage.show();
    }

    private void clearForm() {
        txtCode.clear();
        txtName.clear();
        txtPrice.clear();
        txtStock.clear();
    }

    private void showAlert(Alert.AlertType type, String title, String msg) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}