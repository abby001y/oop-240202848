package com.upb.agripos.service;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.model.Product;

public class ProductService {
    private ProductDAO productDAO = new ProductDAO();

    public void addProduct(Product p) throws Exception {
        // Validasi Bisnis (Variasi)
        if (p.getPrice() <= 0) {
            throw new Exception("Harga harus lebih besar dari 0!");
        }
        if (p.getStock() < 0) {
            throw new Exception("Stok tidak boleh negatif!");
        }

        // Panggil DAO
        productDAO.insert(p);
    }
}