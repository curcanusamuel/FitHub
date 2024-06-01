package com.example.spring;

import com.example.spring.entity.Trainer;
import com.example.spring.repository.ClientRepository;
import com.example.spring.repository.TrainerRepository;
import com.example.spring.service.TrainerServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Test class for testing methods in TrainerServiceImpl.
 */
public class TrainersTest {
    @Mock
    private TrainerRepository trainerRepository;
    private TrainerServiceImpl trainerService;
    private ClientRepository clientRepository;

    /**
     * Initializes the necessary objects for testing.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        trainerService = new TrainerServiceImpl(this.trainerRepository,this.clientRepository);
    }

    /**
     * Tests the creation of a trainer.
     */
    @Test
    public void createTrainerTest() {
        Trainer trainer = new Trainer(1, "Sami", null);
        trainerService.createTrainer(trainer);
        verify(trainerRepository).save(trainer);
    }

    /**
     * Tests the deletion of a trainer.
     */
    @Test
    public void deleteTrainerTest() {
        List<Trainer> trainers = trainerService.getAllTrainers();
        for (Trainer t : trainers) {
            trainerService.deleteTrainer(t.getId());
            verify(trainerRepository).delete(t);
        }
    }

    /**
     * Tests the update of a trainer.
     */
    @Test
    public void updateTrainerTest() {
        Trainer trainer = new Trainer(1, "Sami", null);
        trainerService.createTrainer(trainer);
        trainerService.updateTrainer(trainer);
        verify(trainerRepository).save(trainer);
        verify(trainerRepository).findById(trainer.getId());
    }

    /**
     * Tests getting a trainer by ID.
     */
    @Test
    public void getTrainerTest() {
        List<Trainer> trainers = trainerService.getAllTrainers();
        for (Trainer t : trainers) {
            verify(trainerRepository).findById(t.getId());
        }
    }

    /**
     * Resets the mock repository after each test.
     */
    @After
    public void down() {
        Mockito.reset(trainerRepository);
    }
}

