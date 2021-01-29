FROM openjdk:8u191-jdk-alpine

MAINTAINER "wangp_yong@163.com"
ARG JAR_FILE
COPY ${JAR_FILE} /app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]