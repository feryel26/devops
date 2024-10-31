FROM openjdk:17
EXPOSE 8083
ADD target/spring_projet-1.0.jar spring_projet-1.0.jar
ENTRYPOINT ["java", "-jar", "spring_projet-1.0.jar"]