package com.example.spring;

import com.example.spring.entity.Client;
import com.example.spring.entity.Staff;
import com.example.spring.entity.Trainer;
import com.example.spring.repository.ClientRepository;
import com.example.spring.repository.StaffRepository;
import com.example.spring.repository.TrainerRepository;
import com.example.spring.service.ClientServiceImpl;
import com.example.spring.service.StaffServiceImpl;
import com.example.spring.service.TrainerServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Test class for testing methods in StaffServiceImpl.
 */
public class StaffsTest {
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private StaffRepository staffRepository;
    @Mock
    private TrainerRepository trainerRepository;
    private StaffServiceImpl staffService;
    private TrainerServiceImpl trainerService;
    private ClientServiceImpl clientService;

    /**
     * Initializes the necessary objects for testing.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        staffService = new StaffServiceImpl(this.staffRepository,this.clientRepository,this.trainerRepository);
        trainerService=new TrainerServiceImpl(this.trainerRepository,this.clientRepository);
        clientService=new ClientServiceImpl(this.clientRepository,this.staffRepository,this.trainerRepository);
    }

    /**
     * Tests the creation of a staff member.
     */
    @Test
    public void createStaffTest() {
        Staff staff = new Staff(1, "Tudor",20,"1234");
        staffService.createStaff(staff);
        verify(staffRepository).save(staff);
    }

    /**
     * Tests the deletion of a staff member.
     */
    @Test
    public void deleteStaffTest() {
        List<Staff> staffs = staffService.getAllStaffs();
        for (Staff s : staffs) {
            staffService.deleteStaff(s.getId());
            verify(staffRepository).delete(s);
        }
    }


    /**
     * Tests the update of a staff member.
     */
    @Test
    public void updateStaffTest() {
        Staff staff = new Staff(1, "Tudor",20,"1234");
        staffService.createStaff(staff);
        staffService.updateStaff(staff);
        verify(staffRepository).save(staff);
        verify(staffRepository).findById(staff.getId());
    }

    /**
     * Tests getting a staff member by ID.
     */
    @Test
    public void getStaffTest() {
        List<Staff> staffs = staffService.getAllStaffs();
        for (Staff s : staffs) {
            verify(staffRepository).findById(s.getId());
        }
    }
    /**
     * Tests deletion a trainer member by ID.
     */
    @Test
    public void deleteTrainerTest() {
        List<Trainer> trainers = trainerService.getAllTrainers();
        for (Trainer t : trainers) {
            staffService.deleteTrainer(t.getId());
            verify(trainerRepository).delete(t);
        }
    }
    /**
     * Tests deletion a client member by ID.
     */
    @Test
    public void deleteClientTest() {
        List<Client> clients = clientService.getAllClients();
        for (Client c : clients) {
            staffService.deleteClient(c.getId());
            verify(clientRepository).delete(c);
        }
    }

    /**
     * Resets the mock repository after each test.
     */
    @After
    public void down() {
        Mockito.reset(staffRepository);
    }
}
