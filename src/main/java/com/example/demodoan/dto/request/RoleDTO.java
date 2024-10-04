package com.example.demodoan.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private Long id;

    @JsonProperty("name")
    @NotBlank(message = "name is required")
    private String name;

    @JsonProperty("description")
    @NotBlank(message = "description is required")
    private String description;

}
