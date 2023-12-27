package org.example.notificationservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleEvent {
    private Integer saleId;
    private String clientId;
    private Integer productId;
}