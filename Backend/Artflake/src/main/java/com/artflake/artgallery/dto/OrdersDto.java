package com.artflake.artgallery.dto;

import com.artflake.artgallery.model.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class OrdersDto {

    @NotNull
    private Long userId;

    @NotNull
    private LocalDateTime orderDate;

    @NotNull
    private BigDecimal totalAmount;

    @NotNull
    private OrderStatus orderStatus;
}
