# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /

# Copy the executable JAR file from the host to the container
COPY target/spring-REST-0.0.1-SNAPSHOT.jar /spring-REST-0.0.1-SNAPSHOT.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "spring-REST-0.0.1-SNAPSHOT.jar"]
