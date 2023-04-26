package com.farzadafi.notification.repository;

import com.farzadafi.notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
