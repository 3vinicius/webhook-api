FROM openjdk:21
LABEL authors="vinicius"
ARG JAR_FILE=target/*.jar
COPY ./target/webhook.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]