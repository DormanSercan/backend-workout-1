# Bookesh - Microservices-based RESTful API

**Bookesh** is a microservices-based RESTful API designed for order management, built with **Spring Boot**, **PostgreSQL**, **RabbitMQ**, and **Docker**. The system is composed of three services:

1.  **Order Service** (Manages orders, customers, and restaurants)
2.  **Driver Finder Service** (Assigns drivers to orders)
3.  **Eureka Server** (Handles service discovery for the microservices)

### Key Technologies Used

*   **Spring Boot**: Java framework for building the backend services.
*   **PostgreSQL**: Relational database used for storing order, customer, and restaurant data.
*   **RabbitMQ**: Message broker used for inter-service communication between microservices.
*   **Docker**: Containerization tool for running the services in isolated environments.
*   **Eureka**: Service registry and discovery for managing microservices.
*   **WebClient**: Used for making HTTP requests to other services within the microservice architecture.

* * *

## Features

*   **Order Management System**: Handle customer orders, restaurant menus, and order statuses.
*   **Service Discovery**: Eureka handles dynamic registration and discovery of microservices.
*   **Messaging**: RabbitMQ facilitates communication between services (e.g., Order Service to Driver Finder Service).
*   **Driver Assignment**: Driver Finder Service assigns drivers to orders based on business logic.
*   **Dockerized**: PostgreSQL and RabbitMQ services are containerized and can be easily run using Docker Compose.

* * *

## Installation & Setup

### Prerequisites

*   **Docker** & **Docker Compose** installed on your system.
*   **PostgreSQL** & **RabbitMQ** running on your local machine or configured with Docker Compose.

### Clone the repository

```sh
git clone https://github.com/DormanSercan/backend-workout-1.git
cd backend-workout-1
```
## Docker Setup
Ensure Docker and Docker Compose are installed on your machine. Then, run the following commands to build and start the services:

```sh
docker-compose up -d
```

This will start the services in detached mode, running each microservice in a separate Docker container. The following services will be set up:

**Order Service:** Handles all order-related operations (CRUD for orders).
**Driver Finder Service:** Determines which driver to assign to an order.
**Eureka Server:** Registers and discovers microservices.
**PostgreSQL:** Provides the relational database for storing order data.
**RabbitMQ:** Manages message queues for communication between services.
## Usage
Once the services are up and running, you can use the following API endpoints:

### Order Service

*   **POST** `/api/newOrder` – Create a new order.
    *   **Body**: `OrderDTO`
      ```sh
      {
          "customerId": 1,
          "restaurantId": 1,
          "cartDTOList": [
              {
              "foodAndBeverageId" : 1,
              "quantity": 1
              },
              {
              "foodAndBeverageId" : 2,
              "quantity": 2 
              }
          ]
      }
      ```
    *   **Response**: `Order` object with created order details.

### Driver Finder Service
*   **POST** `/api/findDriver` – Receive an order message from RabbitMQ and assign a driver.

### Order Completed (Communication via WebClient)
*   **POST** `/api/orderCompleted` – Marks an order as completed and updates the order status in the database.

## Architecture Overview
The application follows a microservices architecture, with each service responsible for a specific domain:

1.  **Order Service:** Manages order creation, customer, and restaurant data.
2.  **Driver Finder Service:** Responsible for assigning a driver to an order once it has been placed.
3.  **Eureka Server:** Provides service discovery for all the services, ensuring they can dynamically register themselves and communicate with each other.

### Flow:
**Order Service** creates a new order and sends an event to **RabbitMQ.**
**Driver Finder Service** listens to **RabbitMQ**, processes the order, and assigns a mock driver to the order.
Once the driver is assigned, the **Order Service** is notified via an **API call** to the `/api/orderCompleted` endpoint to mark the order as completed and update the status in the database.

### Troubleshooting & Notes
**PostgreSQL:**
Make sure the database service is running and accessible.
Ensure that you have initialized the database tables and schema as expected.

**RabbitMQ:**
RabbitMQ must be running for message queue functionality to work.
Check if queues and exchanges are set up properly (handled by Docker Compose).

### Contributing
Feel free to fork the repository and contribute. If you find any issues or would like to improve the project, feel free to submit a pull request.
