package com.example.spring.service;

import com.example.spring.entity.Trainer;
import com.example.spring.repository.TrainerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The TrainerServiceImpl class implements the TrainerService interface.
 * It provides methods to manage Trainer entities by interacting with the TrainerRepository.
 */
@Service
@AllArgsConstructor
public class TrainerServiceImpl implements TrainerService {

    private TrainerRepository trainerRepository;

    /**
     * Creates a new trainer entity.
     *
     * @param trainer The trainer to be created.
     * @return The created trainer entity.
     */
    @Override
    public Trainer createTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    /**
     * Retrieves a trainer entity by its ID.
     *
     * @param trainerId The ID of the trainer to retrieve.
     * @return The trainer entity if found, else null.
     */
    @Override
    public Trainer getTrainerById(int trainerId) {
        Optional<Trainer> optionalTrainer = trainerRepository.findById(trainerId);
        return optionalTrainer.orElse(null);
    }

    /**
     * Retrieves all trainer entities.
     *
     * @return A list of all trainer entities.
     */
    @Override
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    /**
     * Updates an existing trainer entity.
     *
     * @param trainer The updated trainer entity.
     * @return The updated trainer entity.
     */
    @Override
    public Trainer updateTrainer(Trainer trainer) {
        Trainer existingTrainer = trainerRepository.findById(trainer.getId()).orElse(null);
        if (existingTrainer != null) {
            existingTrainer.setName(trainer.getName());
            existingTrainer.setClients(trainer.getClients());
            return trainerRepository.save(existingTrainer);
        }
        return null;
    }

    /**
     * Deletes a trainer entity by its ID.
     *
     * @param trainerId The ID of the trainer to delete.
     */
    @Override
    public void deleteTrainer(int trainerId) {
        trainerRepository.deleteById(trainerId);
    }

}
