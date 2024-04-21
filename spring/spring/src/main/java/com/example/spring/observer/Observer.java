package com.example.spring.observer;

/**
 * The Observer interface defines the contract for objects that observe changes in subjects.
 * Implementing classes must define the update method to receive updates from subjects.
 */
public interface Observer {

    /**
     * Receives an update from the subject.
     *
     * @param s The object containing the update information.
     */
    void update(String s);
}
