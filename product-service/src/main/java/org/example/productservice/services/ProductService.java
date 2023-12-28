package org.example.productservice.services;

import jakarta.transaction.Transactional;
import org.example.productservice.entities.Product;
import org.example.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class ProductService implements ProductServiceInterface{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        products = productRepository.findAll();
        return products;
    }

    @Override
    public Product getProduct(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Integer id, Product productReq) {
        Product product = productRepository.findById(id).get();
        if(productReq.getProductName() != null) product.setProductName(productReq.getProductName());
        if(productReq.getProductPrice() != null) product.setProductPrice(productReq.getProductPrice());
        if(productReq.getIsInStock() != null) product.setIsInStock(productReq.getIsInStock());
        if(productReq.getQuantity() != null) product.setQuantity(product.getQuantity());
        if(!product.getIsInStock()) product.setQuantity(0);


    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);

    }
}
