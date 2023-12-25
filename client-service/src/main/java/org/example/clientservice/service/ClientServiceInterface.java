package org.example.clientservice.service;

import org.example.clientservice.entities.Client;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientServiceInterface {
    public List<Client> getAllClients();
    public Client getClient(String id);
    public void addClient(Client client);
    public void updateClient(Client clientRequestDto, String id);
    public void deleteClient(String id);
}
