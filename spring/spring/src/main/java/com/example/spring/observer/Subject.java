package com.example.spring.observer;

import com.example.spring.entity.Trainer;
import com.example.spring.observer.Observer;

/**
 * The Subject interface defines the contract for objects that are observed by observers.
 * Implementing classes must provide methods to attach, detach, and notify observers of changes.
 */
public interface Subject {

    /**
     * Attaches an observer to the subject.
     *
     * @param o The observer to attach.
     */
    void attach(Observer o);

    /**
     * Detaches an observer from the subject.
     *
     * @param o The observer to detach.
     */
    void detach(Observer o);

    /**
     * Notifies all attached observers of a change in the subject.
     *
     * @param trainer The trainer associated with the subject.
     * @param s       The message to notify observers with.
     */
    void notify_Trainer(Trainer trainer, String s);
}
