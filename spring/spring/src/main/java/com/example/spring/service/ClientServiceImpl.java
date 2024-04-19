package com.example.spring.service;

import com.example.spring.entity.Client;
import com.example.spring.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The ClientServiceImpl class implements the ClientService interface and Observer interface.
 * It provides methods to manage Client entities by interacting with the ClientRepository.
 * Additionally, it acts as an Observer for Client entity changes.
 */
@Service
public class ClientServiceImpl implements ClientService {


    private ClientRepository clientRepository;
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }

    /**
     * Creates a new client entity and attaches the current instance as an observer.
     *
     * @param client The client to be created.
     * @return The created client entity.
     */
    @Override
    public Client createClient(Client client) {
        if(client.getTrainer()!=null){
            client.attach(client.getTrainer());
            client.notify_Trainer(client.getTrainer(),"A client has been created");
        }

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
        if (existingClient != null) {
            existingClient.setName(client.getName());
            existingClient.setAge(client.getAge());
            existingClient.setTrainer(client.getTrainer());
            if(client.getTrainer()!=null){
                existingClient.attach(client.getTrainer());
                existingClient.notify_Trainer(existingClient.getTrainer(),"A modification has been made to a client named: "+existingClient.getName());

            }
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
            clientToDelete.notify_Trainer(clientToDelete.getTrainer(),"The client named "+clientToDelete.getName()+" has been deleted");
            clientToDelete.detach(clientToDelete.getTrainer());
        }
        clientRepository.deleteById(clientId);
    }

    /**
     * Retrieves all client entities without a trainer.
     *
     * @return A list of all client entities without a trainer.
     */
    public List<Client> getClientwithoutTrainer() {
        return clientRepository.findByTrainerIdIsNullOrTrainerIdEquals(null);
    }


}
