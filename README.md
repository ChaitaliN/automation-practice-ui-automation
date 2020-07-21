# AutomationPractice.com UI automation

AutomationPractice.com UI automation testing

## Prerequisite

- Java 1.8
- Maven 3.6
- Chrome 80
- Firefox 73

## Framework

- Testing approach - BDD

  - [Feature files](./src/test/resources/feature/)
  - [Step definitions](./src/test/java/stepDefinition)

- Browser automation - Selenium WebDriver
- BDD tool - Cucumber
- Test tool - JUnit
- Build tool - Maven
- Configuration management - [Properties file to change browser, host etc](./src/test/resources/test.config.properties)

## Usage

- Run all scenarios

  ```sh
  mvn clean test

  ```

- Run specific scenario by tags

  ```sh
  mvn clean test -Dcucumber.options="--tags @login-user"
  mvn clean test -Dcucumber.options="--tags @place-order"
  ```

## Reports

- Extent report

  ```sh
  target/cucumber-reports/advanced-reports/extent-reports/extent.html
  ```

- HTML report

  ```sh
  target/cucumber-html-report/index.html
  ```

- Json report

  ```sh
  target/cucumber.json
  ```

- Scenario report

  ```sh
  target/cucumber-pretty.txt
  ```

- XML report

  ```sh
  target/cucumber-results.xml
  ```
