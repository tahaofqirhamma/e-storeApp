package org.example.clientservice.service;

import org.example.clientservice.entities.Client;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientServiceInterface {
    public List<Client> getAllClients();
    public Client getClient(Integer id);
    public void addClient(Client client);
    public void updateClient(Client clientRequestDto, Integer id);
    public void deleteClient(Integer id);
}
