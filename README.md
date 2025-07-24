### 📊 CI Status
![API Tests](https://github.com/NanaQuaci/Advanced-Week7/actions/workflows/run-tests.yml/badge.svg)

# 🧪 API Automation Testing – Users Endpoint (REST Assured + Allure)

This project demonstrates **automated API testing** using **REST Assured** against the `https://jsonplaceholder.typicode.com/users` endpoint. It covers complete **CRUD operations** (Create, Read, Update, Delete), includes **positive and negative scenarios**, and generates detailed **Allure Reports**.

## 🚀 Technologies Used
- **Java 21**
- **REST Assured** – For API test automation
- **JUnit 5** – For unit test management
- **Allure** – For generating test reports
- **Maven** – For build and dependency management
- **Git & GitHub** – For version control and CI/CD

## 🧩 Project Structure
```
APIAutomation/
├── src
│   └── test
│       └── java
│           └── com.example
│               ├── base         # BaseTest class with config
│               ├── endpoints    # Page Object Model for CRUD
│               ├── testdata     # Test data used in requests
│               └── tests        # JUnit test classes
├── pom.xml                      # Maven build file
├── .github/workflows            # GitHub Actions config
└── README.md
```

## ✅ Test Coverage

### ➕ Positive Test Cases
- `POST /users` – Create user with valid payload
- `GET /users` – Fetch all users
- `GET /users/{id}` – Fetch user by valid ID
- `PUT /users/{id}` – Update user with valid data
- `DELETE /users/{id}` – Delete existing user

### ➖ Negative & Edge Test Cases
- `POST /users` – Missing fields, invalid email, empty body
- `GET /users/{id}` – Non-existent, negative or string ID
- `PUT /users/{id}` – Invalid ID, empty or partial body
- `DELETE /users/{id}` – Invalid ID, string ID, missing ID

> ⚠️ **Note**: This API is a **mock service**. It accepts all requests and always returns `200 OK` or `201 Created`, even for invalid payloads or IDs. In real APIs, you’d expect proper validation errors (`400`, `404`, etc.).

## 📄 How to Run Tests

Make sure **Java 21** and **Maven** are installed.

```bash
mvn clean test
```

## 📊 Allure Reporting

```bash
allure serve target/allure-results
```

> 📦 You must install the [Allure CLI](https://docs.qameta.io/allure/#_installing_a_commandline) to view reports locally.

### 🌐 View Deployed Report (CI)
➡️ [Allure Report (GitHub Pages)](https://nanaquaci.github.io/Advanced-Week8/)

## 🔗 Resources
- 📘 [JSONPlaceholder API](https://jsonplaceholder.typicode.com/)
- 🔧 [REST Assured Docs](https://github.com/rest-assured/rest-assured/wiki/Usage)
- 📊 [Allure Report Docs](https://docs.qameta.io/allure/)

## 👤 Author
**Nana Quaci**
> Week 8 – Graduate Trainee Program  
> Advanced Testing Project

## 🏁 License
This project is for learning and demonstration purposes only.  
Feel free to fork and enhance it for real APIs.