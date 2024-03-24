package com.example.spring.Service;

import com.example.spring.Entity.Trainer;
import com.example.spring.Repository.TrainerRepository;

import java.util.List;
import java.util.Optional;

/**
 * The TrainerServiceImpl class implements the TrainerService interface.
 * It provides methods to manage Trainer entities by interacting with the TrainerRepository.
 */
public class TrainerServiceImpl implements TrainerService {

    private TrainerRepository trainerRepository;

    @Override
    public Trainer createTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    @Override
    public Trainer getTrainerById(int trainerId) {
        Optional<Trainer> optionalTrainer = trainerRepository.findById(trainerId);
        return optionalTrainer.orElse(null);
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer updateTrainer(Trainer trainer) {
        Trainer existingTrainer = trainerRepository.findById(trainer.getId()).orElse(null);
        if (existingTrainer != null) {
            existingTrainer.setName(trainer.getName());
            existingTrainer.setClientId(trainer.getClientId());
            return trainerRepository.save(existingTrainer);
        }
        return null;
    }

    @Override
    public void deleteTrainer(int trainerId) {
        trainerRepository.deleteById(trainerId);
    }
}
