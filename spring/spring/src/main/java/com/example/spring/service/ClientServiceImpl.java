package com.example.spring.service;

import com.example.spring.entity.Client;
import com.example.spring.entity.Staff;
import com.example.spring.entity.Trainer;
import com.example.spring.repository.ClientRepository;
import com.example.spring.repository.StaffRepository;
import com.example.spring.repository.TrainerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * The ClientServiceImpl class implements the ClientService interface and Observer interface.
 * It provides methods to manage Client entities by interacting with the ClientRepository.
 * Additionally, it acts as an Observer for Client entity changes.
 */
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final StaffRepository staffRepository;
    private final TrainerRepository trainerRepository;

    /**
     * Constructor for ClientServiceImpl.
     *
     * @param clientRepository  The repository for Client entities.
     * @param staffRepository   The repository for Staff entities.
     * @param trainerRepository The repository for Trainer entities.
     */
    public ClientServiceImpl(ClientRepository clientRepository, StaffRepository staffRepository, TrainerRepository trainerRepository) {
        this.clientRepository = clientRepository;
        this.staffRepository = staffRepository;
        this.trainerRepository = trainerRepository;
    }

    /**
     * Creates a new client entity and attaches the current instance as an observer.
     *
     * @param client The client to be created.
     * @return The created client entity.
     */
    @Override
    public Client createClient(Client client) {
        if (client.getTrainer() != null) {
            client.attach(client.getTrainer());
            client.notify_Trainer(client.getTrainer(), "A client has been created: " + client.getName());
        }
        List<Staff> staffs = staffRepository.findAll();
        try {
            Staff staff = staffs.get(0);
            client.notify_Staff(staff, "A client has been created: " + client.getName());
        } catch (Exception e) {
            client.notify_Staff(new Staff(100, "Obligatoriu", 20, "1234"), "A client has been created: " + client.getName());
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
     * Generates a specified number of random client entities.
     *
     * @param count The number of clients to generate.
     * @return A list of generated client entities.
     */
    @Override
    public List<Client> generateRandomClients(int count) {
        List<Client> clients = new ArrayList<>();
        List<Trainer> trainers = trainerRepository.findAll();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            Client client = new Client();
            client.setName("Client " + random.nextInt(10000));
            client.setAge(random.nextInt(91) + 10);
            if (random.nextBoolean() && !trainers.isEmpty()) {
                client.setTrainer(trainers.get(random.nextInt(trainers.size())));
            } else {
                client.setTrainer(null);
            }
            clients.add(client);
        }

        return clientRepository.saveAll(clients);
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

            if (client.getTrainer() != null) {
                Trainer trainer = trainerRepository.findById(client.getTrainer().getId()).orElse(null);
                existingClient.setTrainer(trainer);
                if (trainer != null) {
                    existingClient.attach(trainer);
                    existingClient.notify_Trainer(trainer, "A modification has been made to a client named: " + existingClient.getName());
                }
            } else {
                existingClient.setTrainer(null);
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
            if (clientToDelete.getTrainer() != null) {
                clientToDelete.notify_Trainer(clientToDelete.getTrainer(), "The client named " + clientToDelete.getName() + " has been deleted");
                clientToDelete.detach(clientToDelete.getTrainer());
            }
            List<Staff> staffs = staffRepository.findAll();
            if (!staffs.isEmpty()) {
                Staff staff = staffs.get(0);
                clientToDelete.notify_Staff(staff, "The client named " + clientToDelete.getName() + " has been deleted");
            }
        }
        clientRepository.deleteById(clientId);
    }

    /**
     * Deletes all client entities.
     *
     * @return null
     */
    @Override
    @Transactional
    public List<Client> deleteAllClients() {
        clientRepository.deleteAll();
        return null;
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
