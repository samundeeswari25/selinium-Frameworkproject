# Selenium Java Cucumber Framework

## Tech Stack
- Java
- Selenium WebDriver
- Cucumber BDD
- Maven
- Allure Report
- Extent Report
- Jenkins CI/CD

---

## Framework Design Pattern
This framework follows:

- Page Object Model (POM)
- Page Object Manager
- Constructor Dependency Injection
- Factory Design Pattern
- ThreadLocal for Parallel Execution

---

## Project Structure

src/test/java
base → reusable methods
factory → driver initialization
manager → page manager
page → page classes
stepDef → cucumber step definitions
Hooks → setup and teardown
utils → utilities

---

## Features
- Parallel execution supported
- Excel data driven testing
- Environment configuration using .env
- Allure reporting
- Extent reporting
- Jenkins integration

---

## Run Tests

```bash
mvn test