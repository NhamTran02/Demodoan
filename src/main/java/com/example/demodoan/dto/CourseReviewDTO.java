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
public class CourseReviewDTO {
    private Long id;

    private Integer rating;

    private String comment;

    private Long user;

    private Long course;
}
