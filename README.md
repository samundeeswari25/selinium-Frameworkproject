# Selenium Java Cucumber Automation Framework

A scalable and reusable **Selenium Automation Framework** built using **Java, Cucumber BDD, Maven, Allure, Extent Reports, Jenkins CI/CD**, and **ThreadLocal Parallel Execution**.

This framework follows industry-standard design patterns like **Page Object Model (POM)**, **Page Object Manager**, **Factory Pattern**, and **Constructor Dependency Injection**.

---

## 🚀 Tech Stack

* Java
* Selenium WebDriver
* Cucumber BDD
* Maven
* Apache POI (Excel Handling)
* Log4j2 (Logging)
* Dotenv (.env configuration)
* Allure Reports
* Extent Reports
* Jenkins Pipeline

---

## 📁 Project Structure

```text
src/test/java
│── base
│   └── baseClass.java          # Reusable browser methods
│
│── factory
│   └── DriverFactory.java      # Browser initialization
│
│── page
│   └── LoginPage.java          # Page Object classes
│
│── manager
│   └── PageObjectManager.java  # Centralized page object initialization
│
│── stepDef
│   └── stepdefClass.java       # Step Definitions
│
│── Hooks
│   └── HooksClass.java         # Before/After execution
│
│── runnerPack
│   └── RunnerClass.java        # Test Runner
│
│── utils
│   ├── ExcelReader.java
│   ├── ExcelManager.java
│   ├── LoggerUtils.java
│   ├── configReader.java
│   ├── ExtentManager.java
│   └── AllureclearReport.java
│
src/test/resources
│── featureFolder
│   └── intro.feature
│
│── testData.xlsx
│── .env
│── pom.xml
│── Jenkinsfile
│── README.md
```

---

## 🏗 Framework Design Pattern

This framework follows:

* **Page Object Model (POM)** → Maintains page locators separately
* **Page Object Manager** → Centralized object creation
* **Constructor Dependency Injection** → Better maintainability
* **Factory Design Pattern** → Browser management
* **ThreadLocal** → Parallel execution support
* **Hooks** → Setup and teardown management

---

## ⚡ Features

✔ Cross-browser support
✔ Parallel test execution
✔ Data-driven testing using Excel
✔ Environment variables using `.env`
✔ Screenshot capture (Full page & element level)
✔ Explicit and implicit wait utilities
✔ JavaScript executor methods
✔ Alert handling
✔ Robot class utilities
✔ Allure report integration
✔ Extent report integration
✔ Jenkins CI/CD integration
✔ Log4j logging support

---

## 🔧 Configuration

Create a `.env` file in the root directory:

```env
browser=chrome
url=https://www.google.com/
User_name=test_User_name
password=test_password
```

---

## ▶ Running Tests

Run all tests:

```bash
mvn clean test
```

Run specific runner:

```bash
mvn test -Dcucumber.filter.tags="@Smoke"
```

---

## 📊 Reporting

### Allure Report

Generate report:

```bash
allure generate allure-results --clean -o allure-report
```

Open report:

```bash
allure serve allure-results
```

---

### Extent Report

After execution:

```text
target/ExtentReport.html
```

---

### Cucumber HTML Report

After execution:

```text
target/cucumber-report.html
```

---

## 🔄 Jenkins Pipeline

Framework supports Jenkins pipeline execution.

Pipeline stages:

* Checkout code
* Clean project
* Run tests
* Generate Allure report
* Archive reports
* Publish Cucumber report

Run pipeline using:

```text
Jenkinsfile
```

---

## 🧪 Sample Feature File

```gherkin
Feature: LMS Web Application

Scenario Outline: Login Test
  Given User data "<Testcase_no>"
  When user details

Examples:
| Testcase_no |
| Tc_001      |
| Tc_002      |
```

---

## 📌 Design Flow

```text
Feature File
     ↓
Step Definition
     ↓
Page Object Manager
     ↓
Page Class
     ↓
Driver Factory
     ↓
Browser Launch
```

---

## 📷 Screenshots

Framework stores screenshots here:

```text
target/screenshot/
```

---

## 👤 Author

**Samundeeswari**

Automation Test Engineer | Selenium | Java | Cucumber | Jenkins

---
