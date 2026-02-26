# Recipe Management API

This project is a Spring Boot REST API that manages recipe data by loading it from a JSON file and storing it in a MySQL database.  
It allows users to retrieve, search, and filter recipes efficiently through REST endpoints.

## Project Overview
The application automatically reads recipe data at startup, parses JSON using Jackson, and persists it using Spring Data JPA.  
It follows a layered architecture (Controller → Service → Repository) and includes DTO mapping and global exception handling.

## ✨ Features
- Auto-load recipes from JSON file
- Store and manage recipes in MySQL
- Search by cuisine, rating, and title
- Global exception handling
- Clean architecture with DTO & Mapper

## 🛠️ Tech Stack
Java 17, Spring Boot, Spring Data JPA, MySQL, Jackson, Lombok

## ⚙️ Run the Project
1. Create MySQL database.
2. Configure `application.properties`.
3. Run `mvn clean install`
4. Start using `mvn spring-boot:run`

Server runs at: `http://localhost:8080`
