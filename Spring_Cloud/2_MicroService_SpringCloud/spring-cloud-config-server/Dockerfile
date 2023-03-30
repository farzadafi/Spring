FROM openjdk:17-jdk-slim
EXPOSE 8888
ARG JAR_FILE=target/spring-cloud-config-server-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]