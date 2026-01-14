package com.upb.agripos.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ProductFormView {
    // Komponen UI sebagai properti agar bisa diakses Controller/App
    private TextField txtCode;
    private TextField txtName;
    private TextField txtPrice;
    private TextField txtStock;
    private Button btnAdd;
    private ListView<String> listView;

    public ProductFormView() {
        initComponents();
    }

    private void initComponents() {
        txtCode = new TextField();
        txtName = new TextField();
        txtPrice = new TextField();
        txtStock = new TextField();
        btnAdd = new Button("Tambah Produk");
        listView = new ListView<>();

        // Variasi: Menambahkan prompt text (placeholder)
        txtCode.setPromptText("Contoh: P001");
        txtName.setPromptText("Nama pupuk/bibit");
        txtPrice.setPromptText("0.0");
        txtStock.setPromptText("0");
    }

    public Parent getView() {
        // 1. Header Section
        Label lblTitle = new Label("Input Data Produk Agri-POS");
        lblTitle.setFont(Font.font("System", FontWeight.BOLD, 16));

        // 2. Form Section (GridPane)
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        grid.add(new Label("Kode Produk"), 0, 0);
        grid.add(txtCode, 1, 0);

        grid.add(new Label("Nama Produk"), 0, 1);
        grid.add(txtName, 1, 1);

        grid.add(new Label("Harga"), 0, 2);
        grid.add(txtPrice, 1, 2);

        grid.add(new Label("Stok"), 0, 3);
        grid.add(txtStock, 1, 3);

        // 3. Button Section
        btnAdd.setMaxWidth(Double.MAX_VALUE);
        btnAdd.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-cursor: hand;");

        // 4. Root Layout (VBox)
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(
                lblTitle,
                grid,
                btnAdd,
                new Separator(),
                new Label("Log Transaksi:"),
                listView);

        return root;
    }

    // Getters agar Controller bisa membaca data dan memasang Event Handler
    public TextField getTxtCode() {
        return txtCode;
    }

    public TextField getTxtName() {
        return txtName;
    }

    public TextField getTxtPrice() {
        return txtPrice;
    }

    public TextField getTxtStock() {
        return txtStock;
    }

    public Button getBtnAdd() {
        return btnAdd;
    }

    public ListView<String> getListView() {
        return listView;
    }
}