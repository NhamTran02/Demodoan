package com.example.demodoan.dto;

import com.example.demodoan.model.Course;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizzeDTO {
    private Long id;

    @NotBlank(message = "title kh đc trống")
    private String title;

    @NotBlank(message = "questions kh đc trống")
    private String questions;

    @NotNull(message = "course ID is required")
    private Long course;
}
