package com.example.demodoan.dto.request;

import com.example.demodoan.enums.PaymentMethod;
import com.example.demodoan.enums.PaymentStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private Long id;

    @Min(value = 0,message = "amount must be >0")
    private BigDecimal amount;

    @NotBlank(message = "status kh đc trống")
    private PaymentStatus status;

    @NotBlank(message = "methodPayment kh đc trống")
    private PaymentMethod methodPayment;

    @NotNull(message = "user ID is required")
    private Long user;

    @NotNull(message = "course ID is required")
    private Long course;
}
