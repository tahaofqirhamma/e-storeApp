package org.example.productservice.services;

import org.example.productservice.entities.Product;

import java.util.List;

public interface ProductServiceInterface {
    public List<Product> getAllProducts();
    public Product getProduct(Integer id);
    public void addProduct(Product product);
    public void updateProduct(Integer id, Product product);
    public void deleteProduct(Integer id);
}
