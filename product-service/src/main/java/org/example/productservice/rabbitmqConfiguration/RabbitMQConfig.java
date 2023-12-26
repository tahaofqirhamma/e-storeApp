package org.example.productservice.rabbitmqConfiguration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public DirectExchange productExchange() {
        return new DirectExchange("product-exchange");
    }

    @Bean
    public Queue addProductQueue() {
        return new Queue("add-product-queue");
    }

    @Bean
    public Queue updateProductQueue() {
        return new Queue("update-product-queue");
    }

    @Bean
    public Queue deleteProductQueue() {
        return new Queue("delete-product-queue");
    }

    @Bean
    public Binding bindingAddProduct(Queue addProductQueue, DirectExchange productExchange) {
        return BindingBuilder.bind(addProductQueue).to(productExchange).with("add-product");
    }

    @Bean
    public Binding bindingUpdateProduct(Queue updateProductQueue, DirectExchange productExchange) {
        return BindingBuilder.bind(updateProductQueue).to(productExchange).with("update-product");
    }

    @Bean
    public Binding bindingDeleteProduct(Queue deleteProductQueue, DirectExchange productExchange) {
        return BindingBuilder.bind(deleteProductQueue).to(productExchange).with("delete-product");
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
