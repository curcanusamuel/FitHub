package com.example.spring.repository;

import com.example.spring.entity.Client;
import com.example.spring.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The ClientRepository interface provides methods for accessing and managing Client entities in the database.
 * It extends the JpaRepository interface, which provides CRUD (Create, Read, Update, Delete) operations for Client entities.
 */
public interface ClientRepository extends JpaRepository<Client,Integer> {

    /**
     * Retrieves a list of clients by trainer ID.
     * If the trainer ID is null, retrieves clients without a trainer.
     *
     * @param trainer The trainer associated with the clients.
     * @return A list of clients filtered by the trainer ID or without a trainer.
     */
    List<Client> findByTrainerIdIsNullOrTrainerIdEquals(Trainer trainer);
}
