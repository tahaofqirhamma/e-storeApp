package org.example.notificationservice;

import org.apache.kafka.common.protocol.types.Field;
import org.example.notificationservice.Repository.NotificationRepository;
import org.example.notificationservice.entity.Notification;
import org.example.notificationservice.event.SaleEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.UUID;

@SpringBootApplication
public class NotificationServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @Autowired
    NotificationRepository notificationRepository;

    @KafkaListener(topics = "notificationTopic")
    public void handelNotification(SaleEvent saleEvent){
        System.out.println("New sale added , sale Id" + " " + saleEvent.getSaleId()+ " " + saleEvent.getClientId() + " " + saleEvent.getProductId() );
        Notification notification = new Notification(UUID.randomUUID().toString(), "New sale added",saleEvent.getSaleId(), saleEvent.getClientId());
        notificationRepository.save(notification);
    }
}