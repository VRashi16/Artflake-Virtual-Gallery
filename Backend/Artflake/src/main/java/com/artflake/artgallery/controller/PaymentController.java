package com.artflake.artgallery.controller;

import com.artflake.artgallery.dto.PaymentDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<PaymentDto>> getAllPayments() {
        List<PaymentDto> payments = paymentService.getAllPayments();
        return ResponseEntity.status(HttpStatus.OK).body(payments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> getPaymentById(@PathVariable("id") Long id) {
        PaymentDto payment = paymentService.getPaymentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(payment);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createPayment(@RequestBody PaymentDto paymentDto) {
        ApiResponse response = paymentService.createPayment(paymentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updatePayment(@PathVariable("id") Long id, @RequestBody PaymentDto paymentDto) {
        ApiResponse response = paymentService.updatePayment(id, paymentDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePayment(@PathVariable("id") Long id) {
        ApiResponse response = paymentService.deletePayment(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
