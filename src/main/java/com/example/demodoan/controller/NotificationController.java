package com.example.demodoan.controller;

import com.example.demodoan.dto.NotificationDTO;
import com.example.demodoan.model.Notification;
import com.example.demodoan.service.impl.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    private NotificationServiceImpl notificationServiceImpl;

    @PostMapping
    Notification createNotification(@RequestBody NotificationDTO notificationDTO){
        return notificationServiceImpl.createNotification(notificationDTO);
    }

    @GetMapping
    List<Notification> getAllNotification(){
        return notificationServiceImpl.getAllNotification();
    }

    @PutMapping("/{id}")
    Notification updateNotification (@PathVariable Long id, @RequestBody NotificationDTO notificationDTO){
        return notificationServiceImpl.updateNotification(id, notificationDTO);
    }

    @DeleteMapping("/{id}")
    String deleteNotification(@PathVariable Long id){
        notificationServiceImpl.deleteNotification(id);
        return "Xóa thành công";
    }

    @GetMapping("/{message}")
    List<Notification> findMessageNotification (@PathVariable String message){
        return notificationServiceImpl.findMessageNotification(message);
    }
}
