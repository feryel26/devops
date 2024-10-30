# Utilisez l'image OpenJDK 17
FROM openjdk:17-jdk-slim

# Exposez le port utilisé par votre application Spring Boot
EXPOSE 8081

# Copiez le fichier JAR généré depuis le dossier cible vers le conteneur
ADD target/spring_projet-1.0.jar spring_projet-1.0.jar

# Point d'entrée pour démarrer l'application Spring Boot
ENTRYPOINT ["java", "-jar", "/spring_projet-1.0.jar"]
