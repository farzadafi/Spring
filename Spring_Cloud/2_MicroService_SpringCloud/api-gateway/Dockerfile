FROM openjdk:17-jdk-slim
EXPOSE 8765
ARG JAR_FILE=target/api-gateway-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

ENV SPRING_APPLICATION_NAME=api-gateway
ENV SERVER_PORT 8765
ENV SPRING_CLOUD_CONFIG_IMPORT-CHECK_ENABLED=FALSE
ENV SPRING_CLOUD_COMPATIBILITY-VERIFIER_ENABLED=FALSE
ENV MANAGEMENT_ZIPKIN_TRACING_ENDPOINT=http://zipkin-server:9411/api/v2/spans

#name of eureka server here:
#ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE http://172.17.0.2:8761/eureka
#ENV EUREKA_CLIENT_REGISTER-WITH-EUREKA=FALSE # when uncomment this line can't connect to eureka server
#ENV EUREKA_CLIENT_FETCH-REGISTRY=FALSE # when uncomment this line con't connect to uereka server
