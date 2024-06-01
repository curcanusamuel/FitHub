package com.example.spring.service;

import com.example.spring.entity.Client;
import com.example.spring.entity.Staff;
import com.example.spring.entity.Trainer;
import com.example.spring.repository.ClientRepository;
import com.example.spring.repository.StaffRepository;
import com.example.spring.repository.TrainerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The StaffServiceImpl class implements the StaffService interface.
 * It provides methods to manage Staff entities by interacting with the StaffRepository.
 */
@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    private final ClientRepository clientRepository;
    private final TrainerRepository trainerRepository;

    /**
     * Constructor for StaffServiceImpl.
     *
     * @param staffRepository   The repository for Staff entities.
     * @param clientRepository  The repository for Client entities.
     * @param trainerRepository The repository for Trainer entities.
     */
    public StaffServiceImpl(StaffRepository staffRepository, ClientRepository clientRepository, TrainerRepository trainerRepository) {
        this.staffRepository = staffRepository;
        this.clientRepository = clientRepository;
        this.trainerRepository = trainerRepository;
    }

    /**
     * Creates a new staff member.
     *
     * @param staff The staff member to be created.
     * @return The created staff member.
     */
    @Override
    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    /**
     * Retrieves a staff member by its ID.
     *
     * @param staffId The ID of the staff member to retrieve.
     * @return The staff member with the specified ID, or null if not found.
     */
    @Override
    public Staff getStaffById(int staffId) {
        Optional<Staff> optionalStaff = staffRepository.findById(staffId);
        return optionalStaff.orElse(null);
    }

    /**
     * Retrieves all staff members.
     *
     * @return A list of all staff members.
     */
    @Override
    public List<Staff> getAllStaffs() {
        return staffRepository.findAll();
    }

    /**
     * Updates an existing staff member.
     *
     * @param staff The staff member to be updated.
     * @return The updated staff member.
     */
    @Override
    public Staff updateStaff(Staff staff) {
        Staff existingStaff = staffRepository.findById(staff.getId()).orElse(null);
        if (existingStaff != null) {
            existingStaff.setName(staff.getName());
            existingStaff.setAge(staff.getAge());
            existingStaff.setPassword(staff.getPassword());
            return staffRepository.save(existingStaff);
        }
        return null;
    }

    /**
     * Deletes a staff member by its ID.
     *
     * @param staffId The ID of the staff member to delete.
     */
    @Override
    public void deleteStaff(int staffId) {
        staffRepository.deleteById(staffId);
    }

    /**
     * Deletes a trainer by its ID and sets the trainer to null for all clients associated with that trainer.
     *
     * @param trainerId The ID of the trainer to delete.
     */
    @Override
    public void deleteTrainer(int trainerId) {
        List<Client> clientsWithTrainer = clientRepository.findAll();
        for (Client client : clientsWithTrainer) {
            if (client.getTrainer() != null && client.getTrainer().getId() == trainerId) {
                client.setTrainer(null);
                clientRepository.save(client);
            }
        }
        trainerRepository.deleteById(trainerId);
    }

    /**
     * Deletes a client by its ID.
     *
     * @param clientId The ID of the client to delete.
     */
    @Override
    public void deleteClient(int clientId) {
        if (clientRepository.existsById(clientId)) {
            clientRepository.deleteById(clientId);
        }
    }

    /**
     * Retrieves a staff member by its name.
     *
     * @param name The name of the staff member to retrieve.
     * @return The staff member with the specified name, or null if not found.
     */
    @Override
    public Staff getStaffbyName(String name) {
        Optional<Staff> optionalStaff = null;
        List<Staff> staffs = staffRepository.findAll();
        for (Staff staff : staffs) {
            if (staff.getName().equals(name)) {
                optionalStaff = Optional.of(staff);
                break;
            }
        }
        return optionalStaff.orElse(null);
    }

    /**
     * Authenticates a staff member using their username and password.
     *
     * @param username The username of the staff member.
     * @param password The password of the staff member.
     * @return True if authentication is successful, false otherwise.
     */
    @Override
    public boolean authenticate(String username, String password) {
        Staff staff = staffRepository.findByName(username);
        return staff != null && staff.getPassword().equals(password);
    }
}
