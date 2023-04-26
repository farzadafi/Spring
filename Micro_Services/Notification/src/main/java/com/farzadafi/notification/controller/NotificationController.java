package com.farzadafi.notification.controller;

import com.farzadafi.clients.notification.NotificationRequest;
import com.farzadafi.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public record NotificationController(NotificationService notificationService) {

    @PostMapping("api/v1/notification")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("New notification {}", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
