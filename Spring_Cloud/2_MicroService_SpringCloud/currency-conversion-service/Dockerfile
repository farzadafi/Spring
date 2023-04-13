FROM openjdk:17-jdk-slim
EXPOSE 8100
ARG JAR_FILE=target/currency-conversion-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

ENV SPRING_APPLICATION_NAME=currency-conversion-service
ENV SERVER_PORT 8100
ENV SPRING_CLOUD_CONFIG_IMPORT-CHECK_ENABLED=false
ENV SPRING_CLOUD_COMPATIBILITY-VERIFIER_ENABLED=false
ENV MANAGEMENT_ZIPKIN_TRACING_ENDPOINT=http://zipkin-server:9411/api/v2/spans

#name of eureka container here:
#ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE http://eureka-server:8761/eureka
#ENV EUREKA_CLIENT_REGISTER-WITH-EUREKA=FALSE # when enabel can't connect to eureka server