package com.example.spring.entity;

import com.example.spring.observer.Observer;
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
public class Staff implements Observer {

    /**
     * The unique identifier for the staff member.
     */
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The name of the staff member.
     */
    @Column(name="NAME", nullable = false)
    private String name;

    /**
     * The age of the staff member.
     */
    @Column(name="AGE", nullable = false)
    private int age;

    /**
     * The password of the staff member.
     */
    @Column(name="PASSWORD", nullable = false)
    private String password;

    /**
     * Updates the observer with a message.
     *
     * @param s The message to update the observer with.
     */
    @Override
    public void update(String s) {
        System.out.println(s);
    }
}
