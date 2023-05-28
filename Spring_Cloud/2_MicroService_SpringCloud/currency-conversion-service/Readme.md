# Open Feign

**OpenFeign** is a Java library that provides a declarative way to define RESTFul API clients for microservices in a
Spring
Boot application. It is part of the Spring Cloud suite of tools and is built on top of Netflix's Feign client.

With **OpenFeign**, you can define an **interface** that specifies the endpoints of a RESTFul API and the expected
response
types. You can then annotate the interface methods with HTTP methods such as *@GetMapping*, *@PostMapping*,
*@PutMapping*,
*@DeleteMapping*, and others, as well as with other annotations such as *@PathVariable*, *@RequestParam*, and
*@RequestBody*, to
specify the details of the API request.

**OpenFeign** generates an implementation of the interface at **runtime**, which acts as a client for the specified
RESTFul API.
It handles requests and responses and can also perform load balancing and retry logic using Ribbon, another component of
the Spring Cloud suite.

### Advantage

1. **Declarative API definition**: OpenFeign allows you to define API clients in a declarative way, which makes it
   easier to
   create and maintain clients for multiple microservices.

2. **Integration with Spring Boot**: OpenFeign integrates seamlessly with Spring Boot and can be used alongside other
   Spring
   Cloud tools such as Eureka for service discovery and Ribbon for load balancing.

3. **Load balancing and retry logic**: OpenFeign can handle load balancing and retry logic using Ribbon, which helps
   improve
   the resilience and scalability of your microservices.

4. **Reduced boilerplate code**: With OpenFeign, you can reduce the amount of boilerplate code required to create
   RESTFul API
   clients, which can make your code more concise and easier to read and maintain.

5. **Easy testability**: Since OpenFeign generates the client implementation at runtime, it can be easily mocked and
   tested in
   isolation, which can help improve the reliability of your tests.

### Disadvantage

1. **Limited flexibility**: OpenFeign provides a declarative way to define API clients, but this can be limiting in some
   cases
   where more fine-grained control over the request and response is needed. In these cases, it may be necessary to use a
   lower-level HTTP client library.

2. **Performance overhead**: The use of OpenFeign can introduce additional performance overhead, especially for large or
   complex API requests, due to the dynamic generation of the client implementation at runtime. This can be mitigated by
   optimizing the configuration and tuning the performance settings, but it still adds an extra layer of complexity.

3. **Learning curve**: While OpenFeign is relatively easy to use and integrates well with Spring Boot, it still requires
   some
   familiarity with the Spring Cloud ecosystem and its configuration model. This can be a learning curve for developers
   who
   are new to Spring Cloud.

4. **Dependency management**: OpenFeign has its own set of dependencies and can introduce version conflicts or
   compatibility
   issues with other libraries in your project. It's important to carefully manage your dependencies and ensure that
   they
   are compatible with each other.

5. **Limited support for non-RESTFul APIs**: OpenFeign is designed to work with RESTful APIs and may not be suitable for
   other
   types of APIs, such as SOAP or GraphQL. In these cases, it may be necessary to use a different client library or
   write custom code.

### Start With Feign :

first step is add open feign dependency to pom.xml file:

```xml

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```

add annotation @EnableFeignClients to main Spring boot app like this:

```java

@SpringBootApplication
@EnableFeignClients // <----
public class CurrencyConversionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConversionServiceApplication.class, args);
    }
}
```

and then create a interface with a name :), for example here is
CurrencyExchangeProxy and add annotation @FeignClient :(I dont have eureka here)

```java

@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyExchangeProxy {
}
```

name and port is name and port of target microservice(that we want to send request), the same name and port we enter on
application.properties
file :

```properties
spring.application.name=currency-exchange-service
server.port=8000
```

and add a method for use it like this:

```java
@GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyExchange getExchange(@PathVariable String from,@PathVariable String to);
```

and the last step inject this interface in the controller and use from it :

```java
@Autowired
private CurrencyExchangeProxy proxy;
```

in body of method :
```java
var result = proxy.getExchange(from, to);
```

That's it :-)
