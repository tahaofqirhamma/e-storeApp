package org.example.productservice.rabbitmqConfiguration;

import org.example.productservice.entities.Product;
import org.example.productservice.services.ProductServiceInterface;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProductEventConsumer  {

    @Autowired
    private ProductServiceInterface productServiceInterface;


    @RabbitListener(queues = "add-product-queue")
    public void handleAddProductEvent(Product product) {
        System.out.println("add event");
        productServiceInterface.getAllProducts();
    }

    @RabbitListener(queues = "update-product-queue")
    public void handleUpdateProductEvent(Product product) {
        System.out.println("Update event");
        productServiceInterface.updateProduct(product.getProductId(), product);
    }

    @RabbitListener(queues = "delete-product-queue")
    public void handleDeleteProductEvent(Integer productId) {
        System.out.println("Delete event");
    }
}
