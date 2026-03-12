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
- Clone the repository:
    ```bash
        git clone https://github.com/Saminu3110c/studentapi.git
    ```
- Navigate to the project folder:
    ```bash
        cd studentapi
    ```
- Refresh the Project
    ```bash
        ctrl + shift + p --> Maven: Reload Project
    ```

- Run to start the project:

    ```bash
        ./mvnw spring-boot:run
    ```
- Navigate to your browser:
    - You can use any of the following
    ```bash
        http://localhost:8080/h2-console
    ```
    ```bash
        http://localhost:8080/students
    ```
    ```bash
        http://localhost:8080/swagger-ui/index.html
    ```