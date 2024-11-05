# Use OpenJDK 17 as the base image
FROM openjdk:17

# Expose the port that the Spring Boot app will use
EXPOSE 8082

# Replace this URL with your Nexus repository URL
ARG NEXUS_REPO_URL="http://localhost:8081/repository/maven-releases"
ARG ARTIFACT_ID="spring_projet"
ARG VERSION="0.0.1-SNAPSHOT"
ARG JAR_FILE="${ARTIFACT_ID}-${VERSION}.jar"

# Download the JAR file from Nexus
RUN wget -O ${JAR_FILE} ${NEXUS_REPO_URL}/com/yourcompany/${ARTIFACT_ID}/${VERSION}/${JAR_FILE}

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "spring_projet-0.0.1-SNAPSHOT.jar"]
