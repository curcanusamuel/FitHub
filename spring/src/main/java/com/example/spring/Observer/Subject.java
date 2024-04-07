package com.example.spring.Observer;

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
    void Attach(Observer o);

    /**
     * Detaches an observer from the subject.
     *
     * @param o The observer to detach.
     */
    void Detach(Observer o);

    /**
     * Notifies all attached observers of a change in the subject.
     */
    void Notify();
}
