package com.example.spring.Service;

import com.example.spring.Entity.Client;
import com.example.spring.Repository.ClientRepository;

import java.util.List;
import java.util.Optional;

/**
 * The ClientServiceImpl class implements the ClientService interface.
 * It provides methods to manage Client entities by interacting with the ClientRepository.
 */
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(int clientId) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        return optionalClient.orElse(null);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client updateClient(Client client) {
        Client existingClient = clientRepository.findById(client.getId()).orElse(null);
        if (existingClient != null) {
            existingClient.setName(client.getName());
            existingClient.setAge(client.getAge());
            existingClient.setTrainerId(client.getTrainerId());
            return clientRepository.save(existingClient);
        }
        return null;
    }

    @Override
    public void deleteClient(int clientId) {
        clientRepository.deleteById(clientId);
    }
}
