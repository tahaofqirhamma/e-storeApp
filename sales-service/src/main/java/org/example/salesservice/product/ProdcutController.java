package org.example.salesservice.product;

import org.example.salesservice.Model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProdcutController {
    @GetMapping("/api/v1/products")
    public List<Product> getAllProducts();
    @GetMapping("/api/v1/products/{id}")
    public Product getProduct(@PathVariable("id") Integer id);
}
