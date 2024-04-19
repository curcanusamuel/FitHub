package com.example.spring.entity;

import com.example.spring.observer.Observer;
import com.example.spring.observer.Subject;
import jakarta.persistence.*;
import lombok.*;

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
public class Client implements Subject {

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
    @ManyToOne
    @JoinColumn(name="Trainer_id",referencedColumnName = "id",nullable = true)
    private com.example.spring.entity.Trainer trainer;

    /**
     * Attaches an observer (trainer) to the client.
     *
     * @param o The observer (trainer) to attach.
     */
    @Override
    public void attach(Observer o) {
        this.trainer=(Trainer)o;
    }

    /**
     * Detaches an observer (trainer) from the client.
     *
     * @param o The observer (trainer) to detach.
     */
    @Override
    public void detach(Observer o) {
        this.trainer=null;
    }

    /**
     * Notifies the attached trainer with a message.
     *
     * @param trainer The trainer to notify.
     * @param s       The message to notify with.
     */
    @Override
    public void notify_Trainer(Trainer trainer, String s) {
        trainer.update(s);
    }
}
