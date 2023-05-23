# Banking Application

The Banking Application is a simple Java-based application that allows users to perform transactions such as deposits and withdrawals. It provides basic authentication and authorization functionalities for user registration and login. The application uses Spring Boot as the backend framework and implements REST API for data communication. It utilizes a MySQL database for data storage and interacts with it using Spring Data JPA.

## Features

- User registration and login using basic authentication
- Perform deposits and withdrawals
- Display current bank balance and transaction details
- RESTful API for data communication
- MySQL database for data storage

## Technologies Used

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- Spring Data JPA
- MySQL

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed
- MySQL (or any other supported database) installed and running
- IDE (e.g., IntelliJ IDEA, Eclipse) for running and editing the code

### Installation

1. Clone the repository:
   git clone https://github.com/ankita-acharekar/banking-application.git
   
2. Import the project into your IDE.

3. Open the `application.properties` file in the `resources` folder and configure the database connection details.

4. Build and run the application.

## Security

The application uses Spring Security for authentication and authorization. It includes basic authentication using username and password.

## Database

The application utilizes a MySQL database (or any other supported database). The database schema includes tables for users, accounts, and transactions.
