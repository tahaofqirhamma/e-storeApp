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
            Client client1 = Client.builder().Address("Rabat, Morocco").FullName("Taha ofqir-hamma").productId(1).build();
            clientRepository.save(client1);

            // Client 2
            Client client2 = Client.builder().Address("Casablanca, Morocco").FullName("John Doe").productId(2).build();
            clientRepository.save(client2);

            // Client 3
            Client client3 = Client.builder().Address("Marrakech, Morocco").FullName("Jane Smith").productId(3).build();
            clientRepository.save(client3);

            // Client 4
            Client client4 = Client.builder().Address("Fes, Morocco").FullName("Ahmed Khalid").productId(4).build();
            clientRepository.save(client4);

            // Client 5
            Client client5 = Client.builder().Address("Tangier, Morocco").FullName("Fatima Ali").productId(5).build();
            clientRepository.save(client5);

            // Client 6
            Client client6 = Client.builder().Address("Agadir, Morocco").FullName("Sara Hassan").productId(6).build();
            clientRepository.save(client6);

            // Client 7
            Client client7 = Client.builder().Address("Fez, Morocco").FullName("Omar Ahmed").productId(7).build();
            clientRepository.save(client7);
        };
    }

}
