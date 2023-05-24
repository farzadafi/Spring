# Spring Cloud Config Server :)

Spring Cloud Config Server is a feature of Spring **Cloud** that provides a centralized configuration management system
for
distributed applications.<br>
It allows you to manage externalized configuration for your Spring Boot applications in a
central place, which can be versioned and maintained **independently** of the application code.

When you use Spring Cloud Config Server, your Spring Boot applications can **fetch** their **configuration** from a *
*central**
Config Server over HTTP, instead of storing the configuration within the application itself. This allows you to manage
configuration for multiple environments and multiple instances of a service in a central place, and change it without
having to redeploy the application.

## Advantage

1. **Centralized configuration management**: With Spring Cloud Config Server, you can store your configuration files in
   a
   centralized location, which makes it easier to manage configuration for multiple environments and multiple instances
   of
   a service.

2. **Externalized configuration**: By externalizing your configuration from your application code, you can change the
   configuration without having to redeploy the application. This makes it easier to make changes to your application's
   behavior in production.

3. **Secure configuration**: Spring Cloud Config Server provides support for encrypting and decrypting sensitive
   configuration
   properties, which helps keep your configuration secure.

4. and some other thing :)

## Disadvantage

1. **Network latency**: When your Spring Boot applications fetch their configuration from a remote Config Server over
   the
   network, this can introduce additional network latency and increase the response time of your application. This can
   be
   mitigated by caching the configuration locally, but it still adds an extra layer of complexity.

2. **Security risks**: If your configuration files contain sensitive information such as passwords or API keys, storing
   them in
   a centralized location like a Config Server can increase the risk of unauthorized access or exposure. This risk can
   be
   mitigated by encrypting sensitive information and securing access to the Config Server.

3. **Centralized point of failure**: If your Config Server goes down or becomes unavailable, all of your Spring Boot
   applications that rely on it for configuration will be affected. This can be mitigated by using multiple instances of
   the Config Server and configuring your applications to fallback to a local configuration source if the Config Server
   is
   unavailable.

4. **Complexity**: Setting up and configuring a Spring Cloud Config Server can add complexity to your deployment
   process,
   especially if you need to integrate with multiple backends or use advanced features like encryption.

## How to config ?

in pom.xml you have to add:

```xml

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

add "@EnableConfigServer" annotation to your main class in your spring boot app.
for example:

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServerApplication.class, args);
    }

}
```

create a directory for add application.properties files and then
add uri for this directory to application.properties config server
app same is(linux) :

```properties
spring.application.name=config-server
server.port=8888
spring.cloud.config.server.git.uri=file:///home/farzad/Desktop/fileLinux/Maktab/Tamrin/Spring/Spring_Cloud/2_MicroService_SpringCloud/git-localconfig-repo
```

and then in target resources property(auto configuration spring boot file)
we should to add this property:

```properties
spring.server.name=customer-service
spring.config.import=optional:configserver:http://localhost:8888
```

and then add a file with name **customer-service** in
git uri directory that's create is before step for keep all config files
and add property we need to that

and that's it!!!

***notation*** <br>
When you use Spring Cloud Config Server to manage the configuration for your Spring Boot applications, the name of the
configuration file should match the spring.application.name property of the application that is fetching the
configuration.

For example, if you have a Spring Boot application named "customer-service" and you have set its spring.application.name
property to "customer-service", then the corresponding configuration file in your Git repository should be named "
customer-service.properties" or "customer-service.yml", depending on the format you are using.