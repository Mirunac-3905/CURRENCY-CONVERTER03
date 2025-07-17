# Currency Converter

A demo Spring Boot application for currency exchange with live rates and conversion.

## Features
- Convert between major currencies using live exchange rates
- Enter any amount and get the converted value
- Modern UI with instant (AJAX) conversion, no page reload
- Error handling for invalid input and API issues

## Project Structure
- Java source: `src/main/java/com/api/currency/`
- Main class: `ExampleApplication.java`
- Controller: `controller/CurrencyController.java`
- Service: `service/CurrencyService.java`
- Exception handler: `GlobalExceptionHandler.java`
- Frontend: `src/main/resources/templates/index.html`
- Static resources: `src/main/resources/static/` (e.g., favicon)
- Tests: `src/test/java/com/api/example/example/ExampleApplicationTests.java`

## Prerequisites
- Java 8 or higher
- Internet connection (for fetching live rates)

## Build & Run

### Using Maven Wrapper (Recommended)
No need to install Maven globally. Use the provided wrapper scripts:

**On Windows:**
```
./mvnw.cmd spring-boot:run
```
**On Linux/Mac:**
```
./mvnw spring-boot:run
```

### Or with Maven (if installed globally)
```
mvn spring-boot:run
```

The app will start on [http://localhost:8081](http://localhost:8081)

## Configuration
- Port is set in `src/main/resources/application.properties` (default: 8081)
- Uses [RapidAPI Currency Exchange API](https://rapidapi.com/developer/marketplace) (API key is hardcoded for demo)

## Notes
- The Maven Wrapper (`.mvn/wrapper/maven-wrapper.jar`) ensures consistent builds for all users.
- If you change the package or directory structure, update references in this README and in your code.
- For any issues, check the logs or update your API key if needed.

---

*Feel free to extend or modify this project for your own use!*
