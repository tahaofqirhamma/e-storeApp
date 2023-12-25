package org.example.salesservice;

import org.example.salesservice.config.GlobalConfig;
import org.example.salesservice.config.SalesConfig;
import org.example.salesservice.entities.Sale;
import org.example.salesservice.repositories.SalesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
@EnableConfigurationProperties({GlobalConfig.class, SalesConfig.class})

@SpringBootApplication
@EnableFeignClients
public class SalesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(SalesRepository salesRepository){
        return args -> {
            Sale sale = Sale.builder().saleDate(new Date()).clientId("15cba452-642a-432e-a8db-a038a7bbd263").productId(1).saleQuantity(3).build();
            salesRepository.save(sale);
        };
    }

}
