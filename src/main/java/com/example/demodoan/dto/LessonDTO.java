package com.example.demodoan.dto;

import com.example.demodoan.model.Chapter;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonDTO {
    private Long id;

    private String title;

    private String videoUrl;

    private Long chapter;
}
