package com.example.spring.entity;

import com.example.spring.observer.Observer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
public class Trainer implements Observer {

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
    @JsonIgnore
    @OneToMany(mappedBy = "trainer",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Client> clients=new ArrayList<>();

    /**
     * Method called when the trainer is notified.
     *
     * @param s The message received by the trainer.
     */
    @Override
    public void update(String s) {
        System.out.println(s);
    }
}
