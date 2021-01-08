FROM openjdk:8-jdk-alpine
ARG JAR_FILE=server/target/*.jar
COPY ${JAR_FILE} server.jar
ENTRYPOINT ["java","-jar","/server.jar"]