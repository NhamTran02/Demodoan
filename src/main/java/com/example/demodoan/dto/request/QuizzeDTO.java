package com.example.demodoan.dto.request;

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
