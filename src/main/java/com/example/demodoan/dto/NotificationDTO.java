package com.example.demodoan.dto;

import com.example.demodoan.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {
    private Long id;

    private String message;

    private Boolean isRead=false;

    private Long user;
}
