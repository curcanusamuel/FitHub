package com.example.spring.service;

import com.example.spring.entity.Staff;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The StaffService interface defines operations for managing Staff entities.
 */
public interface StaffService {

    /**
     * Creates a new staff member.
     *
     * @param staff The staff member to be created.
     * @return The created staff member.
     */
    Staff createStaff(Staff staff);

    /**
     * Retrieves a staff member by its ID.
     *
     * @param staffId The ID of the staff member to retrieve.
     * @return The staff member with the specified ID, or null if not found.
     */
    Staff getStaffById(int staffId);

    /**
     * Retrieves all staff members.
     *
     * @return A list of all staff members.
     */
    List<Staff> getAllStaffs();

    /**
     * Updates an existing staff member.
     *
     * @param staff The staff member to be updated.
     * @return The updated staff member.
     */
    Staff updateStaff(Staff staff);

    /**
     * Deletes a staff member by its ID.
     *
     * @param staffId The ID of the staff member to delete.
     */
    void deleteStaff(int staffId);

    /**
     * Deletes a trainer member by its ID.
     *
     * @param trainerId The ID of the trainer member to delete.
     */
    void deleteTrainer(int trainerId);

    /**
     * Deletes a client member by its ID.
     *
     * @param clientId The ID of the client member to delete.
     */
    void deleteClient(int clientId);

    /**
     * Retrieves a staff member by its name.
     *
     * @param name The name of the staff member to retrieve.
     * @return The staff member with the specified name, or null if not found.
     */
    Staff getStaffbyName(String name);

    /**
     * Authenticates a staff member using their username and password.
     *
     * @param username The username of the staff member.
     * @param password The password of the staff member.
     * @return True if authentication is successful, false otherwise.
     */
    boolean authenticate(String username, String password);
}
