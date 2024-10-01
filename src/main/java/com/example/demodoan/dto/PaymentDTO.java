package com.example.demodoan.dto;

import com.example.demodoan.enums.PaymentStatus;
import com.example.demodoan.model.Course;
import com.example.demodoan.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private Long id;

    private BigDecimal amount;

    private PaymentStatus status;

    private String methodPayment;

    private Long user;

    private Long course;
}
