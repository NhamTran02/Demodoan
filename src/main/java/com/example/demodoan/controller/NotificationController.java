package com.example.demodoan.controller;

import com.example.demodoan.dto.request.NotificationDTO;
import com.example.demodoan.model.Notification;
import com.example.demodoan.service.NotificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping
    Notification createNotification(@Valid  @RequestBody NotificationDTO notificationDTO){
        return notificationService.createNotification(notificationDTO);
    }

    @GetMapping
    List<Notification> getAllNotification(){
        return notificationService.getAllNotification();
    }

    @PutMapping("/{id}")
    Notification updateNotification (@PathVariable Long id,@Valid @RequestBody NotificationDTO notificationDTO){
        return notificationService.updateNotification(id, notificationDTO);
    }

    @DeleteMapping("/{id}")
    String deleteNotification(@PathVariable Long id){
        notificationService.deleteNotification(id);
        return "Xóa thành công";
    }

    @GetMapping("/{message}")
    List<Notification> findMessageNotification (@PathVariable String message){
        return notificationService.findMessageNotification(message);
    }
}
