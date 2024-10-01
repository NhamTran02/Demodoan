package com.example.demodoan.dto;

import com.example.demodoan.model.Course;
import com.example.demodoan.model.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDTO {
    private Long id;

    private Long user;

    private Long course;
}
