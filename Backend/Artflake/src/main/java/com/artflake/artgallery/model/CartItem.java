package com.artflake.artgallery.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Cart_Item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @ManyToOne
    @JoinColumn(name = "Cart_ID", nullable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "Artwork_ID", nullable = false)
    private Artwork artwork;

    @Column(nullable = false)
    private int quantity = 1;

    @Column(name = "Added_At", nullable = false, updatable = false)
    private LocalDateTime addedAt = LocalDateTime.now();
}

