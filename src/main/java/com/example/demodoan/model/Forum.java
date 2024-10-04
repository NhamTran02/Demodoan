package com.example.demodoan.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tbl_forums")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Forum extends Base{

    @Column(name = "title",nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
