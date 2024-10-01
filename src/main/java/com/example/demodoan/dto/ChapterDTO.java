package com.example.demodoan.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChapterDTO {
    private Long id;

    private String name;

    private Integer quantity;

    private Long course;
}
