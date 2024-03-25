package com.example.spring.Controller;

import com.example.spring.Entity.Client;
import com.example.spring.Service.ClientService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The ClientController class handles HTTP requests related to client entities.
 * It defines REST endpoints for CRUD operations on clients.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/clients")
public class ClientController {

    private ClientService clientService;

    /**
     * REST endpoint to create a new client.
     *
     * @param client The client data to be created.
     * @return The created client and HTTP status code 201 (Created) if successful.
     */
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        Client savedClient = clientService.createClient(client);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    /**
     * REST endpoint to retrieve a client by ID.
     *
     * @param clientId The ID of the client to retrieve.
     * @return The client with the specified ID and HTTP status code 200 (OK) if found.
     */
    @GetMapping("{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") int clientId){
        Client client = clientService.getClientById(clientId);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    /**
     * REST endpoint to retrieve all clients.
     *
     * @return A list of all clients and HTTP status code 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    /**
     * REST endpoint to update an existing client.
     *
     * @param clientId The ID of the client to update.
     * @param client   The updated client data.
     * @return The updated client and HTTP status code 200 (OK) if successful.
     */
    @PutMapping("{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") int clientId,
                                               @RequestBody Client client){
        client.setId(clientId);
        Client updatedClient = clientService.updateClient(client);
        return new ResponseEntity<>(updatedClient, HttpStatus.OK);
    }

    /**
     * REST endpoint to delete a client by ID.
     *
     * @param clientId The ID of the client to delete.
     * @return A success message and HTTP status code 200 (OK) if deletion is successful.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") int clientId){
        clientService.deleteClient(clientId);
        return new ResponseEntity<>("Client successfully deleted!", HttpStatus.OK);
    }
}
