package com.farzadafi.notification;

import com.farzadafi.advance_message_mq.RabbitMQMessageProducer;
import com.farzadafi.notification.config.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {
        "com.farzadafi.notification",
        "com.farzadafi.advance_message_mq"
})
@EnableDiscoveryClient
@EnableFeignClients(
        basePackages = "com.farzadafi.clients"
)
public class NotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig notificationConfig) {
        return args -> producer.publish("farzad",
                notificationConfig.getInternalExchange(),
                notificationConfig.getInternalNotificationRoutingKey());
    }
}
