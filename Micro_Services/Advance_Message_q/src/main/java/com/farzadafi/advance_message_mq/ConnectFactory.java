package com.farzadafi.advance_message_mq;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectFactory {

    //    @Value("${spring.rabbitmq.host}")
    private final static String rabbitHost = "rabbitmq";
    //when use docker on rabbitmq, when use locally should be localhost

    //    @Value("${spring.rabbitmq.port}")
    private final static int RABBIT_PORT = 5672;

    //    @Value("${spring.rabbitmq.username}")
    private final static String RABBIT_USERNAME = "guest";

    //    @Value("${spring.rabbitmq.password}")
    private final static String RABBIT_PASSWORD = "guest";

    @Bean
    public CachingConnectionFactory connectionFactory() {
        final CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost(rabbitHost);
        factory.setPort(RABBIT_PORT);
        factory.setUsername(RABBIT_USERNAME);
        factory.setPassword(RABBIT_PASSWORD);
        return factory;
    }
}
