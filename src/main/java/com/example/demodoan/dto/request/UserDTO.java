package com.example.demodoan.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    @JsonProperty("username")
    @NotBlank(message = "username is required")
    private String username;

    @NotBlank(message = "email is required")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "invalid email format")
    private String email;


    @NotBlank(message = "password is required")
    @Size(min = 6,message = "password must be at least 6 characters")
    private String password;

    @JsonProperty("phone_number")
    @NotBlank(message = "phone number is required")
    @Size(max = 11,message = "phone number must be at most 11 characters")
    private String phoneNumber;

    @NotNull(message = "role ID is required")
    @JsonProperty("role_id")
    private Long role;
}
