package com.example.spring.Service;

import com.example.spring.Entity.Client;

import java.util.List;

/**
 * The ClientService interface defines operations for managing Client entities.
 */
public interface ClientService {

    /**
     * Creates a new client.
     *
     * @param client The client to be created.
     * @return The created client.
     */
    Client createClient(Client client);

    /**
     * Retrieves a client by its ID.
     *
     * @param clientId The ID of the client to retrieve.
     * @return The client with the specified ID, or null if not found.
     */
    Client getClientById(int clientId);

    /**
     * Retrieves all clients.
     *
     * @return A list of all clients.
     */
    List<Client> getAllClients();

    /**
     * Updates an existing client.
     *
     * @param client The client to be updated.
     * @return The updated client.
     */
    Client updateClient(Client client);

    /**
     * Deletes a client by its ID.
     *
     * @param clientId The ID of the client to delete.
     */
    void deleteClient(int clientId);

}
