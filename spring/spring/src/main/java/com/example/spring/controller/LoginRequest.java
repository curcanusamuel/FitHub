package com.example.spring.controller;

/**
 * The LoginRequest class represents a request for logging in.
 * It contains the username and password provided by the user.
 */
public class LoginRequest {

    private String username;
    private String password;

    /**
     * Default constructor.
     */
    public LoginRequest() {}

    /**
     * Parameterized constructor.
     *
     * @param username The username for login.
     * @param password The password for login.
     */
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the username.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
