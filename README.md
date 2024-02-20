[![Project Status: Work in Progress](https://img.shields.io/badge/Project%20Status-Work%20in%20Progress-orange.svg)](https://img.shields.io/badge/Project%20Status-Work%20in%20Progress-orange.svg)

# Banking App

## Overview

The Banking App is a backend API built using Java Spring Boot and MySQL for managing customer data and transactions. 
It provides CRUD operations for customers, along with deposit and withdrawal transactions. Each transaction includes a unique 
identifier and a timestamp, making it suitable for professional use. In addition, Endpoint security, user identification and role-based authorization are offered.

## Features

- **Customer Management**: Perform CRUD operations (Create, Read, Update, Delete) for customer data. When a Customer entity is created and saved to the database, the createdDate field will be automatically populated with the current date and time, and the createdBy field will be set to the creator's username or identifier (if applicable). When the entity is subsequently modified and saved, the lastModifiedDate field will be updated, and the lastModifiedBy field will be set to the modifier's username or identifier.
- **Transaction Handling**: Record and retrieve deposit and withdrawal transactions for customers.
- **Transaction Details**: Each transaction includes a unique identifier (transaction ID) and a timestamp for tracking and auditing. When a Transaction entity is created and saved to the database, the createdDate field will be automatically populated with the current date and time, and the createdBy field will be set to the creator's username or identifier (if applicable). When the entity is subsequently modified and saved, the lastModifiedDate field will be updated, and the lastModifiedBy field will be set to the modifier's username or identifier.

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

## EER Diagram
// TODO

## Endpoints

- `/api/customer`: CRUD operations for managing customers.
- `/api/transaction`: Record and retrieve deposit and withdrawal transactions.

## Security
Customized Spring Security with JPA authentication involves configuring and extending 
the existing components provided by Spring Security and Spring Data JPA.

## Role based CRUD actions for customer API 

| HTTP Method | Endpoint                   | CRUD Action     | Role     |  
|-------------|----------------------------|-----------------|----------|
| GET         | /api/customer              | Read all        | EMPLOYEE |   
| GET         | /api/customer/{customerId} | Read single     | EMPLOYEE |   
| POST        | /api/customer              | Create          | MANAGER  |   
| PUT         | /api/customer/{customerId} | Update          | MANAGER  |   
| DELETE      | /api/customer/{customerId} | Delete customer | ADMIN    |   

## Role based CRUD actions for transaction API

| HTTP Method | Endpoint                         | CRUD Action        | Role     |  
|-------------|----------------------------------|--------------------|----------|
| GET         | /api/transaction                 | Read all           | EMPLOYEE |   
| GET         | /api/transaction/{transactionId} | Read single        | EMPLOYEE |   
| POST        | /api/transaction                 | Create             | MANAGER  |   
| PUT         | /api/transaction/{transactionId} | Update             | MANAGER  |   
| DELETE      | /api/transaction/{transactionId} | Delete transaction | ADMIN    |   

## JPA Auditing 

Add JPA auditing to Entities

```Java
@EntityListeners(AuditingEntityListener.class)
```

```Java
@CreatedDate
@Column(name = "created_date")
private LocalDateTime createdDate;

@LastModifiedDate
@Column(name = "last_modified_date")
private LocalDateTime lastModifiedDate;

@CreatedBy
@Column(name = "created_by")
private String createdBy;

@LastModifiedBy
@Column(name = "last_modified_by")
private String lastModifiedBy;
```
The annotations @CreatedDate, @LastModifiedDate, @CreatedBy, and @LastModifiedBy are part of Spring Data JPA's auditing feature. They are used to automatically track and store metadata about when an entity is created, last modified, and by whom. Here's a brief explanation of each:

@CreatedDate:
Annotates a field representing the creation timestamp of the entity.
Automatically populates the field with the current date and time when the entity is first persisted to the database.

@LastModifiedDate:
Annotates a field representing the timestamp of the last modification to the entity.
Automatically updates the field with the current date and time whenever the entity is modified and saved.

@CreatedBy:
Annotates a field representing the user who created the entity.
Typically used in combination with Spring Security to automatically set the creator's username or identifier when the entity is first persisted.

@LastModifiedBy:
Annotates a field representing the user who last modified the entity.
Similar to @CreatedBy, it is often used with Spring Security to automatically set the modifier's username or identifier when the entity is modified and saved.
Here's an example of how these annotations work in your Transaction entity:

