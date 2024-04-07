package com.example.spring.Observer;

/**
 * The Observer interface defines the contract for objects that observe changes in subjects.
 * Implementing classes must define the update method to receive updates from subjects.
 */
public interface Observer {

    /**
     * Receives an update from the subject.
     *
     * @param o The object containing the update information.
     */
    void update(Object o);
}
