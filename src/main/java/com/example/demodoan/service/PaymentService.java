package com.example.demodoan.service;


import com.example.demodoan.dto.request.PaymentDTO;
import com.example.demodoan.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment createPayment(PaymentDTO paymentDTO);
    List<Payment> findAllPayments();
    Payment findPaymentById(Long id);
}
