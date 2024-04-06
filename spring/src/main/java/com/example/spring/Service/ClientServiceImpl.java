package com.example.spring.Service;

import com.example.spring.Entity.Client;
import com.example.spring.Observer.Observer;
import com.example.spring.Repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The ClientServiceImpl class implements the ClientService interface.
 * It provides methods to manage Client entities by interacting with the ClientRepository.
 */
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService,Observer{

    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        client.Attach(this);
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
        client.Attach(this);
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
        Client clientToDelete =getClientById(clientId);
        if (clientToDelete != null) {
            clientToDelete.Attach(this);
        }
        clientRepository.deleteById(clientId);
    }

    @Override
    public void update(Object o) {

    }
}
