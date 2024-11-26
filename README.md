# RabbitMQ Spike Project

### RabbitMQ Docker Image
``` bash
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.13-management
```
### Web interface

>http://localhost:15672/

- Loggin username:password -> guest:guest.

<img alt="Rabbit Interface" src="/images/Rabbit Interface.png"/>

### Spring Dependencies

Add these dependencies to the [pom.xml](pom.xml) file.

``` xml
<!-- RabbitMQ -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.amqp</groupId>
    <artifactId>spring-rabbit-test</artifactId>
</dependency>
```

### application.properties

Connection settings to add in [application.properties](/src/main/resources/application.properties).

```
## RabbitMQ Properties ##
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest

## Queue name ##
tpi.queue.name=queue-test
```

## Consumer example

The class [Consumer.java](src/main/java/ar/edu/utn/frc/tup/lc/iv/rabbitmq/consumer/Consumer.java) is created,
containing the necessary methods to listen to and receive messages from the configured queue.

## Publisher example

It is necessary to create the configuration class  
[RabbitMQConfig.java](src/main/java/ar/edu/utn/frc/tup/lc/iv/configs/RabbitMQConfig.java),  
which generates the required Java Bean to instantiate  
[Publisher.java](src/main/java/ar/edu/utn/frc/tup/lc/iv/rabbitmq/publisher/Publisher.java).

## Swagger

> http://localhost:8080/swagger-ui/index.html

# Fonts

- https://www.youtube.com/watch?v=IdJ3bS-7cbg&t=786s
- https://mstryoda.medium.com/how-to-consume-messages-from-java-applications-with-rabbitmq-in-masstransit-e5c96b6618dd
- https://stackoverflow.com/questions/77499442/spring-boot-rabbitmq-attempt-to-deserialize-unauthorized-class-exception