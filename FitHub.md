# FitHub
## Java App

Description:
FitHub is a Java application designed for the fitness domain, aiming to provide an integrated platform for clients, staff, and trainers. This application facilitates the management of activities related to workouts and services within a fitness facility or training center.

## Features

User Types:

Clients: These are the end-users of the application, who can create and manage their personal accounts. They can access personalized workout programs, schedule training sessions, and track their progress over time.

Staff: These individuals are responsible for the management and operation of the fitness facility. They have administrative privileges and can oversee various aspects of the system, including user management, scheduling, and facility maintenance.

Trainers: Trainers are professionals who provide personalized coaching and guidance to clients. They are assigned specific clients by the staff members, and they can tailor workout programs based on individual goals and preferences.

## Functionality

### Client Management:

Clients can register and create profiles detailing their fitness goals, preferences, and health information.
They can browse and select from a range of workout programs tailored to their needs.
Clients can schedule training sessions with available trainers and manage their appointments through the application.

### Staff Administration:

Staff members have access to administrative tools for managing user accounts, including clients and trainers.
They can assign specific clients to trainers based on availability and expertise.
Staff members can monitor facility usage, schedule maintenance tasks, and handle billing and payments.

### Trainer Support:

Trainers receive notifications about new client assignments and can review their clients' profiles and goals.
They can create personalized workout plans, track progress.
Trainers have access to tools and resources for designing effective training regimens tailored to individual needs.

### Observer Pattern and Client Notifications:

#### Addition of Client:

- Implemented the observer pattern where clients act as subjects and notify observers (e.g., trainers) upon creation.
- Clients now receive notifications about important updates such as new workout assignments or changes to their schedules.

#### Deletion of Client:

- Clients notify relevant observers (e.g., trainers) before deletion from the system to ensure proper handling of associated tasks.
- Upon successful deletion, clients receive a notification confirming the action.

#### Update of Client:

- Updated client information triggers notifications to relevant observers (e.g., trainers) to keep them informed about changes.

## License
