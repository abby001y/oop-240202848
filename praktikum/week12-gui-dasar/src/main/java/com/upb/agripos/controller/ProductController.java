package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.view.ProductFormView;
import javafx.scene.control.Alert;

public class ProductController {
    private ProductFormView view;
    private ProductService service;

    public ProductController(ProductFormView view) {
        this.view = view;
        this.service = new ProductService();

        // Menghubungkan event klik tombol dengan logic di controller
        this.initEventListeners();
    }

    private void initEventListeners() {
        // Event Handling JavaFX
        view.getBtnAdd().setOnAction(event -> handleAddProduct());
    }

    private void handleAddProduct() {
        try {
            // 1. Ekstraksi Data dari View
            String code = view.getTxtCode().getText();
            String name = view.getTxtName().getText();

            // Variasi: Validasi dasar sebelum masuk ke Service
            if (code.isEmpty() || name.isEmpty()) {
                throw new Exception("Kode dan Nama produk wajib diisi!");
            }

            double price = Double.parseDouble(view.getTxtPrice().getText());
            int stock = Integer.parseInt(view.getTxtStock().getText());

            // 2. Bungkus ke dalam Model
            Product product = new Product(code, name, price, stock);

            // 3. Kirim ke Service (Bridge ke DAO)
            service.addProduct(product);

            // 4. Update View jika sukses
            updateUI(product);
            clearFields();
            showNotice(Alert.AlertType.INFORMATION, "Sukses", "Produk berhasil disimpan ke database!");

        } catch (NumberFormatException ex) {
            showNotice(Alert.AlertType.ERROR, "Input Salah", "Harga dan Stok harus berupa angka!");
        } catch (Exception ex) {
            showNotice(Alert.AlertType.ERROR, "Terjadi Kesalahan", ex.getMessage());
        }
    }

    private void updateUI(Product p) {
        // Variasi: Menampilkan format yang rapi pada ListView
        String logEntry = String.format("[%s] %s - Rp%.2f (Stok: %d)",
                p.getCode(), p.getName(), p.getPrice(), p.getStock());
        view.getListView().getItems().add(logEntry);
    }

    private void clearFields() {
        view.getTxtCode().clear();
        view.getTxtName().clear();
        view.getTxtPrice().clear();
        view.getTxtStock().clear();
        view.getTxtCode().requestFocus();
    }

    private void showNotice(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}