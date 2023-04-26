package com.farzadafi.clients.notification;

import java.time.LocalDateTime;

public record NotificationRequest(Integer notificationId,
                                  Integer toCustomerId,
                                  String toCustomerEmail,
                                  String sender,
                                  String message,
                                  LocalDateTime sendAt) {
}
