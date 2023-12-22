package org.example.clientservice.service;

import jakarta.transaction.Transactional;
import org.example.clientservice.entities.Client;
import org.example.clientservice.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class ClientService implements ClientServiceInterface{
    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClient(Integer id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public void addClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void updateClient(Client clientReq, Integer id) {

      Client client = clientRepository.findById(id).get();
        if(clientReq.getFullName() != null) client.setFullName(clientReq.getFullName());
        if (clientReq.getAddress() != null) client.setAddress(clientReq.getAddress());
    }

    @Override
    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }
}
