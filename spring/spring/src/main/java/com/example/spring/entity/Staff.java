package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * The Staff class represents a staff member entity in the application.
 * This class is mapped to the "Staff_DB" table in the database.
 */
@Getter
@Setter
@AllArgsConstructor
@Entity
@Data
@Table(name="Staff_DB")
@NoArgsConstructor
public class Staff{

    /**
     * The unique identifier for the staff member.
     */
    @Id
    @Column(name="ID")
    @GeneratedValue
    private int id;

    /**
     * The name of the staff member.
     */
    @Column(name="NAME",nullable = false)
    private String name;

    /**
     * The ID of the client associated with the staff member.
     * Can be null if no client is assigned.
     */
    @Column(name="ClientID",nullable = true)
    private int clientId;

    /**
     * The ID of the trainer associated with the staff member.
     * Can be null if no trainer is assigned.
     */
    @Column(name="TrainerID",nullable = true)
    private int trainerId;

}
