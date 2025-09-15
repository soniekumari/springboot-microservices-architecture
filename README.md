# Spring Boot Microservices Architecture
A complete backend microservices architecture built using Spring Boot, It includes Hotel, Rating, and User services with Eureka Discovery, Config Server, and API Gateway.
# Tech Stack
- Java 17
- Spring Boot
- Spring Cloud (Eureka, Config Server, Gateway)
- MySQL & MongoDB
- Feign Client, Resilience4J
- JWT Security
- Postman, JUnit
# Microservices Overview Table
| Service Name        | Port  | Description |
|---------------------|-------|-------------|
| API Gateway         | 8084  | Routes client requests to services |
| Config Server       | 8085  | Centralized config management |
| Discovery Server    | 8761  | Eureka service registry |
| User Service        | 8081  | Manages users and aggregates ratings |
| Rating Service      | 8083  | Stores ratings (MySQL) |
| Hotel Service       | 8082  | Manages hotel data (MySQL) |

# Architecture Diagram
<img width="850" height="561" alt="image" src="https://github.com/user-attachments/assets/b8a1b694-b152-4324-a90a-c0dddf29c743" />

# Folder Structure
springboot-microservices-architecture/<br>
├── api-gateway/<br>
├── config-server/<br>
├── discovery-server/<br>
├── hotel-service/<br>
├── rating-service/<br>
├── user-service/<br>
└── README.md<br>

# Security Features
- JWT-based authentication
- Role-based access control
- OKTA integration

# Prerequisites
Before running this project, make sure you have:
- **Java 17** installed
- **Maven** installed
- **MySQL** database running (create a database named `microservices`)
- **Postman** for testing APIs (Optional)

# How to Run the Project
1. Discovery Server (Eureka Server - 8761)
2. Config Server (8085)
3. API Gateway (8084)
4. User Service (8081)
5. Rating Service (8083)
6. Hotel Service (8082)


