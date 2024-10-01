package com.example.demodoan.repository;

import com.example.demodoan.model.Lesson;
import com.example.demodoan.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByMessageContainingIgnoreCase(String message);
}
