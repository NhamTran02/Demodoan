package com.example.demodoan.dto;

import com.example.demodoan.model.Course;
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
public class ForumDTO {
    private Long id;

    private String title;

    private String content;

    private Long user;
}
