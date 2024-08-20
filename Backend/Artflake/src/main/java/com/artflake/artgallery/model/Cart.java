package com.artflake.artgallery.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cart_ID", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "User_ID", nullable = false)
    private Long userId;

    @Column(name = "Created_At", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "User_ID", insertable = false, updatable = false)
    private User user;
}
