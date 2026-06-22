# Basic Automation Setup

This project uses Java, Maven, Selenium WebDriver, Cucumber, and TestNG.

## Prerequisites

- Java 17 or newer
- Maven
- Chrome or Edge installed

Selenium Manager downloads and resolves the browser driver automatically, so no separate driver executable is required.

## Run Tests

Run the Cucumber login suite in a visible browser:

```powershell
mvn test
```

Run in headless Chrome:

```powershell
mvn test -Dheadless=true
```

Run in Edge:

```powershell
mvn test -Dbrowser=edge
```

## Project Structure

```text
src/test/java/com/example/automation/core
  BaseTest.java
  DriverFactory.java

src/test/java/com/example/automation/tests
  ExampleSmokeTest.java

src/test/java/com/example/automation/steps
  LoginSteps.java

src/test/java/com/example/automation/runners
  TestRunner.java

src/test/resources/features
  login.feature

testng.xml
pom.xml
```
