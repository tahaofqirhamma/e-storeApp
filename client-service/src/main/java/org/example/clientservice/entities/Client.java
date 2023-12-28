package org.example.clientservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class Client {
    @Id
    private String clientId;
    private String FullName;
    private String Address;

}
