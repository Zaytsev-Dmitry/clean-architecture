# Clean Architecture Project

![Visitors](https://api.visitorbadge.io/api/visitors?path=https://github.com/Zaytsev-Dmitry/clean-architecture&label=Repository%20Visits&countColor=%230c7ebe&style=flat&labelStyle=none)

🚀 **A modern Java-based project following Clean Architecture principles.**

---

## 🛠 Tech Stack

### **Core Technologies**

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![OpenAPI](https://img.shields.io/badge/openapiinitiative-%23000000.svg?style=for-the-badge&logo=openapiinitiative&logoColor=white)

### **Coming Soon** ✨

![Apache Kafka](https://img.shields.io/badge/Apache%20Kafka-000?style=for-the-badge&logo=apachekafka)
![RabbitMQ](https://img.shields.io/badge/Rabbitmq-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)
![Redis](https://img.shields.io/badge/redis-%23DD0031.svg?&style=for-the-badge&logo=redis&logoColor=white)
![GithubActions](https://img.shields.io/badge/GitHub_Actions-2088FF?style=for-the-badge&logo=github-actions&logoColor=white)

---

## 📖 Project structure
.
├── main
│   ├── java
│   │   └── com.clean.architecture      # Основной пакет проекта
│   │       ├── CleanArchitectureApplication.java  # Главный класс приложения
│   │       ├── adapters                # Адаптеры для взаимодействия с внешним миром
│   │       │   ├── AppSettings.java      # Конфигурация приложения
│   │       │   └── rest                 # REST API адаптеры
│   │       │       ├── api
│   │       │       │   ├── AbstractLoggableApiDecorator.java # Декоратор API с логированием
│   │       │       │   └── DecoratedWebApi.java # Основной REST API интерфейс
│   │       │       ├── controller
│   │       │       │   └── UserController.java # Контроллер для работы с пользователями
│   │       │       ├── handler
│   │       │       │   └── RestExceptionControllerAdvice.java # Глобальная обработка исключений
│   │       │       ├── presenter         # Представители данных
│   │       │       │   ├── base
│   │       │       │   │   ├── BaseListPresenter.java  # Базовый список представления
│   │       │       │   │   └── BaseSinglePresenter.java  # Базовое одиночное представление
│   │       │       │   └── user
│   │       │       │       ├── UserListPresenter.java  # Список пользователей
│   │       │       │       └── UserSinglePresenter.java  # Один пользователь
│   │       │       ├── security         # Безопасность
│   │       │       │   ├── JwtAuthenticationEntryPoint.java # JWT точка входа
│   │       │       │   ├── JwtFilter.java # Фильтр JWT токенов
│   │       │       │   └── config
│   │       │       │       └── SecurityConfig.java # Конфигурация безопасности
│   │       │       └── validator        # Валидаторы данных
│   │       │           ├── aspecj
│   │       │           │   ├── ValidateEndpointParameters.java # Аннотации валидации
│   │       │           │   └── ValidateEndpointParametersAspect.java # Аспект валидации
│   │       │           ├── base
│   │       │           │   ├── RuleChecker.java  # Проверка правил валидации
│   │       │           │   ├── ValidationRule.java # Правила валидации
│   │       │           │   └── ValidationRuleType.java # Типы правил валидации
│   │       │           ├── dto
│   │       │           │   ├── ValidateItem.java  # Объект валидации
│   │       │           │   ├── ValidateScheme.java  # Схема валидации
│   │       │           │   └── ValidateSchemeItem.java  # Элемент схемы валидации
│   │       │           └── strategy
│   │       │               ├── NotNullOrEmptyRule.java  # Проверка на null или пустоту
│   │       │               └── NotNullRule.java  # Проверка на null
│   │       ├── application          # Бизнес-логика
│   │       │   ├── port
│   │       │   │   ├── in            # Входные порты (use cases)
│   │       │   │   │   ├── UserUCaseDelegate.java # Делегат для пользователя
│   │       │   │   │   └── usecaseimpl
│   │       │   │   │       ├── auth
│   │       │   │   │       └── user
│   │       │   │   └── out           # Выходные порты (репозитории, API)
│   │       │   │       ├── repository
│   │       │   │       │   └── UserRepository.java # Репозиторий пользователя
│   │       │   │       └── rest
│   │       │   │           └── keycloak
│   │       │   ├── usecase           # Реализация бизнес-логики
│   │       │   │   ├── auth
│   │       │   │   │   ├── AuthenticationUCase.java # Аутентификация
│   │       │   │   │   └── CheckJWTSignatureUCase.java # Проверка JWT подписи
│   │       │   │   └── user
│   │       │   │       ├── GetAllUsersUCase.java # Получение всех пользователей
│   │       │   │       └── GetUserByIdUCase.java # Получение пользователя по ID
│   │       │   └── util
│   │       │       └── JsonFacade.java # Утилиты для работы с JSON
│   │       ├── domain              # Доменная область
│   │       │   ├── auth
│   │       │   │   ├── CleanArchitectureAuthDetails.java # Детали авторизации
│   │       │   │   └── CleanArchitectureUserDetails.java # Детали пользователя
│   │       │   ├── entity
│   │       │   │   └── User.java # Сущность пользователя
│   │       │   └── exception
│   │       │       ├── CustomHttpErrorCode.java # Кастомные HTTP ошибки
│   │       │       ├── NotFoundException.java # Исключение "Не найдено"
│   │       │       └── ValidationException.java # Исключение валидации
│   ├── resources
│   │   ├── application.yaml  # Основной конфигурационный файл
│   │   ├── db                # Миграции базы данных
│   │   │   └── changelog
│   │   │       ├── changelog-master.xml
│   │   │       └── v-1.0
│   │   │           ├── 2025.03
│   │   │           │   ├── 06.03.2025__16:00_create_basic_tables.sql # SQL для создания таблиц
│   │   │           │   └── changelog.2025.03.xml
│   │   │           └── changelog-v-1.0.xml
│   │   └── static           # Статические ресурсы
│   │       ├── openapi
│   │       │   └── api-spec.yml # OpenAPI спецификация
│   │       └── validator
│   │           └── scheme
│   │               └── getUserByUid.json # JSON схема валидации
└── test
├── java
└── com.clean.architecture # Тесты для проекта

🚧 *Work in Progress... Stay tuned!* 🚧

---

## 📬 Contact Me

Feel free to reach out if you have any questions or suggestions!

[<img src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white">](mailto:zaytsev.dmitry9228@gmail.com)
[<img src="https://img.shields.io/badge/Telegram-2CA5E0?style=for-the-badge&logo=telegram&logoColor=white">](https://t.me/zaytsev_dv)

---