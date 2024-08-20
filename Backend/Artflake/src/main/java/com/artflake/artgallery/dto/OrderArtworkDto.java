package com.artflake.artgallery.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderArtworkDto {
    private Long orderId;
    private Long artworkId;
    private int quantity;
    private BigDecimal price;
}
