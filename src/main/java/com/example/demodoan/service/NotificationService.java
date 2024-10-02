package com.example.demodoan.service;

import com.example.demodoan.dto.NotificationDTO;
import com.example.demodoan.model.Notification;

import java.util.List;


public interface NotificationService {
    List<Notification> getAllNotification();
    Notification createNotification(NotificationDTO notificationDTO);
    Notification updateNotification(Long id, NotificationDTO notificationDTO);
    void deleteNotification(Long id);
    List<Notification> findMessageNotification(String message);
}
