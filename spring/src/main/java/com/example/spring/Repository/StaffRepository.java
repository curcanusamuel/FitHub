package com.example.spring.Repository;

import com.example.spring.Entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The StaffRepository interface provides methods for accessing and managing Staff entities in the database.
 * It extends the JpaRepository interface, which provides CRUD (Create, Read, Update, Delete) operations for Staff entities.
 */
public interface StaffRepository extends JpaRepository<Staff,Integer> {
}
