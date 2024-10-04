package com.example.demodoan.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChapterDTO {
    private Long id;

    @NotBlank(message = "name kh đc trống")
    private String name;

    @Min(value = 1,message = " Số chapter phải lớn hơn 0")
    private Integer quantity;

    @NotNull(message = "course ID is required")
    private Long course;
}
