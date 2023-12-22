package org.example.productservice.web;

import org.example.productservice.entities.Product;
import org.example.productservice.services.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class ProductWebController {
    @Autowired
    ProductServiceInterface productServiceInterface;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productServiceInterface.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") Integer id){
        return productServiceInterface.getProduct(id);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
        productServiceInterface.addProduct(product);
    }
    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable("id") Integer id,@RequestBody Product product){
        productServiceInterface.updateProduct(id, product);
    }
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") Integer id){
        productServiceInterface.deleteProduct(id);
    }

}
