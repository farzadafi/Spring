package com.example.customer.service;

import com.example.customer.dto.CustomerRegistrationRequest;
import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import com.farzadafi.advance_message_mq.RabbitMQMessageProducer;
import com.farzadafi.clients.fraud.FraudCheckResponse;
import com.farzadafi.clients.fraud.FraudClient;
import com.farzadafi.clients.notification.NotificationClient;
import com.farzadafi.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Date;

@Service
public record CustomerService(CustomerRepository customerRepository,
                              RestTemplate restTemplate,
                              FraudClient fraudClient,
                              NotificationClient notificationClient,
                              RabbitMQMessageProducer rabbitMQMessageProducer) {

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstname(customerRequest.firstname())
                .lastname(customerRequest.lastname())
                .email(customerRequest.email())
                .build();
        customerRepository.saveAndFlush(customer);

        checkFraud(customer);
        sendNotification(customer);
    }

    private void sendNotification(Customer customer) {
        NotificationRequest notificationRequest = new NotificationRequest(null, customer.getId(),
                customer.getEmail(),
                "farzadafi",
                String.format("Hi %s, welcome to farzadafi site...", customer.getFirstname()),
                Date.from(Instant.now()));
        rabbitMQMessageProducer.publish(notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key");
        notificationClient.sendNotification(notificationRequest);
    }

    private void checkFraud(Customer customer) {
        FraudCheckResponse fraudster = fraudClient.isFraudster(customer.getId());

        if (fraudster.isFraudster())
            throw new IllegalStateException("fraudster");
    }
}
