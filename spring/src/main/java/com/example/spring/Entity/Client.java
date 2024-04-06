package com.example.spring.Entity;

import com.example.spring.Observer.Observer;
import com.example.spring.Observer.Subject;
import com.example.spring.Service.ClientServiceImpl;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The Client class represents a client entity in the application.
 * This class is mapped to the "Client_DB" table in the database.
 */
@Getter
@Setter
@AllArgsConstructor
@Entity
@Data
@Table(name="Client_DB")
@NoArgsConstructor
public class Client implements Subject{

    /**
     * The unique identifier for the client.
     */
    @Id
    @Column(name="ID")
    @GeneratedValue
    private int id;

    /**
     * The name of the client.
     */
    @Column(name="NAME",nullable = false)
    private String name;

    /**
     * The age of the client.
     */
    @Column(name="AGE",nullable = false)
    private int age;

    /**
     * The ID of the trainer associated with the client.
     * Can be null if no trainer is assigned.
     */
    @Column(name="TrainerID",nullable = true)
    private int trainerId;

    private List<Observer> observers = new ArrayList<>();
    @Override
    public void Attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void Detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void Notify() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
