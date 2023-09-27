# Use a base image with Java and a specified version
FROM openjdk:17.0.2-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file into the container at the specified directory
COPY target/*.jar /app/app.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Define the command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]
