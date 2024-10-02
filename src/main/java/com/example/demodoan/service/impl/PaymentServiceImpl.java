package com.example.demodoan.service.impl;

import com.example.demodoan.dto.PaymentDTO;
import com.example.demodoan.exception.ErrorCode;
import com.example.demodoan.exception.ResourceNotFoundException;
import com.example.demodoan.model.Course;
import com.example.demodoan.model.Payment;
import com.example.demodoan.model.User;
import com.example.demodoan.repository.CourseRepository;
import com.example.demodoan.repository.PaymentRepository;
import com.example.demodoan.repository.UserRepository;
import com.example.demodoan.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    @Override
    public Payment createPayment(PaymentDTO paymentDTO) {

        User user = userRepository.findById(paymentDTO.getUser())
                .orElseThrow(()->new ResourceNotFoundException(ErrorCode.YOU_MUST_LOGIN));

        Course course = courseRepository.findById(paymentDTO.getCourse())
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.YOU_MUST_LOGIN));

        Payment payment = Payment.builder()
                .amount(paymentDTO.getAmount())
                .status(paymentDTO.getStatus())
                .methodPayment(paymentDTO.getMethodPayment())
                .user(user)
                .course(course)
                .build();
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(ErrorCode.PAYMENT_NOT_FOUND));
    }
}
