package org.example.salesservice.client;

import org.example.salesservice.Model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CLIENT-SERVICE")
public interface ClientController {
    @GetMapping("/clients")
    public List<Client> getAllClients();
    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable("id") Integer id);

}
