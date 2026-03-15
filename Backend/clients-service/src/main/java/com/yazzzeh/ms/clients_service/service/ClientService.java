package com.yazzzeh.ms.clients_service.service;

import com.yazzzeh.ms.clients_service.model.Client;
import com.yazzzeh.ms.clients_service.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Get all clients
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Get client by id
    public Client getClientById(Long id) throws Exception {
        return clientRepository.findById(id).orElseThrow(() -> new Exception("Client not found"));
    }

    // Create a new client
    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    // Update a client
    public ResponseEntity<Client> updateClient(Long id, Client client) throws Exception {
        Client existingClient = clientRepository.findById(id).orElseThrow(() -> new Exception("Client not found"));
        existingClient.setAge(client.getAge());
        existingClient.setName(client.getName());
        clientRepository.save(existingClient);
        return ResponseEntity.ok().body(existingClient);
    }

    // Delete a client
    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }
}
