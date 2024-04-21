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
    @GeneratedValue
    private int id;

    /**
     * The name of the staff member.
     */
    @Column(name="NAME",nullable = false)
    private String name;
    /**
     * The age of the staff member.
     */
    @Column(name="AGE",nullable = false)
    private int age;

    @Override
    public void update(String s) {
        System.out.println(s);
    }
}
