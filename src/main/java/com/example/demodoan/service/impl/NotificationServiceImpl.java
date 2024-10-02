package com.example.demodoan.service.impl;

import com.example.demodoan.dto.NotificationDTO;
import com.example.demodoan.exception.ErrorCode;
import com.example.demodoan.exception.ResourceNotFoundException;
import com.example.demodoan.model.Notification;
import com.example.demodoan.model.User;
import com.example.demodoan.repository.NotificationRepository;
import com.example.demodoan.repository.UserRepository;
import com.example.demodoan.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    @Override
    public List<Notification> getAllNotification() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification createNotification(NotificationDTO notificationDTO) {
        Notification notification = new Notification();

        notification.setMessage(notificationDTO.getMessage());
        notification.setIsRead(notificationDTO.getIsRead());

        User user = userRepository.findById(notificationDTO.getUser())
                .orElseThrow(()->new ResourceNotFoundException(ErrorCode.YOU_MUST_LOGIN));
        notification.setUser(user);
        return notificationRepository.save(notification);
    }

    @Override
    public Notification updateNotification(Long id, NotificationDTO notificationDTO) {
        Optional<Notification> optionalNotification = notificationRepository.findById(id);
        Notification notification = optionalNotification.get();

        notification.setMessage(notificationDTO.getMessage());
        notification.setIsRead(notificationDTO.getIsRead());

        User user = userRepository.findById(notificationDTO.getUser())
                .orElseThrow(()->new ResourceNotFoundException(ErrorCode.YOU_MUST_LOGIN));
        notification.setUser(user);
        return notificationRepository.save(notification);
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public List<Notification> findMessageNotification(String message) {
        return notificationRepository.findByMessageContainingIgnoreCase(message);
    }
}
