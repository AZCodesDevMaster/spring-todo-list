# Spring Todo List

A simple to-do list application using Spring Boot.

## Description

This application allows users to manage their tasks with features like creating, updating, and deleting tasks.

## Project Files

<details>
<summary><strong>Configuration</strong></summary>
  
    - WebSecurityConfig.java: Contains Spring Security configuration for handling user authentication and authorization.
</details>

<details>
<summary><strong>Controller</strong></summary>
  
    - task:
      - TaskController.java: Handles HTTP requests related to tasks.
  
    - user:
      - UserController.java: Handles HTTP requests related to users.
</details>

<details>
<summary><strong>Exception</strong></summary>
    
    - task:
      - TaskExceptionHandler.java: Handles exceptions globally for task-related operations.
      - TaskNotFoundException.java: A custom exception thrown when a requested task is not found. 
  
    - user:
      - UserExceptionHandler.java: 

</details>

<details>
<summary><strong>Model</strong></summary>
  
     - task:
        - Task.java: Represents a task in the ToDo List application.
        - TaskStatusType.java: Enum for task status types.
     - user:
        - User.java: Represents a user entity in the application.
</details>

<details>
<summary><strong>Repository</strong></summary>
  
     - task:
       - TaskRepository.java: Repository interface for managing Task entities.
         
    - user:
        - UserRepository.java: Repository interface for managing User entities.
</details>

<details>
<summary><strong>Service</strong></summary>
 
    - task:
       - TaskService.java: Service class for managing tasks in the ToDo list application.
       
    - user:
      - UserService.java: Service class for managing users in the application.
      - UserDetailsServiceImpl.java: Custom implementation of UserDetailsService for Spring Security, used to load user-specific data.
</details>

##  API Endpoints
- **GET /api/todos - Get all to-do items
- **GET /api/todos/{id} - Get a to-do item by ID
- **POST /api/todos - Create a new to-do item
- **PUT /api/todos/{id} - Update a to-do item
- **DELETE /api/todos/{id} - Delete a to-do item
- **PUT /api/todos/{id}/complete - Mark a to-do item as complete
- **PUT /api/todos/{id}/incomplete - Mark a to-do item as incomplete
  
## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL
- Maven

## Getting Started

### Prerequisites

- Java 17+
- Maven
- PostgreSQL
- Git

<details>
<summary><strong>Installation</strong></summary>

1. Clone the repository:

   ```sh
   git clone https://github.com/your-username/spring-todo-list.git
   
4. Build the project using Maven:

   ```sh
   mvn clean package
   
6. Run the application:

   ```sh
   java -jar target/spring-todo-list-0.0.1-SNAPSHOT.jar
   
8. Access the application in your web browser at http://localhost:8080.
</details>

<details>
<summary><strong>Importing the Project into IntelliJ IDEA</strong></summary>

1. Import the Project:

  - Go to File > New > Project from Existing Sources....
    
  - Navigate to the directory where you cloned the project and select the pom.xml file.
    
  - Click Open.

2. Import Maven Projects:
   
   - IntelliJ IDEA will automatically detect that it is a Maven project and will start importing dependencies.
   If prompted, enable Auto-Import for Maven projects.

4. Run the Application:
   
   - In the Project view, navigate to src/main/java/com/example/spring_todo_list/SpringTodoListApplication.java.
   - Right-click on SpringTodoListApplication and select Run 'SpringTodoListApplication'.


6. Access the application:
   
   - Open your web browser and navigate to http://localhost:8080.
</details>

<details>
<summary><strong>Configuration for PostgreSQL</strong></summary>

1. Create a Database:

   - Create a new database in PostgreSQL named tasklistdb (or any name of your choice).
      ```sh
      CREATE DATABASE tasklistdb
     
2. Configure application.properties:

   - Open the src/main/resources/application.properties file and configure the PostgreSQL connection settings:

   ```sh
   spring.datasource.url=jdbc:postgresql://localhost:5432/TaskListDB
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true

3. Run the Application:

  - Follow the steps under "Run the Application" to start the application with PostgreSQL configured.

</details>
