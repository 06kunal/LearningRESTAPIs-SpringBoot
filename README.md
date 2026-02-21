
## 📗 LearningRESTAPIs-SpringBoot

**This repository is a learning project for building RESTful APIs using Spring Boot.** It contains tutorials and examples demonstrating core backend concepts in Spring Boot such as controllers, services, repositories, DTOs, object mapping with ModelMapper, and architectural best practices.

---

## 📌 About the Project

This repository is a hands-on project focused on learning how to build **REST APIs with Spring Boot**. REST stands for **Representational State Transfer**, a style of web architecture used to create stateless services that communicate over HTTP using standard methods like GET, POST, PUT, DELETE, etc. Spring Boot simplifies REST API development using auto configuration, embedded servers, and convention-over-configuration principles. :contentReference[oaicite:1]{index=1}

---

## ⚙️ Features

✔ Create REST endpoints using Spring Boot  
✔ Use of **Controller**, **Service**, and **Repository** layers  
✔ Integration of **DTOs** (Data Transfer Objects) to structure data safely  
✔ Use of **ModelMapper** for object conversion  
✔ Structured exception handling and project layout  
✔ Demonstration of clean backend architecture

---

## 🏛 Architecture

This project follows the **Spring Boot MVC / layered architecture** where the responsibilities are separated into different layers:

```

Client
↓
DispatcherServlet (Front Controller)
↓
Controller
↓
Service
↓
Repository
↓
Database

````

🧠 DispatcherServlet accepts all HTTP requests and routes them to corresponding controllers. Services contain business logic, and repositories handle data access. DTOs help transfer only safe and required data. This pattern ensures separation of concerns and modular project structure.


## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/project/
│   │       ├── controller/
│   │       ├── service/
│   │       ├── repository/
│   │       ├── dto/
│   │       ├── entity/
│   │       └── Application.java
├── resources/
│   └── application.properties
```

---

## ▶️ How to Run

1. **Clone the repository**

   ```bash
   git clone https://github.com/06kunal/LearningRESTAPIs-SpringBoot.git
   ```

2. **Open in IDE**
   Use IntelliJ, Eclipse, or VSCode

3. **Build & Run**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Access APIs**
   Use tools like Postman or browser for GET endpoints

---

## 🛠 Technologies Used

| Technology      | Purpose                       |
| --------------- | ----------------------------- |
| Java            | Programming language          |
| Spring Boot     | Framework for REST APIs       |
| Spring MVC      | Controllers & web handling    |
| Spring Data JPA | ORM data access               |
| ModelMapper     | Object mapping (Entity ↔ DTO) |
| Maven           | Build & dependency manager    |

---

## 📚 References & Learning Resources

These resources help build REST APIs and learn Spring Boot:

* Spring Boot REST API Concepts – GeeksforGeeks ([GeeksforGeeks][1])
* Spring Boot MVC and REST tutorials (multiple online guides)
