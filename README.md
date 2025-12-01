# Tesco Selenium Test Automation

## Project Context

This is a test automation project using Java and Selenium with JUnit as the test framework and Cucumber for BDD (Behavior-Driven Development) test cases written in Gherkin.

### Important Notes

- **Language**: All source code and feature files are written in **English**.
- This README serves as a context storage for future reference.

## Project Structure

```
Tesco_Selenium/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   └── java/
    └── test/
        ├── java/
        │   └── com/
        │       └── tesco/
        │           ├── TestRunner.java
        │           └── stepdefinitions/
        │               └── StepDefinitions.java
        └── resources/
            └── features/
                └── example.feature
```

## Technology Stack

- **Java**: 21
- **Selenium**: 4.16.1
- **JUnit**: 5.10.1
- **Cucumber**: 7.18.0
- **WebDriverManager**: 5.6.3 (for automatic driver management)
- **Maven**: Build tool

## Setup Instructions

1. Ensure Java 21 is installed
2. Install Maven (if not already installed)
3. Clone/download the project
4. Run `mvn clean install` to download dependencies
5. Run tests with `mvn test`

## Running Tests

Execute all tests:
```bash
mvn test
```

Run specific feature:
```bash
mvn test -Dcucumber.filter.tags="@tag"
```

## Test Reports

After running tests, reports are generated in:
- HTML: `target/cucumber-report.html`
- JSON: `target/cucumber-report.json`

## Additional Context

(Add any additional context, notes, or important information here as needed)

