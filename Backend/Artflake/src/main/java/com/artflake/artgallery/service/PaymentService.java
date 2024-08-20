package com.artflake.artgallery.service;

import com.artflake.artgallery.dto.PaymentDto;
import com.artflake.artgallery.exception.ApiResponse;

import java.util.List;

public interface PaymentService {
    List<PaymentDto> getAllPayments();

    PaymentDto getPaymentById(Long id);

    ApiResponse createPayment(PaymentDto paymentDto);

    ApiResponse updatePayment(Long id, PaymentDto paymentDto);

    ApiResponse deletePayment(Long id);
}
