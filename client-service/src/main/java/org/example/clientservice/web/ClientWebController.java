package org.example.clientservice.web;

import org.example.clientservice.entities.Client;
import org.example.clientservice.service.ClientServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Component
@RestController
@RequestMapping("/api/v1")
public class    ClientWebController {

    @Autowired
    ClientServiceInterface clientServiceInterface;

    @GetMapping("/clients")
    public List<Client> getAllClients(){
        return clientServiceInterface.getAllClients();
    }

    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable("id") Integer id){
        return clientServiceInterface.getClient(id);
    }

    @PostMapping("/clients")
    public void addClient(@RequestBody Client client){
        clientServiceInterface.addClient(client);
    }

    @PutMapping("/clients/{id}")
    public void updateClient(@PathVariable("id") Integer id,@RequestBody Client client){
        clientServiceInterface.updateClient(client,id);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Integer id){
        clientServiceInterface.deleteClient(id);
    }

}
