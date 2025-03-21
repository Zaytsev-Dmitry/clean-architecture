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
│           com.clean.architecture/             # Root package for clean architecture structure
│               ├── adapters/                   # Adapters layer (interface adapters)
│               │   ├── in/                     # Incoming adapters (handling input)
│               │   │   └── rest/               # REST API layer
│               │   │       ├── api/            # API endpoints
│               │   │       │   ├── desktop/    # Desktop-specific endpoints
│               │   │       │   ├── mobile/     # Mobile-specific endpoints
│               │   │       │   └── web/        # Web-specific endpoints
│               │   │       ├── controller/     # Controllers for handling requests
│               │   │       │   ├── desktop/    # Desktop-specific controllers
│               │   │       │   ├── mobile/     # Mobile-specific controllers
│               │   │       │   └── web/        # Web-specific controllers
│               │   │       ├── handler/        # General request handlers
│               │   │       ├── presenter/      # Presentation layer
│               │   │       │   ├── base/       # Base presenter classes
│               │   │       │   └── user/       # User-specific presenters
│               │   │       ├── security/       # Security configurations
│               │   │       │   └── config/     # Security-related configurations
│               │   │       └── validator/      # Input validation components
│               │   └── out/                    # Outgoing adapters (handling output, persistence, external calls)
│               ├── application/                # Application layer (use cases, business logic)
│               │   ├── port/                   # Ports for dependency inversion
│               │   │   ├── in/                 # Input ports (use case interfaces)
│               │   │   │   └── delegate/       # Delegates for input handling
│               │   │   └── out/                # Output ports (external communication)
│               │   │       ├── repository/     # Repository interfaces
│               │   │       └── rest/           # REST clients for external services
│               │   │           └── keycloak/   # Keycloak integration
│               │   ├── usecase/                # Use cases (business logic)
│               │   │   ├── auth/               # Authentication use cases
│               │   │   │   └── impl/           # Implementation of authentication use cases
│               │   │   └── user/               # User-related use cases
│               │   │       └── impl/           # Implementation of user use cases
│               │   └── util/                   # Utility classes
│               └── domain/                     # Domain layer (entities and core business logic)
│                   ├── auth/                   # Authentication-related domain models
│                   ├── entity/                 # Core business entities
│                   └── exception/              # Custom exceptions
├── resources/                                  # Resource files (configuration, static assets)
│   ├── application.yaml                        # Main application configuration file
│   ├── db/                                     # Database-related resources
│   │   └── changelog/                          # Database migration scripts
│   └── static/                                 # Static resources
│       ├── openapi/                            # OpenAPI specifications
│       │   └── api-spec.yml                    # OpenAPI specification file
│       └── validator/                          # Validation-related resources
│           └── scheme/                         # Validation schema files
         
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

