# 🚀 Clean Architecture Project

![Visitors](https://api.visitorbadge.io/api/visitors?path=https://github.com/Zaytsev-Dmitry/clean-architecture&label=Repository%20Visits&countColor=%230c7ebe&style=flat&labelStyle=none)

# The Ultimate Java Clean Architecture Boilerplate — Scalable, Secure & Production-Ready!

---

## 🎯 Why Choose This Project?

🔹 **Enterprise-Grade** — Built for real-world, high-performance applications.  
🔹 **Scalable & Maintainable** — Based on Clean Architecture principles, ensuring flexibility & modularity.  
🔹 **Production-Ready** — Pre-configured with **Spring Boot**, **Hibernate**, **PostgreSQL**, **Swagger**, and more!  
🔹 **Security First** — Integrated authentication, validation, and best security practices.  
🔹 **API-First Approach** — Fully documented with **OpenAPI** for seamless integration.

---

## ⚡ Tech Stack

### **Core Technologies**

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![OpenAPI](https://img.shields.io/badge/openapiinitiative-%23000000.svg?style=for-the-badge&logo=openapiinitiative&logoColor=white)

### **Upcoming Features ✨**

![Apache Kafka](https://img.shields.io/badge/Apache%20Kafka-000?style=for-the-badge&logo=apachekafka)
![RabbitMQ](https://img.shields.io/badge/Rabbitmq-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)
![Redis](https://img.shields.io/badge/redis-%23DD0031.svg?&style=for-the-badge&logo=redis&logoColor=white)
![GithubActions](https://img.shields.io/badge/GitHub_Actions-2088FF?style=for-the-badge&logo=github-actions&logoColor=white)

---

## 📂 Project Structure

```plaintext
main
├── java
│   └── com.clean.architecture      # Main package with all business logic and adapters
│       ├── adapters                # External system adapters (REST API, DB, etc.)
│       │   └── rest                 # REST API adapters
│       │       ├── api              # API interfaces & abstractions
│       │       ├── controller       # HTTP request controllers
│       │       ├── handler          # Global exception & error handling
│       │       ├── presenter        # Data transformation (DTOs, mappers)
│       │       ├── security         # Authentication & JWT security
│       │       └── validator        # Input data validation
│       ├── application             # Business logic (use cases)
│       │   ├── port                 # Clean Architecture ports
│       │   │   ├── in               # Input ports (use cases & scenarios)
│       │   │   └── out              # Output ports (repositories, APIs)
│       │   │       ├── repository   # Database repositories
│       │   │       └── rest         # External API integrations
│       │   ├── usecase              # Business logic implementation
│       │   └── util                 # Utility classes
│       ├── domain                   # Domain layer (entities, exceptions)
│       │   ├── entity               # Core business entities
│       │   └── exception            # Custom exceptions
├── resources                        # Application resources
│   ├── application.yaml             # Main configuration file
│   ├── db                           # Database migrations (Liquibase/Flyway)
│   └── static                       # Static files (Swagger, JSON schemas)
│       ├── openapi                  # OpenAPI API spec
│       └── validator                # JSON validation schemas
│           └── scheme               # Data validation schemas
```

---

## 🚀 Quick Start

### 1️⃣ Clone the Repository
```sh
git clone https://github.com/Zaytsev-Dmitry/clean-architecture.git
cd clean-architecture
```

### 2️⃣ Configure the Application
- Update **`application.yaml`** with your database credentials.

### 3️⃣ Run the Application
```sh
./mvnw spring-boot:run
```

### 4️⃣ Access API Documentation
- Open Swagger UI: [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)

---

## 🤝 Contributing

We ❤️ contributions! If you want to improve this project, feel free to:
1. Fork the repository
2. Create a new feature branch
3. Make your changes
4. Submit a pull request 🚀

---

## 📬 Contact & Collaboration

Have questions, ideas, or just want to connect? Let’s chat! 📩

[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:zaytsev.dmitry9228@gmail.com)  
[![Telegram](https://img.shields.io/badge/Telegram-2CA5E0?style=for-the-badge&logo=telegram&logoColor=white)](https://t.me/zaytsev_dv)

---

### ⭐ Don't forget to give this repository a star if you find it useful!

