# Use a base image with OpenJDK Java 11 installed
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container
COPY ./smartstock-0.0.1-SNAPSHOT.jar /app

# Specify the command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "smartstock-0.0.1-SNAPSHOT.jar"]
