#  ENT Platform (Java Backend Project)

A backend system for preparing for the Kazakhstan Unified National Test (ENT / ЕНТ).

---

## - Project Overview

This project is a learning and exam preparation platform that allows students to:

- Take mock ENT exams
- Practice test questions
- Review mistakes
- Track progress and performance

Admins/Teachers can:

- Create questions
- Manage tests
- Organize subjects

---

## - Key Features

### - Student Panel
- Take tests with timer
- View results (score out of 140)
- Review mistakes
- Track progress

### - Admin Panel
- Add / edit / delete questions
- Create tests
- Manage question bank

---

## - Architecture

- Layered architecture (Controller → Service → Repository)
- Domain-based modules
- Clean separation of concerns

---

## - Modules

- User (Auth & Roles)
- Question (Question bank)
- Test (Exam system)
- Result (Scoring system)
- Mistake (Error tracking)
- Analytics (future)

---

## -️ Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Security (JWT - planned)
- PostgreSQL (Docker)
- Maven

---

## - Database

PostgreSQL is running inside Docker container.

```bash

docker-compose up -d
📊 Exam Logic
Each correct answer = 1 point
Maximum score = 140
Score is calculated per test result
🚧 Current Status

✔ Project initialized
✔ Database configured (Docker)
✔ Entity layer created
✔ Question–Test relation implemented

⏳ Next steps:

Repository layer
Service layer
REST API
JWT authentication
🔥 Goal

Build a production-level backend system to demonstrate:

Clean architecture
Real-world business logic
Scalable system design
👨‍💻 Author

Bakhyt Zharkynbek
Java Backend Developer 


---
