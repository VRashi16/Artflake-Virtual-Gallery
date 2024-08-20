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
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_ID", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "User_ID", nullable = false)
    private Long userId;

    @Column(name = "Order_Date", nullable = false, updatable = false)
    private LocalDateTime orderDate = LocalDateTime.now();

    @Column(name = "Total_Amount")
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "Order_Status", nullable = false)
    private OrderStatus orderStatus = OrderStatus.PENDING;

     @ManyToOne
     @JoinColumn(name = "User_ID", insertable = false, updatable = false)
     private User user;
}
