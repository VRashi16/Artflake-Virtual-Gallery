package com.artflake.artgallery.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Payment_ID", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "Order_ID", nullable = false)
    private Long orderId;

    @Column(name = "Payment_Date", nullable = false, updatable = false)
    private LocalDateTime paymentDate = LocalDateTime.now();

    @NotNull
    @Column(name = "Amount", nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "Payment_Method", nullable = false)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "Payment_Status", nullable = false)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = "Order_ID", insertable = false, updatable = false)
    private Orders order;
}
