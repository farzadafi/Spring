# Spring Cloud Gateway :)

Spring Cloud Gateway is a **lightweight**, **developer-friendly**, **open-source API Gateway**
built on top of *Spring Framework 5*, *Spring Boot 2*, and Project Reactor.

***API Gateway*** is an *entry point* for all the client's requests. It is a type of *reverse proxy* that routes
requests from
*clients* to the appropriate **microservices**. It is responsible for handling API requests, routing them to the
appropriate
microservices, and returning the response back to the client.

***Spring Cloud Gateway*** provides a simple and powerful API that allows developers to define *routes*, *filter
requests*, and
*handle errors easily*. It also provides features like **load balancing**, **service discovery**, **rate limiting**, and
**circuit
breaking** that are essential for building scalable and resilient microservices architectures.

Some key features of Spring Cloud Gateway are:

1. **Dynamic routing**: Allows you to route requests based on headers, cookies, and other attributes.

2. **Load balancing**: Provides a pluggable load balancer implementation that can distribute traffic across multiple
   instances
   of a service.

3. **Circuit breaking**: Helps to prevent cascading failures by breaking the circuit when a downstream service fails.

4. **Service discovery**: Integrates with service discovery tools like Eureka, Consul, and Kubernetes to dynamically
   discover
   services.

5. **Security**: Provides a range of security features such as JWT authentication, OAuth2, and SSL.

### How to config and use from spring gateway:

1. Add this to pom.xml
   ```xml
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-gateway</artifactId>
   </dependency>
   ```
2. If you use from Eureka server too, add this:
   ```xml
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
   </dependency>
   ```
3. Add these property for name, port and eureka server URL to application.properties file:
   ```properties
   spring.application.name=api-gateway
   server.port=8765
   
   eureka.client.serverUrl.defaultZone=http://localhost:8761/eureka # this is default url, you can dont write it
   ```
4. If you use from Eureka server add this to class that has main method:
   ```java
   @SpringBootApplication
   @EnableDiscoveryClient // <------------------
   public class ApiGatewayApplication {
       public static void main(String[] args) {
           SpringApplication.run(ApiGatewayApplication.class, args);
       }
   }
   ```
5. Add this property for when this property is set to true, Spring Cloud Gateway uses the service registry to
   dynamically discover services and routes requests to the appropriate instance of the service based on the service's
   metadata.
   ```properties
   spring.cloud.gateway.discovery.locator.enabled=true
   ```
6. Add this property for By default, when Spring Cloud Gateway uses service discovery to locate services, it uses the
   service ID as the route ID. However, some service registries may have service IDs with uppercase letters, which can
   cause issues with routing. Setting lowerCaseServiceId to true converts the service ID to lowercase, ensuring that the
   route ID is always in lowercase.
   ```properties
   spring.cloud.gateway.discovery.locator.lowerCaseServiceId=true
   ```
7. And you have to create a class and write some config fot path gateway as you want like this:
```java

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .uri("https://www.google.com"))
                .route(p -> p
                        .path("/currency-exchange/**")
                        .uri("lb://currency-exchange-service"))
                .route(p -> p
                        .path("/conversion/**")
                        .uri("lb://currency-conversion-service"))
                .route(p -> p
                        .path("/conversion-feign/**")
                        .uri("lb://currency-conversion-service"))
                .build();
    }
}
```



