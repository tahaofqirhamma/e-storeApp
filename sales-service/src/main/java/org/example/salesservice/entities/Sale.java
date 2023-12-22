package org.example.salesservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.salesservice.Model.Client;
import org.example.salesservice.Model.Product;

import java.util.Date;
@Entity @Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Sale {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer saleId;
    private Date saleDate;
    private Integer clientId;
    private Integer productId;
    @Transient
    private Client client;
    @Transient
    private Product product;

}
