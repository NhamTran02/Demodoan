package com.example.demodoan.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseReviewDTO {
    private Long id;

    @Min(value = 1, message = "rating phải lớn hơn hoặc bằng 1")
    @Max(value = 5, message = "rating phải nhỏ hơn hoặc bằng 5")
    private Integer rating;

    @NotBlank(message = "comment kh đc trống")
    private String comment;

    @NotNull(message = "user ID is required")
    private Long user;

    @NotNull(message = "course ID is required")
    private Long course;
}
