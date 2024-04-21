package com.example.spring.controller;

import com.example.spring.entity.Staff;
import com.example.spring.service.ClientService;
import com.example.spring.service.StaffService;
import com.example.spring.service.TrainerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The StaffController class handles HTTP requests related to staff entities.
 * It defines REST endpoints for CRUD operations on staff members.
 *
 * @author Curcanu Samuel Adrian
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/staffs")
public class StaffController {

    private StaffService staffService;
    private TrainerService trainerService;
    private ClientService clientService;

    /**
     * REST endpoint to create a new staff member.
     *
     * @param staff The staff member data to be created.
     * @return The created staff member and HTTP status code 201 (Created) if successful.
     */
    @PostMapping
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff){
        Staff savedStaff = staffService.createStaff(staff);
        return new ResponseEntity<>(savedStaff, HttpStatus.CREATED);
    }

    /**
     * REST endpoint to retrieve a staff member by ID.
     *
     * @param staffId The ID of the staff member to retrieve.
     * @return The staff member with the specified ID and HTTP status code 200 (OK) if found.
     */
    @GetMapping("{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable("id") int staffId){
        Staff staff = staffService.getStaffById(staffId);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    /**
     * REST endpoint to retrieve all staff members.
     *
     * @return A list of all staff members and HTTP status code 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Staff>> getAllStaffs(){
        List<Staff> staffs = staffService.getAllStaffs();
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }

    /**
     * REST endpoint to update an existing staff member.
     *
     * @param staffId The ID of the staff member to update.
     * @param staff   The updated staff member data.
     * @return The updated staff member and HTTP status code 200 (OK) if successful.
     */
    @PutMapping("{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable("id") int staffId,
                                             @RequestBody Staff staff){
        staff.setId(staffId);
        Staff updatedStaff = staffService.updateStaff(staff);
        return new ResponseEntity<>(updatedStaff, HttpStatus.OK);
    }

    /**
     * REST endpoint to delete a staff member by ID.
     *
     * @param staffId The ID of the staff member to delete.
     * @return A success message and HTTP status code 200 (OK) if deletion is successful.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable("id") int staffId){
        staffService.deleteStaff(staffId);
        return new ResponseEntity<>("Staff successfully deleted!", HttpStatus.OK);
    }
    /**
     * REST endpoint to delete a trainer member by ID.
     *
     * @param trainerId The ID of the trainer member to delete.
     * @return A success message and HTTP status code 200 (OK) if deletion is successful.
     */
    @DeleteMapping("/deleteTrainer/{id}")
    public ResponseEntity<String> deleteTrainer(@PathVariable("id") int trainerId){
        trainerService.deleteTrainer(trainerId);
        return new ResponseEntity<>("Trainer successfully deleted!", HttpStatus.OK);
    }
    /**
     * REST endpoint to delete a client member by ID.
     *
     * @param clientId The ID of the client member to delete.
     * @return A success message and HTTP status code 200 (OK) if deletion is successful.
     */
    @DeleteMapping("/deleteClient/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") int clientId){
        clientService.deleteClient(clientId);
        return new ResponseEntity<>("Client successfully deleted!", HttpStatus.OK);
    }
}
