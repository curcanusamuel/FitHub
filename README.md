# FitHub
## Java App

## Description

FitHub is a simple Java application designed for the fitness domain, providing an integrated platform for staff to manage clients and trainers. The application allows only staff members to log in and perform various management tasks, such as adding new clients and trainers, assigning clients to trainers, deleting clients and trainers, and adding other staff members.


## Features

User Types:

Clients: These are the end-users of the application, who can create and manage their personal accounts.

Staff: These individuals are responsible for the management and operation of the fitness facility. They have administrative privileges and can oversee various aspects of the system, including user management, scheduling, and facility maintenance.

Trainers: Trainers are professionals who provide personalized coaching and guidance to clients. They are assigned specific clients by the staff members, and they can tailor workout programs based on individual goals and preferences.

# Functionality

### Client Management

- Clients can register and create profiles detailing their fitness goals, preferences, and health information.
- They can browse and select from a range of workout programs tailored to their needs.
- Clients can schedule training sessions with available trainers and manage their appointments through the application.
- Endpoints:
  - **Create Client:** Registers a new client.
  - **Update Client:** Updates an existing client's information.
  - **Get Client:** Retrieves client details by ID.
  - **Delete Client:** Deletes a client by ID.
  - **Get Clients Without Trainers:** Retrieves all clients without an assigned trainer.

### Staff Administration

- Staff members have access to administrative tools for managing user accounts, including clients and trainers.
- They can assign specific clients to trainers based on availability and expertise.
- Staff members can monitor facility usage, schedule maintenance tasks, and handle billing and payments.
- Endpoints:
  - **Create Staff:** Registers a new staff member.
  - **Update Staff:** Updates an existing staff member's information.
  - **Get Staff:** Retrieves staff member details by ID.
  - **Delete Staff:** Deletes a staff member by ID.
  - **Delete Client:** Deletes a client by ID.
  - **Delete Trainer:** Deletes a trainer by ID.

### Trainer Support

- Trainers receive notifications about new client assignments and can review their clients' profiles and goals.
- They can create personalized workout plans and track progress.
- Trainers have access to tools and resources for designing effective training regimens tailored to individual needs.
- Endpoints:
  - **Create Trainer:** Registers a new trainer.
  - **Update Trainer:** Updates an existing trainer's information.
  - **Get Trainer:** Retrieves trainer details by ID.
  - **Delete Trainer:** Deletes a trainer by ID.

### Observer Pattern and Client Notifications:

#### Addition, Update, and Deletion of Clients:

- Implemented the observer pattern where clients act as subjects and notify observers (e.g., trainers) upon creation, modification, or deletion.
- Clients now notify relevant observers (e.g., trainers) if they have been created, modified, or deleted, ensuring proper handling of associated tasks by trainers.
- Trainers receive notifications about new client assignments, modifications to client information, or client deletions, keeping them informed about changes in their client base.
- Additionally, notifications are sent to a randomly selected staff member from the staff list if a client is created, modified, or deleted. If no staff member exists, a new staff member is created with the name "#Obligatoriu".

### Testing:

- Comprehensive testing has been conducted for each class within the application.
- Tests include verification of interdependence between specific classes, ensuring seamless integration and functionality.
- Mockito framework has been utilized for mocking dependencies and facilitating unit testing processes.


### Frontend

- The frontend is developed using React( JavaScript and CSS).
- It features a simple login page initially.
- Upon successful login, it opens a management page for clients, trainers, and staff.
- The management page provides various functionalities, such as adding new clients and trainers, assigning clients to trainers, deleting clients and trainers, and managing staff members.

