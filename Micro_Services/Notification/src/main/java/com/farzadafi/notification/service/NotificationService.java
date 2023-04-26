package com.farzadafi.notification.service;

import com.farzadafi.clients.notification.NotificationRequest;
import com.farzadafi.notification.model.Notification;
import com.farzadafi.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(NotificationRepository notificationRepository) {

    public void send(NotificationRequest notificationRequest) {
        Notification notification = Notification.builder()
                .toCustomerId(notificationRequest.toCustomerId())
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .sender("farzadafi")
                .message(notificationRequest.message())
                .sendAt(LocalDateTime.now())
                .build();
        notificationRepository.save(notification);
    }
}
