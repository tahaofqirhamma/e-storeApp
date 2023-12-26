package org.example.productservice.web;

import org.example.productservice.entities.Product;
import org.example.productservice.services.ProductServiceInterface;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class ProductWebController {
    @Autowired
    ProductServiceInterface productServiceInterface;
    @Autowired
    private RabbitTemplate rabbitTemplate;
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
        rabbitTemplate.convertAndSend("product-exchange", "add-product", product);
    }
    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable("id") Integer id,@RequestBody Product product){
        productServiceInterface.updateProduct(id, product);
        rabbitTemplate.convertAndSend("product-exchange", "update-product",  product);
    }
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") Integer id){
        productServiceInterface.deleteProduct(id);
        rabbitTemplate.convertAndSend("product-exchange", "delete-product", id);
    }

}
