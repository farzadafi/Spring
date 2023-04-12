FROM openjdk:17-jdk-slim
EXPOSE 8000
ARG JAR_FILE=target/currency-exchange-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

ENV SPRING_APPLICATION_NAME=currency-exchange-service
ENV SERVER_PORT 8000
ENV MANAGEMENT_ZIPKIN_TRACING_ENDPOINT=http://zipkin-server:9411/api/v2/spans
ENV SPRING_CLOUD_CONFIG_IMPORT-CHECK_ENABLED=false
ENV SPRING_CLOUD_COMPATIBILITY-VERIFIER_ENABLED=false

#name of eureka container
#ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE http://eureka-server:8761/eureka
#ENV EUREKA_CLIENT_REGISTER-WITH-EUREKA=FALSE # when enabel can't connect to eureka server