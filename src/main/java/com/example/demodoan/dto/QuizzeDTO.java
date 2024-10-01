package com.example.demodoan.dto;

import com.example.demodoan.model.Course;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizzeDTO {
    private Long id;

    private String title;

    private String questions;

    private Long course;
}
