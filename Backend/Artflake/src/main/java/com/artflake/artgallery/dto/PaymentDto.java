package com.artflake.artgallery.dto;

import com.artflake.artgallery.model.PaymentMethod;
import com.artflake.artgallery.model.PaymentStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PaymentDto {

    @NotNull
    private Long orderId;

    @NotNull
    private LocalDateTime paymentDate;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private PaymentMethod paymentMethod;

    @NotNull
    private PaymentStatus paymentStatus;
}
