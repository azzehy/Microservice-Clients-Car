FROM openjdk:21-slim
COPY target/api-gateway-1.0-SNAPSHOT.jar /Gateway.jar
ENTRYPOINT ["java", "-jar", "/Gateway.jar"]