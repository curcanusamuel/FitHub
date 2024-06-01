package com.example.spring.observer;

import com.example.spring.entity.Staff;
import com.example.spring.entity.Trainer;

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
     * Notifies all attached observers of a change in the subject, specifically for trainers.
     *
     * @param trainer The trainer associated with the subject.
     * @param s       The message to notify observers with.
     */
    void notify_Trainer(Trainer trainer, String s);

    /**
     * Notifies all attached observers of a change in the subject, specifically for staff.
     *
     * @param staff The staff member associated with the subject.
     * @param s     The message to notify observers with.
     */
    void notify_Staff(Staff staff, String s);
}
