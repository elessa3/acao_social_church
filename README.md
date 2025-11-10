# acao_social_church

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue)

A complete RESTful API for social action, with JWT authentication and cloud deployment.

## 🚀 Features

*   Complete CRUD tasks
*   Authentication and authorization with JWT
*   Upload files to AWS 
*   API documentation with Swagger

## 🛠 Technologies Used

*   **Backend:** Java 17, Spring Boot 3.1, Spring Security, JPA/Hibernate
*   **Database:** PostgreSQL
*   **Tools:** Maven, AWS 
*   **Tests:** JUnit 5, Mockito

## 📋 Prerequisites

*   Java 17+
*   Maven 3.6+
*   PostgreSQL 14+

## 🔧 Installation and Execution

`bash
# Clone the repository
git clone https://github.com/elessa3/acao_social_church.git

# Enter the directory
cd acao_social_church

# Configure the database in application.properties

# Run the application
mvn spring-boot:run
`

The API will be available at http://localhost:8080
Swagger documentation: http://localhost:8080/swagger-ui.html

📁 Structure of the project

`
src/
main/
java/com/example/acaosocialchurch/
controller/   # REST controllers
service/   # Business logic
repository/   # Data layer
model/   # JPA entities
security/   # Security configuration
resources/
application.properties
`

🤝 How to contribute

Contributions are always welcome! Please read CONTRIBUTING.md first.

---

Developed by Erica Lessa

`
