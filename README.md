# 🎓 Student Management System (Spring Boot REST API)

A production-ready **Student Management System** built using **Java Spring Boot**, implementing RESTful APIs with role-based access control and a structured layered architecture.

---

## 🚀 Features

* 🔐 **Authentication & Authorization (JWT-based)**
* 👥 **Role-Based Access Control** (Admin/User)
* 🎓 **Student Management**
* 🏫 **Class Management**
* 📚 **Subject Management**
* ✅ **Task Management**
* 🧩 Clean layered architecture (Controller → Service → Repository)
* 📦 DTO-based data transfer
* ⚙️ Scalable and production-ready design

---

## 🏗️ Tech Stack

* **Backend:** Java, Spring Boot
* **Security:** Spring Security + JWT
* **Database:** PostgreSQL 
* **Build Tool:** Maven
* **Architecture:** REST API

---

## 📁 Project Structure

```
src/main/java/com/Project/Learning/LearningRESTAPIs
│
├── auth
│   ├── impl
│   │   └── AuthServiceImpl.java
│   ├── AuthController.java
│   ├── AuthService.java
│   ├── JwtAuthFilter.java
│   └── JwtService.java
│
├── config
│   ├── AdminInitializer.java
│   ├── MapperConfig.java
│   └── SecurityConfig.java
│
├── controller
│   ├── AdminController.java
│   ├── ClassController.java
│   ├── StudentController.java
│   ├── SubjectController.java
│   └── TaskController.java
│
├── dto
│   ├── AdminRequestDto.java
│   ├── AuthResponse.java
│   ├── ClassDto.java
│   ├── LoginRequestDto.java
│   ├── RegisterRequestDto.java
│   ├── StudentDto.java
│   ├── SubjectDto.java
│   └── TaskDto.java
│
├── entity
│   ├── ClassEntity.java
│   ├── Student.java
│   ├── Subject.java
│   └── Task.java
│
├── enums
│   ├── Role.java
│   ├── TaskPriority.java
│   └── TaskStatus.java
│
├── repository
│   ├── ClassRepository.java
│   ├── StudentRepository.java
│   ├── SubjectRepository.java
│   └── TaskRepository.java
│
├── service
│   ├── impl
│   │   ├── ClassServiceImpl.java
│   │   ├── StudentServiceImpl.java
│   │   ├── SubjectServiceImpl.java
│   │   └── TaskServiceImpl.java
│   │
│   ├── AdminService.java
│   ├── ClassService.java
│   ├── StudentService.java
│   ├── SubjectService.java
│   └── TaskService.java
│
└── LearningRestapisApplication.java
```
This modular structure follows clean architecture principles, ensuring scalability, maintainability, and separation of concerns.

---

## 🧠 Entities

The system is designed around the following core entities:

* **Student** – Stores student details
* **Class** – Represents academic classes
* **Subject** – Subjects assigned to classes
* **Task** – Assignments/tasks given to students

---

## 🔐 Authentication & Authorization

* Uses **JWT (JSON Web Token)** for secure authentication
* Role-based access:

   * **ADMIN** → Full access
   * **USER/STUDENT** → Limited access
* Custom filter: `JwtAuthFilter`
* Token handling via `JwtService`

---

## 📡 API Endpoints (Sample)

### 🔑 ADMIN Promote API
* `POST /admin/promote`

### 🔑 Auth APIs

* `POST /auth/register` → Register new user
* `POST /auth/login` → Login and get JWT

### 🎓 STUDENT APIs
* `GET /classes/{classId}/students`
* `POST /classes/{classId}/students`
* `PUT /classes/{classId}/students/{id}`
* `DELETE /classes/{classId}/students/{id}`

### 🎓 SUBJECT APIs
* `GET /classes/{classId}/subjects`
* `POST /classes/{classId}/subjects`
* `PUT /classes/{classId}/subjects/{id}`
* `DELETE /classes/{classId}/subjects/{id}`

### 🎓 CLASS APIs
* `GET /classes`
* `POST /classes/create`
* `PUT /classes/{id}`
* `DELETE /classes/{id}`

### 🎓 TASK APIs
* `GET /subjects/{subjectId}/tasks`
* `POST /subjects/{subjectId}/tasks/create`
* `PUT /subjects/{subjectId}/tasks/{taskId}`
* `DELETE /subjects/{subjectId}/tasks/{taskId}`
---

## ⚙️ Setup & Installation

### 1️⃣ Clone the repository

```bash
git clone https://github.com/06kunal/LearningRESTAPIs-SpringBoot.git
cd LearningRESTAPIs-SpringBoot
```

### 2️⃣ Configure Database

Update `application.properties`:

```properties
spring.datasource.url=YOUR_DB_URL
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Run the application

```bash
mvn spring-boot:run
```

---

## 🧪 Testing

You can test APIs using:

* Postman
* Swagger (if configured)
---

## 🙌 Author

**Kunal Garg**

---