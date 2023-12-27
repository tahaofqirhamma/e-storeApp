package org.example.notificationservice.web;

import org.example.notificationservice.Repository.NotificationRepository;
import org.example.notificationservice.entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
@Component
public class NotificationWeb {
    @Autowired
    NotificationRepository notificationRepository;
    @GetMapping("/notifications")
    public List<Notification> getNotifications(){
      return notificationRepository.findAll();
    }
}
