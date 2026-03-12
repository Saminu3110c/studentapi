# Welcome to student API
- Successfully Achieved:
    - You now understand:
    - Layered architecture
    - Dependency injection
    - REST endpoints
    - Lombok
    - Stream API
    - Optional
    - Custom exceptions
    - Global exception handling
    - HTTP status mapping

## Switching to:
- Spring Data JPA + H2 Database
    - Creates in-memory database
    - Auto-creates tables
    - Shows SQL in console
    - Enables H2 web console
- The backend now has:
    - REST API
    - Validation
    - Exception handling
    - H2 database
    - JPA repository (Spring Data JPA)
    - Derived queries
    - Pagination
    - Sorting
    - MapStruct
    - Lombok
    - DTO + Mapper layer
- Documentation
    - Swagger/OpenAPI Documentation


- The API Now Supports
    | Method | Endpoint                | Purpose           |
    | ------ | ----------------------- | ----------------- |
    | POST   | /students               | Create student    |
    | GET    | /students               | Get students      |
    | GET    | /students/{id}          | Get student by id |
    | PUT    | /students/{id}          | Update student    |
    | DELETE | /students/{id}          | Delete student    |
    | GET    | /students/above/{age}   | Custom query      |
    | GET    | /students/email/{email} | Custom query      |


## Usage
- Navigate to project folder:
    ```bash
        cd studentapi
    ```
- And run:

    ```bash
        ./mvnw spring-boot:run
    ```
    ```bash
        http://localhost:8080/h2-console
    ```
    ```bash
        http://localhost:8080/students
    ```
    ```bash
        http://localhost:8080/swagger-ui/index.html
    ```