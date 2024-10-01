package com.example.demodoan.service.impl;

import com.example.demodoan.dto.PaymentDTO;
import com.example.demodoan.model.Course;
import com.example.demodoan.model.Payment;
import com.example.demodoan.model.User;
import com.example.demodoan.repository.CourseRepository;
import com.example.demodoan.repository.PaymentRepository;
import com.example.demodoan.repository.UserRepository;
import com.example.demodoan.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Payment createPayment(PaymentDTO paymentDTO) {

        User user = userRepository.findById(paymentDTO.getUser())
                .orElseThrow(()->new RuntimeException("User not found"));

        Course course = courseRepository.findById(paymentDTO.getCourse())
                .orElseThrow(() -> new RuntimeException("Course not found"));

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
                .orElseThrow(()->new RuntimeException("Payment not found"));
    }
}
