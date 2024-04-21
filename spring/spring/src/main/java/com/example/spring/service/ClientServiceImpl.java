package com.example.spring.service;

import com.example.spring.entity.Client;
import com.example.spring.entity.Staff;
import com.example.spring.repository.ClientRepository;
import com.example.spring.repository.StaffRepository;
import org.springframework.stereotype.Service;

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


    private ClientRepository clientRepository;
    private StaffRepository staffRepository;
    public ClientServiceImpl(ClientRepository clientRepository,StaffRepository staffRepository){
        this.clientRepository=clientRepository;
        this.staffRepository=staffRepository;
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
            client.notify_Trainer(client.getTrainer(),"A client has been created: "+client.getName());

        }
        List<Staff> staffs=staffRepository.findAll();
        try{
            Staff staff=staffs.getFirst();
            client.notify_Staff(staff,"A client has been created: "+client.getName());
        } catch (Exception e){
            client.notify_Staff(new Staff(100,"Obligatoriu",20),"A client has been created: "+client.getName());
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
            List<Staff> staffs=staffRepository.findAll();
            Staff staff=staffs.getFirst();
            existingClient.notify_Staff(staff,"A modification has been made to a client named: "+existingClient.getName());
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
            if(clientToDelete.getTrainer()!=null){
                clientToDelete.notify_Trainer(clientToDelete.getTrainer(),"The client named "+clientToDelete.getName()+" has been deleted");
                clientToDelete.detach(clientToDelete.getTrainer());
            }
            List<Staff> staffs=staffRepository.findAll();
            Staff staff=staffs.getFirst();
            clientToDelete.notify_Staff(staff,"The client named "+clientToDelete.getName()+" has been deleted");
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
