package com.example.spring.Controller;

import com.example.spring.Entity.Trainer;
import com.example.spring.Service.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The TrainerController class handles HTTP requests related to trainer entities.
 * It defines REST endpoints for CRUD operations on trainers.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/Trainers")
public class TrainerController {

    private TrainerService trainerService;

    /**
     * REST endpoint to create a new trainer.
     *
     * @param trainer The trainer data to be created.
     * @return The created trainer and HTTP status code 201 (Created) if successful.
     */
    @PostMapping
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer){
        Trainer savedTrainer = trainerService.createTrainer(trainer);
        return new ResponseEntity<>(savedTrainer, HttpStatus.CREATED);
    }

    /**
     * REST endpoint to retrieve a trainer by ID.
     *
     * @param trainerId The ID of the trainer to retrieve.
     * @return The trainer with the specified ID and HTTP status code 200 (OK) if found.
     */
    @GetMapping("{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable("id") int trainerId){
        Trainer trainer = trainerService.getTrainerById(trainerId);
        return new ResponseEntity<>(trainer, HttpStatus.OK);
    }

    /**
     * REST endpoint to retrieve all trainers.
     *
     * @return A list of all trainers and HTTP status code 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Trainer>> getAllTrainers(){
        List<Trainer> trainers = trainerService.getAllTrainers();
        return new ResponseEntity<>(trainers, HttpStatus.OK);
    }

    /**
     * REST endpoint to update an existing trainer.
     *
     * @param trainerId The ID of the trainer to update.
     * @param trainer   The updated trainer data.
     * @return The updated trainer and HTTP status code 200 (OK) if successful.
     */
    @PutMapping("{id}")
    public ResponseEntity<Trainer> updateTrainer(@PathVariable("id") int trainerId,
                                                 @RequestBody Trainer trainer){
        trainer.setId(trainerId);
        Trainer updatedTrainer = trainerService.updateTrainer(trainer);
        return new ResponseEntity<>(updatedTrainer, HttpStatus.OK);
    }

    /**
     * REST endpoint to delete a trainer by ID.
     *
     * @param trainerId The ID of the trainer to delete.
     * @return A success message and HTTP status code 200 (OK) if deletion is successful.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTrainer(@PathVariable("id") int trainerId){
        trainerService.deleteTrainer(trainerId);
        return new ResponseEntity<>("Trainer successfully deleted!", HttpStatus.OK);
    }
}
