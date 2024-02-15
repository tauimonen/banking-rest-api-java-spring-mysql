# Banking App

## Overview

The Banking App is a backend API built using Java Spring Boot and MySQL for managing customer data and transactions. 
It provides CRUD operations for customers, along with deposit and withdrawal transactions. Each transaction includes a unique 
identifier and a timestamp, making it suitable for professional use. In addition, Endpoint security, user identification and role-based authorization are offered.

## Features

- **Customer Management**: Perform CRUD operations (Create, Read, Update, Delete) for customer data.
- **Transaction Handling**: Record and retrieve deposit and withdrawal transactions for customers.
- **Transaction Details**: Each transaction includes a unique identifier (transaction ID) and a timestamp for tracking and auditing.

## Technologies Used

- Java Spring Boot
- MySQL Database
- Spring Data JPA for database interaction
- Spring Data REST
- Spring Security

## Getting Started

1. Clone the repository.
2. Configure the MySQL database in `src/main/resources/application.properties`.
3. Run the application using your preferred IDE or build tools.
4. Explore the API using tools like Postman or Swagger UI.

## Endpoints

- `/api/customer`: CRUD operations for managing customers.
- `/api/transaction`: Record and retrieve deposit and withdrawal transactions.

## Security
//TODO

## Role based CRUD actions for customer API 

| HTTP Method | Endpoint                   | CRUD Action     | Role     |  
|-------------|----------------------------|-----------------|----------|
| GET         | /api/customer              | Read all        | EMPLOYEE |   
| GET         | /api/customer/{customerId} | Read single     | EMPLOYEE |   
| POST        | /api/customer              | Create          | MANAGER  |   
| PUT         | /api/customer              | Update          | MANAGER  |   
| DELETE      | /api/customer/{customerId} | Delete customer | ADMIN    |   

## Role based CRUD actions for transaction API
//TODO
