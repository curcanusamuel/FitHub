package com.example.spring.repository;

import com.example.spring.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The TrainerRepository interface provides methods for accessing and managing Trainer entities in the database.
 * It extends the JpaRepository interface, which provides CRUD (Create, Read, Update, Delete) operations for Trainer entities.
 */
public interface TrainerRepository extends JpaRepository<Trainer,Integer> {
}
