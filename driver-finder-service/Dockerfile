FROM openjdk:17-jdk-slim

WORKDIR /app

COPY ./driver-finder-service/target/*.jar /app/driver-finder-service.jar

ENTRYPOINT ["java", "-jar", "/app/driver-finder-service.jar"]
