package com.example.spring.Service;

import com.example.spring.Entity.Client;
import com.example.spring.Observer.Observer;
import com.example.spring.Repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The ClientServiceImpl class implements the ClientService interface and Observer interface.
 * It provides methods to manage Client entities by interacting with the ClientRepository.
 * Additionally, it acts as an Observer for Client entity changes.
 */
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService, Observer {

    private ClientRepository clientRepository;

    /**
     * Creates a new client entity and attaches the current instance as an observer.
     *
     * @param client The client to be created.
     * @return The created client entity.
     */
    @Override
    public Client createClient(Client client) {
        client.Attach(this);
        return clientRepository.save(client);
    }

    /**
     * Retrieves a client entity by its ID.
     *
     * @param clientId The ID of the client to retrieve.
     * @return The client entity if found, else null.
     */
    @Override
    public Client getClientById(int clientId) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        return optionalClient.orElse(null);
    }

    /**
     * Retrieves all client entities.
     *
     * @return A list of all client entities.
     */
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    /**
     * Updates an existing client entity and attaches the current instance as an observer.
     *
     * @param client The updated client entity.
     * @return The updated client entity.
     */
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

    /**
     * Deletes a client entity by its ID.
     *
     * @param clientId The ID of the client to delete.
     */
    @Override
    public void deleteClient(int clientId) {
        Client clientToDelete = getClientById(clientId);
        if (clientToDelete != null) {
            clientToDelete.Attach(this);
        }
        clientRepository.deleteById(clientId);
    }

    /**
     * Retrieves all client entities without a trainer.
     *
     * @return A list of all client entities without a trainer.
     */
    public List<Client> getClientwithoutTrainer() {
        return clientRepository.findByTrainerIdIsNullOrTrainerIdEquals(0);
    }

    /**
     * Updates the state of this observer.
     * Currently not implemented.
     *
     * @param o The object to observe.
     */
    @Override
    public void update(Object o) {
        // Not implemented
    }
}
