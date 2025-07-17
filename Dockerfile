# -------- Build Stage --------
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copy everything to the container
COPY . .

# Make wrapper executable and build the app
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# -------- Run Stage --------
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port used by Spring Boot
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

