package com.farzadafi.clients.notification;

import java.util.Date;

public record NotificationRequest(Integer notificationId,
                                  Integer toCustomerId,
                                  String toCustomerEmail,
                                  String sender,
                                  String message,
                                  Date sendAt) {
}
