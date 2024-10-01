package com.example.demodoan.controller;

import com.example.demodoan.dto.PaymentDTO;
import com.example.demodoan.model.Payment;
import com.example.demodoan.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("")
    public ResponseEntity<Payment> createPayment(@RequestBody PaymentDTO paymentDTO) {
        Payment payment = paymentService.createPayment(paymentDTO);
        return ResponseEntity.ok().body(payment);
    }

    @GetMapping("")
    public ResponseEntity<List<Payment>> getPayments() {
        return ResponseEntity.ok().body(paymentService.findAllPayments());
    }

    @GetMapping("{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long id) {
        return ResponseEntity.ok().body(paymentService.findPaymentById(id));
    }

}
