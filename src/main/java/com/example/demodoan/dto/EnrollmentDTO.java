package com.example.demodoan.dto;

import com.example.demodoan.model.Course;
import com.example.demodoan.model.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDTO {
    private Long id;

    @NotNull(message = "user ID is required")
    private Long user;

    @NotNull(message = "course ID is required")
    private Long course;
}
