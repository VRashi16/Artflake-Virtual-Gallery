package com.artflake.artgallery.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Order_Artwork")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@IdClass(OrderArtworkId.class)
public class OrderArtwork {

    @Id
    @ManyToOne
    @JoinColumn(name = "Order_ID", nullable = false)
    private Orders order;

    @Id
    @ManyToOne
    @JoinColumn(name = "Artwork_ID", nullable = false)
    private Artwork artwork;

    @Column(nullable = false)
    private int quantity = 1;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
}
