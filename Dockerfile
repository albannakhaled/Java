# Use a base image with Java 17
FROM openjdk:17-jdk-slim as build

# Set the working directory
WORKDIR /app

# Copy the Maven or Gradle build files to the container
# If you're using Maven
COPY pom.xml .
COPY src ./src

# Build the Spring Boot application using Maven
RUN ./mvnw clean package -DskipTests

# Use an official OpenJDK 17 image to run the app
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port that Spring Boot runs on (default is 8080)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
