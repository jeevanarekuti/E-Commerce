package com.example.ecommerce.services;

import com.example.ecommerce.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(long id);
    public List<Product> getAllProducts();
}
