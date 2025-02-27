FROM openjdk:17-jdk-slim

WORKDIR /app

COPY ./eureka-server/target/*.jar /app/eureka-server.jar

ENTRYPOINT ["java", "-jar", "/app/eureka-server.jar"]
