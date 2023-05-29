# Eureka Server (Naming Server)

### Service Discovery

### Service Registry

![Eureka server image](https://github.com/farzadafi/Spring/blob/master/Spring_Cloud/2_MicroService_SpringCloud/naming-server/image/image.png)

In a **microServices** architecture, there are typically many small services running independently, each with its own
**instance** or instances. ***Eureka Server*** provides a *central* registry that allows these services to **discover**
and **communicate**
with each other. Each service instance registers with Eureka Server during *startup*, providing metadata such as its
host
and port. Other services can then *query Eureka Server* to locate the instances of the service they need to communicate
with.

**Eureka Server** is designed to be highly available and **fault-tolerant**. It uses a peer-to-peer architecture, where
each
instance of Eureka Server is both a server and a client. This means that if one instance goes **down**, the other
instances
can **still communicate** with each other and continue to provide service discovery.

### Advantage

1. **Service discovery**: Eureka Server provides a central registry that allows services to dynamically discover and
   communicate with each other.

2. **Load balancing**: Eureka Server can be used to implement load balancing of service instances. Services can query
   Eureka
   Server to find the available instances of a service and distribute requests across them, ensuring that the load is
   evenly distributed.

3. **Fault tolerance**: Eureka Server is designed to be highly available and fault-tolerant. It uses a peer-to-peer
   architecture, where each instance of Eureka Server is both a server and a client. This means that if one instance
   goes
   down, the other instances can still communicate with each other and continue to provide service discovery.

4. **Metadata**: Eureka Server allows services to register metadata about themselves, such as their host and port, which
   can be
   used by other services to make intelligent routing decisions. This allows for more efficient communication between
   services.

5. **Integrations**: Eureka Server can be integrated with other tools and frameworks, such as Spring Cloud and
   Kubernetes,
   making it a flexible and widely adopted solution for service discovery.

##### Disadvantage

1. **Single point of failure**: Although Eureka Server is designed to be fault-tolerant, it is still a central point of
   control
   for service discovery. If the Eureka Server goes down, service discovery will be affected, potentially leading to
   service outages.

2. **Limited functionality**: While Eureka Server provides basic service discovery and load balancing functionality, it
   may not
   be sufficient for more complex scenarios. For example, Eureka Server does not support advanced routing or traffic
   shaping features.

3. **Complexity**: Eureka Server can add complexity to a microServices architecture, particularly if it is integrated
   with
   other tools and frameworks. This can make it more difficult to debug and maintain the system.

4. **Performance overhead**: Eureka Server adds a more layer of communication and processing overhead to the system,
   which can impact performance. However, this overhead is typically minimal and may not be noticeable in most
   scenarios.

5. **Security**: Eureka Server does not provide built-in security features, such as authentication or encryption. This
   means
   that additional security measures may need to be implemented to protect the service registry and the services that
   use
   it.
