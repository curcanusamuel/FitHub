package com.example.spring;

import com.example.spring.entity.Client;
import com.example.spring.repository.ClientRepository;
import com.example.spring.service.ClientServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Test class for testing methods in ClientServiceImpl.
 */
public class ClientsTest {
    @Mock
    private ClientRepository clientRepository;
    private ClientServiceImpl clientService;

    /**
     * Initializes the necessary objects for testing.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        clientService = new ClientServiceImpl(this.clientRepository);
    }

    /**
     * Tests the creation of a client.
     */
    @Test
    public void createClientTest() {
        Client client = new Client(20, "NoutTest", 30, null);
        clientService.createClient(client);
        verify(clientRepository).save(client);
    }

    /**
     * Tests the deletion of a client.
     */
    @Test
    public void deleteClientTest() {
        List<Client> clients = clientService.getAllClients();
        for (Client c : clients) {
            clientService.deleteClient(c.getId());
            verify(clientRepository).delete(c);
        }
    }

    /**
     * Tests the update of a client.
     */
    @Test
    public void updateClientTest() {
        Client client = new Client(20, "NoutTest", 30, null);
        clientService.createClient(client);
        clientService.updateClient(client);
        verify(clientRepository).save(client);
        verify(clientRepository).findById(client.getId());
    }

    /**
     * Tests getting a client by ID.
     */
    @Test
    public void getClientTest() {
        List<Client> clients = clientService.getAllClients();
        for (Client c : clients) {
            verify(clientRepository).findById(c.getId());
        }
    }

    /**
     * Tests getting clients without a trainer.
     */
    @Test
    public void getClientWithoutTrainerTest() {
        List<Client> clients = clientService.getClientwithoutTrainer();
        for (Client c : clients) {
            verify(clientRepository).findById(c.getId());
        }
    }

    /**
     * Resets the mock repository after each test.
     */
    @After
    public void down() {
        Mockito.reset(clientRepository);
    }
}
