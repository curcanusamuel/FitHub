package com.example.spring.repository;

import com.example.spring.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The StaffRepository interface provides methods for accessing and managing Staff entities in the database.
 * It extends the JpaRepository interface, which provides CRUD (Create, Read, Update, Delete) operations for Staff entities.
 */
public interface StaffRepository extends JpaRepository<Staff, Integer> {

    /**
     * Finds a staff member by their name.
     *
     * @param name The name of the staff member to find.
     * @return The staff member with the specified name, or null if no staff member is found.
     */
    Staff findByName(String name);
}
