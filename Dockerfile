# Use OpenJDK 17 as the base image
FROM openjdk:17
# Expose the port that the Spring Boot app will use
EXPOSE 8082
COPY target/spring_projet-0.0.1-SNAPSHOT.jar spring_projet-0.0.1-SNAPSHOT.jar
# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "spring_projet-0.0.1-SNAPSHOT.jar"]
