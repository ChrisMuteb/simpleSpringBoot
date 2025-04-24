# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jre-focal

# Set the working directory in the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container
COPY target/*.jar app.jar

# Expose the port the Spring Boot application runs on (default is 8080)
EXPOSE 8080

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]