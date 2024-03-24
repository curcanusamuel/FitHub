package com.example.spring.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * The Trainer class represents a trainer entity in the application.
 * This class is mapped to the "Trainer_DB" table in the database.
 */
@Getter
@Setter
@AllArgsConstructor
@Entity
@Data
@Table(name="Trainer_DB")
@NoArgsConstructor
public class Trainer {

    /**
     * The unique identifier for the trainer.
     */
    @Id
    @Column(name="ID")
    @GeneratedValue
    private int id;

    /**
     * The name of the trainer.
     */
    @Column(name="NAME",nullable = false)
    private String name;

    /**
     * The ID of the client associated with the trainer.
     * Can be null if no client is assigned.
     */
    @Column(name="ClientID",nullable = true)
    private int clientId;
}
