package com.example.demodoan.dto;

import com.example.demodoan.model.Course;
import com.example.demodoan.model.User;
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
public class ForumDTO {
    private Long id;

    @NotBlank(message = "title kh đc trống")
    private String title;

    @NotBlank(message = "content kh đc trống")
    private String content;

    @NotNull(message = "user ID is required")
    private Long user;
}
