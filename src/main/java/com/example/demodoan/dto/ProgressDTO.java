package com.example.demodoan.dto;

import com.example.demodoan.enums.ProgressStatus;
import com.example.demodoan.model.Course;
import com.example.demodoan.model.Lesson;
import com.example.demodoan.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgressDTO {
    private Long id;

    @NotBlank(message = "status kh đc trống")
    private ProgressStatus status;

    @NotNull(message = "user ID is required")
    private Long user;

    @NotNull(message = "course ID is required")
    private Long course;

    @NotNull(message = "lesson ID is required")
    private Long lesson;
}
