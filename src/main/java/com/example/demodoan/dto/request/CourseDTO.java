package com.example.demodoan.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private Long id;

    @NotBlank(message = "title kh đc trống")
    private String title;

    @NotBlank(message = "description kh đc trống")
    private String description;

    @NotBlank(message = "image kh đc trống")
    private String image;

    @NotNull(message = "category ID is required")
    private Long category;
}
