package com.example.spring.Service;

import com.example.spring.Entity.Trainer;

import java.util.List;

/**
 * The TrainerService interface defines operations for managing Trainer entities.
 */

public interface TrainerService {

    /**
     * Creates a new trainer.
     *
     * @param trainer The trainer to be created.
     * @return The created trainer.
     */
    Trainer createTrainer(Trainer trainer);

    /**
     * Retrieves a trainer by its ID.
     *
     * @param trainerId The ID of the trainer to retrieve.
     * @return The trainer with the specified ID, or null if not found.
     */
    Trainer getTrainerById(int trainerId);

    /**
     * Retrieves all trainers.
     *
     * @return A list of all trainers.
     */
    List<Trainer> getAllTrainers();

    /**
     * Updates an existing trainer.
     *
     * @param trainer The trainer to be updated.
     * @return The updated trainer.
     */
    Trainer updateTrainer(Trainer trainer);

    /**
     * Deletes a trainer by its ID.
     *
     * @param trainerId The ID of the trainer to delete.
     */
    void deleteTrainer(int trainerId);

}
