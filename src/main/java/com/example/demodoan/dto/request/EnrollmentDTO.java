package com.example.demodoan.dto.request;

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
