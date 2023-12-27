package org.example.notificationservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Notification {
    @Id
    private String notificationId;
    private String description;
    private Integer productId;
    private String clientId;
}
