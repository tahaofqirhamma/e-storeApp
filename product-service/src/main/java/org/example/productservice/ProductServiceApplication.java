package org.example.productservice;

import org.example.productservice.config.GlobalConfig;
import org.example.productservice.config.ProductConfig;
import org.example.productservice.entities.Product;
import org.example.productservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerWebClientBuilderBeanPostProcessor;
import org.springframework.context.annotation.Bean;
@SpringBootApplication(exclude = {
        org.springframework.cloud.client.loadbalancer.LoadBalancerAutoConfiguration.class
})
@EnableConfigurationProperties({GlobalConfig.class, ProductConfig.class})

public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            // Product 1
            Product product1 = Product.builder().productName("AL YASSINE").productPrice(550.00).isInStock(true).quantity(2334).build();
            productRepository.save(product1);

            // Product 2
            Product product2 = Product.builder().productName("MOROCCAN SPICE").productPrice(420.50).isInStock(true).quantity(1500).build();
            productRepository.save(product2);

            // Product 3
            Product product3 = Product.builder().productName("CITRUS BURST").productPrice(720.75).isInStock(false).quantity(0).build();
            productRepository.save(product3);

            // Product 4
            Product product4 = Product.builder().productName("SAHARA SUNSET").productPrice(630.25).isInStock(true).quantity(1800).build();
            productRepository.save(product4);

            // Product 5
            Product product5 = Product.builder().productName("DESERT ROSE").productPrice(890.00).isInStock(true).quantity(1200).build();
            productRepository.save(product5);

            // Product 6
            Product product6 = Product.builder().productName("MINT TEA").productPrice(310.50).isInStock(true).quantity(2000).build();
            productRepository.save(product6);

            // Product 7
            Product product7 = Product.builder().productName("GOLDEN SAND").productPrice(770.75).isInStock(true).quantity(1500).build();
            productRepository.save(product7);
        };
    }


}
