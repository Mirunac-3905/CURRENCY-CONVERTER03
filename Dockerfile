# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copy only pom.xml and download dependencies first (cache efficient)
COPY pom.xml . 
RUN mvn dependency:go-offline

# Now copy all source code
COPY . .

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the built jar/war from the build stage
COPY --from=build /app/target/*.war app.war

# Run the application
CMD ["java", "-jar", "app.war"]

