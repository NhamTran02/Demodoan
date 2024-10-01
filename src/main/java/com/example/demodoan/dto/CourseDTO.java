package com.example.demodoan.dto;

import com.example.demodoan.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private Long id;

    private String title;

    private String description;

    private String image;

    private Long category;
}
