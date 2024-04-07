package com.example.spring.Repository;

import com.example.spring.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The ClientRepository interface provides methods for accessing and managing Client entities in the database.
 * It extends the JpaRepository interface, which provides CRUD (Create, Read, Update, Delete) operations for Client entities.
 */
public interface ClientRepository extends JpaRepository<Client,Integer> {
    List<Client> findByTrainerIdIsNullOrTrainerIdEquals(int trainerId);
}
