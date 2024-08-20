package com.artflake.artgallery.serviceimpl;

import com.artflake.artgallery.dto.PaymentDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.exception.ResourceNotFoundException;
import com.artflake.artgallery.model.Payment;
import com.artflake.artgallery.model.PaymentMethod;
import com.artflake.artgallery.model.PaymentStatus;
import com.artflake.artgallery.repository.PaymentRepository;
import com.artflake.artgallery.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PaymentDto> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return payments.stream()
                .map(payment -> modelMapper.map(payment, PaymentDto.class))
                .toList();
    }

    @Override
    public PaymentDto getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found"));
        return modelMapper.map(payment, PaymentDto.class);
    }

    @Override
    public ApiResponse createPayment(PaymentDto paymentDto) {
        Payment payment = modelMapper.map(paymentDto, Payment.class);
        paymentRepository.save(payment);
        return new ApiResponse("Inserted payment successfully");
    }

    @Override
    public ApiResponse updatePayment(Long id, PaymentDto paymentDto) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found"));
        modelMapper.map(paymentDto, payment);
        paymentRepository.save(payment);
        return new ApiResponse("Updated payment successfully");
    }

    @Override
    public ApiResponse deletePayment(Long id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return new ApiResponse("Deleted payment successfully");
        } else {
            throw new ResourceNotFoundException("Payment not found");
        }
    }
}
