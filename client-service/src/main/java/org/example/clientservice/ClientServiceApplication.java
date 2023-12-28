package org.example.clientservice;

import org.example.clientservice.config.ClinetConfig;
import org.example.clientservice.config.GlobalConfig;
import org.example.clientservice.entities.Client;
import org.example.clientservice.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@EnableConfigurationProperties({GlobalConfig.class, ClinetConfig.class})
@SpringBootApplication

public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
        return args -> {
            // Client 1
            Client client1 = Client.builder().clientId("15cba452-642a-432e-a8db-a038a7bbd263").Address("Rabat, Morocco").FullName("Taha ofqir-hamma").build();
            clientRepository.save(client1);

            // Client 2
            Client client2 = Client.builder().clientId("59116fea-b555-4a1b-8814-e5484b20946e").Address("Casablanca, Morocco").FullName("John Doe").build();
            clientRepository.save(client2);

            // Client 3
            Client client3 = Client.builder().clientId(UUID.randomUUID().toString()).Address("Marrakech, Morocco").FullName("Jane Smith").build();
            clientRepository.save(client3);

            // Client 4
            Client client4 = Client.builder().clientId(UUID.randomUUID().toString()).Address("Fes, Morocco").FullName("Ahmed Khalid").build();
            clientRepository.save(client4);

            // Client 5
            Client client5 = Client.builder().clientId(UUID.randomUUID().toString()).Address("Tangier, Morocco").FullName("Fatima Ali").build();
            clientRepository.save(client5);

            // Client 6
            Client client6 = Client.builder().clientId(UUID.randomUUID().toString()).Address("Agadir, Morocco").FullName("Sara Hassan").build();
            clientRepository.save(client6);

            // Client 7
            Client client7 = Client.builder().clientId(UUID.randomUUID().toString()).Address("Fez, Morocco").FullName("Omar Ahmed").build();
            clientRepository.save(client7);
        };
    }

}
