# AI Powered Recipe Management System

A backend REST API built using Spring Boot that allows users to manage recipes and generate AI-based recipe suggestions using OpenAI.

This project was developed during my internship to explore modern backend development practices including API design, security, and AI integration.

---

## Tech Stack

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- Spring AI
- OpenAI GPT-4 API
- Maven

---

## OS and java version

- Gentoo Linux
- java 21 and spring 3.3.1

## Features

- User authentication and authorization
- Create, update, and manage recipes
- AI-powered recipe generation using OpenAI
- Nutrition information modeling
- RESTful API design
- Global exception handling
- API documentation using Swagger

---

## Steps to run project

### 1. Clone the Repository

### 2. Configure OpenAI API Key

Set the OpenAI API key as an environment variable.
Linux : export OPENAI_API_KEY=your_api_key_here

### 3. Configure Database

Create a MySQL database: CREATE DATABASE recipes;
For Linux install mariadb using package manager like emerge(gentoo linux),pacman(arch linux),apt(debian and its derivatives),xbps(void linux)
and perform the basic configuration

Now perform these steps:
Update `src/main/resources/application.properties`:
spring.datasource.url=jdbc:mysql://localhost:3306/recipes
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

### 4. Build the Project

makesure java21 in the path and maven installed
mvn clean install

### 5. Run the Application

on Linux terminal:
mvn spring-boot:run

## Project File Structure

```
.
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── InternShip
    │   │           └── Backend
    │   │               ├── AiModel
    │   │               │   └── OpenAi.java
    │   │               ├── BackendApplication.java
    │   │               ├── Controllers
    │   │               │   ├── RecepieController.java
    │   │               │   └── UserController.java
    │   │               ├── Exceptions
    │   │               │   ├── AiExceptions.java
    │   │               │   ├── Details
    │   │               │   │   └── ErrorDetails.java
    │   │               │   ├── ExceptionHandlers.java
    │   │               │   ├── userNotFoundException.java
    │   │               │   └── wrongOperation.java
    │   │               ├── Model
    │   │               │   ├── Recepies
    │   │               │   │   ├── AiRecepie.java
    │   │               │   │   ├── Nutrition.java
    │   │               │   │   └── Recepies.java
    │   │               │   └── Users
    │   │               │       ├── User.java
    │   │               │       └── UserResponse.java
    │   │               ├── Repo
    │   │               │   ├── RecepieRepo.java
    │   │               │   └── UserRepo.java
    │   │               ├── Security
    │   │               │   ├── SecurityConfig.java
    │   │               │   └── UserPrincipals.java
    │   │               └── Services
    │   │                   ├── RecepieService.java
    │   │                   └── UserService.java
    │   └── resources
    │       └── application.properties
    └── test
        └── java
            └── com
                └── InternShip
                    └── Backend
                        └── BackendApplicationTests.java
```
