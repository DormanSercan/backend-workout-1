FROM openjdk:17-jdk-slim

WORKDIR /app

COPY ./target/*.jar /app/order-service.jar

ENTRYPOINT ["java", "-jar", "/app/order-service.jar", "--spring.profiles.active=docker"]