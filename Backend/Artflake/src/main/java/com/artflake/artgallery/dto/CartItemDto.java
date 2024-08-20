package com.artflake.artgallery.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    private Long id;

    private Long cartItemId;
    private Long cartId;
    private Long artworkId;
    private int quantity;
    private LocalDateTime addedAt;

    private String artworkTitle;
    private String artistDescription;
    private BigDecimal artworkPrice;
    private String artworkImageUrl;
}

