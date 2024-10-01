package com.example.demodoan.dto;

import com.example.demodoan.enums.ProgressStatus;
import com.example.demodoan.model.Course;
import com.example.demodoan.model.Lesson;
import com.example.demodoan.model.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgressDTO {
    private Long id;

    private ProgressStatus status;

    private Long user;

    private Long course;

    private Long lesson;
}
