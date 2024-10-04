package com.example.demodoan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification extends Base {

    @Column(name = "title",columnDefinition = "TEXT",nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String message;

    @Column(name = "is_read",nullable = false)
    private Boolean isRead=false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
